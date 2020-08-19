import java.io.*;
import java.util.*;

public class StoreFileRL {

	public ArrayList <BSpending> bspend = new ArrayList<BSpending>();
	public ArrayList <spending> spend = new ArrayList<spending>();
	public ArrayList <Building> build = new ArrayList<Building>();
	public ArrayList <FlatFee> FF = new ArrayList<FlatFee>();
	public ArrayList <Water> water = new ArrayList<Water>();
	public ArrayList <Energy> energy = new ArrayList<Energy>();
	public ArrayList <Telephone> phone = new ArrayList<Telephone>();
	
	

	 public void loadFile(File data) { 
        int counter = 0;
		
        File f = null;
        BufferedReader reader = null; 
        Building bld = null; 
		FlatFee expense = null;
		Water exp = null;
		Energy exp2 = null;
		Telephone exp3 = null;
		String line;
		double code = 0;
		String description = "";
		double cubic = 0;
		double kwh = 0;
		double callDuration = 0;
		double monthlyfee = 0;
		double price = 0;
		double pricePerSquareMeters = 0;
		String measure = "";
		spending special = null;
		

        try {
            f = data;
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {
			line = reader.readLine();  
			while(line != null){
				
				if((line.trim().toUpperCase().equals("BUILDING_LIST"))) {
					line = reader.readLine();
					while (line.isEmpty()) {
						line = reader.readLine();
					}
					if(line.trim().equals("{")){
						line = reader.readLine();
						while (line.isEmpty()) {
							line = reader.readLine();
						}
						while ((line.trim().toUpperCase().startsWith("BUILDING"))){
								bld = new Building();
								line = reader.readLine();
								while (line.trim().isEmpty()) {
									line = reader.readLine();
								}
								if(line.trim().startsWith("{")){
									line = reader.readLine();
									while (line.trim().isEmpty()) {
										line = reader.readLine();
									}
									while ((line.trim().toUpperCase().startsWith("BUILDING_CODE ")) || (line.trim().toUpperCase().startsWith("BUILDING_DESCR ")) || (line.trim().toUpperCase().startsWith("ADDRESS ")) || (line.trim().toUpperCase().startsWith("SURFACE ")) || (line.trim().toUpperCase().startsWith("PRICE"))) {
										if((line.trim().toUpperCase().startsWith("BUILDING_CODE "))){
											bld.setPassword(Double.parseDouble(line.trim().substring(14).trim()));
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
										} else if((line.trim().toUpperCase().startsWith("BUILDING_DESCR "))){
											bld.setDescription(line.trim().substring(15).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
										} else if((line.trim().toUpperCase().startsWith("ADDRESS "))){
											((Building) bld).setAddress(line.trim().substring(8).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
										} else if((line.trim().toUpperCase().startsWith("SURFACE "))){
											bld.setSquareMetres(Double.parseDouble(line.trim().substring(8).trim()));
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
										} else if((line.trim().toUpperCase().startsWith("PRICE "))){
											bld.setPriceZone(Double.parseDouble(line.trim().substring(6).trim()));
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
										}
									}
								}
								if (line.trim().toUpperCase().startsWith("EXPENSES")) {
									line = reader.readLine();
									while (line.trim().isEmpty()) {
										line = reader.readLine();
									}
									if(line.trim().startsWith("{")){
										line = reader.readLine();
										while (line.trim().isEmpty()) {
											line = reader.readLine();
											}
										while ((line.trim().toUpperCase().startsWith("EXPENSE"))) {
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
											if(line.trim().startsWith("{")){
												line = reader.readLine();
												while (line.trim().isEmpty()) {
													line = reader.readLine();
												}
												if ((line.trim().toUpperCase().equals("TYPE RENT")) || ((line.trim().toUpperCase().equals("TYPE CLEANING")))) {
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													code = Double.parseDouble(line.trim().substring(18).trim());
													for (int i=0; i < FF.size(); i++) {
														if (FF.get(i).getCode() == code) {
															expense = FF.get(i);
															bspend.add(new BSpending(bld, expense));
														}
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
												}else if (line.trim().toUpperCase().equals("TYPE WATER")) {
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													code = Double.parseDouble(line.trim().substring(18).trim());
													for (int i=0; i < water.size(); i++) {
														if (water.get(i).getCode() == code) {
															exp = water.get(i);
															bspend.add(new BSpending(bld, exp));
														}
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
												} else if (line.trim().toUpperCase().equals("TYPE ENERGY")) {
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													code = Double.parseDouble(line.trim().substring(18).trim());
													for (int i=0; i < energy.size(); i++) {
														if (energy.get(i).getCode() == code) {
															exp2 = energy.get(i);
															bspend.add(new BSpending(bld, exp2));
														}
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
												} else if (line.trim().toUpperCase().equals("TYPE TELEPHONE")) {
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													code = Double.parseDouble(line.trim().substring(18).trim());
													for (int i=0; i < phone.size(); i++) {
														if (phone.get(i).getCode() == code) {
															exp3 = phone.get(i);
															bspend.add(new BSpending(bld, exp3));
														}
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
													line = reader.readLine();
													while (line.trim().isEmpty()) {
														line = reader.readLine();
													}
												}
												
											}
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
											if (line.trim().startsWith("}")){
												line = reader.readLine();
												while (line.trim().isEmpty()) {
													line = reader.readLine();
												}
											}
										}
									}
								}
							line = reader.readLine();
							while (line.trim().isEmpty()) {
								line = reader.readLine();
							}
							build.add(bld);
						}
						if(line.trim().equals("}"))
							line = reader.readLine();
					}
				} else if ((line.trim().toUpperCase().equals("EXPENSE_TYPE_LIST"))){
					line = reader.readLine();
					while (line.trim().isEmpty()) {
						line = reader.readLine();
					}
					if(line.trim().equals("{")) {
						line = reader.readLine();
						while (line.trim().isEmpty()) {
							line = reader.readLine();
						}
						while ((line.trim().toUpperCase().startsWith("EXPENSE_TYPE"))){
							line = reader.readLine();
							while (line.trim().isEmpty()) {
								line = reader.readLine();
							}
							if(line.trim().startsWith("{")) {
								line = reader.readLine();
								while (line.trim().isEmpty()) {
									line = reader.readLine();
								}
								while (!line.trim().startsWith("}")) {    
									if (line.trim().toUpperCase().startsWith("TYPE")) {
                                        if (line.trim().substring(5).trim().toUpperCase().equals("WATER")) {
                                            special = new Water();
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
                                        } else if (line.trim().toUpperCase().startsWith("TYPE ENERGY")) {
											special = new Energy();
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
                                        } else if (line.trim().toUpperCase().startsWith("TYPE TELEPHONE")) {
											special = new Telephone();
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
                                        } else if ((line.trim().toUpperCase().startsWith("TYPE RENT")) || (line.trim().toUpperCase().startsWith("TYPE CLEANING"))) {
											special = new FlatFee();
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
                                        }
                                    } else if (line.trim().toUpperCase().startsWith("EXPENSE_TYPE_CODE")){
										code = Double.parseDouble(line.trim().substring(18).trim());
										line = reader.readLine();	
										while (line.trim().isEmpty()) {
											line = reader.readLine();
										}
									} else if((line.trim().toUpperCase().startsWith("EXPENSE_TYPE_DESCR"))){
										description = line.trim().substring(19).trim();
										line = reader.readLine();
										while (line.trim().isEmpty()) {
											line = reader.readLine();
										}
									} else if ((line.trim().toUpperCase().startsWith("MEASUREMENT_UNIT"))){
											measure = line.trim().substring(16).trim();
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
									} else if ((line.trim().toUpperCase().startsWith("PRICE"))){
											price = Double.parseDouble(line.trim().substring(6).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
									} else if ((line.trim().toUpperCase().startsWith("MONTHLY_FEE"))){
											monthlyfee = Double.parseDouble(line.trim().substring(12).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
									} else if (line.trim().toUpperCase().startsWith("CUBIC_METERS")){
											cubic = Double.parseDouble(line.trim().substring(13).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
									}else if (line.trim().toUpperCase().startsWith("KWH")) {
											kwh = Double.parseDouble(line.trim().substring(4).trim());
											line = reader.readLine();
											while (line.trim().isEmpty()) {
												line = reader.readLine();
											}
									} else if (line.trim().toUpperCase().startsWith("CALL_DURATION")) {
										callDuration = Double.parseDouble(line.trim().substring(14).trim());
										line = reader.readLine();
										while (line.trim().isEmpty()) {
											line = reader.readLine();
										}
									}
								}
								if (special instanceof Water) {
									special.setCode(code);
									special.setDescription(description);
									((Water) special).setCubicMeters(cubic);
									((Water) special).setMonthlyFee(monthlyfee);
									((Water) special).setPricePerConsumerUnit(price);
									((Water) special).setMeasurementUnit(measure);
									spend.add(special);
									water.add(new Water(code, description, price, measure, monthlyfee, cubic));
								} else if (special instanceof Energy) {
									special.setCode(code);
									special.setDescription(description);
									((Energy) special).setKwh(kwh);
									((Energy) special).setMonthlyFee(monthlyfee);
									((Energy) special).setPricePerConsumerUnit(price);
									((Energy) special).setMeasurementUnit(measure);
									spend.add(special);
									energy.add(new Energy(code, description, price, measure, monthlyfee, kwh));
								} else if (special instanceof Telephone) {
									special.setCode(code);
									special.setDescription(description);
									((Telephone) special).setCallDuration(callDuration);
									((Telephone) special).setMonthlyFee(monthlyfee);
									((Telephone) special).setPricePerConsumerUnit(price);
									((Telephone) special).setMeasurementUnit(measure);
									spend.add(special);
									phone.add(new Telephone(code, description, price, measure, monthlyfee, callDuration));
								} else if (special instanceof FlatFee) {
									special.setCode(code);
									special.setDescription(description);
									((FlatFee) special).setPricePerSquareMeter(price);
									spend.add(special);
									FF.add(new FlatFee(code, description, price));
								}
								code = 0;
								description = "";
								callDuration =0;
								kwh = 0;
								pricePerSquareMeters = 0;
								monthlyfee = 0;
								price = 0;
								measure = "";
								cubic = 0;
							}
							line = reader.readLine();
							while (line.trim().isEmpty()) {
								line = reader.readLine();
							}
						}
						line = reader.readLine();
					}
				}
				line = reader.readLine();
			}//while								
							
								


        } catch (IOException e) {
            System.out.println("Error reading line " + counter + ".");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
	public Building get(int i){
		return build.get(i);
	}


	public int size()	{
		return build.size();
	}
	
	public void listBuilding() {
        for( Building  b : build)
			System.out.print(b.print());
		System.out.println(" ");
    }
	
	public void listSpending() {
        for( spending  s : spend)
			System.out.print(s.print());
		System.out.println(" ");
    }
	
	public int bsize() {
		return bspend.size();
	}
	
	public void listBSpending() {
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
		System.out.println(" ");
    }
}

