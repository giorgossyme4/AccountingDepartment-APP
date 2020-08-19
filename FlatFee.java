public class FlatFee extends spending {
	
	private double pricePerSquareMeter;
	
	public FlatFee() {
		super();
	}
	
	public FlatFee(double code, String description, double pricePerSquareMeter) {
		
		super(code, description);
		this.pricePerSquareMeter = pricePerSquareMeter;
	}
	
	public double RentOrCleaning(double pricePerSquareMeter, double squareMeter) {
		double spending = pricePerSquareMeter * squareMeter;
		return spending;
	}
	
	public double getPricePerSquareMeter() {
		return pricePerSquareMeter;
	}
	
	public void setPricePerSquareMeter(double pricePerSquareMeter) {
		this.pricePerSquareMeter = pricePerSquareMeter;
	}
	
	public double getCode() {
		return super.getCode();
	}
	
	public String getDescription() {
		return super.getDescription();
	}
	
	public String print() {
		return super.print() + "\t Price per square meter: "+getPricePerSquareMeter();
	}
		
}