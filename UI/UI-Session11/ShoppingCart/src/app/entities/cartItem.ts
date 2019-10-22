import { item } from '../entities/item';
export class cartItem{
    public item;
    public qty;
    
    constructor(item:item, qty:any){
        this.item = item;
        this.qty = qty;
    }
}