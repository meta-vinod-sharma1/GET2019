import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  constructor() { }
  
  showTodayDate() {
    let ndate = new Date();
    return ndate;
 }
}
