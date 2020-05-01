package bean;

import java.io.File;
import java.io.SequenceInputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.ibatis.session.SqlSession;

import mybatis.AttVo;
import mybatis.Factory;
import mybatis.BoardVo;
import mybatis.FileUpload;

public class BoardMybatisDao {
	SqlSession sqlSession;
	
	public BoardMybatisDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public List<BoardVo> select(Page p) {
		List<BoardVo> list = null;
		
		try {
			
			int totList = sqlSession.selectOne("board.count", p);
			p.setTotListSize(totList);
			p.pageCompute();
			list = sqlSession.selectList("board.select", p);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return list;
		}
	}
	
	public String insert(BoardVo vo, List<AttVo> attList) {
		String msg = "정상적으로 입력되었습니다.";
		
		try {
			int cnt = sqlSession.insert("board.insert", vo);
			if(cnt<1) {
				throw new Exception("본문 저장중 오류 발생");
			}
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.att_insert", attVo);
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
	public BoardVo view(int serial, char v) {
		BoardVo vo = null;
		
		try {
			
			if(v== 'v') {
				sqlSession.update("board.hit_up", serial);
				sqlSession.commit();
			}
			
			vo = sqlSession.selectOne("board.view", serial);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return vo;
		}
	}
	
	public String modify(BoardVo vo, List<AttVo> attList, List<AttVo> delList) {
		String msg = "정상적으로 수정되었습니다.";
		
		try {
			// 본문글 수정
			int cnt = sqlSession.update("board.update", vo);
			if(cnt<1) throw new Exception("본문글 수정중 오류 발생");
			
			//boardAtt에 첨부 파일 정보를 추가
			for(AttVo attVo : attList) {
				attVo.setSerial(vo.getSerial());
				cnt = sqlSession.insert("board.att_insert2", attVo);
				if(cnt<1) throw new Exception("첨부 데이터 정보 추가중 오류 발생");
			}
			// boardAtt에 삭제파일 정보를 제거
			for(AttVo attVo : delList) {
				cnt = sqlSession.delete("board.att_delete", attVo);
				if(cnt<1) throw new Exception("첨부 데이터 정보 삭제중 오류 발생");
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
	
	
	public String delete(BoardVo vo) {
		String msg = "게시물이 삭제되었습니다.";
		int cnt = 0;
		try {
			// 삭제 하기전 댓글 존재 파악
			cnt = sqlSession.selectOne("board.repl_cnt", vo.getSerial());
			if(cnt>0) throw new Exception("댓글이 있는 자료는 삭제할 수 없습니다.");
			
			// 본문삭제
			cnt = sqlSession.delete("board.delete", vo);
			if(cnt<1) throw new Exception("삭제중 오류 발생");
			
			// 첨부된 파읾 목록 
			List<AttVo> delList = sqlSession.selectList("board.att_list", vo.getSerial());
			
			// 첨부 테이블 자료 사제
			for(AttVo attVo : delList) {
				cnt = sqlSession.delete("board.att_delete", attVo);
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
	
	public String repl(BoardVo vo, List<AttVo> attList ) {
		String msg = "댓글이 저장 되었습니다.";
		int cnt = 0;
		try {
			// 댓글 저장
			cnt = sqlSession.insert("board.repl", vo);
			if(cnt<1) throw new Exception("댓글 저장중 오류 발생");
			
			// 첨부 테이터 저장
			for(AttVo attVo : attList) {
				cnt = sqlSession.insert("board.att_insert", attVo);
				if(cnt<1) throw new Exception("첨부 데이터 저장중 오류 발생");
			}
			
			sqlSession.commit();
		}catch(Exception ex) {
			delFile(attList);
			sqlSession.rollback();
			msg = ex.getMessage();
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return msg;
		}
	}
	
	
	
	public List<AttVo> getAttList(int pserial){
		List<AttVo> attList = null;
		
		try {
			attList = sqlSession.selectList("board.att_list", pserial);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//sqlSession.close();
			return attList;
		}
	}
	
	
	
	
	//insert, modify에서 sql 오류가 발생할 때, 삭제할 때 공통 사용
	public void delFile(List<AttVo> delList) {
		for(AttVo attVo : delList) {
			File f = new File(FileUpload.upload + attVo.getSysFile() );
			if(f.exists()) f.delete();
		}
	}
	
}













