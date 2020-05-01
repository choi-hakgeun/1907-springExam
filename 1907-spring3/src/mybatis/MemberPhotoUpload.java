package mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Page;

public class MemberPhotoUpload {
	public static String upload = "N:/workspace/1907/1907-spring/WebContent/photo/";
	                               
	String tempDir = "c:/temp/";
	
	int maxSize = 1024*1024*50;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public MemberPhotoUpload(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	public boolean uploadFormCheck() {
		boolean flag = ServletFileUpload.isMultipartContent(req);
		
		return flag;
	}
	public HttpServletRequest uploading() {
		MemberVo vo = new MemberVo();
		List<MemberPhoto> attList = new ArrayList<MemberPhoto>();
		List<MemberPhoto> delList = new ArrayList<MemberPhoto>();
		Page p = new Page(); 
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir) );
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi : list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
					switch(k) {
					case "mId": // <input type='text' name='Id'/>
						vo.setmId(v);break;
					case "pwd":
						vo.setPwd(v);break;
					case "mName":
						vo.setmName(v);break;
					case "rDate":
						vo.setrDate(v);break;
					case "grade":
						vo.setGrade(Integer.parseInt(v));break;
					case "delFile":
						MemberPhoto attVo = new MemberPhoto();
						attVo.setSysFile(v);
						delList.add(attVo);break;
						
					case "findStr":
						p.setFindStr(v);break;
					case "nowPage":
						p.setNowPage(Integer.parseInt(v));break;
					}
				}else { // <input type='file'/>
					if(fi.getSize()>0) {
						String f = fi.getName();
						String sysfile = new Date().getTime() + "-" +f ;
						MemberPhoto attVo = new MemberPhoto();
						attVo.setmId(vo.getmId());
						attVo.setOriFile(f);
						attVo.setSysFile(sysfile);
						attList.add(attVo);
						
						File file = new File(upload + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("vo", vo);
		req.setAttribute("attList", attList);
		req.setAttribute("delList", delList);
		req.setAttribute("p", p);
		
		return req;
		
	}
}
