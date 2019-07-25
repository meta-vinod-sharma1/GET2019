package zonePkg;

import java.util.ArrayList;

public class Zone {
	public String name;
	public String zoneCategory;
	public int id;
	public ArrayList<Cage> cageList = new ArrayList<Cage>();
	public int cageLimit;
	boolean hasPark;
	boolean hasCanteen;
	public Zone(String name, String category, int id, int cageLimit, boolean hasPark, boolean hasCanteen){
		this.name = name;
		this.zoneCategory = category;
		this.id = id;
		this.cageLimit = cageLimit;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}
	
	public void addCage(String animalType, int animalLimit){
		if(cageList.size() <= cageLimit){
			Cage cage = new Cage(animalType,animalLimit);
			cageList.add(cage);	
		}else{
			System.out.println("Zone don't have space for new Cage !! Please try in another Zone");
		}
	}
}
