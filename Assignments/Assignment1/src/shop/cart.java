
/**
 * il is the object of ItemList class
 * list is the Array-list of itemList class
 * s is Scanner Object for input
 */
package shop;
import java.util.*;

public class cart{
	ArrayList<item> cartList=new ArrayList<item>();   
	
	Scanner s= new Scanner(System.in);   
	
	
	void addItemInCart(itemList il){    //Method For Adding Item IN The Cart
				System.out.println("\tPlease Press the item Code Which you want\n");
				System.out.println("Item Code\tItem Name\t\tItem Price\t");
				for(int i=0;i<il.list.size();i++){
					System.out.println((i+1)+"\t\t"+il.list.get(i).name+"\t\t"+il.list.get(i).price);
				}
				int itemCode=s.nextInt();
				
				if(itemCode>0 && itemCode<5){
					if(isItemAlreadyInList(il.list.get(itemCode-1).name)==true){
						System.out.println("!! Product is already in the List");
					}else{
						System.out.print("\t\tHow Many Quantity You Want : ");
						int qty_num=s.nextInt();
						if(qty_num<=0){
							System.out.println("Opps!! Invalid Choice");
						}else{
							if(qty_num <= il.list.get(itemCode-1).qty){
								item cart_item = new item(il.list.get(itemCode-1).name,il.list.get(itemCode-1).price,qty_num);
								cartList.add(cart_item);
							}else{
								System.out.println("Sorry This Much Quantity is Not Available");
							}
						}
					}
				}else System.out.println("Opps It's Invalid Value");

				
	}
	
	
	
	void updateItemInCart(itemList il){
		if(cartList.isEmpty()==true){
			System.out.println("Sorry!! Your Cart is Empty");
		}else{
			displayCart();
			System.out.println("Press the Item Code Which do you want Update");
			int itemCode=s.nextInt();
			System.out.println("How Many Quantity do You want Now? :");
			int newQty=s.nextInt();
			if(newQty<= 10){
				item updateCart_item = new item(cartList.get(itemCode-1).name,cartList.get(itemCode-1).price,newQty);
				cartList.set((itemCode-1),updateCart_item);
				System.out.println("\t\tYour Cart is Succesfully Updated");
			
			}else{
				System.out.println("\t\tThis much Quantity is not available");
			}
		}
		
	}
	
	
	void removeItemInCart(){
		if(cartList.isEmpty()==true){
			System.out.println("Sorry!! Your Cart is Empty");
		}else{
			displayCart();
			System.out.print("Item Code which you want to Remove :");
			int ItemCode=s.nextInt();
			if(ItemCode<1 || ItemCode>cartList.size()){
				System.out.println("Invalid Choice");
			}else{
				cartList.remove(ItemCode-1);
				System.out.println("Your Item is Succesfully Removed");
			}
		}
	}
	
	
	void displayCart(){
		if(cartList.isEmpty()){
			System.out.println("Sorry!! Your Cart is Empty");
		}else{
			System.out.println("\tItem Code\t\tItem Name \t\t Qty\t\t\tPrice");
			for(int i=0;i<cartList.size();i++){
				System.out.println("\t"+(i+1)+"\t\t\t"+cartList.get(i).name+"\t\t\t  "+cartList.get(i).qty+"\t\t"+cartList.get(i).price);
			}
		}
	}
	
	
	void bill(){
		if(cartList.isEmpty()==true){
			System.out.println("Sorry !! You Don't have any item in the Cart\n");
		}else{
			double totalPrice=0;
			System.out.println("\t\t\t\tYour Bill ");
			System.out.println("\t\tItem\t\t QTY\t\tPrice ");
			for(int i=0;i<cartList.size();i++){
				System.out.println("\t\t"+cartList.get(i).name+"\t\t  "+cartList.get(i).qty+"\t\t"+cartList.get(i).price);
				totalPrice=totalPrice+cartList.get(i).price*cartList.get(i).qty;
			}
			System.out.println("\t\tTotal Price : " +totalPrice);
		}
		
	}
	boolean isItemAlreadyInList(String itemName){
		for(int i=0;i<cartList.size();i++){
			if(cartList.get(i).name==itemName){
				return true;
			}
		}
		return false;
	}
}
