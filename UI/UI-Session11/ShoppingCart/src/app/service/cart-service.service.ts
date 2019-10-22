import { Injectable,OnInit } from '@angular/core';
import { item } from '../entities/item';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { cartItem } from '../entities/cartItem';
import { Observable} from 'rxjs';
import { map, catchError } from 'rxjs/operators'; 
@Injectable({
  providedIn: 'root'
})
export class CartServiceService{
  
  cartList :Array<cartItem> = [];
  itemList:Array<item> = [];
  orderList:Array<cartItem> = [];
  itemCount = 0;
  items : Array<item> =[];
  public arrays;
  
  baseUrl: string = 'http://localhost:8080/ItemApi/api/items/get';
  

  constructor(private http: HttpClient, ) {
    this.getItemFromApi().subscribe(data=>{
      this.arrays = data.item;
      console.log(this.arrays);
      this.getItems('');
    });

   }
   
   getItemFromApi() : Observable<item[]>{
     return this.http.get<item[]>(this.baseUrl);
   }
  
  getItems(type:String) {
    this.items.splice(0,this.items.length);
    switch (type) {   
      case 'bread':
          this.arrays.forEach(element => {
            if(element.category == 'bread'){
              this.items.push(element);
            } 
          });
        break;
        case 'dairy':
          this.arrays.forEach(element => {
            if(element.category == 'dairy'){
              this.items.push(element);
            } 
          });
        break;
        case 'fruits':
          this.arrays.forEach(element => {
            if(element.category == 'fruit'){
              this.items.push(element);
            } 
          });
        break;
        case 'ss':
          this.arrays.forEach(element => {
            if(element.category == 'ss'){
              this.items.push(element);
            } 
          });
        break;
        case 'veg':
          this.arrays.forEach(element => {
            if(element.category == 'veg'){
              this.items.push(element);
            } 
          });
        break;
      default:
          this.arrays.forEach(element => {
            this.items.push(element);
          });
        break;
    }
  }
  /**
   * This method used to add a item in the cart
   * @param id id of item which is adding
   */
  addItemInCart(id: number) {
    this.items.forEach(item => {
      if(id == item.id){
          this.cartList.push(new cartItem(item,1));
          alert('Item is added in the cart');  
          this.itemCount++;
      }
    });
  }
   
  FilterItem(type:String){
    let count = this.items.length;
    for (let index = 0; index < count; index++) {
        this.items.pop();
    }
    
  }
  /**
   * This method used to increase item and decrease item in the cart
   */
  updateCartQty(id:any, type:String){
    for (let index = 0; index < this.cartList.length; index++) {
      const element = this.cartList[index];
      if(element.item.id == id){
        if(type == '+'){
          element.qty++;
        }else{
          if(element.qty == 1){
            this.cartList.splice(index,1);
            alert('Item is removed');
            this.itemCount--;
          }else{
            element.qty--;
          }
        }
        break;   
      } 
    }
  }
  /**
   * This method used to convert cart item to order when user ordered
   */
  cartToMyOrder(){
    const len = this.cartList.length;
    for (let index = 0; index < len; index++) {
      this.orderList.push(this.cartList.pop());
    }
    this.itemCount = 0;
  }
}
