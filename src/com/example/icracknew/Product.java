package com.example.icracknew;

public class Product {
	 	private int id;
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String name;
	   
	    public Product(){
	        super();
	    }
	    
	    public Product(int id, String name) {
	        super();
	        this.id = id;
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return this.id + ". " + this.name;
	    }
}
