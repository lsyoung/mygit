package co.micol.prj.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@RequestMapping("/cart.do")
	public String cart() {
		return "shop/cart";
	}
}
