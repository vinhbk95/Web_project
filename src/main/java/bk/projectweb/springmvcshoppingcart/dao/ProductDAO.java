package bk.projectweb.springmvcshoppingcart.dao;
 
import bk.projectweb.springmvcshoppingcart.entity.Product;
import bk.projectweb.springmvcshoppingcart.model.PaginationResult;
import bk.projectweb.springmvcshoppingcart.model.ProductInfo;
 
public interface ProductDAO {
 
    
    
    public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage, String likeName, int check);
    
//    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
//                       int maxNavigationPage, String likeName);
 
    public void save(ProductInfo productInfo);
    
}