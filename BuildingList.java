import java.util.*;

public class BuildingList {
      	   	
	public ArrayList <Building> buildings = new ArrayList <Building>();

    public void addBuilding(Building b){
        buildings.add(b);
    }
	
	public void removeB(int i) {
		buildings.remove(i);
	}

    public void listBuilding() {
        for( Building  b : buildings)
			System.out.print(b.print());
		System.out.println(" ");
    }
	
	public int numberOfBuildings() { 
		return buildings.size();
    }
	
	public void listPasswords() {
		for( Building  b : buildings)
			System.out.println("\n[ "+b.getPassword()+" ]");
		System.out.print("\n> ");
	}
	
	
	public Building ChooseBuilding (double code) {
		Building chosen = new Building();
        for(Building b : buildings){
			if (b.getPassword() == code){
				chosen = b;
				break;
			}
		}
		return chosen;				
    }
	
	
	public boolean OneCode(double newCode) {
		for (Building b : buildings) {
			if (b.getPassword() == newCode) {
				return false;
			}
		}
		return true;
	}
}











