package project;

public class Line extends Station{//This is seperate class that stores the varaiables red,green,blue,orange,pink,purple,brown.It is a subclass of the class Station.(Author:Darshan,Date 11/29/2021).It is also the main class used to create refrences
	private int red;//red line pos
	private int green;//green line pos
	private int blue;//blue lines pos
	private int brown;//brown line pos
	private int purple;//purple line pos
	private int pink;//pink line pos
	private int orange;//orange line pos
	private Station station;//Station reference
	
	public Line() {//default constructor
		super();
		red=-1;
		green=-1;
		blue=-1;
		brown=-1;
		purple=-1;
		pink=-1;
		orange=1;
		station=new Station();
	}
	
	public Line(String Name,double Latitude,double Longitude,String Description,boolean Wheelchair,int red,int green,int blue,int brown,int purple,int pink,int orange) {
		//non-default constructor
		super(Name,Latitude,Longitude,Description,Wheelchair);
		this.red=red;
		this.green=green;
		this.blue=blue;
		this.brown=brown;
		this.purple=purple;
		this.pink=pink;
		this.orange=orange;
	}
	
	public Line(String Name,double Latitude,double Longitude,String Description,boolean Wheelchair,int red,int green,int blue,int brown,int purple,int pink,int orange,Station station) {
		//second non default construtor
		super(Name,Latitude,Longitude,Description,Wheelchair);
		this.red=red;
		this.green=green;
		this.blue=blue;
		this.brown=brown;
		this.purple=purple;
		this.pink=pink;
		this.orange=orange;
		this.station=station;
	}
	
	public int getRed() {//returns red pos
		return red;
	}
	
	public int getGreen() {//returns green pos
		return green;
	}
	
	public int getBlue() {//returns blue pos
		return blue;
	}
	
	public int getBrown() {//returns brown pos
		return brown;
	}
	
	public int getPurple() {//returns purple pos
		return purple;
	}
	
	public int getPink() {//returns pink pos
		return pink;
	}
	
	public int getOrange() {//returns orange pos
		return orange;
	}
	
	public Station getStation() {//sets Station variable
		return station;
	}
	
	public void setRed(int red) {//sets red pos
		this.red=red;
	}
	
	public void setGreen(int green) {//sets green pos
		this.green=green;
	}
	
	public void setBlue(int blue) {//sets blue pos
		this.blue=blue;
	}
	
	public void setBrown(int brown) {//sets brown pos
		this.brown=brown;
	}
	
	public void setPurple(int purple) {//sets purple pos
		this.purple=purple;
	}
	
	public void setPink(int pink) {//sets pink pos
		this.pink=pink;
	}
	
	public void setOrange(int orange) {//sets orange pos
		this.orange=orange;
	}
	
	public void setStation(Station s) {//sets Station variable
		station=s;
	}
	
	public String toString() {//returns the variables in string form
		return (Name+","+Latitude+","+Longitude+","+Description+","+Wheelchair+","+red+","+green+","+blue+","+brown+","+purple+","+pink+","+orange);
	}
	
	public boolean equals(Line l) {//checks whether two line variables are equal
		if(Name!=l.getName()) {
			return false;
		}else if(Latitude!=l.getLatitude()) {
			return false;
		}else if(Longitude!=l.getLongitude()) {
			return false;
		}else if(Description!=l.getDescription()) {
			return false;
		}else if(Wheelchair!=l.getWheelchair()) {
			return false;
		}else if(red!=l.getRed()) {
			return false;
		}else if(green!=l.getGreen()) {
			return false;
		}else if(blue!=l.getBlue()) {
			return false;
		}else if(brown!=l.getBrown()) {
			return false;
		}else if(purple!=l.getPurple()) {
			return false;
		}else if(pink!=l.getPink()) {
			return false;
		}else if(orange!=l.getOrange()) {
			return false;
		}
		return true;
		
	}
	
	public String details() {//returns details of the station
		return("Name:"+Name+"\n"+"Latitude:"+Latitude+"             Longitude:"+Longitude+"\n"+"Description:"+Description+"     Wheelchair Acess:"+Wheelchair+"\n"+"Position on the Lines(-1 if not on the line) \n"+"RedLine Position:"+red+"\n"+"GreenLine Position:"+green+"\n"+"BlueLine Position:"+blue+"\n"+"BrownLine Position:"+brown+"\n"+"PurpleLine Position:"+purple+"\n"+"PinkLine Position:"+pink+"\n"+"OrangeLine Position:"+orange);
	}
}
