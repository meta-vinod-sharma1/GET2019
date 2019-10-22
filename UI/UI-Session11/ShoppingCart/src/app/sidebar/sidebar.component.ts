import { Component, OnInit } from '@angular/core';
import { CartServiceService } from '../service/cart-service.service';
import { ProductListComponent } from '../product-list/product-list.component';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  productCmpObj;

  constructor(private myService : CartServiceService) {
    this.productCmpObj =new ProductListComponent(this.myService,);
  }
  ngOnInit() {
  }

}
