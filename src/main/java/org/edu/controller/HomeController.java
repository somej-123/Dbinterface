package org.edu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.edu.dao.IF_SampleDAO;
import org.edu.service.IF_SampleService;
import org.edu.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject 
	private IF_SampleService sampleservice;//실행 가능한 클래스를 만들때 사용합니다.
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/create", method = RequestMethod.POST)
	public String createMember(MemberVO memberVO, Model model ,  RedirectAttributes rdat) throws Exception {
		
		sampleservice.insertMember(memberVO);
		return "redirect:/";
		}
	//회원수정을 위한 경로
	@RequestMapping(value = "/admin/member/update", method = RequestMethod.POST)
	public String updateMember(MemberVO memberVO, Model model ,  RedirectAttributes rdat) throws Exception {
		
		sampleservice.updateMember(memberVO);
		return "redirect:/";
		}
	@RequestMapping(value = "/admin/member/delete", method = RequestMethod.POST)
	public String deleteMember(@RequestParam("userid") String userid,MemberVO memberVO, Model model ,  RedirectAttributes rdat) throws Exception {
		
		sampleservice.deleteMember(userid);
		return "redirect:/";//삭제 된 후 화면 리플레쉬 하는 효과를 줌
		}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		String maker = "우정호";
		model.addAttribute("jspMaker", maker);//괄호안은 인자
		//제네릭타입-List<T>를 사용하는 이유는 실행시(runtime)에서만 발생될 수 있는 에러를
		//서버에 올리기 전에 미리 이클립스 단에서 컴파일시 에러를 확인 가능하게 하기 위해서
		List<MemberVO> list = sampleservice.selectMember();
		model.addAttribute("memberList", list);
		return "home";
	}
	
}
