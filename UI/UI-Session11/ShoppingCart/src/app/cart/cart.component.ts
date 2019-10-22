import { Component, OnInit } from '@angular/core';
import { CartServiceService } from '../service/cart-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartList;
  constructor(private myService :CartServiceService) {
    this.cartList = myService.cartList;
   }
  
  increaseQty(id:any){
    this.myService.updateCartQty(id,'+');
  }
  decreaseQty(id:any){
    this.myService.updateCartQty(id,'-');
  }
  ngOnInit() {
  }

}
