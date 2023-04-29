package EnumClasses;

public enum ServicePlan { 
		SILVER(1000), 
		GOLD(2000), 
		DIAMOND(5000), 
		PLATINUM(10000);
	//----------double price-------------------
		private double price;
	//----------------parameterized constructor--------------
	private ServicePlan(double price) {
			this.price=price;
		}
	//-------------toString(name:price)--------------
	@Override
	public String toString() {
		return super.name()+":Rs."+price;
	}
	
	
	//----------getter and setter for price---------
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
