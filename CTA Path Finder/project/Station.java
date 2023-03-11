package project;

public class Station {//This is seperate class that stores the varaiables Name,Longitude,Latitude,Description,Wheelchair.It is a superclass of the class Line.(Author:Darshan,Date 11/29/2021)
	protected String Name;//Station name
	protected double Latitude;//station coordinates
	protected double Longitude;//station coordinates
	protected String Description;//station description
	protected boolean Wheelchair;//station wheelchair access
	
	public Station() {//default constructor
	Name=" ";
	Latitude=0;
	Longitude=0;
	Description="";
	Wheelchair=false;
	}
	
	public Station(String Name,double Latitude,double Longitude,String Description,boolean Wheelchair) {//non default constructor
		this.Name=Name;
		this.Latitude=Latitude;
		this.Longitude=Longitude;
		this.Description=Description;
		this.Wheelchair=Wheelchair;
	}
	
	public String getName() {//returns station name
		return Name;
	}
	
	public double getLatitude() {//returns station latitude
		return Latitude;
	}
	
	public double getLongitude() {//returns station longitude
		return Longitude;
	}
	
	public String getDescription() {//returns station description
		return Description;
	}
	
	public boolean getWheelchair() {//returns station wheelchair access
		return Wheelchair;
	}
	
	public void setName(String Name) {//sets new station name
		this.Name=Name;
	}
	
	public void setLatitude(double Latitude) {//sets new station latitude
		this.Latitude=Latitude;
	}
	
	public void setLongitude(double Longitude) {//sets new station longitude
		this.Longitude=Longitude;
	}
	
	public void setDescription(String Description) {//sets new station description
		this.Description=Description;
	}
	
	public void setWheelchair(boolean Wheelchair) {//sets new station wheelchair access
		this.Wheelchair=Wheelchair;
	}
	
	public String toString() {//returns the station variables in string form
		return (Name+","+Latitude+","+Longitude+","+Description+","+Wheelchair);
	}
	
	public boolean equals(Station s) {//checks whether two station variables have equal instance variables
		if(Name!=s.getName()) {
			return false;
		}else if(Latitude!=s.getLatitude()) {
			return false;
		}else if(Longitude!=s.getLongitude()) {
			return false;
		}else if(Description!=s.getDescription()) {
			return false;
		}else if(Wheelchair!=s.getWheelchair()) {
			return false;
		}
		return true;
	}
	
	public String details() {//returns station details
		return("Name:"+Name+"\n"+"Latitude:"+Latitude+"             Longitude:"+Longitude+"\n"+"Description:"+Description+"     Wheelchair Acess:"+Wheelchair+"\n");
	}
	
	public boolean equalsName(String name) {//checks whether external name is same as the instance variable name
		if(this.Name.toLowerCase().equals(name)) {
			return true;
		}
		return false;
	}
}
