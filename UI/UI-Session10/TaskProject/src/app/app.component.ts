import { Component, APP_BOOTSTRAP_LISTENER } from '@angular/core';
import { TaskServiceService } from './task-service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TaskProject';
  //todaydate;
   constructor(private myservice: TaskServiceService) {}
   ngOnInit() {
      //this.todaydate = this.myservice.showTodayDate();
   }
}
