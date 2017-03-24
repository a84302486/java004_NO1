package _20_ShoppingCart;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class ShoppingCart {

	public ShoppingCart() {
	}
	
	private Map<Object ,OrderItemBean> cart = new LinkedHashMap< >();
	public Map<Object, OrderItemBean>  getContent() {  // ${ShoppingCart.content}
		return cart;
	}
	
	public void addToCart(String productId, OrderItemBean oi) {
		if (oi.getQty() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(productId) == null ) {
		    cart.put(productId, oi);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItemBean oib = cart.get(productId);
			// 加購的數量：oi.getQty()
			// 原有的數量：oib.getQty()			
			oib.setQty(oi.getQty() + oib.getQty());
			
			System.out.println("productId=" + productId + ",Qty=" +oib.getQty());
		}
	}
	// 修改商品的數量
	public boolean modifyQty(String productId, OrderItemBean  oi) {
		if ( cart.get(productId) != null && oi.getQty() > 0 ) {
	       cart.put(productId, oi);
	       return true;
		} else {
		   return false;
		}
	}
	public boolean modifyQty(String productId, int newQty) {
		if ( cart.get(productId) != null ) {
		   OrderItemBean  oi = cart.get(productId);
		   oi.setQty(newQty);
	       //cart.put(bookID, oi);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteProduct(String productId) {
		if ( cart.get(productId) != null ) {
	       cart.remove(productId);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Object> set = cart.keySet();
		for(Object n : set){
			double price    = cart.get(n).getPgPrice();
			int    qty      = cart.get(n).getQty();
			subTotal +=  price * qty;
		}
		return subTotal;
	}
}
