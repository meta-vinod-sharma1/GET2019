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
	
	public boolean addCage(String animalType, int animalLimit){
		boolean flag = false;
		if(cageList.size()<cageLimit){
			Cage cage = new Cage(animalType,animalLimit);
			cageList.add(cage);	
			flag = true;
		}
		return flag;
	}
}
