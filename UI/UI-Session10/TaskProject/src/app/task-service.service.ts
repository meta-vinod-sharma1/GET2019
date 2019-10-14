import { Injectable,NgModule } from '@angular/core';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  id =4;
  tasks: Array<Task> = [new Task(1,"task1","This is first task and first description","high"),new Task(2,"task2","This is first task and first description","medium"),
  new Task(3,"task3","This is first task and first description","low")];

  /**
   * this method used to add a new Task
   */
  addTask(title:String,description:String,priority:String) {
        let obj = new Task(this.id,title,description,priority);
        this.tasks.push(obj);
        this.id++;
  }

  /**
   * This method used to update a task
   */
  updateTask(taskId:any,status:String,title:String,description:String,priority:String){
      for (let index = 0; index < this.tasks.length; index++) {
        if(taskId == this.tasks[index].taskId){
          this.tasks[index].taskTitle= title;
          this.tasks[index].description = description;
          this.tasks[index].priority = priority;
          this.tasks[index].status = status; 
        }
        
      }
  }
 
  constructor() { 
    
  }
  
  
}
