import { Component } from '@angular/core';
import { CartServiceService } from './service/cart-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ShoppingCart';
  constructor(private myService : CartServiceService){
    
  }
}
