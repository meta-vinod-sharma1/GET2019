export class item{
    public id:any;
    public name;
    public price;
    public description;
    public imgUrl;
    public category;

    constructor( id, name:string, price, description:string, imgUrl:string, category:string){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
        this.category = category;
       
    }
}