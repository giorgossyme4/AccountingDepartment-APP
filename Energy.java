public class Energy extends FlatFeeAndUse{
	
	private double kwh;
	private static final double monthlyERTuse = 20;
	private double municipalityFees = 10;
	
	public Energy() {
		super();
	}
	
	public Energy (double code, String description, double pricePerConsumerUnit, String measurementUnit, double monthlyFee, double kwh){
		super(code, description, pricePerConsumerUnit, measurementUnit, monthlyFee);
		this.kwh = kwh;
	}
	
	public double getKwh() {
		return kwh;
	}
	
	public void setKwh(double kwh) {
		this.kwh = kwh;
	}
	
	public void setPricePerConsumerUnit (double pricePerConsumerUnit){	
		super.pricePerConsumerUnit = pricePerConsumerUnit;
	}
	
	public double energy(double pricePerConsumerUnit, double monthlyFee, double kWh) {
		return monthlyFee + monthlyERTuse + municipalityFees + (pricePerConsumerUnit * kWh);
	}
	
	public String print() {
		return super.print() + "\t Monthly ERT use: " +monthlyERTuse+ "\t Municipality fees: " +municipalityFees+ "\t Kwh: " +getKwh();
	}
}
		