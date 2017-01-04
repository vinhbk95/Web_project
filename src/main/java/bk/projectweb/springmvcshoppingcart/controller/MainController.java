package bk.projectweb.springmvcshoppingcart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bk.projectweb.springmvcshoppingcart.model.CartInfo;
import bk.projectweb.springmvcshoppingcart.model.CustomerInfo;
import bk.projectweb.springmvcshoppingcart.model.PaginationResult;
import bk.projectweb.springmvcshoppingcart.model.ProductInfo;
import bk.projectweb.springmvcshoppingcart.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bk.projectweb.springmvcshoppingcart.dao.OrderDAO;
import bk.projectweb.springmvcshoppingcart.dao.ProductDAO;
import bk.projectweb.springmvcshoppingcart.entity.Product;
import bk.projectweb.springmvcshoppingcart.validator.CustomerInfoValidator;

@Controller
// Cần thiết cho Hibernate Transaction.
@Transactional
// Cáº§n thiáº¿t Ä‘á»ƒ sá»­ dá»¥ng RedirectAttributes
@EnableWebMvc
public class MainController {

	static String test = "";
	// @Autowired: Tá»± Ä‘á»™ng liÃªn káº¿t cÃ¡c bean Ä‘Æ°á»£c sá»­ dá»¥ng trong
	// cÃ¡c class vá»›i cÃ¡c
	// bean Ä‘Æ°á»£c Spring Container sinh ra vÃ  quáº£n lÃ½.
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CustomerInfoValidator customerInfoValidator;

	// @InitBinder: dÃ¹ng Ä‘á»ƒ Ä‘Ã¡nh dáº¥u má»™t phÆ°Æ¡ng thá»©c cÃ³ tÃ¹y
	// biáº¿n cÃ¡c rÃ ng buá»™c dá»¯ liá»‡u.
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		// TrÆ°á»�ng há»£p update SL trÃªn giá»� hÃ ng.
		// (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
		if (target.getClass() == CartInfo.class) {

		}

