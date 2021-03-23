package com.address;

public class Person {
	    private String fname;
	    private String lname;
	    private String city;
	    private String state;
	    
	    public String getFName() {
	        return fname;
	    }

	    public void setFName(String fname) {
	        this.fname = fname;
	    }

	    public String getLname() {
	        return lname;
	    }

	    public void setLname(String lname) {
	        this.lname = lname;
	    }
	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }
	    public String getState() {
	        return state;
	    }

	    public void set(String state) {
	        this.state = state;
	    }

	    public Person(String fname, String lname, String state, String city) {
	        this.fname = fname;
	        this.lname = lname;
	        this.city = city;
	        this.state = state;
	        
	    }
	    	
		@Override
		public String toString() {
			return "[" + this.fname + ", " + this.lname + ", " + this.city + ", " + this.state + "]";
		}


	@Override
	public boolean equals(Object obj) {
	    if(obj == null) return false;
	    else if ( getFName().equals(((Person) obj).getFName())
	            && getLname().equals(((Person) obj).getLname()))
	    return true;

	    else return false;
	}
	    @Override
	    public int hashCode() {
	        return 0;
	    }


}
