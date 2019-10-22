import { Component, OnInit,NgModule, ChangeDetectorRef } from '@angular/core';
import { item } from '../entities/item';
import { CartServiceService } from '../service/cart-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public items;
  public cartList;
  public arrays = [];
  constructor( private myService : CartServiceService) {
    this.items = myService.items;
   }

  /**
   * This method will be used as to add a item in the cart
   */
  getItems(type:String){
    this.myService.getItems(type);
    this.items = this.myService.items;
  }
  addCart(id){
    let flag = 0;
    this.cartList = this.myService.cartList;
    this.cartList.forEach(element => {
      if(element.item.id == id){
        flag = 1;
      }
    });
    if(flag == 0){
      this.myService.addItemInCart(id);
    }else{
      alert('Item alredy in the cart'); 
    }
   
  }
  ngOnInit() {
    
  }

}
