package co.micol.prj.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {
	
	@RequestMapping("/shopDatil.do")
	public String datail() {
		return "detail/shopDatil";
	}
}
