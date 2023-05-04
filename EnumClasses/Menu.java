package EnumClasses;


public enum Menu {
	
	sign_up ,
	sign_in,
	update_password,
	unsubscribe,
	list_of_all_customers,
	sort_customer_by_emailID,
	sort_customers_by_servicePlan_and_name,
	Pay_Subscription,  //for customer
	delete_accounts_late_on_paying,   //for admin
	exit;
	
	@Override
	public String toString() {
		return super.ordinal()+":"+super.name();
		
	}

}
