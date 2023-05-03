package utils;

import static customer.ValidationRules.checkAllDetailsSignUp;
import java.util.ArrayList;

import customer.Customer;

public class HardcoreCustList {
	public static ArrayList<Customer> populateCustList() {
		ArrayList<Customer> custList=new ArrayList<>();//size 0 ArrayList
		try {
		custList.add(checkAllDetailsSignUp("sita", "yadav", "sita@gm", "sita1*Yadav", "1990-01-02", "silver", custList));
		custList.add(checkAllDetailsSignUp("ram", "yadav", "rama@gm", "rama2#Yadav", "1991-02-03", "gold", custList));
		custList.add(checkAllDetailsSignUp("shyam", "sharma", "sharma@gm", "Radha3$nagari", "1992-03-04", "platinum", custList));
		custList.add(checkAllDetailsSignUp("radha", "sharma", "radha@gm", "Shyam4%dev", "1993-04-05", "diamond", custList));
		custList.add(checkAllDetailsSignUp("madhav", "godbole", "madhav@gm", "Keshav5^8", "1994-05-06", "silver", custList));
		custList.add(checkAllDetailsSignUp("anjani", "gupta", "anjani@gm", "anjani6$Gupta", "1995-06-07", "gold", custList));
		custList.add(checkAllDetailsSignUp("maruti", "pavanputa", "maruti@gm", "Pavan7!putra", "1996-07-08", "diamond", custList));
		custList.add(checkAllDetailsSignUp("mukta", "tilak", "mukta@gm", "tilak8~Mukta", "1997-11-12", "platinum", custList));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//return whatever custList contains even if error occurs (aftr catch)
		return custList;
		
	}

}
