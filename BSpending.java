import java.lang.*;

public class BSpending {
	
	private Building build;
	private FlatFee flatfee;
	private Water water;
	private Energy energy;
	private Telephone phone;
	
	
	public BSpending() {
	}
	
	public BSpending(Building build, FlatFee flatfee) {
		this.build = build;
		this.flatfee = flatfee;
	}
	
	
	public BSpending(Building build, Water water) {
		this.build = build;
		this.water = water;
	}
	
	public BSpending(Building build, Energy energy) {
		this.build = build;
		this.energy = energy;
	}
	
	public BSpending(Building build, Telephone phone) {
		this.build = build;
		this.phone = phone;
	}
	
	public Building getBuilding() {
		return build;
	}
	
	public String getspending() {
		spending s = new spending();
		return s.print();
	}
	
	public String getbuilding() {
		return build.print();
	}
	
	public FlatFee getFlatfee() {
		return flatfee;
	}
	
	public String getflatfee() {
		return flatfee.print();
	}
	
	public Water getWater() {
		return water;
	}
	
	public String getwater() {
		return water.print();
	}
	
	public Energy getEnergy() {
		return energy;
	}
	
	public String getenergy() {
		return energy.print();
	}
	
	public Telephone getTelephone() {
		return phone;
	}
	
	public String gettelephone() {
		return phone.print();
	}
	
	public String print() {
		return "\n[Building: "+getbuilding()+ "\nFlat Fee: " +getflatfee() +"]";
	}
	
	public String printW() {
		return "\n[Building: "+getbuilding()+ "\nWater: " +getwater() +"]";
	}
	
	public String printE() {
		return "\n[Building: "+getbuilding()+ "\nEnergy: " +getenergy() +"]";
	}
	
	public String printT() {
		return "\n[Building: "+getbuilding()+ "\nTelephone: " +gettelephone() +"]";
	}
}	
		
	
	