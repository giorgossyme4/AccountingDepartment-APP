public class spending {
	
	private double code;
	private String description;
	
	public spending() {
	}
	
	public spending(double code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public double getCode() {
		
		return code;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setCode (double code){
		
		this.code = code;
	}
	
	public void setDescription(String description){
		
		this.description = description;
	}
	
	public String print() {
       
	   return "\n Code: "+getCode()+ "\t Description: " +getDescription();
    }
	
}