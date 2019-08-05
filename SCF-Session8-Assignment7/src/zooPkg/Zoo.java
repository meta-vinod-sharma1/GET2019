package zooPkg;

import java.util.ArrayList;

import zonePkg.Cage;
import zonePkg.Zone;
	
public class Zoo {
	int totalAnimal = 0;
	int totalZone = 0;
	static int  zoneId = 1;	
	public ArrayList<Zone> zoneList = new ArrayList<Zone>();
	
	public void addZone(String category, int cageLimit, boolean hasPark, boolean hasCanteen){
		//first zone added in Zoo
		Zone zone = new Zone(category, zoneId++ , cageLimit, hasPark, hasCanteen);
		zoneList.add(zone);
		totalZone++;
		
	}

}
