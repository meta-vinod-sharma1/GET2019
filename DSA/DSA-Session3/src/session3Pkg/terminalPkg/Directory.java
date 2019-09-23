package session3Pkg.terminalPkg;
import java.util.*;
/**
 * This class used to create a new Directory
 * @author Vinod
 * Dated 08/04/2019
 */
public class Directory {

	public String directoryName;
	public ArrayList<Directory> subDirectory;
	
	Directory(String directoryName) {
		this.directoryName=directoryName;
		this.subDirectory=new ArrayList<>();
	}
}
