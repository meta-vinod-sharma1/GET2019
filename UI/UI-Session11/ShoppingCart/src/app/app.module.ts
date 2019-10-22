import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { HttpClientModule} from "@angular/common/http";
import { CartServiceService } from './service/cart-service.service';
import { RouterModule, Routes } from '@angular/router';
import { BreadComponent } from './bread/bread.component';
import { CartComponent } from './cart/cart.component';
import { ShippingComponent } from './shipping/shipping.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';

const appRoutes: Routes = [
  { path: 'cart', component: CartComponent },
  { path: 'item/:id',      component: ProductListComponent },
  {
    path: 'home',
    component: ProductListComponent,
    data: { title: 'Heroes List' }
  },
  { path: 'shipping',
  component: ShippingComponent,
  },
  
  { path: 'thanks',
  component: ThankYouComponent,
  },
  { path: 'order',
  component: MyOrdersComponent,
  },
  { path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  
  { path: '**', component: HeaderComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    ProductListComponent,
    BreadComponent,
    CartComponent,
    ShippingComponent,
    ThankYouComponent,
    MyOrdersComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [CartServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
