package ezen.yorizori.web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.yorizori.domain.member.service.MemberService;
import ezen.yorizori.domain.member.service.MemberServiceImpl;

/**
 * 회원 아이디 중복 여부 반환
 */
@WebServlet("/member/idcheck.do")
public class IdDupCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 비즈니스 객체 사용
	private MemberService memberService = new MemberServiceImpl();
		
	/**
	 * 회원 아이디 중복 체크
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  id = request.getParameter("id");
		boolean exist = memberService.existId(id);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(!exist);
	}
}












