/**
 * list is collection of items
 */

package shop;
import java.util.ArrayList;
public class itemList {
	 ArrayList<item> list=new ArrayList<item>();
	void create(){
		item item1 = new item("Bat       ",12.50,10);
		list.add(item1);
		item item2 = new item("Basketball",7,10);
		list.add(item2);
		item item3 = new item("Football  ",50,10);
		list.add(item3);
		item item4 =new item("Hockey     ",120,10);
		list.add(item4);
	}

}