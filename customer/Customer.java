package customer;
//-----------imported package and classes----------
import java.time.LocalDate;
import EnumClasses.ServicePlan;

public class Customer implements Comparable<Customer> {
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
   private LocalDate registrationDate;
   private LocalDate lastSubscriptionDate;
   
   //--------static block-------------------------------
   static {
	   idCounter=0;
   }
//------------------constructor--name,email,password,dob,plan----
public Customer(String first_name, String last_name, String email,String password, LocalDate dob, ServicePlan plan,LocalDate registrationDate) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.password=password;
	this.dob = dob;
	this.plan = plan;
	this.registrationDate=registrationDate;
	this.lastSubscriptionDate=registrationDate;
	
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

public void setLastSubscriptinDate(LocalDate date)  //setLastSubscriptionDate
{
	this.lastSubscriptionDate=date;
}

public LocalDate getLastSubscriptinDate() {       //getLastSubscriptinDate
	return this.lastSubscriptionDate;
	
}

public double getRegistrationAmount() {         //getRegistrationAmount
	return registrationAmount;
}


private void setRegistrationAmount() {          //setRegistrationAmount
	this.registrationAmount=plan.getPrice();
}
 
//--------------------toString-----------------
@Override
public String toString() {
	return "id:" + id + " name:" + first_name +" "+ last_name + " email:" + email+
	" dob:" + dob + " plan:"+ plan.name();
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
//----------------overrriding compareTo method of Comparable---------
@Override
public int compareTo(Customer o) {      
	
	return this.email.compareTo(o.getEmail());
}


}
