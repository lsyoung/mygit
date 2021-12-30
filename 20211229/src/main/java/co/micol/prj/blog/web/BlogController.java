package co.micol.prj.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping("/blog.do")
	public String blog() {
		return "blog/blog";
	}
}
