import { Component, OnInit } from '@angular/core';
import { CartServiceService } from '../service/cart-service.service';
import { item } from '../entities/item';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent implements OnInit {
  public orderList;
  constructor(myService:CartServiceService) {
    this.orderList = myService.orderList;
  }

  ngOnInit() {
  }

}
