package zooPkg;

import java.util.ArrayList;

import zonePkg.Cage;
import zonePkg.Zone;
	
public class Zoo {
	int totalAnimal = 0;
	static int  zoneId = 1;	
	public ArrayList<Zone> zoneList = new ArrayList<Zone>();
	
	public void addZone(){
		//first zone added in Zoo
		Zone zone1 = new Zone("Zone1", "Mammal",zoneId++, 5, true, false);
		zone1.addCage("Tiger",1);
		zone1.addCage("Lion",1);
		
		//first zone added in Zoo
		Zone zone2 = new Zone("Zone2", "Reptile",zoneId++, 3, true, false);
		zone2.addCage("Lizard", 1);
		zone2.addCage("Snake", 1);
			
		//first zone added in Zoo
		Zone zone3 = new Zone("Zone3", "Bird",zoneId++, 4, true, false);
		zone2.addCage("Pigeon", 1);
		zone2.addCage("Parrot", 1);
			
		//first zone added in Zoo
		Zone zone4 = new Zone("Zone4", "Mammal",zoneId++, 2, true, false);
		zoneList.add(zone1);
		zoneList.add(zone2);
		zoneList.add(zone3);
		zoneList.add(zone4);
		
	}
	
	public ArrayList<Zone> getZoneList(){
		return zoneList;
	}
	
}
