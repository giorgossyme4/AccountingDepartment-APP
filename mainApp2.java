/*Giorgos Symeonidis, 2o , 3170153
Chrysoula Oikonomou, 2o , 3170127
Sofia Mastoropoulou, 2o , 3170103*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.text.*;
import java.util.*;

public class mainApp2 extends JFrame implements ActionListener, MouseListener  {
	private static BuildingList myBuilding = new BuildingList();
	private static BSpendingList myBSpending = new BSpendingList();
	private static SpendingList mySpending = new SpendingList();
	private static ArrayList<FlatFee> flatfee = new ArrayList<FlatFee>();
	private static ArrayList<Water> waterl = new ArrayList<Water>();
	private static ArrayList<Energy> energyl = new ArrayList<Energy>();
	private static ArrayList<Telephone> phonel = new ArrayList<Telephone>();
	private Building B, B1;
	private BSpending BS;
	private FlatFee expe;
	private Water expe1;
	private Energy expe2;
	private Telephone expe3;
	private DefaultListModel listModel, listModel2, listModel3;
	private JLabel label;
	private JFrame Sframe, S2frame, S3frame, Mframe;
	private JToolBar toolbar;
	private	JTabbedPane tabs;
	private JPanel expenses, buildings, panelButton, panelButton2, panelButton2b, listpanel, listpanel2, listpanel3;
	private JButton openExpenses, openBuildExpenses, save, saveExit, water, energy, phone, cleaning, rent, addBuild, showEditBuild, delBuild, calcuCost, calcuCostClean, calcuCostW, calcuCostE, calcuCostT, calcuCostB, manageExp, changeCode, changeCode2, changeDescr, changeDescr2, changeAddr, changePrice, changePrice2, changeSquareM, saveChanges, saveChanges2, cancelChanges, cancelChanges2, addExp, delExp, showEditExp, saveBS, cancelBS, changeCubic, changekWh, changeMeasure, changeMonthly, changeCallDur, saveExp, cancelExp;
	private FileFilter filter;
    private JFileChooser chooser;
    private File F,F2;
	private StoreFileWL Product;
	private StoreFileRL read;	
	private JList list, list2, list3;
	private Container cp;
	private JScrollPane listScroller, listScroller2, listScroller3;
	private JTextArea resultArea = new JTextArea();
	private JTextArea resultArea2 = new JTextArea("\nWhen the new expense appears tap the Save button to store it.");
	private int I = -1;
	private int J = -1;
	private int K = -1;
	private int l = -1;
	
	public static void main(String[] args) {
		new mainApp2();
		
	}
	
	public mainApp2() {
		initialize();
	}
	
	private void initialize() {
		
		expenses = new JPanel(new BorderLayout());
		buildings = new JPanel(new BorderLayout());
		panelButton = new JPanel();
		panelButton2 = new JPanel();
		panelButton2b = new JPanel();
		listpanel = new JPanel();
		toolbar = new JToolBar();
		read = new StoreFileRL();
		Product = new StoreFileWL();
		filter = new FileNameExtensionFilter("Text Files","txt");
        F = new File("");
        F2 = new File("");
        chooser = new JFileChooser();
        chooser.setFileFilter(filter);
		resultArea2.setEditable(false);
		openExpenses = new JButton("Open Expenses");
		openBuildExpenses = new JButton("Open Buildings & Expenses");
		save = new JButton("Save");
		saveExit = new JButton("Save & Exit");
		tabs = new JTabbedPane();
		tabs.add("Expenses", expenses);
		tabs.add("Buildings & Expenses", buildings);
		chooser = new JFileChooser();
		rent = new JButton("Rent");
		cleaning = new JButton("Cleaning");
		water = new JButton("Water");
		energy = new JButton("Energy");
		phone = new JButton("Telephone");
		calcuCost = new JButton("Calculate Cost");
		calcuCostClean = new JButton("Calculate Cost");
		calcuCostW = new JButton("Calculate Cost");
		calcuCostE = new JButton("Calculate Cost");
		calcuCostT = new JButton("Calculate Cost");
		addExp = new JButton("Add Expense");
		showEditExp = new JButton("Show/Edit Expense");
		delExp = new JButton("Remove Expense");
		addBuild = new JButton("Add Building");
		showEditBuild = new JButton("Show/Edit Building");
		delBuild = new JButton("Remove Building");
		calcuCostB = new JButton("Calculate Cost");
		manageExp = new JButton("Manage Expenses");
		changeCode = new JButton("Change Code");
		changeDescr = new JButton("Change Description");
		changeAddr = new JButton("Change Address");
		changePrice = new JButton("Change Price");
		changeSquareM = new JButton("Change Surface");
		saveChanges = new JButton("Save");
		cancelChanges = new JButton("Cancel");
		saveBS = new JButton("Save");
		cancelBS = new JButton("Cancel");
		changeCode2 = new JButton("Change Code");
		changeDescr2 = new JButton("Change Description");
		changePrice2 = new JButton("Change Price");
		changeMeasure = new JButton("Change Measurement Unit");
		changeMonthly = new JButton("Change Monthly Fee");
		changeCubic = new JButton("Change Cubic Meters");
		changekWh = new JButton("Change kWh");
		changeCallDur = new JButton("Change Call Duration");
		saveExp = new JButton("Save");
		cancelExp = new JButton("Cancel");
		toolbar.add(openExpenses);
		toolbar.add(openBuildExpenses);
		save.setEnabled(false);
		saveExit.setEnabled(false);
		toolbar.add(save);
		toolbar.add(saveExit);
		toolbar.setFloatable(false);
		panelButton.setLayout(new GridLayout(5, 1));
		panelButton.add(rent);
		panelButton.add(cleaning);
		panelButton.add(water);
		panelButton.add(energy);
		panelButton.add(phone);
		expenses.add(panelButton, BorderLayout.WEST);
		panelButton2.setLayout(new GridLayout(3,1));
		panelButton2.add(addBuild);
		panelButton2.add(showEditBuild);
		panelButton2.add(delBuild);
		panelButton2b.setLayout(new GridLayout(2,1));
		panelButton2b.add(calcuCostB);
		panelButton2b.add(manageExp);
		buildings.add(panelButton2b, BorderLayout.EAST);
		buildings.add(panelButton2, BorderLayout.WEST);
		addBuild.addActionListener(this);
		showEditBuild.addActionListener(this);
		delBuild.addActionListener(this);
		rent.addActionListener(this);
		cleaning.addActionListener(this);
		water.addActionListener(this);
		energy.addActionListener(this);
		phone.addActionListener(this);
		openBuildExpenses.addActionListener(this);
		openExpenses.addActionListener(this);
		save.addActionListener(this);
		saveExit.addActionListener(this);
		calcuCost.addActionListener(this);
		calcuCostClean.addActionListener(this);
		calcuCostW.addActionListener(this);
		calcuCostE.addActionListener(this);
		calcuCostT.addActionListener(this);
		calcuCostB.addActionListener(this);
		manageExp.addActionListener(this);
		changeCode.addActionListener(this);
		changeDescr.addActionListener(this);
		changeAddr.addActionListener(this);
		changePrice.addActionListener(this);
		changeSquareM.addActionListener(this);
		saveChanges.addActionListener(this);
		cancelChanges.addActionListener(this);
		delExp.addActionListener(this);
		addExp.addActionListener(this);
		showEditExp.addActionListener(this);
		saveBS.addActionListener(this);
		cancelBS.addActionListener(this);
		changeCode2.addActionListener(this);
		changeDescr2.addActionListener(this);
		changePrice2.addActionListener(this);
		changeMeasure.addActionListener(this);
		changeMonthly.addActionListener(this);
		changeCubic.addActionListener(this);
		changekWh.addActionListener(this);
		changeCallDur.addActionListener(this);
		saveExp.addActionListener(this);
		cancelExp.addActionListener(this);
		openBuildExpenses.setEnabled(false);
		rent.addMouseListener(this);
		cleaning.addMouseListener(this);
		water.addMouseListener(this);
		energy.addMouseListener(this);
		phone.addMouseListener(this);
		calcuCost.addMouseListener(this);
		calcuCostClean.addMouseListener(this);
		listModel = new DefaultListModel();
		list = new JList(listModel);
		label = new JLabel();
		listScroller = new JScrollPane(list);
		listpanel.setLayout(new GridLayout(1,2));
		listpanel.add(listScroller);
		buildings.add(listpanel, BorderLayout.CENTER);
		listModel2 = new DefaultListModel();
		list2 = new JList(listModel2);
		list2.setSelectedIndex(0);
		listScroller2 = new JScrollPane(list2);
		listpanel2 = new JPanel();
		listpanel2.setLayout(new GridLayout(1,1));
		listpanel2.add(listScroller2);
		expenses.add(listpanel2, BorderLayout.CENTER);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					B = null;
					resultArea.setText(null);
					Sframe = new JFrame();
					JPanel bpanel = new JPanel();
					JPanel p6 = new JPanel();
					JPanel p6b = new JPanel();
					Sframe.setBounds(200, 200, 1080, 400);
					Sframe.setTitle("Building : SHOW/EDIT");
					Sframe.setVisible(true);
					resultArea.setEditable(false);
					bpanel.setLayout(new GridLayout(5, 1));
					bpanel.add(changeCode);
					bpanel.add(changeDescr);
					bpanel.add(changeAddr);
					bpanel.add(changePrice);
					bpanel.add(changeSquareM);
					p6b.add(saveChanges, BorderLayout.CENTER);
					p6b.add(cancelChanges, BorderLayout.SOUTH);
					p6.add(resultArea);
					Sframe.add(p6b, BorderLayout.EAST);
					Sframe.add(bpanel, BorderLayout.WEST);
					Sframe.add(p6, BorderLayout.CENTER);
					int i = list.getSelectedIndex();
					if (list.getSelectedIndex() != -1) {
						B = myBuilding.buildings.get(i);
						String outputText = B.print();
						I = i;
						resultArea.setText(outputText);
					}
					Sframe.pack();
				}
			}
		});
		
		/*list3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {
					resultArea.setText(null);
					expe = null;
					expe1 = null;
					expe2 = null;
					expe3 = null;
					resultArea.setText(null);
					BS = null;
					B = null;
					S3frame = new JFrame();
					JPanel bpanel = new JPanel();
					JPanel p6 = new JPanel();
					JPanel p6b = new JPanel();
					S3frame.setBounds(20, 200, 1080, 400);
					S3frame.setTitle("Manage Building's Expenses : SHOW/EDIT");
					S3frame.setVisible(true);
					resultArea.setEditable(false);
					bpanel.setLayout(new GridLayout(8, 1));
					bpanel.add(changeCode2);
					bpanel.add(changeDescr2);
					bpanel.add(changePrice2);
					bpanel.add(changeMeasure);
					bpanel.add(changeMonthly);
					bpanel.add(changeCubic);
					bpanel.add(changeCallDur);
					bpanel.add(changekWh);
					changeMeasure.setEnabled(false);
					changeMonthly.setEnabled(false);
					changeCubic.setEnabled(false);
					changeCallDur.setEnabled(false);
					changekWh.setEnabled(false);
					p6.add(resultArea);
					p6b.add(saveExp);
					p6b.add(cancelExp);
					S3frame.add(p6b, BorderLayout.EAST);
					S3frame.add(bpanel, BorderLayout.WEST);
					S3frame.add(p6, BorderLayout.CENTER);
					int i = list.getSelectedIndex();
					l = list3.getSelectedIndex();
					int k = 0;
					String outputText = "";
					if ((list3.getSelectedIndex() != -1) && (list.getSelectedIndex() != -1))  {
						Building b = myBuilding.buildings.get(i);
						for(k=0; k < myBSpending.bspend.size(); k++){
							BSpending bss = myBSpending.bspend.get(k);
							if (bss.getBuilding().getPassword() == b.getPassword()) {
								spending ss = mySpending.spend.get(l+k);
								B = b;
								BSpending bs = myBSpending.bspend.get(l+k);
								BS = bs;
								if (bs.getFlatfee() != null) {
									expe = bs.getFlatfee();
									outputText = expe.print();
								} else if (bs.getWater() != null) {
									changeMeasure.setEnabled(true);
									changeMonthly.setEnabled(true);
									changeCubic.setEnabled(true);
									expe1 = bs.getWater();
									outputText = expe1.print();
								} else if (bs.getTelephone() != null) {
									changeMeasure.setEnabled(true);
									changeMonthly.setEnabled(true);
									changeCallDur.setEnabled(true);
									expe3 = bs.getTelephone();
									outputText = expe3.print();
								} else if (bs.getEnergy() != null) {
									changeMeasure.setEnabled(true);
									changeMonthly.setEnabled(true);
									changekWh.setEnabled(true);
									expe2 = bs.getEnergy();
									outputText = expe2.print();
								}
							break;
							}
						}
						K = k+l;
						resultArea.setText(outputText);
					}
					S3frame.pack();
				}
			}
		});*/
		
		setTitle("Logistics");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(tabs);
		tabs.setEnabledAt(1,false);
	}
	
	public void StoreF() {
		flatfee.clear();
		waterl.clear();
		energyl.clear();
		phonel.clear();
		myBSpending.bspend.clear();
		myBuilding.buildings.clear();
		mySpending.spend.clear();
		listModel.clear();
		listModel2.clear();
		for (int i=0; i < read.bspend.size(); i++) {
			BSpending bb = read.bspend.get(i);
			myBSpending.addBSpending(bb);
			Product.add(bb);
			if (bb.getFlatfee() != null) {
				mySpending.addSpending(bb.getFlatfee());
				flatfee.add(bb.getFlatfee());
			} else if (bb.getWater() != null) {
				mySpending.addSpending(bb.getWater());
				waterl.add(bb.getWater());
			} else if (bb.getEnergy() != null) {
				mySpending.addSpending(bb.getEnergy());
				energyl.add(bb.getEnergy());
			} else if (bb.getTelephone() != null) {
				mySpending.addSpending(bb.getTelephone());
				phonel.add(bb.getTelephone());
			}
		}
		for (int j=0; j < read.build.size(); j++) {
			Building b = read.build.get(j);
			listModel.addElement("//CODE: "+ b.getPassword() +" //DESCRIPTION: "+ b.getDescription());
			Product.add(read.build.get(j));
			myBuilding.addBuilding(b);
		}
		list.setSelectedIndex(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openExpenses) {
			JOptionPane.showMessageDialog(null,"Please choose Expense file");
			int Checker;
			chooser.setCurrentDirectory(F);
			Checker = chooser.showOpenDialog(null);
			if(Checker == JFileChooser.APPROVE_OPTION) {
				read.loadFile(chooser.getSelectedFile());
				F = new File(chooser.getSelectedFile().toString());
				openBuildExpenses.setEnabled(true);
			}
			
		} else if (e.getSource() == openBuildExpenses) {
			JOptionPane.showMessageDialog(null,"Please choose Buildin-Expense file");
            int Checker2;
            chooser.setCurrentDirectory(F2);
            Checker2 = chooser.showOpenDialog(null);
            if(Checker2 == JFileChooser.APPROVE_OPTION){
                read.loadFile(chooser.getSelectedFile());
                F2 = new File(chooser.getSelectedFile().toString());
                StoreF();
                tabs.setEnabledAt(1,true);
				save.setEnabled(true);
            }
            if(listModel.size()!=0){
                save.setEnabled(true);
                saveExit.setEnabled(true);
            }
        }
			

		else if (e.getSource() == delBuild){
			int i = list.getSelectedIndex();
			if (i != -1) {
				int val = JOptionPane.showConfirmDialog(null, "Remove Building?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (val == JOptionPane.YES_OPTION) {
					listModel.remove(i);
					myBuilding.buildings.remove(i);
					Product.remove(i);
					JOptionPane.showMessageDialog(this, "The Building REMOVED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else if (e.getSource() == delExp){
			BSpending bs = null;
			int j = list3.getSelectedIndex();
			int i = list.getSelectedIndex();
			if (j != -1) {
				int val = JOptionPane.showConfirmDialog(null, "Remove Expense?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (val == JOptionPane.YES_OPTION) {
					spending s = mySpending.spend.get(j);
					int k = 0;
					if ((list3.getSelectedIndex() != -1) && (list.getSelectedIndex() != -1))  {
						Building b = myBuilding.buildings.get(i);
						for(k=0; k < myBSpending.bspend.size(); k++){
							BSpending bss = myBSpending.bspend.get(k);
							if (bss.getBuilding().getPassword() == b.getPassword()) {
								bs = myBSpending.bspend.get(j+k);
								mySpending.spend.remove(j+k);
								myBSpending.bspend.remove(j+k);
								Product.removeBS(j+k);
								break;
							}
						}
						if (bs.getFlatfee() != null) {
							for (int n = 0; n < flatfee.size(); n++) {
								double code = flatfee.get(n).getCode();
								if (bs.getFlatfee().getCode() == code) { 
									System.out.println(code);
									flatfee.remove(n);
									break;
								}
							}
						} else if (bs.getWater() != null) {
							for (int n = 0; n < waterl.size(); n++) {
								double code = waterl.get(n).getCode();
								if (bs.getWater().getCode() == code) {
									System.out.println(code);
									waterl.remove(n);
									break;
								}
							}
						} else if (bs.getEnergy() != null) {
							for (int n = 0; n < energyl.size(); n++) {
								double code = energyl.get(n).getCode();
								if (bs.getEnergy().getCode() == code) {
									System.out.println(code);
									energyl.remove(n);
									break;
								}
							}
						} else if (bs.getTelephone() != null) {
							for (int n = 0; n < phonel.size(); n++) {
								double code = phonel.get(n).getCode();
								if (bs.getTelephone().getCode() == code) {
									System.out.println(code);
									phonel.remove(n);
									break;
								}
							}
						}
					}
					listModel3.remove(j);
					JOptionPane.showMessageDialog(this, "The Building REMOVED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		} else if (e.getSource() == addBuild) {
			String password = (String)JOptionPane.showInputDialog(this, "Code ");
			String description = (String)JOptionPane.showInputDialog(this, "Description ");
			String address = (String)JOptionPane.showInputDialog(this, "Address ");
			String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
			String surface = (String)JOptionPane.showInputDialog(this, "Surface ");
			double code = (new Double(password)).doubleValue();
			double price = (new Double(pricee)).doubleValue();
			double squareMeters = (new Double(surface)).doubleValue();
			Building building = new Building(code, description, address, price, squareMeters);
			myBuilding.addBuilding(building);
			Product.add(building);
			listModel.addElement("//CODE: "+ building.getPassword() +" //DESCRIPTION: "+ building.getDescription());
			JOptionPane.showMessageDialog(this, "The Building ADDED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (e.getSource() == addExp) {
			B = null;
			String[] Etype = {"Rent", "Cleaning", "Water", "Energy", "Telephone"};
			int response = JOptionPane.showOptionDialog(null, "Select the Expense type you want to add:", "Expense : ADD", 0, JOptionPane.INFORMATION_MESSAGE, null, Etype, Etype[4]);
			if ((response == 0) || (response == 1)) {
				String password = (String)JOptionPane.showInputDialog(this, "Code ");
				String description = "";
				if (response == 0) {
					description = "Rent";
				} else if (response == 1) {
					description = "Cleaning";
				}
				String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
				double code = (new Double(password)).doubleValue();
				double price = (new Double(pricee)).doubleValue();
				int j = list.getSelectedIndex();
				J = j;
				expe = new FlatFee(code, description, price);
				String outputText = expe.print();
				resultArea2.setText(outputText);
			} else if (response == 2) {
				String password = (String)JOptionPane.showInputDialog(this, "Code ");
				String description = "Water";
				String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
				String measurementUnit = (String)JOptionPane.showInputDialog(this, "Measurement Unit ");
				String mF = (String)JOptionPane.showInputDialog(this, "Monthly Fee ");
				String cM = (String)JOptionPane.showInputDialog(this, "Cubic Meters ");
				double code = (new Double(password)).doubleValue();
				double price = (new Double(pricee)).doubleValue();
				double monthlyfee = (new Double(mF)).doubleValue();
				double cubic = (new Double(cM)).doubleValue();
				int j = list.getSelectedIndex();
				J = j;
				expe1 = new Water(code, description, price, measurementUnit ,monthlyfee, cubic);
				String outputText = expe1.print();
				resultArea2.setText(outputText);
				
			} else if (response == 3) {
				String password = (String)JOptionPane.showInputDialog(this, "Code ");
				String description = "Energy";
				String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
				String measurementUnit = (String)JOptionPane.showInputDialog(this, "Measurement Unit ");
				String mF = (String)JOptionPane.showInputDialog(this, "Monthly Fee ");
				String kwh = (String)JOptionPane.showInputDialog(this, "kWh ");
				double code = (new Double(password)).doubleValue();
				double price = (new Double(pricee)).doubleValue();
				double monthlyfee = (new Double(mF)).doubleValue();
				double kWh = (new Double(kwh)).doubleValue();
				int j = list.getSelectedIndex();
				J = j;
				expe2 = new Energy(code, description, price, measurementUnit ,monthlyfee, kWh);
				String outputText = expe2.print();
				resultArea2.setText(outputText);
				
			} else if (response == 4) {
				String password = (String)JOptionPane.showInputDialog(this, "Code ");
				String description = "Telephone";
				String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
				String measurementUnit = (String)JOptionPane.showInputDialog(this, "Measurement Unit ");
				String mF = (String)JOptionPane.showInputDialog(this, "Monthly Fee ");
				String cD = (String)JOptionPane.showInputDialog(this, "Call Duration ");
				double code = (new Double(password)).doubleValue();
				double price = (new Double(pricee)).doubleValue();
				double monthlyfee = (new Double(mF)).doubleValue();
				double callDuration = (new Double(cD)).doubleValue();
				int j = list.getSelectedIndex();
				J = j;
				expe3 = new Telephone(code, description, price, measurementUnit ,monthlyfee, callDuration);
				String outputText = expe3.print();
				resultArea2.setText(outputText);
				
			}	
		} else  if (e.getSource() == showEditBuild) {
			B = null;
			resultArea.setText(null);
			Sframe = new JFrame();
			JPanel bpanel = new JPanel();
			JPanel p6 = new JPanel();
			JPanel p6b = new JPanel();
			Sframe.setBounds(200, 200, 1080, 400);
			Sframe.setTitle("Building : SHOW/EDIT");
			Sframe.setVisible(true);
			resultArea.setEditable(false);
			bpanel.setLayout(new GridLayout(5, 1));
			bpanel.add(changeCode);
			bpanel.add(changeDescr);
			bpanel.add(changeAddr);
			bpanel.add(changePrice);
			bpanel.add(changeSquareM);
			p6b.add(saveChanges, BorderLayout.CENTER);
			p6b.add(cancelChanges, BorderLayout.SOUTH);
			p6.add(resultArea);
			Sframe.add(p6b, BorderLayout.EAST);
			Sframe.add(bpanel, BorderLayout.WEST);
			Sframe.add(p6, BorderLayout.CENTER);
			int i = list.getSelectedIndex();
			if (list.getSelectedIndex() != -1) {
				B = myBuilding.buildings.get(i);
				String outputText = B.print();
				I = i;
				resultArea.setText(outputText);
			}
			Sframe.pack();
			
   		} else  if (e.getSource() == showEditExp) {
			resultArea.setText(null);
			expe = null;
			expe1 = null;
			expe2 = null;
			expe3 = null;
			resultArea.setText(null);
			BS = null;
			B = null;
			S3frame = new JFrame();
			JPanel bpanel = new JPanel();
			JPanel p6 = new JPanel();
			JPanel p6b = new JPanel();
			S3frame.setBounds(20, 200, 1080, 400);
			S3frame.setTitle("Manage Building's Expenses : SHOW/EDIT");
			S3frame.setVisible(true);
			resultArea.setEditable(false);
			bpanel.setLayout(new GridLayout(8, 1));
			bpanel.add(changeCode2);
			bpanel.add(changeDescr2);
			bpanel.add(changePrice2);
			bpanel.add(changeMeasure);
			bpanel.add(changeMonthly);
			bpanel.add(changeCubic);
			bpanel.add(changeCallDur);
			bpanel.add(changekWh);
			changeMeasure.setEnabled(false);
			changeMonthly.setEnabled(false);
			changeCubic.setEnabled(false);
			changeCallDur.setEnabled(false);
			changekWh.setEnabled(false);
			p6.add(resultArea);
			p6b.add(saveExp);
			p6b.add(cancelExp);
			S3frame.add(p6b, BorderLayout.EAST);
			S3frame.add(bpanel, BorderLayout.WEST);
			S3frame.add(p6, BorderLayout.CENTER);
			int i = list.getSelectedIndex();
			l = list3.getSelectedIndex();
			int k = 0;
			String outputText = "";
			if ((list3.getSelectedIndex() != -1) && (list.getSelectedIndex() != -1))  {
				Building b = myBuilding.buildings.get(i);
				for(k=0; k < myBSpending.bspend.size(); k++){
					BSpending bss = myBSpending.bspend.get(k);
					if (bss.getBuilding().getPassword() == b.getPassword()) {
						spending ss = mySpending.spend.get(l+k);
						B = b;
						BSpending bs = myBSpending.bspend.get(l+k);
						BS = bs;
						if (bs.getFlatfee() != null) {
							expe = bs.getFlatfee();
							outputText = expe.print();
						} else if (bs.getWater() != null) {
							changeMeasure.setEnabled(true);
							changeMonthly.setEnabled(true);
							changeCubic.setEnabled(true);
							expe1 = bs.getWater();
							outputText = expe1.print();
						} else if (bs.getTelephone() != null) {
							changeMeasure.setEnabled(true);
							changeMonthly.setEnabled(true);
							changeCallDur.setEnabled(true);
							expe3 = bs.getTelephone();
							outputText = expe3.print();
						} else if (bs.getEnergy() != null) {
							changeMeasure.setEnabled(true);
							changeMonthly.setEnabled(true);
							changekWh.setEnabled(true);
							expe2 = bs.getEnergy();
							outputText = expe2.print();
						}
					break;
					}
				}
				K = k+l;
				resultArea.setText(outputText);
			}
			S3frame.pack();
			
			
			
   		} else if (e.getSource() == rent) {
			listModel2.removeAllElements();
			for (FlatFee ff : flatfee) {
				if (ff.getDescription().equalsIgnoreCase("Rent")) {
					listModel2.addElement("//CODE: "+ ff.getCode() +" //DESCRIPTION: "+ ff.getDescription());
				}
			}
		}
		else if (e.getSource() == cleaning) {
			listModel2.removeAllElements();
			for (FlatFee ff : flatfee) {
				if (ff.getDescription().equalsIgnoreCase("Cleaning")) {
					listModel2.addElement("//CODE: "+ ff.getCode() +" //DESCRIPTION: "+ ff.getDescription());
				}
			}
		}
		else if (e.getSource() == water) {
			listModel2.removeAllElements();
			for (Water ww : waterl) {
				listModel2.addElement("//CODE: "+ ww.getCode() +" //DESCRIPTION: "+ ww.getDescription());
			}
		}
		else if (e.getSource() == energy) {
			listModel2.removeAllElements();
			for (Energy Ee : energyl) {
				listModel2.addElement("//CODE: "+ Ee.getCode() +" //DESCRIPTION: "+ Ee.getDescription());
			}
		}
		else if (e.getSource() == phone) {
			listModel2.removeAllElements();
			for (Telephone Tt : phonel) {
				listModel2.addElement("//CODE: "+ Tt.getCode() +" //DESCRIPTION: "+ Tt.getDescription());
			}
		} else if(e.getSource() == calcuCost){
			double cost = myBSpending.CalculateAllFF("rent");
			JOptionPane.showMessageDialog(this, "The Rent's cost is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == calcuCostClean){
			double cost = myBSpending.CalculateAllFF("Cleaning");
			JOptionPane.showMessageDialog(this, "The Cleaning's cost is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == calcuCostW){
			double cost = myBSpending.CalculateAllWater();
			JOptionPane.showMessageDialog(this, "The Water's cost is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == calcuCostE){
			double cost = myBSpending.CalculateAllEnergy();
			JOptionPane.showMessageDialog(this, "The Energy's cost is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == calcuCostT){
			double cost = myBSpending.CalculateAllPhone();
			JOptionPane.showMessageDialog(this, "The Telephone's cost is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == calcuCostB){
			int i = list.getSelectedIndex();
			if (list.getSelectedIndex() != -1) {
				Building b = myBuilding.buildings.get(i);
				double cost = myBSpending.CalculateSpend(b);
				JOptionPane.showMessageDialog(this, "The cost of the building"+i+" is: "+cost+" Euros.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if(e.getSource() == changeCode){
			String password = (String)JOptionPane.showInputDialog(this, "Code ");
			double code = (new Double(password)).doubleValue();
			B.setPassword(code);
			String outputText = B.print();
			resultArea.setText(outputText);	
			
		} else if(e.getSource() == changeCode2){
			String outputText = "";
			String password = (String)JOptionPane.showInputDialog(this, "Code ");
			double code = (new Double(password)).doubleValue();
			if (expe != null) {
				expe.setCode(code);
				outputText = expe.print();
			} else if (expe1 != null) {
				expe1.setCode(code);
				outputText = expe1.print();
			} else if (expe2 != null) {
				expe2.setCode(code);
				outputText = expe2.print();
			} else if (expe3 != null) {
				expe3.setCode(code);
				outputText = expe3.print();
			}
			resultArea.setText(outputText);	
			
		} else if(e.getSource() == changeDescr){
			String description = (String)JOptionPane.showInputDialog(this, "Description ");
			B.setDescription(description);
			String outputText = B.print();
			resultArea.setText(outputText);	
			
		} else if(e.getSource() == changeDescr2){
			String outputText = "";
			String description = (String)JOptionPane.showInputDialog(this, "Description ");
			if (expe != null) {
				expe.setDescription(description);
				outputText = expe.print();
			} else if (expe1 != null) {
				expe1.setDescription(description);
				outputText = expe1.print();
			} else if (expe2 != null) {
				expe2.setDescription(description);
				outputText = expe2.print();
			} else if (expe3 != null) {
				expe3.setDescription(description);
				outputText = expe3.print();
			}
			resultArea.setText(outputText);	
			
		} else if(e.getSource() == changeAddr){
			String address = (String)JOptionPane.showInputDialog(this, "Address ");
			B.setAddress(address);
			String outputText = B.print();
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changePrice){
			String pricee = (String)JOptionPane.showInputDialog(this, "Price ");
			double price = (new Double(pricee)).doubleValue();
			B.setPriceZone(price);
			String outputText = B.print();
			resultArea.setText(outputText);

		} else if(e.getSource() == changePrice2){
			resultArea.setText(null);
			String outputText = "";
			String pricee2 = (String)JOptionPane.showInputDialog(this, "Price ");
			double price2 = (new Double(pricee2)).doubleValue();
			if (expe != null) {
				expe.setPricePerSquareMeter(price2);
				outputText = expe.print();
			} else if (expe1 != null) {
				expe1.setPricePerConsumerUnit(price2);
				outputText = expe1.print();
			} else if (expe2 != null) {
				expe2.setPricePerConsumerUnit(price2);
				outputText = expe2.print();
			} else if (expe3 != null) {
				expe3.setPricePerConsumerUnit(price2);
				outputText = expe3.print();
			}
			resultArea.setText(outputText);

		} else if(e.getSource() == changeSquareM){
			String surface = (String)JOptionPane.showInputDialog(this, "Surface ");
			double squareMeters = (new Double(surface)).doubleValue();
			B.setSquareMetres(squareMeters);
			String outputText = B.print();
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changeMeasure){
			resultArea.setText(null);
			String outputText = "";
			String measure = (String)JOptionPane.showInputDialog(this, "Measurement Unit ");
			if (expe1 != null) {
				expe1.setMeasurementUnit(measure);
				outputText = expe1.print();
			} else if (expe2 != null) {
				expe2.setMeasurementUnit(measure);
				outputText = expe2.print();
			} else if (expe3 != null) {
				expe3.setMeasurementUnit(measure);
				outputText = expe3.print();
			}
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changeMonthly){
			resultArea.setText(null);
			String outputText = "";
			String monthlyf = (String)JOptionPane.showInputDialog(this, "Monthly Fee ");
			double monthly = (new Double(monthlyf)).doubleValue();
			if (expe1 != null) {
				expe1.setMonthlyFee(monthly);
				outputText = expe1.print();
			} else if (expe2 != null) {
				expe2.setMonthlyFee(monthly);
				outputText = expe2.print();
			} else if (expe3 != null) {
				expe3.setMonthlyFee(monthly);
				outputText = expe3.print();
			}
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changeCubic){
			resultArea.setText(null);
			String c = (String)JOptionPane.showInputDialog(this, "Cubic Meters ");
			double cubic = (new Double(c)).doubleValue();
			expe1.setCubicMeters(cubic);
			String outputText = expe1.print();
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changekWh){
			resultArea.setText(null);
			String k = (String)JOptionPane.showInputDialog(this, "kWh ");
			double kwh = (new Double(k)).doubleValue();
			expe2.setKwh(kwh);
			String outputText = expe2.print();
			resultArea.setText(outputText);
					
		} else if(e.getSource() == changeCallDur){
			resultArea.setText(null);
			String d = (String)JOptionPane.showInputDialog(this, "Call Duration ");
			double callD = (new Double(d)).doubleValue();
			expe3.setCallDuration(callD);
			String outputText = expe3.print();
			resultArea.setText(outputText);
					
		} else if(e.getSource() == saveChanges){
			myBuilding.buildings.set(I, B);
			Product.set(I, B);
			listModel.set(I, "//CODE: "+ B.getPassword() +" //DESCRIPTION: "+ B.getDescription());
			
		} else if(e.getSource() == saveExp){
			if (expe != null) {
				myBSpending.set(K, new BSpending(B, expe));
				Product.set(K, new BSpending(B, expe));
				listModel3.set(l, "//CODE: "+ expe.getCode() +" //DESCRIPTION: "+ expe.getDescription());
			} else if (expe1 != null) {
				myBSpending.set(K, new BSpending(B, expe1));
				Product.set(K, new BSpending(B, expe1));
				listModel3.set(l, "//CODE: "+ expe1.getCode() +" //DESCRIPTION: "+ expe1.getDescription());
			} else if (expe2 != null) {
				myBSpending.set(K, new BSpending(B, expe2));
				Product.set(K, new BSpending(B, expe2));
				listModel3.set(l, "//CODE: "+ expe2.getCode() +" //DESCRIPTION: "+ expe2.getDescription());
			} else if (expe3 != null) {
				myBSpending.set(K, new BSpending(B, expe3));
				Product.set(K, new BSpending(B, expe3));
				listModel3.set(l, "//CODE: "+ expe3.getCode() +" //DESCRIPTION: "+ expe3.getDescription());
			}
			
			
			if (BS.getFlatfee() != null) {
				for (int n = 0; n < flatfee.size(); n++) {
					double code = flatfee.get(n).getCode();
					if (BS.getFlatfee().getCode() == code) { 
						flatfee.set(n, expe);
						break;
					}
				}
			} else if (BS.getWater() != null) {
				for (int n = 0; n < waterl.size(); n++) {
					double code = waterl.get(n).getCode();
					if (BS.getWater().getCode() == code) {
						waterl.set(n, expe1);
						break;
					}
				}
			} else if (BS.getEnergy() != null) {
				for (int n = 0; n < energyl.size(); n++) {
					double code = energyl.get(n).getCode();
					if (BS.getEnergy().getCode() == code) {
						energyl.set(n, expe2);
						break;
					}
				}
			} else if (BS.getTelephone() != null) {
				for (int n = 0; n < phonel.size(); n++) {
					double code = phonel.get(n).getCode();
					if (BS.getTelephone().getCode() == code) {
						phonel.set(n, expe3);
						break;
					}
				}
			}
			
		} else if(e.getSource() == cancelChanges){
			Sframe.dispose();
			
		} else if(e.getSource() == cancelBS){
			Mframe.dispose();
			
		} else if(e.getSource() == cancelExp){
			expe = null;
			expe1 = null;
			expe2 = null;
			expe3 = null;
			S3frame.dispose();
			
		} else if(e.getSource() == manageExp){
			//resultArea.setText(null);
			Mframe = new JFrame();
			JPanel expButtPanel = new JPanel();
			JPanel p = new JPanel();
			JPanel pa = new JPanel();
			JPanel pb = new JPanel();
			pa.add(saveBS);
			pa.add(cancelBS);
			pb.add(resultArea2);
			expButtPanel.setLayout(new GridLayout(3,1));
			listModel3 = new DefaultListModel();
			list3 = new JList(listModel3);
			listScroller3 = new JScrollPane(list3);
			listpanel3 = new JPanel();
			listpanel3.setLayout(new GridLayout(1,1));
			listpanel3.add(listScroller3);
			p.add(listpanel3, BorderLayout.CENTER);
			expButtPanel.add(addExp);
			expButtPanel.add(showEditExp);
			expButtPanel.add(delExp);
			Mframe.add(expButtPanel, BorderLayout.WEST);
			Mframe.add(pb, BorderLayout.SOUTH);
			Mframe.add(p, BorderLayout.CENTER);
			Mframe.add(pa, BorderLayout.EAST);
			int j = list.getSelectedIndex();
			B1 = myBuilding.buildings.get(j);
			//myBSpending.ShowSpend(B1);
			for(BSpending b : myBSpending.bspend){
				if (b.getBuilding() == B1){
					if (b.getFlatfee() != null) {
						listModel3.addElement("//CODE: "+ b.getFlatfee().getCode() +" //DESCRIPTION: "+ b.getFlatfee().getDescription());
					} else if (b.getWater() != null) {
						listModel3.addElement("//CODE: "+ b.getWater().getCode() +" //DESCRIPTION: "+ b.getWater().getDescription());
					} else if (b.getEnergy() != null) {
						listModel3.addElement("//CODE: "+ b.getEnergy().getCode() +" //DESCRIPTION: "+ b.getEnergy().getDescription());
					} else if (b.getTelephone() != null) {
						listModel3.addElement("//CODE: "+ b.getTelephone().getCode() +" //DESCRIPTION: "+ b.getTelephone().getDescription());
					}
				}
			}
			Mframe.getContentPane().add(listpanel3);
			Mframe.setBounds(150, 200, 1180, 400);
			Mframe.setTitle("Building : MANAGE EXPENSES");
			list3.setSelectedIndex(0);
			Mframe.setVisible(true);
			
			
		} else if((e.getSource() == saveBS) && (expe instanceof FlatFee)) {
			int counter = 0;
			int k = 0;
			B = myBuilding.buildings.get(J);
			for(k=0; k < myBSpending.bspend.size(); k++){
				BSpending bss = myBSpending.bspend.get(k);
				if (bss.getBuilding() == B) {
					counter++;
					if (counter == listModel3.size()) {
						break;
					}
				}
			}
			int index = k+1;
			listModel3.addElement("//CODE: "+ expe.getCode() +" //DESCRIPTION: "+ expe.getDescription());
			flatfee.add(expe);
			mySpending.addSpending(expe);
			if (index > myBSpending.bspend.size()) {
				myBSpending.addBSpending(new BSpending(B, expe));
				Product.add(new BSpending(B, expe));
			} else if (index <= myBSpending.bspend.size()) {
				myBSpending.addBSpending(index, new BSpending(B, expe));
				Product.add(index, new BSpending(B, expe));
			}
			
			B = null;
			expe = null;
			resultArea2.setText("\nWhen the new expense appears tap the Save button to store it. ");
			JOptionPane.showMessageDialog(this, "The Expense ADDED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
			
		} else if((e.getSource() == saveBS) && (expe1 instanceof Water)) {
			int counter = 0;
			int k = 0;
			B = myBuilding.buildings.get(J);
			for(k=0; k < myBSpending.bspend.size(); k++){
				BSpending bss = myBSpending.bspend.get(k);
				if (bss.getBuilding() == B) {
					counter++;
					if (counter == listModel3.size()) {
						break;
					}
				}
			}
			int index = k+1;
			listModel3.addElement("//CODE: "+ expe1.getCode() +" //DESCRIPTION: "+ expe1.getDescription());
			waterl.add(expe1);
			mySpending.addSpending(expe1);
			if (index > myBSpending.bspend.size()) {
				myBSpending.addBSpending(new BSpending(B, expe1));
			} else if (index <= myBSpending.bspend.size()) {
				myBSpending.addBSpending(index, new BSpending(B, expe1));
			}
			myBSpending.listBSpend();
			Product.add(new BSpending(B, expe1));
			B = null;
			expe1 = null;
			resultArea2.setText("\nWhen the new expense appears tap the Save button to store it. ");
			JOptionPane.showMessageDialog(this, "The Expense ADDED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
			
		} else if((e.getSource() == saveBS) && (expe2 instanceof Energy)) {
			int counter = 0;
			int k = 0;
			B = myBuilding.buildings.get(J);
			for(k=0; k < myBSpending.bspend.size(); k++){
				BSpending bss = myBSpending.bspend.get(k);
				if (bss.getBuilding() == B) {
					counter++;
					if (counter == listModel3.size()) {
						break;
					}
				}
			}
			int index = k+1;
			listModel3.addElement("//CODE: "+ expe2.getCode() +" //DESCRIPTION: "+ expe2.getDescription());
			energyl.add(expe2);
			mySpending.addSpending(expe2);
			if (index > myBSpending.bspend.size()) {
				myBSpending.addBSpending(new BSpending(B, expe2));
			} else if (index <= myBSpending.bspend.size()) {
				myBSpending.addBSpending(index, new BSpending(B, expe2));
			}
			myBSpending.listBSpend();
			Product.add(new BSpending(B, expe2));
			B = null;
			expe2 = null;
			resultArea2.setText("\nWhen the new expense appears tap the Save button to store it. ");
			JOptionPane.showMessageDialog(this, "The Expense ADDED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
			
		} else if((e.getSource() == saveBS) && (expe3 instanceof Telephone)) {
			int counter = 0;
			int k = 0;
			B = myBuilding.buildings.get(J);
			for(k=0; k < myBSpending.bspend.size(); k++){
				BSpending bss = myBSpending.bspend.get(k);
				if (bss.getBuilding() == B) {
					counter++;
					if (counter == listModel3.size()) {
						break;
					}
				}
			}
			int index = k+1;
			listModel3.addElement("//CODE: "+ expe3.getCode() +" //DESCRIPTION: "+ expe3.getDescription());
			phonel.add(expe3);
			mySpending.addSpending(expe3);
			if (index > myBSpending.bspend.size()) {
				myBSpending.addBSpending(new BSpending(B, expe3));
			} else if (index <= myBSpending.bspend.size()) {
				myBSpending.addBSpending(index, new BSpending(B, expe3));
			}
			myBSpending.listBSpend();
			Product.add(new BSpending(B, expe3));
			B = null;
			expe3 = null;
			resultArea2.setText("\nWhen the new expense appears tap the Save button to store it. ");
			JOptionPane.showMessageDialog(this, "The Expense ADDED successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(e.getSource() == save) {
			Product.createFile("Products.txt");
			
		} else if(e.getSource() == saveExit){
            if (listModel.size() != 0) {
                Product.createFile("Products.txt");
                System.exit(0);
            } else {
                String[] opts = {"Yes","No"};
                int opt = (int)JOptionPane.showOptionDialog(null,"The list is empty, do you want to exit?","Error",JOptionPane.ERROR_MESSAGE,0,null,opts,opts[0]);
                if(opt == 0){
                    System.exit(0);
                }
            }
        }
			
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
            if(e.getSource() == rent){
				resultArea.setText(null);
				JFrame Rframe = new JFrame();
				JPanel calcuPanel = new JPanel();
				JPanel p = new JPanel();
				Rframe.setBounds(200, 200, 1080, 400);
				Rframe.setTitle("Expenses : RENT");
				Rframe.setVisible(true);
				resultArea.setEditable(false);
				p.add(resultArea);
				calcuPanel.add(calcuCost, BorderLayout.CENTER);
				Rframe.add(calcuPanel, BorderLayout.SOUTH);
				Rframe.add(p, BorderLayout.WEST);
				for (FlatFee ff : flatfee) {
					if (ff.getDescription().equalsIgnoreCase("Rent")) {
						String outputText = ff.print();
						resultArea.append(outputText);
					}
				}
				Rframe.pack();
			} else if(e.getSource() == cleaning){
				resultArea.setText(null);
				JFrame Cframe = new JFrame();
				JPanel calcuPanel2 = new JPanel();
				JPanel p2 = new JPanel();
				Cframe.setBounds(200, 200, 1080, 400);
				Cframe.setTitle("Expenses : CLEANING");
				Cframe.setVisible(true);
				resultArea.setEditable(false);
				p2.add(resultArea);
				calcuPanel2.add(calcuCostClean, BorderLayout.CENTER);
				Cframe.add(calcuPanel2, BorderLayout.SOUTH);
				Cframe.add(p2, BorderLayout.WEST);
				for (FlatFee ff : flatfee) {
					if (ff.getDescription().equalsIgnoreCase("Cleaning")) {
						String outputText = ff.print();
						resultArea.append(outputText);
					}
				}
				Cframe.pack();
			}  else if(e.getSource() == water){
				resultArea.setText(null);
				JFrame Wframe = new JFrame();
				JPanel calcuPanel3 = new JPanel();
				JPanel p3 = new JPanel();
				Wframe.setBounds(200, 200, 1080, 400);
				Wframe.setTitle("Expenses : WATER");
				Wframe.setVisible(true);
				resultArea.setEditable(false);
				p3.add(resultArea);
				calcuPanel3.add(calcuCostW, BorderLayout.CENTER);
				Wframe.add(calcuPanel3, BorderLayout.SOUTH);
				Wframe.add(p3, BorderLayout.WEST);
				for (Water w : waterl) {
					String outputText = w.print();
					resultArea.append(outputText);
				}
				Wframe.pack();
			} else if(e.getSource() == energy){
				resultArea.setText(null);
				JFrame Eframe = new JFrame();
				JPanel calcuPanel4 = new JPanel();
				JPanel p4 = new JPanel();
				Eframe.setBounds(200, 200, 1080, 400);
				Eframe.setTitle("Expenses : ENERGY");
				Eframe.setVisible(true);
				resultArea.setEditable(false);
				p4.add(resultArea);
				calcuPanel4.add(calcuCostE, BorderLayout.CENTER);
				Eframe.add(calcuPanel4, BorderLayout.SOUTH);
				Eframe.add(p4, BorderLayout.WEST);
				for (Energy ee : energyl) {
					String outputText = ee.print();
					resultArea.append(outputText);
				}
				Eframe.pack();
			} else if(e.getSource() == phone){
				resultArea.setText(null);
				JFrame Tframe = new JFrame();
				JPanel calcuPanel5 = new JPanel();
				JPanel p5 = new JPanel();
				Tframe.setBounds(200, 200, 1080, 400);
				Tframe.setTitle("Expenses : TELEPHONE");
				Tframe.setVisible(true);
				resultArea.setEditable(false);
				p5.add(resultArea);
				calcuPanel5.add(calcuCostT, BorderLayout.CENTER);
				Tframe.add(calcuPanel5, BorderLayout.SOUTH);
				Tframe.add(p5, BorderLayout.WEST);
				for (Telephone t : phonel) {
					String outputText = t.print();
					resultArea.append(outputText);
				}
				Tframe.pack();
			}
		}	
	}
	
	
	public void mouseExited(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
	public void mousePressed(MouseEvent event){}
	
	
}