		// TrÆ°á»�ng há»£p save thÃ´ng tin khÃ¡ch hÃ ng.
		// (@ModelAttribute("customerForm") @Validated CustomerInfo
		// customerForm)
		else if (target.getClass() == CustomerInfo.class) {
			dataBinder.setValidator(customerInfoValidator);
		}

	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/productList";
	}

	// Danh sÃ¡ch sáº£n pháº©m.
	@RequestMapping({ "/productList" })
	public String listProductHandler(Model model, //
			@RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
		final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

		PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
				maxResult, maxNavigationPage, likeName, 0);

		Integer i = 4;
		model.addAttribute("paginationProducts", result);
		model.addAttribute("check", i);
		return "productList";
	}

	
	// Danh sach cac list san pham
		@RequestMapping({ "/iphone" })
		public String listProductHandler11(Model model, //
				@RequestParam(value = "name", defaultValue = "iphone") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 11);
			return "productList";
		}
		
		@RequestMapping({ "/samsung" })
		public String listProductHandler12(Model model, //
				@RequestParam(value = "name", defaultValue = "samsung") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 12);
			return "productList";
		}
	
		@RequestMapping({ "/oppo" })
		public String listProductHandler13(Model model, //
				@RequestParam(value = "name", defaultValue = "oppo") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 13);
			return "productList";
		}
		
		@RequestMapping({ "/xiaomi" })
		public String listProductHandler14(Model model, //
				@RequestParam(value = "name", defaultValue = "xiaomi") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 14);
			return "productList";
		}
	
		@RequestMapping({ "/lkdt" })
		public String listProductHandler15(Model model, //
				@RequestParam(value = "name", defaultValue = "lkdt") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 15);
			return "productList";
		}
		
		@RequestMapping({ "/macbook" })
		public String listProductHandler16(Model model, //
				@RequestParam(value = "name", defaultValue = "macbook") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 16);
			return "productList";
		}
		
		@RequestMapping({ "/dell" })
		public String listProductHandler17(Model model, //
				@RequestParam(value = "name", defaultValue = "dell") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 17);
			return "productList";
		}
		
		@RequestMapping({ "/hp" })
		public String listProductHandler18(Model model, //
				@RequestParam(value = "name", defaultValue = "hp") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 18);
			return "productList";
		}
		
		@RequestMapping({ "/asus" })
		public String listProductHandler19(Model model, //
				@RequestParam(value = "name", defaultValue = "asus") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 19);
			return "productList";
		}
		
		@RequestMapping({ "/lklt" })
		public String listProductHandler20(Model model, //
				@RequestParam(value = "name", defaultValue = "lklt") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 1);

			//Integer i = 7;
			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 20);
			return "productList";
		}
		
	@RequestMapping(value = { "/searchProduct" }, method = RequestMethod.GET)
	public String searchProduct(HttpServletRequest request, Model model, //
			 @RequestParam(value = "name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
		final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a
		
		String sea = request.getParameter("search");
		if(sea != null){
			likeName = sea;
		}
		
		model.addAttribute("buff", likeName);
		
		PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
				maxResult, maxNavigationPage, likeName, 1);

	 //Integer i = 6;
		model.addAttribute("paginationProducts", result);
	 model.addAttribute("check", 6);
		return "productList";
	}

	// Sắp xếp theo giá
	@RequestMapping({ "/productListSort" })
	public String listProductHandler1(Model model, //
			@RequestParam(value = "name", defaultValue = "pricesort") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
		final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

		PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
				maxResult, maxNavigationPage, likeName, 0);

		Integer i = 5;
		model.addAttribute("paginationProducts", result);
		model.addAttribute("check", i);
		return "productList";
	}
	
	
	// Sắp xếp theo tên
		@RequestMapping({ "/productListSortName" })
		public String listProductHandler23(Model model, //
				@RequestParam(value = "name", defaultValue = "namesort") String likeName,
				@RequestParam(value = "page", defaultValue = "1") int page) {
			final int maxResult = 9;// tá»‘i Ä‘a cho sáº£n pháº©m cá»§a 1 page
			final int maxNavigationPage = 10; // sá»‘ page tá»‘i Ä‘a

			PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
					maxResult, maxNavigationPage, likeName, 0);

			model.addAttribute("paginationProducts", result);
			model.addAttribute("check", 22);
			return "productList";
		}
		
		
	

	@RequestMapping(value = { "/productDetail" }, method = RequestMethod.GET)
	public String showProductDetail(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {

		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {
			ProductInfo productInfo = new ProductInfo(product);
			model.addAttribute("showProductInfo", productInfo);
		}

		return "productDetail";
	}

	@RequestMapping({ "/buyProduct" })
	public String listProductHandler(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {

		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {

			// ThÃ´ng tin giá»� hÃ ng cÃ³ thá»ƒ Ä‘Ã£ lÆ°u vÃ o trong Session
			// trÆ°á»›c Ä‘Ã³.
			CartInfo cartInfo = Utils.getCartInSession(request);

			ProductInfo productInfo = new ProductInfo(product);

			cartInfo.addProduct(productInfo, 1);
		}

		// Chuyá»ƒn sang trang danh sÃ¡ch cÃ¡c sáº£n pháº©m Ä‘Ã£ mua.
		return "redirect:/shoppingCart";
	}

	@RequestMapping({ "/shoppingCartRemoveProduct" })
	public String removeProductHandler(HttpServletRequest request, Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {
		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {

			// ThÃ´ng tin giá»� hÃ ng cÃ³ thá»ƒ Ä‘Ã£ lÆ°u vÃ o trong Session
			// trÆ°á»›c Ä‘Ã³.
			CartInfo cartInfo = Utils.getCartInSession(request);

			ProductInfo productInfo = new ProductInfo(product);

			cartInfo.removeProduct(productInfo);

		}

		// Chuyá»ƒn sang trang danh sÃ¡ch cÃ¡c sáº£n pháº©m Ä‘Ã£ mua.
		return "redirect:/shoppingCart";
	}

	// POST: Cáº­p nháº­p sá»‘ lÆ°á»£ng cho cÃ¡c sáº£n pháº©m Ä‘Ã£ mua.
	@RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
	public String shoppingCartUpdateQty(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("cartForm") CartInfo cartForm) {

		CartInfo cartInfo = Utils.getCartInSession(request);
		cartInfo.updateProduct("MD5", 3);
		cartInfo.updateQuantity(cartForm);

		// Chuyá»ƒn sang trang danh sÃ¡ch cÃ¡c sáº£n pháº©m Ä‘Ã£ mua.
		return "redirect:/shoppingCart";
	}

	// GET: Hiá»ƒn thá»‹ giá»� hÃ ng.
	@RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	public String shoppingCartHandler(HttpServletRequest request, Model model) {
		CartInfo mycart = Utils.getCartInSession(request);

		model.addAttribute("cartForm", mycart);
		return "shoppingCart";
	}

	// GET: Nháº­p thÃ´ng tin khÃ¡ch hÃ ng.
	@RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
	public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {

		CartInfo cartInfo = Utils.getCartInSession(request);

		// ChÆ°a mua máº·t hÃ ng nÃ o.
		if (cartInfo.isEmpty()) {

			// Chuyá»ƒn tá»›i trang danh giá»� hÃ ng
			return "redirect:/shoppingCart";
		}

		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		if (customerInfo == null) {
			customerInfo = new CustomerInfo();
		}

		model.addAttribute("customerForm", customerInfo);

		return "shoppingCartCustomer";
	}

	// POST: Save thÃ´ng tin khÃ¡ch hÃ ng.
	@RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.POST)
	public String shoppingCartCustomerSave(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("customerForm") @Validated CustomerInfo customerForm, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		// Káº¿t quáº£ Validate CustomerInfo.
		if (result.hasErrors()) {
			customerForm.setValid(false);
			// Forward to reenter customer info.
			// Forward tá»›i trang nháº­p láº¡i.
			return "shoppingCartCustomer";
		}

		customerForm.setValid(true);
		CartInfo cartInfo = Utils.getCartInSession(request);

		cartInfo.setCustomerInfo(customerForm);

		// Chuyá»ƒn hÆ°á»›ng sang trang xÃ¡c nháº­n.
		return "redirect:/shoppingCartConfirmation";
	}

	// GET: Xem láº¡i thÃ´ng tin Ä‘á»ƒ xÃ¡c nháº­n.
	@RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
	public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
		CartInfo cartInfo = Utils.getCartInSession(request);

		// ChÆ°a mua máº·t hÃ ng nÃ o.
		if (cartInfo.isEmpty()) {

			// Chuyá»ƒn tá»›i trang danh giá»� hÃ ng
			return "redirect:/shoppingCart";
		} else if (!cartInfo.isValidCustomer()) {

			// Chuyá»ƒn tá»›i trang nháº­p thÃ´ng tin khÃ¡ch hÃ ng.
			return "redirect:/shoppingCartCustomer";
		}

		return "shoppingCartConfirmation";
	}

	// POST: Gá»­i Ä‘Æ¡n hÃ ng (Save).
	@RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)

	// TrÃ¡nh ngoáº¡i lá»‡: UnexpectedRollbackException (Xem giáº£i thÃ­ch
	// thÃªm).
	@Transactional(propagation = Propagation.NEVER)
	public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
		CartInfo cartInfo = Utils.getCartInSession(request);

		// ChÆ°a mua máº·t hÃ ng nÃ o.
		if (cartInfo.isEmpty()) {

			// Chuyá»ƒn tá»›i trang danh giá»� hÃ ng
			return "redirect:/shoppingCart";
		} else if (!cartInfo.isValidCustomer()) {

			// Chuyá»ƒn tá»›i trang nháº­p thÃ´ng tin khÃ¡ch hÃ ng.
			return "redirect:/shoppingCartCustomer";
		}
		try {
			orderDAO.saveOrder(cartInfo);
		} catch (Exception e) {

			// Cáº§n thiáº¿t: Propagation.NEVER?
			return "shoppingCartConfirmation";
		}

		// XÃ³a rá»� hÃ ng khá»�i session.
		Utils.removeCartInSession(request);

		// LÆ°u thÃ´ng tin Ä‘Æ¡n hÃ ng Ä‘Ã£ xÃ¡c nháº­n mua.
		Utils.storeLastOrderedCartInSession(request, cartInfo);

		// Chuyáº¿n hÆ°á»›ng tá»›i trang hoÃ n thÃ nh mua hÃ ng.
		return "redirect:/shoppingCartFinalize";
	}

	@RequestMapping(value = { "/shoppingCartFinalize" }, method = RequestMethod.GET)
	public String shoppingCartFinalize(HttpServletRequest request, Model model) {

		CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);

		if (lastOrderedCart == null) {
			return "redirect:/shoppingCart";
		}

		return "shoppingCartFinalize";
	}

	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("code") String code) throws IOException {
		Product product = null;
		if (code != null) {
			product = this.productDAO.findProduct(code);
		}
		if (product != null && product.getImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImage());
		}
		response.getOutputStream().close();
	}

	@RequestMapping(value = { "/productImage1" }, method = RequestMethod.GET)
	public void productImage1(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("code") String code) throws IOException {
		Product product = null;
		if (code != null) {
			product = this.productDAO.findProduct(code);
		}
		if (product != null && product.getImage1() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getImage1());
		}
		response.getOutputStream().close();
	}

}