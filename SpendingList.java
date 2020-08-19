import java.util.*;

public class SpendingList {
	
	public ArrayList <spending> spend = new ArrayList <spending>();
	
	public void addSpending(spending s){
        spend.add(s);
    }
	
	public void ListSpending() {
        for( spending  s : spend)
			System.out.print(s.print());			   
    }
}