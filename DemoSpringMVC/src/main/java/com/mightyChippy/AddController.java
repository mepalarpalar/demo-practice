package com.mightyChippy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@Autowired
	AddService addService;
	
	private int i;
	private int j;
	private int k;
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		checkParameter(request);
		execute();
		
		//preparing model to be passed in client
		//added comment for git push testing
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", k);
		
		return mv;
	}
	
	public void checkParameter(HttpServletRequest request) {
		i = Integer.parseInt(request.getParameter("t1"));
		j = Integer.parseInt(request.getParameter("t2"));
	}
	
	public void execute() {
		k = addService.add(i, j);
	}
}
