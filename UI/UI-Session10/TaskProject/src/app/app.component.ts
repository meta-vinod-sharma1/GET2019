import { Component, APP_BOOTSTRAP_LISTENER,ChangeDetectorRef,OnInit , NgModule } from '@angular/core';
import { TaskServiceService } from './task-service.service';
import { FormBuilder,FormGroup } from '@angular/forms';
import { NONE_TYPE } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TaskProject';
  public tasks;
  newTaskModal = 'none';
  editTaskModal = 'none';
  public editTask;
  eId;
  eTitle;
  eDescription;
  eStatus;
  ePriority;

  myForm :FormGroup;
  myFormOne :FormGroup;
 
  constructor(private myservice: TaskServiceService, private fb: FormBuilder,) {
     this.tasks = myservice.tasks
  }
  ngOnInit() {
    this.createForm();
    this.createFormOne();
  }
 
  /**
   * This method used to collects data from new task add form
   */
  createForm() {
    this.myForm = this.fb.group({
      taskId:[''],
      status:[''],
      taskTitle: [''],
      description: [''],
      priority:[''],
    });
  }
  /**
   * this method used to collects edit form data
   */
  createFormOne() {
    this.myFormOne = this.fb.group({
      taskId:[''],
      status:[''],
      taskTitle: [''],
      description: [''],
      priority:[''],
    });
  }

  /**
   * This method used to render data in the modal for edit 
   */
  editData(index:any){
   this.openModel('edit');
   this.editTask = this.tasks[index-1];
   this.eId = this.editTask.taskId;
   this.eTitle = this.editTask.taskTitle;
   this.eDescription = this.editTask.description;
   this.eStatus = this.editTask.status;
   this.ePriority = this.editTask.priority;
  }
  /**
   * This method used to add a new task in the Tasks
   */
  onSubmit() {
      this.myservice.addTask(this.myForm.value.taskTitle,this.myForm.value.description,this.myForm.value.priority);
      this.myForm.reset();
      this.closeModel();
    
  }
  /**
   * This method is used to call updateTask on service 
   */
  onEdit(){
    this.myservice.updateTask(this.myFormOne.value.taskId,this.myFormOne.value.status,this.myFormOne.value.taskTitle,
      this.myFormOne.value.description,this.myFormOne.value.priority)
      this.myFormOne.reset();
      this.eId = '';
      this.closeModel();
  }
  /**
   * This method used to open a model of new task and edit task
   */
  openModel(type:String){
    if(type == 'edit'){
      this.editTaskModal = 'block';
    }else{
      this.newTaskModal = 'block'
    }
  }
  /**
   * This method used to close the form modal 
   */
  closeModel(){
    this.newTaskModal = 'none';
    this.editTaskModal = 'none';
  }
}
