package customer;

import java.time.LocalDate;
import EnumClasses.ServicePlan;

public class acceptCustDetails {
 public static Customer acceptDetails(String first_name, String last_name, String email,String password, LocalDate dob, ServicePlan plan)
 {
	 Customer c=new Customer(first_name,last_name,email,password,dob,plan);
     return c;
 }
}
