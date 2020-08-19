import java.util.*;

public class BSpendingList {
	
	public ArrayList <BSpending> bspend = new ArrayList <BSpending>();
	
	public void addBSpending(BSpending b){
        bspend.add(b);
    }
	
	public void addBSpending(int index, BSpending b){
        bspend.add(index, b);
    }
	
	public void set(int index, BSpending b){
        bspend.set(index, b);
    }
	
	public void listBSpend() {
        for( BSpending b : bspend)
			if (b.getFlatfee() != null) {
				System.out.print(b.print());
			} else if (b.getWater() != null) {
				System.out.print(b.printW());
			} else if (b.getEnergy() != null) {
				System.out.print(b.printE());
			} else if (b.getTelephone() != null) {
				System.out.print(b.printT());
			}	
    }
	
	public double CalculateFlatFee(Building g) {
		double result = 0;
		for(BSpending b : bspend){
			if (b.getBuilding() == g) {
				if (b.getFlatfee() != null) {
					FlatFee f = new FlatFee();
					double spend = f.RentOrCleaning(b.getFlatfee().getPricePerSquareMeter(), b.getBuilding().getSquareMetres());
					result += spend;
				}
			}
		}
		return result;
	}
	
	public double CalculateWater(Building g) {
		double result = 0;
		for(BSpending b : bspend){
			if (b.getBuilding() == g) {
				if (b.getWater() != null) {
					Water w = new Water();
					double spend  = w.water(b.getWater().getPricePerConsumerUnit(), b.getWater().getMonthlyFee(), b.getWater().getCubicMeters());
					result += spend;
				}
			}
		}
		return result;
	}
	
	public double CalculateEnergy(Building g) {
		double result = 0;
		for(BSpending b : bspend){
			if (b.getBuilding() == g) {
				if (b.getEnergy() != null) {
					Energy e = new Energy();
					double spend = e.energy(b.getEnergy().getPricePerConsumerUnit(), b.getEnergy().getMonthlyFee(), b.getEnergy().getKwh());
					result += spend;
				}
			}
		}
		return result;
	}
	
	public double CalculateTelephone(Building g) {
		double result = 0;
		for(BSpending b : bspend){
			if (b.getBuilding() == g) {
				if (b.getTelephone() != null) {
					Telephone t = new Telephone();
					double spend = t.phone(b.getTelephone().getPricePerConsumerUnit(), b.getTelephone().getMonthlyFee(), b.getTelephone().getCallDuration());
					result += spend;
				}
			}
		}
		return result;
	}
		
	public double CalculateSpend(Building g) {
		double r = CalculateFlatFee(g) + CalculateWater(g) + CalculateEnergy(g) + CalculateTelephone(g);
		//System.out.println("Building's spends are: "+r+ " Euros.");
		return r;
	}
	
	public void ShowSpend (Building g) {
        for(BSpending b : bspend){
			if (b.getBuilding() == g){
				if (b.getFlatfee() != null) {
					System.out.print("\n"+b.getflatfee());
				} else if (b.getWater() != null) {
					System.out.print("\n"+b.getwater());
				} else if (b.getEnergy() != null) {
					System.out.print("\n"+b.getenergy());
				} else if (b.getTelephone() != null) {
					System.out.print("\n"+b.gettelephone());
				}
			}
		}
		System.out.println(" ");
    }
	
	public double CalculateAllFF (String type) {
		double result = 0;
        for(BSpending b : bspend){
			if (b.getFlatfee() != null) {
				String answer = b.getFlatfee().getDescription();
				if (answer.equalsIgnoreCase(type)) {
					FlatFee f = new FlatFee();
					double spend = f.RentOrCleaning(b.getFlatfee().getPricePerSquareMeter(), b.getBuilding().getSquareMetres());
					result += spend;
				}	
			}
		}
		System.out.println("The "+type+ " spendings for all the buildings are: "+result+ " Euros.");
		return result;
	}
	
	public double CalculateAllWater() {
		double result = 0;
        for(BSpending b : bspend){
			if (b.getWater() != null) {
				Water w = new Water();
				double spend  = w.water(b.getWater().getPricePerConsumerUnit(), b.getWater().getMonthlyFee(), b.getWater().getCubicMeters());
				result += spend;	
			}
		}
		System.out.println("The Water spendings for all the buildings are: "+result+ " Euros.");
		return result;
	}
	
	public double CalculateAllEnergy() {
		double result = 0;
        for(BSpending b : bspend){
			if (b.getEnergy() != null) {
				Energy e = new Energy();
				double spend = e.energy(b.getEnergy().getPricePerConsumerUnit(), b.getEnergy().getMonthlyFee(), b.getEnergy().getKwh());
				result += spend;	
			}
		}
		System.out.println("The Energy spendings for all the buildings are: "+result+ " Euros.");
		return result;
	}
	
	public double CalculateAllPhone() {
		double result = 0;
        for(BSpending b : bspend){
			if (b.getTelephone() != null) {
				Telephone t = new Telephone();
				double spend = t.phone(b.getTelephone().getPricePerConsumerUnit(), b.getTelephone().getMonthlyFee(), b.getTelephone().getCallDuration());
				result += spend;				
			}
		}
		System.out.println("The Telephone spendings for all the buildings are: "+result+ " Euros.");
		return result;
	}
}