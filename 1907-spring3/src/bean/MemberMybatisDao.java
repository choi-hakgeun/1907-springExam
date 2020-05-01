package bean;

import java.io.File;
import java.io.SequenceInputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.ibatis.session.SqlSession;

import mybatis.MemberPhoto;
import mybatis.MemberPhotoUpload;
import mybatis.Factory;
import mybatis.MemberVo;
import mybatis.FileUpload;

public class MemberMybatisDao {
	SqlSession sqlSession;
	
	public MemberMybatisDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public List<MemberVo> select(Page p) {
		List<MemberVo> list = null;
		
		try {
			
			int totList = sqlSession.selectOne("mm.count", p);
			p.setTotListSize(totList);
			p.pageCompute();
			list = sqlSession.selectList("mm.select", p);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return list;
		}
	}
	
	public String insert(MemberVo vo, List<MemberPhoto> attList) {
		String msg = "정상적으로 입력되었습니다.";
		
		try {
			int cnt = sqlSession.insert("mm.insert", vo);
			if(cnt<1) {
				throw new Exception("회원 정보 저장중 오류 발생");
			}
			for(MemberPhoto attVo : attList) {
				cnt = sqlSession.insert("mm.att_insert", attVo);
				if(cnt<1) {
					throw new Exception("첨부 데이터 저장시 오류 발생");
				}
			}
			sqlSession.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			msg = ex.getMessage();
			sqlSession.rollback();
			delFile(attList);
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	//상세보기, 수정정보
	public MemberVo view(String mId) {
		MemberVo vo = null;
		
		try {
			vo = sqlSession.selectOne("mm.view", mId);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return vo;
		}
	}
	
	public String modify(MemberVo vo, List<MemberPhoto> attList, List<MemberPhoto> delList) {
		String msg = "정상적으로 수정되었습니다.";
		
		try {
			// 본문글 수정
			int cnt = sqlSession.update("mm.update", vo);
			if(cnt<1) throw new Exception("회원정보 수정중 오류 발생");
			
			// member_photo에 삭제파일 정보를 제거
			for(MemberPhoto attVo : delList) {
				if(!attVo.getSysFile().equals("") ) {
					attVo.setmId(vo.getmId());
					cnt = sqlSession.delete("mm.att_delete", attVo);
					if(cnt<1) throw new Exception("첨부 데이터 정보 삭제중 오류 발생");
				}
			}
			
			
			//member_photo에 첨부 파일 정보를 추가
			for(MemberPhoto attVo : attList) {
				attVo.setmId(vo.getmId());
				
				if(!attVo.getSysFile().equals("") ) {
					cnt = sqlSession.insert("mm.att_insert", attVo);
					if(cnt<1) throw new Exception("첨부 데이터 정보 수정중 오류 발생");
				}
			}
			
			// 파일 삭제
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception ex) {
			
			delFile(attList);
			
			ex.printStackTrace();
			msg = ex.getMessage();
			sqlSession.rollback();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	
	public String delete(MemberVo vo) {
		String msg = "회원정보가 삭제되었습니다.";
		int cnt = 0;
		try {
			// 회원 정보삭제
			cnt = sqlSession.delete("mm.delete", vo);
			if(cnt<1) throw new Exception("삭제중 오류 발생");
			
			// 첨부된 파읾 목록 
			List<MemberPhoto> delList = sqlSession.selectList("mm.att_list", vo.getmId());
			
			// 첨부 테이블 자료 사제
			for(MemberPhoto attVo : delList) {
				cnt = sqlSession.delete("mm.att_delete", attVo);
				if(cnt<1 ) throw new Exception("첨부 자료 삭제중 오류 발생");
			}
			// 파일 삭제
			delFile(delList);
			
			sqlSession.commit();
		}catch(Exception ex) {
			sqlSession.rollback();
			msg = ex.getMessage();
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	public List<MemberPhoto> getAttList(String mId){
		List<MemberPhoto> attList = null;
		
		try {
			attList = sqlSession.selectList("mm.att_list", mId);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return attList;
		}
	}
	
	
	//insert, modify에서 sql 오류가 발생할 때, 삭제할 때 공통 사용
	public void delFile(List<MemberPhoto> delList) {
		for(MemberPhoto attVo : delList) {
			File f = new File(MemberPhotoUpload.upload + attVo.getSysFile() );
			if(f.exists()) f.delete();
		}
	}
	
	
	
	public boolean login(MemberVo vo) {
		boolean b = true;
		
		try {
			b = sqlSession.selectOne("mm.login", vo);
		}catch(Exception ex) {
			b=false;
			ex.printStackTrace();
		}finally {
			return b;
		}
		
		
	}
	
}













