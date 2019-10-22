import { Component, OnInit } from '@angular/core';
import { CartServiceService } from '../service/cart-service.service';

@Component({
  selector: 'app-shipping',
  templateUrl: './shipping.component.html',
  styleUrls: ['./shipping.component.css']
})
export class ShippingComponent implements OnInit {

  netAmount;
  cartList;
  constructor(private myService : CartServiceService) { 
    this.cartList = myService.cartList;
  }

  netAmountCalc(){
    this.netAmount = 0;
    this.cartList.forEach(element => {
      this.netAmount += element.qty * element.item.price;
    });
    return this.netAmount;
  }
  order(event){
   return false;
  }
  ngOnInit() {
  }

}
