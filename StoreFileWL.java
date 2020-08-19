import java.io.*;
import java.util.*;

public class StoreFileWL {


	private ArrayList<BSpending> StoreProducts = new ArrayList<BSpending>();
	private ArrayList<Building> Store = new ArrayList<Building>();

 public void createFile  (String path) {

		File f = null;
		BufferedWriter writer = null;

		try	{
			f = new File(path);
		}
		catch (NullPointerException e) {
			System.out.println ("Can't create file");
		}

		try	{
			writer = new BufferedWriter(new FileWriter(f));
			writer.write("BUILDING_LIST\n" + "{");
		}
		catch (IOException e){
			System.out.println("Can't write to file");
		}
		
		for (Building product : Store) {
			try {
				writer.write("\n\tBUILDING \n\t" + "{\n\t" +
							"\tBUILDING_CODE "+ product.getPassword()+ "\n\t" +
							"\tBUILDING_DESCR " + product.getDescription() + "\n\t" +
							"\tADDRESS " + product.getAddress() + "\n\t"+
							"\tPRICE " + product.getPriceZone() + "\n\t" +
							"\tSQUARE METERS " + product.getSquareMetres() + "\n" +
							"\t\tEXPENSES\n\t" + "\t{\n\t" );
				for (BSpending s : StoreProducts) {
					if (s.getBuilding() == product) {
						if (s.getFlatfee() != null) {
							FlatFee p = s.getFlatfee();
							writer.write("\n\t\t\tEXPENSE\n\t" + "\t\t{\n\t" +
										"\t\t\tTYPE "+ p.getDescription() + "\n\t" +
										"\t\t\tEXPENSE_TYPE_CODE " + p.getCode() + "\n\t" +
										"\t\t\tCONSUMPTION "	+ p.RentOrCleaning(p.getPricePerSquareMeter(), s.getBuilding().getSquareMetres())	+ "\n\t\t\t}"	);
				
						} 
						if ((s.getWater() != null)) {
							Water w = s.getWater();
							writer.write("\n\t\t\tEXPENSE\n\t" + "\t\t{\n\t" +
										"\t\t\tTYPE "+ w.getDescription() + "\n\t" +
										"\t\t\tEXPENSE_TYPE_CODE " + w.getCode() + "\n\t" +
										"\t\t\tCONSUMPTION "	+ w.water(w.getPricePerConsumerUnit(), w.getMonthlyFee(), w.getCubicMeters()) + "\n\t\t\t}"	);
						}
						if ((s.getEnergy() != null)) {
							Energy e = s.getEnergy();
							writer.write("\n\t\t\tEXPENSE\n\t" + "\t\t{\n\t" +
										"\t\t\tTYPE "+ e.getDescription() + "\n\t" +
										"\t\t\tEXPENSE_TYPE_CODE " + e.getCode() + "\n\t" +
										"\t\t\tCONSUMPTION "	+ e.energy(e.getPricePerConsumerUnit(), e.getMonthlyFee(), e.getKwh()) + "\n\t\t\t}"	);
						}
						if ((s.getTelephone() != null)) {
							Telephone t = s.getTelephone();
							writer.write("\n\t\t\tEXPENSE\n\t" + "\t\t{\n\t" +
										"\t\t\tTYPE "+ t.getDescription() + "\n\t" +
										"\t\t\tEXPENSE_TYPE_CODE " + t.getCode() + "\n\t" +
										"\t\t\tCONSUMPTION "	+ t.phone(t.getPricePerConsumerUnit(), t.getMonthlyFee(), t.getCallDuration()) + "\n\t\t\t}"	);
						}
					}
				}
				writer.write("\n\t\t}\n\t}\n");
								
			}catch (IOException e){
				System.err.println("Write error!");
			}
		}

		try {
			writer.write("}\n");
			writer.close();

		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}

		public void printFile (String data) {
		File f = null;
		BufferedReader reader = null;
		String line;

		try	{
			f = new File(data);
		}
		catch (NullPointerException e) {
			System.out.println ("Can't open file");
		}


		try {
            reader = new BufferedReader(new FileReader(f));
        }
        catch (IOException e) {
        	System.out.println("Can't read from file");
        }


        try {
			
			line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

        }
        catch (IOException e) {
			System.err.println("Read error!");
		}

	}


 	public void add(BSpending b) {
		StoreProducts.add(b);
	}
	
	public void add(int i, BSpending b) {
		StoreProducts.add(i, b);
	}

	public void add(Building b) {
		Store.add(b);
	}
	
	public void remove(int i) {
		Store.remove(i);
	}
	
	public void removeBS(int i) {
		StoreProducts.remove(i);
	}
	
	public void set(int i, BSpending b) {
		StoreProducts.set(i, b);
	}
	
	public void set(int i, Building b) {
		Store.set(i, b);
	}
}

