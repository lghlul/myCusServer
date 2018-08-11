package com.cad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

	@ModelAttribute("basePath")
	public String basePath(HttpServletRequest request) {
		String basePath = request.getContextPath();
		return basePath.endsWith("/") ? basePath.substring(0, basePath.length() - 1) : basePath;
	}

}
