export class Task {
    public taskId:any;
    public taskTitle:String;
    public description:String;
    public creationDate:Date;
    public completionDate:Date;
    public status:String;
    public priority:String;

    constructor(taskId,taskTitle, description, priority ) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.description = description;
        this.priority = priority;
        this.creationDate = new Date();
        this.status = "new";
      }
}
