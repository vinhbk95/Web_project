package bk.projectweb.springmvcshoppingcart.util;
 
import javax.servlet.http.HttpServletRequest;
 
import bk.projectweb.springmvcshoppingcart.model.CartInfo;
 
public class Utils {
  
   // ThÃ´ng tin cÃ¡c máº·t hÃ ng Ä‘Ã£ mua, Ä‘Æ°á»£c lÆ°u trá»¯ trong Session.
   public static CartInfo getCartInSession(HttpServletRequest request) {
 
  
       // ThÃ´ng tin giá»� hÃ ng cÃ³ thá»ƒ Ä‘Ã£ lÆ°u vÃ o trong Session trÆ°á»›c Ä‘Ã³.
       CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
      
  
       // Náº¿u chÆ°a táº¡o giá»� hÃ ng, táº¡o nÃ³.
       if (cartInfo == null) {
           cartInfo = new CartInfo();
          
  
           // VÃ  lÆ°u vÃ o trong session.
           request.getSession().setAttribute("myCart", cartInfo);
       }
 
       return cartInfo;
   }
 
   public static void removeCartInSession(HttpServletRequest request) {
       request.getSession().removeAttribute("myCart");
   }
 
   public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
       request.getSession().setAttribute("lastOrderedCart", cartInfo);
   }
  
   public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
       return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
   }
 
}