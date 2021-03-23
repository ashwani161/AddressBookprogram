package com.address;

public class Person {
	    private String fname;
	    private String lname;
	    
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

	    public Person(String fname, String lname) {
	        this.fname = fname;
	        this.lname = lname;
	    }
	    	
		@Override
		public String toString() {
			return "[" + this.fname + ", " + this.lname + "]";
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
