public class Telephone extends FlatFeeAndUse {
	
	private double CallDuration;
	private static final double monthlyTelephoneFee = 20;
	
	public Telephone() {
		super();
	}
	
	public Telephone (double code, String description, double pricePerConsumerUnit, String measurementUnit, double monthlyFee, double CallDuration){
		super(code, description, pricePerConsumerUnit, measurementUnit, monthlyFee);
		this.CallDuration = CallDuration;
	}
	
	public double getCallDuration(){
		return CallDuration;
	}
	
	public void setCallDuration(double CallDuration){
		this.CallDuration = CallDuration;
	}
	
	public void setPricePerConsumerUnit (double pricePerConsumerUnit){
		super.pricePerConsumerUnit = pricePerConsumerUnit;
	}
	
	public double phone(double pricePerConsumerUnit, double monthlyFee, double CallDuration) {
		return monthlyFee + monthlyTelephoneFee + ( pricePerConsumerUnit * CallDuration);
	}
	
	public String print() {
		return super.print() + "\t Monthly telephone fee: " +monthlyTelephoneFee+ "\t Call duration: " +getCallDuration();
	}
}