package customer;
//-----------imported package and classes----------
import java.time.LocalDate;
import EnumClasses.ServicePlan;

public class Customer {
   private static int idCounter;        //idCounter(static)
   
   //----------------instance variables
   private int id;
   private String first_name;
   private String last_name;
   private String email;
   private String password;
   private double registrationAmount;
   private LocalDate dob;
   private ServicePlan plan;
   
   //--------static block-------------------------------
   static {
	   idCounter=0;
   }
//------------------constructor--name,email,password,dob,plan----
public Customer(String first_name, String last_name, String email,String password, LocalDate dob, ServicePlan plan) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.password=password;
	this.dob = dob;
	this.plan = plan;
	
	this.id=++idCounter;
}
//------------overloaded customer constctor--using PK values
public Customer(String email)
{
	this.email=email;  //other fiels will be null or 0
}

//---------------------getters and setters----------------

public String getFirst_name() {                  //getFirst_name
	return first_name;
}

public void setFirst_name(String first_name) {   //setFirst_name 
	this.first_name = first_name;
}

public String getLast_name() {                  //getLast_name
	return last_name;
}

public void setLast_name(String last_name) {    //setLast_name
	this.last_name = last_name;
}

public String getEmail() {                      //getEmail
	return email;
}

public void setEmail(String email) {            //setEmail
	this.email = email;
}

public String getPassword() {                   //getPassword
	return password;
}

public void setPassword(String password) {      //setPassword
	this.password = password;
}

public LocalDate getDob() {                    //getDob
	return dob;
}

public void setDob(LocalDate dob) {             //setDob
	this.dob = dob;
}

public ServicePlan getPlan() {                  //getPlan
	return plan;
}

public void setPlan(ServicePlan plan) {         //setPlan
	this.plan = plan;
	setRegistrationAmount();                 //change registration amt according tonew plan
}

public int getId() {                            //getID
	return id;
}

public double getRegistrationAmount() {         //getRegistrationAmount
	return registrationAmount;
}

@SuppressWarnings("unused")
private void setRegistrationAmount() {          //setRegistrationAmount
	this.registrationAmount=plan.getPrice();
}
 
//--------------------toString-----------------
@Override
public String toString() {
	return "Customer :id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
			+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
			+ plan;
}
//------------------override equals method---check by primary key
@Override
public boolean equals(Object anotherCust)
{
	if(anotherCust instanceof Customer)
		return (this.email).equals(((Customer)anotherCust).getEmail());
	else
		return false;
}


}
