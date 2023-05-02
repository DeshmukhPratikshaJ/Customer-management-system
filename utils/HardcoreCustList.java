package utils;

import static customer.ValidationRules.checkAllDetailsSignUp;
import java.util.ArrayList;

import customer.Customer;

public class HardcoreCustList {
	public static ArrayList<Customer> populateCustList() {
		ArrayList<Customer> custList=new ArrayList<>();//size 0 ArrayList
		try {
		custList.add(checkAllDetailsSignUp("sita", "yadav", "sita@gm", "sitayadav", "01-02-1990", "silver", custList));
		custList.add(checkAllDetailsSignUp("ram", "yadav", "rama@gm", "ramayadav", "02-03-1991", "gold", custList));
		custList.add(checkAllDetailsSignUp("shyam", "sharma", "sharma@gm", "radha", "03-04-1992", "platinum", custList));
		custList.add(checkAllDetailsSignUp("radha", "sharma", "radha@gm", "shyam", "04-05-1993", "diamond", custList));
		custList.add(checkAllDetailsSignUp("madhav", "godbole", "madhav@gm", "keshav", "05-06-1994", "silver", custList));
		custList.add(checkAllDetailsSignUp("anjani", "gupta", "anjani@gm", "anjanigupta", "06-07-1995", "gold", custList));
		custList.add(checkAllDetailsSignUp("maruti", "pavanputa", "maruti@gm", "pavan", "07-08-1996", "diamond", custList));
		custList.add(checkAllDetailsSignUp("mukta", "tilak", "mukta@gm", "tilakmukta", "11-12-1997", "platinum", custList));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//return whatever custList contains even if error occurs (aftr catch)
		return custList;
		
	}

}
