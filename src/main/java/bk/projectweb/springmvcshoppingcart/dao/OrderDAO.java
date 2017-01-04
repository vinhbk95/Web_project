package bk.projectweb.springmvcshoppingcart.dao;
 
import java.util.List;
 
import bk.projectweb.springmvcshoppingcart.model.CartInfo;
import bk.projectweb.springmvcshoppingcart.model.OrderDetailInfo;
import bk.projectweb.springmvcshoppingcart.model.OrderInfo;
import bk.projectweb.springmvcshoppingcart.model.PaginationResult;
 
public interface OrderDAO {
 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}