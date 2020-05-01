package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.MemberMybatisDao;
import bean.Page;
import mybatis.MemberPhoto;
import mybatis.MemberPhotoUpload;
import mybatis.MemberVo;

@Controller
public class MemberController {
	MemberMybatisDao dao;
	
	public MemberController(MemberMybatisDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value="/select.mm", 
			            method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String findStr = req.getParameter("findStr");
		Page p = new Page();
		p.setFindStr(findStr);
		if(req.getParameter("nowPage") == null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		List<MemberVo> list = dao.select(p);
		mv.addObject("p", p);
		mv.addObject("list", list);		
		return mv;
	}

	
	
	@RequestMapping(value="/insert.mm", method=RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insert");
		return mv;
	}
	
	@RequestMapping(value="/insertR.mm", method=RequestMethod.POST)
	public  ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
		 
		ModelAndView mv = new ModelAndView();
		String msg = null;
		MemberVo vo = new MemberVo();
		
		//FileUpload
		MemberPhotoUpload fu = new MemberPhotoUpload(req, resp);
		fu.uploading();
		
		vo = (MemberVo)req.getAttribute("vo");
		List<MemberPhoto> attList = (List<MemberPhoto>)req.getAttribute("attList");
		
		System.out.println("mId : " + vo.getmId());
		
		msg = dao.insert(vo, attList);
		
		mv.addObject("p", req.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}	
	
	
	
	@RequestMapping(value="/view.mm", method= {RequestMethod.POST})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = null;
		List<MemberPhoto> attList = null;
		String mId = req.getParameter("mId");
		vo = dao.view(mId);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		if(req.getParameter("nowPage") == null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		mv.addObject("p", p);
		mv.addObject("vo", vo);
		mv.setViewName("view");
		return mv;
	}
	@RequestMapping(value="/modify.mm", method= {RequestMethod.POST})
	public ModelAndView modify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = null;
		String mId = req.getParameter("mId");
		
		vo = dao.view(mId);
		List<MemberPhoto> attList = dao.getAttList(mId);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		
		mv.addObject("p", p);
		mv.addObject("vo", vo);
		mv.addObject("attList", attList);
		mv.setViewName("modify");
		return mv;
	}	
	
	@RequestMapping(value="/modifyR.mm", method= {RequestMethod.POST})
	public ModelAndView modifyR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = null;
		List<MemberPhoto> attList = null;
		List<MemberPhoto> delList = null;
		Page p = null;
		
		MemberPhotoUpload fu = new MemberPhotoUpload(req, resp);
		fu.uploading();
		
		
		
		vo = (MemberVo)req.getAttribute("vo");
		attList = (List<MemberPhoto>)req.getAttribute("attList");
		delList = (List<MemberPhoto>)req.getAttribute("delList");
		
		String msg = dao.modify(vo, attList, delList);
		
		mv.addObject("msg", msg);
		mv.addObject("p", req.getAttribute("p"));
		mv.setViewName("result");
		return mv;
	}	

	@RequestMapping(value="/deleteR.mm", method= {RequestMethod.POST})
	public ModelAndView deleteR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = new MemberVo();
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		Page p = new Page();
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		p.setFindStr(req.getParameter("findStr"));
		
		vo.setmId(mId);
		vo.setPwd(pwd);
		String msg = dao.delete(vo);
		
		mv.addObject("p", p);
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}	
	
	// 로그인 | 로그아웃 처리
	@RequestMapping(value="/login.mm", method= {RequestMethod.POST}, produces="application/text;charset=utf-8")
	@ResponseBody
	public String login(HttpServletRequest req) {
		
		String msg = "환영~~";
		MemberVo vo = new MemberVo();
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		
		vo.setmId(mId);
		vo.setPwd(pwd);
		boolean loginResult = dao.login(vo);
		if( loginResult ) {
			HttpSession session = req.getSession();
			session.setAttribute("session_id", mId);
		}else {
			msg = "아이디나 암호 다시 확인 !!! ";
		}

		return msg;
	}	
	
	@RequestMapping(value="logout.mm", method= {RequestMethod.POST},produces="application/text;charset=utf-8")
	@ResponseBody
	public String logout(HttpServletRequest req) {
		
		String msg = "다음에 다시 보는 걸로~~";

		HttpSession session = req.getSession();
		session.removeAttribute("session_id");
		return msg;
	}	
	
	
}
