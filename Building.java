public class Building {
	
	private double password;
	private String description;
	private String address;
	private double priceZone;
	private double squareMetres;
	
	public Building() {
	}
	
	public Building(double password, String description, String address, double priceZone, double squareMetres) {
		
		this.password = password;
		this.description = description;
		this.address = address;
		this.priceZone = priceZone;
		this.squareMetres = squareMetres;
		
	}
	
	
	public double getPassword() {
		
		return password;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public double getPriceZone() {
		
		return priceZone;
	}
	
	public double getSquareMetres() {
		
		return squareMetres;
	}
	
	public void setPassword (double password){
		
		this.password = password;
	}
	
	public void setDescription (String description){
		
		this.description = description;
	}
	
	public void setAddress (String address){
		
		this.address = address;
	}
	
	public void setPriceZone (double priceZone){
		
		this.priceZone = priceZone;
	}
	
	public void setSquareMetres (double squareMetres){
		
		this.squareMetres = squareMetres;
	}
	
	public String print() {
       
	   return "\n Password: "+getPassword()+ "\t Description: " +getDescription()+ "\t Address: " +getAddress()+ "\t Price Zone: " +getPriceZone()+ "\t Square Meters: " +getSquareMetres();
    }
}
	