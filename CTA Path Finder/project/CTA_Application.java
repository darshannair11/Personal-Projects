package project;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CTA_Application {//This is the main application tasked with running the program and modfying the data.(Author:Darshan,Date 11/29/2021)
	
	public static ArrayList<Line> readExistingFile(){//This method is tasked with reading the external csv file and seperating the values to store in the class reference.
		//And then stores the reference in the an arraylist which is returned.
		ArrayList<Line> Stations=new ArrayList<Line>();
		File f=new File("src/project/CTAStops.csv");
		try {
			Scanner input=new Scanner(f);
			input.nextLine();
			while(input.hasNextLine()) {
				Line s=null;//temporary Line reference
				try {
					String readline=input.nextLine();//String of each line in the csv file
					String[] values=readline.split(",");//array of the values divide by commas
					s=new Line(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),values[3],Boolean.parseBoolean(values[4].toLowerCase()),Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8]),Integer.parseInt(values[9]),Integer.parseInt(values[10]),Integer.parseInt(values[11]));
				}catch(Exception ex) {
					System.out.println(ex.toString());
				}
			Stations.add(s);
			}
			input.close()
;		}catch(Exception e){
			System.out.println("File not found");
		}
		return Stations;
	}
	
	public static int searchByName(ArrayList<Line> Stations,Scanner input) {//This methods acts as a subsidary method of search.
		//Its functon is to search for a station by its name and return the index of that station in the main arrayList.It gives
		//The user the choice to choose between stations if a stations with same names are detected.
		Line s=null;//Temporary variable
		System.out.println("Enter the name of the station you want to select:");
		String name=input.nextLine().toLowerCase().stripIndent();//Name to search for
		ArrayList<Line> temp=new ArrayList<Line>();//Temporary arrayList to store search results
		for(int i=0;i<Stations.size();i++) {
			String StationName=Stations.get(i).getName().toLowerCase();
			if(StationName.equals(name)) {
				temp.add(Stations.get(i));
			}
		}
		if(temp.size()==1) {
			s=temp.get(0);
		}else if(temp.size()>=2) {
			System.out.println("There were "+temp.size()+" Stations of this name.Which one do you wish to choose");
			for(int i=0;i<temp.size();i++) {
				System.out.println((i+1)+"."+temp.get(i).details());
				System.out.println();
			}
			int index=-1;//Index in the temp arrayList
			boolean done=false;//Used to exit the while loop
			while(!done){
				try {
					System.out.println("Enter the index of the Station you want to choose(Enter any other number to return to the main menu)");
					index=Integer.parseInt(input.nextLine())-1;
					done=true;
				}catch(Exception e) {
					System.out.println("Make sure to enter an Integer");
				}
			}
			int size=temp.size();//size of the temp arrayList
			if((index<size) && (index>=0)) {
				s=temp.get(index);
			}else {
				return -1;
			}
		}else {
			System.out.println("No Station of that name was found");
			return -1;
		}
		for(int i=0;i<Stations.size();i++) {
			if(s.equals(Stations.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public static ArrayList<Line> OnLine(ArrayList<Line> Stations,int red,int green,int blue,int brown,int purple,int pink,int orange){
		//This method is tasked with seperating the stations that lie on a certain line into a results arrayList which is then returned.
		ArrayList<Line> temp=new ArrayList<Line>();//Temp arrayList to store search results
		if(red>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>=0) {
					System.out.println(Stations.get(i).getRed());
					temp.add(Stations.get(i));
				}
			}
		}else if(green>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}else if(blue>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}else if(brown>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}else if(purple>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}else if(pink>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}else if(orange>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>=0) {
					temp.add(Stations.get(i));
				}
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> OnLine(ArrayList<Line> Stations,int red,int green,int blue,int brown,int purple,int pink,int orange,boolean wheechair){
		//This method is tasked with seperating the stations that lie on a certain line and have certain wheelchair access into a results arrayList which is then returned.
		ArrayList<Line> temp=new ArrayList<Line>();//Temp arrayList to store search results
		if(red>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(green>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(blue>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(brown>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(purple>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(pink>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}else if(orange>0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>=0 && Stations.get(i).getWheelchair()==wheechair) {
					temp.add(Stations.get(i));
				}
			}
		}
		return temp;
	}
	
	public static int searchByOtherCriteria(ArrayList<Line> Stations,Scanner input) {//This method searches for a station with criteria other
		//than name like line and wheelcair acess.It uses the methods Online and its variant to do so and then returns its index
		//within the main arrayList after asking the user to select one of the station that meet the criteria
		int red=0,green=0,blue=0,brown=0,purple=0,pink=0,orange=0;//variable to show which line selected 
		boolean wheelchair=false,changed=false,done=false;//stores the value of wheelchair access to be searched ,stores whether the user has changed wheelchair acess.
		Line s=null;
		while(!done){
			System.out.println("red:"+red+" green:"+green+" blue:"+blue+" brown:"+brown+" purple:"+purple+" pink:"+pink+" orange:"+orange);
			System.out.println("Wheelchair:"+wheelchair+" Has the user changed the whhelchair value:"+changed);
			System.out.println("1.Line the station is on");
			System.out.println("2.Wheelchair Access");
			System.out.println("3.Search");
			String choice1=input.nextLine().toLowerCase().stripIndent();//index of the choice
			switch(choice1) {
			case "1":
				System.out.println("1.RedLine");
				System.out.println("2.GreenLine");
				System.out.println("3.BlueLine");
				System.out.println("4.BrownLine");
				System.out.println("5.PurpleLine");
				System.out.println("6.PinkLine");
				System.out.println("7.OrangeLine");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("1")) {
					red=1;green=0;blue=0;brown=0;purple=0;pink=0;orange=0;
				}else if(choice2.equals("2")) {
					red=0;green=1;blue=0;brown=0;purple=0;pink=0;orange=0;
				}else if(choice2.equals("3")) {
					red=0;green=0;blue=1;brown=0;purple=0;pink=0;orange=0;
				}else if(choice2.equals("4")) {
					red=0;green=0;blue=0;brown=1;purple=0;pink=0;orange=0;
				}else if(choice2.equals("5")) {
					red=0;green=0;blue=0;brown=0;purple=1;pink=0;orange=0;
				}else if(choice2.equals("6")) {
					red=0;green=0;blue=0;brown=0;purple=0;pink=1;orange=0;
				}else if(choice2.equals("7")) {
					red=0;green=0;blue=0;brown=0;purple=0;pink=0;orange=1;
				}else {
					System.out.println("INVALID INPUT\nReturning to Search Screen\n");
				}
				break;
			case "2":
				System.out.println("1.True");
				System.out.println("2.False");
				String choice3=input.nextLine().toLowerCase().stripIndent();
				if(choice3.equals("1")) {
					wheelchair=true;changed=true;
				}else if(choice3.equals("2")) {
					wheelchair=false;changed=true;
				}else {
					System.out.println("INVALID INPUT\nReturning to Search Screen\n");
				}
				break;
			case "3":
				done=true;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		ArrayList<Line> temp=new ArrayList<Line>();
		if(red==0 && green==0 && blue==0 && brown==0 && purple==0 && pink==0 && orange==0 && changed==false) {
			for(int i=0;i<Stations.size();i++) {
				temp.add(Stations.get(i));
			}
		}else if(red==0 && green==0 && blue==0 && brown==0 && purple==0 && pink==0 && orange==0 && changed==true) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getWheelchair()==wheelchair)
				temp.add(Stations.get(i));
			}
		}else if((red==1 || green==1 || blue==1 || brown==1 || purple==1 || pink==1 || orange==1) && changed==false) {
			temp=OnLine(Stations,red,green,blue,brown,purple,pink,orange);
		}else if((red==1 || green==1 || blue==1 || brown==1 || purple==1 || pink==1 || orange==1) && changed==true) {
			temp=OnLine(Stations,red,green,blue,brown,purple,pink,orange,wheelchair);
		}else {
			
		}
		if(temp.size()==0) {
			System.out.println("No station match the following criteria");
		}else if(temp.size()>=1) {
			System.out.println("There are "+temp.size()+" Stations that meet this criteria.Which one do you wish to choose");
			for(int i=0;i<temp.size();i++) {
				System.out.println((i+1)+"."+temp.get(i).toString());
				System.out.println();
			}
			int index=-1;//index of the station in the temporary arrayList
			boolean done1=false;//to enter and exit the loop.
			while(!done1){
				try {
					System.out.println("Enter the index of the Station you want to choose(Enter any other number to return to the main menu)");
					index=Integer.parseInt(input.nextLine())-1;
					done1=true;
				}catch(Exception e) {
					System.out.println("Make sure to enter an Integer");
				}
			}
			int size=temp.size();
			if((index<size) && (index>=0)) {
				s=temp.get(index);
			}else {
				return -1;
			}
			for(int i=0;i<Stations.size();i++) {
				if(s.equals(Stations.get(i))) {
					return i;
				}
			}
			return -1;
		}
		return -1;
	}
	
	public static int search(ArrayList<Line> Stations,Scanner input) {//Acts as the main search engine which includes searchByName()
		//and searchByOtherCriteria() methods which then returns the index of the selected station in the main arrayList.
		System.out.println("How do you wish to select a station: ");
		System.out.println("1.By Name");
		System.out.println("2.By Line and wheelchair acess");
		System.out.println("Choose one of the given options(Type any other number to return to main menu):");
		String choice=input.nextLine().stripIndent();//Index of choice for the user.
		switch(choice) {
		case "1":
			return searchByName(Stations,input);
		case "2":
			return searchByOtherCriteria(Stations,input);
		default:
			return -1;
		}
	}
	
	public static ArrayList<Line> StationRelocation(ArrayList<Line> Stations,int index){//The purpose of this method is to relocate
		//those stations that are affected when a particular station is removes
		Line s=Stations.get(index);//temp Line variable
		if(s.getRed()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>s.getRed()) {
					int temp=Stations.get(i).getRed()-1;
					Stations.get(i).setRed(temp);
				}
			}
		}
		if(s.getGreen()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>s.getGreen()) {
					int temp=Stations.get(i).getGreen()-1;
					Stations.get(i).setGreen(temp);
				}
			}
		}if(s.getBlue()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>s.getBlue()) {
					int temp=Stations.get(i).getBlue()-1;
					Stations.get(i).setBlue(temp);
				}
			}
		}if(s.getBrown()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>s.getBrown()) {
					int temp=Stations.get(i).getBrown()-1;
					Stations.get(i).setBrown(temp);
				}
			}
		}if(s.getPurple()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>s.getPurple()) {
					int temp=Stations.get(i).getPurple()-1;
					Stations.get(i).setPurple(temp);
				}
			}
		}if(s.getPink()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>s.getPink()) {
					int temp=Stations.get(i).getPink()-1;
					Stations.get(i).setPink(temp);
				}
			}
		}if(s.getOrange()>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>s.getOrange()) {
					int temp=Stations.get(i).getOrange()-1;
					Stations.get(i).setOrange(temp);
				}
			}
		}
		return Stations;
	}
	
	public static ArrayList<Line> removeStation(ArrayList<Line> Stations,Scanner input){//At first selects a station using the search()
		//method by storing its index  and then removes the station from the main arrayList if index not -1
		System.out.println("Select the Station you wish to remove");
		System.out.println();
		int index=search(Stations,input);
		if(index==-1) {
			System.out.println();
			System.out.println("Returning to main Menu");
			System.out.println();
		}else {
			Stations=StationRelocation(Stations,index);
			Stations.remove(index);
			System.out.println("System Alert!\nA Station has been removed");
		}
		return Stations;
	}
	
	public static void showStationDetails(ArrayList<Line> Stations,Scanner input) {//At first selects a station using the search()
		//method by storing its index  and then shows the station details if index not -1
		System.out.println("Select the Station whose details you wish to view");
		System.out.println();
		int index=search(Stations,input);
		if(index==-1) {
			System.out.println();
			System.out.println("Returning to main Menu");
			System.out.println();
		}else {
			System.out.println(Stations.get(index).details());
			System.out.println();
		}
	}
	
	public static ArrayList<Line> removeStationsRelocation(ArrayList<Line> Stations,String method,int pos){//Used in to removeStations() method
		// and acts as a relocation method to change the position of the station coming after the removed station for every line.
		if(method.equals("red")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>pos) {
					int pos1=Stations.get(i).getRed()-1;
					Stations.get(i).setRed(pos1);
				}
			}
		}else if(method.equals("green")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>pos) {
					int pos1=Stations.get(i).getGreen()-1;
					Stations.get(i).setGreen(pos1);
				}
			}
		}else if(method.equals("blue")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>pos) {
					int pos1=Stations.get(i).getBlue()-1;
					Stations.get(i).setBlue(pos1);
				}
			}
		}else if(method.equals("brown")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>pos) {
					int pos1=Stations.get(i).getBrown()-1;
					Stations.get(i).setBrown(pos1);
				}
			}
		}else if(method.equals("purple")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>pos) {
					int pos1=Stations.get(i).getPurple()-1;
					Stations.get(i).setPurple(pos1);
				}
			}
		}else if(method.equals("pink")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>pos) {
					int pos1=Stations.get(i).getPink()-1;
					Stations.get(i).setPink(pos1);
				}
			}
		}else if(method.equals("orange")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>pos) {
					int pos1=Stations.get(i).getOrange()-1;
					Stations.get(i).setOrange(pos1);
				}
			}
		}
		return Stations;
	}
	
	public static ArrayList<Line> addStationsRelocation(ArrayList<Line> Stations,String method,int pos){//The purpose of this method is to relocate
		//those stations that are affected when a particular station is added by chnaging its position by +1
		if(method.equals("red")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>=pos) {
					int pos1=Stations.get(i).getRed()+1;
					Stations.get(i).setRed(pos1);
				}
			}
		}else if(method.equals("green")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>=pos) {
					int pos1=Stations.get(i).getGreen()+1;
					Stations.get(i).setGreen(pos1);
				}
			}
		}else if(method.equals("blue")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>=pos) {
					int pos1=Stations.get(i).getBlue()+1;
					Stations.get(i).setBlue(pos1);
				}
			}
		}else if(method.equals("brown")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>=pos) {
					int pos1=Stations.get(i).getBrown()+1;
					Stations.get(i).setBrown(pos1);
				}
			}
		}else if(method.equals("purple")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>=pos) {
					int pos1=Stations.get(i).getPurple()+1;
					Stations.get(i).setPurple(pos1);
				}
			}
		}else if(method.equals("pink")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>=pos) {
					int pos1=Stations.get(i).getPink()+1;
					Stations.get(i).setPink(pos1);
				}
			}
		}else if(method.equals("orange")) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>=pos) {
					int pos1=Stations.get(i).getOrange()+1;
					Stations.get(i).setOrange(pos1);
				}
			}
		}
		return Stations;
	}
	
	public static ArrayList<Line> modifyLines(ArrayList<Line> Stations,Scanner input,int index){//This method is responsible for
		//allowing the user to either add a station to a line or remove a station from a line if it is already on it.
		System.out.println("RedLine pos:"+Stations.get(index).getRed()+"\nGreenLine position:"+Stations.get(index).getGreen()+"\nBlueLine position:"+Stations.get(index).getBlue()+"  BrownLine position:"+Stations.get(index).getBrown()+"  PurpleLine position:"+Stations.get(index).getPurple()+"\nPinkLine position:"+Stations.get(index).getPink()+"  OrangeLine position:"+Stations.get(index).getOrange());
		System.out.println("Choose the lines you wish to add or remove the station(type any other number to return to main menu)");
		System.out.println("1.Red Line");
		System.out.println("2.Green Line");
		System.out.println("3.Blue Line");
		System.out.println("4.Brown Line");
		System.out.println("5.Purple Line");
		System.out.println("6.Pink Line");
		System.out.println("7.Orange Line");
		String choice=input.nextLine().toLowerCase().stripIndent();//user input choice
		switch(choice) {
		case "1":
			if(Stations.get(index).getRed()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();//user input choice
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"red",Stations.get(index).getRed());
					Stations.get(index).setRed(-1);
					System.out.println("Station has been removed from the red line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"red",pos);
				Stations.get(index).setRed(pos);
				System.out.println("Station has been added to the red line");
				return Stations;
			}
		case "2":
			if(Stations.get(index).getGreen()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();//user input choice
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"green",Stations.get(index).getGreen());
					Stations.get(index).setGreen(-1);
					System.out.println("Station has been removed from the green line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line:");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"green",pos);
				Stations.get(index).setGreen(pos);
				System.out.println("Station has been added to the green line");
				return Stations;
			}
		case "3":
			if(Stations.get(index).getBlue()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"blue",Stations.get(index).getBlue());
					Stations.get(index).setBlue(-1);
					System.out.println("Station has been removed from the blue line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"blue",pos);
				Stations.get(index).setBlue(pos);
				System.out.println("Station has been added to the blue line");
				return Stations;
			}
		case "4":
			if(Stations.get(index).getBrown()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"brown",Stations.get(index).getBrown());
					Stations.get(index).setBrown(-1);
					System.out.println("Station has been removed from the brown line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"brown",pos);
				Stations.get(index).setBrown(pos);
				System.out.println("Station has been added to the brown line");
				return Stations;
			}
		case "5":
			if(Stations.get(index).getPurple()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"purple",Stations.get(index).getPurple());
					Stations.get(index).setPurple(-1);
					System.out.println("Station has been removed from the purple line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"purple",pos);
				Stations.get(index).setPurple(pos);
				System.out.println("Station has been added to the purple line");
				return Stations;
			}
		case "6":
			if(Stations.get(index).getPink()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"pink",Stations.get(index).getPink());
					Stations.get(index).setPink(-1);
					System.out.println("Station has been removed from the pink line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"pink",pos);
				Stations.get(index).setPink(pos);
				System.out.println("Station has been added to the pink line");
				return Stations;
			}
		case "7":
			if(Stations.get(index).getOrange()>=0) {
				System.out.println("This Station already exists on this line ,Do you wish to remove it(yes/no)");
				String choice2=input.nextLine().toLowerCase().stripIndent();
				if(choice2.equals("yes")) {
					Stations=removeStationsRelocation(Stations,"orange",Stations.get(index).getOrange());
					Stations.get(index).setOrange(-1);
					System.out.println("Station has been removed from the orange line");
					return Stations;
				}else {
					System.out.println("Returning to main menu");
				}
			}else {
				int pos=-1;//position of the station on the line
				boolean done=false;//while loop exit variable 
				while(!done) {
					try {
						System.out.println("Enter the pos of this Station on the line");
						pos=Integer.parseInt(input.nextLine().stripIndent());
						if(pos>=0) {
							done=true;
						}else {
							System.out.println("Please enter a position of 0 or above");
						}
					}catch(Exception e) {
						System.out.println("Not an Integer, Please enter an integer");
					}
				}
				Stations=addStationsRelocation(Stations,"orange",pos);
				Stations.get(index).setOrange(pos);
				System.out.println("Station has been added to the orange line");
				return Stations;
			}

		default:
			System.out.println("Returning to main menu");
			return Stations;
		}
	}
	
	public static ArrayList<Line> modifyStation(ArrayList<Line> Stations,Scanner input){//This method allows the user to change some
		//of the key values of the station like name,coordinates,wheelchair acess,Description and it uses ModifyLines() method to 
		//modify the lines
	System.out.println("Select the Station whose details you wish to modify");
	System.out.println();
	int index=search(Stations,input);//uses search method to select a station whose index is stored in this variable
	if(index==-1) {
		System.out.println();
		System.out.println("Returning to main Menu");
		System.out.println();
		return Stations;
	}
	System.out.println("Which of the following details do you wish to modify(Type any other number to return to main menu)");
	System.out.println("1.Name");
	System.out.println("2.Coordinates");
	System.out.println("3.Description");
	System.out.println("4.Wheelchair access");
	System.out.println("5.Lines the station lies on");
	String choice=input.nextLine().toLowerCase().stripIndent();//user input choice
	switch(choice) {
	case "1":
		System.out.println("Current Name:"+Stations.get(index).getName());
		System.out.println("Enter the new Name:");
		Stations.get(index).setName(input.nextLine());
		System.out.println("System Alert! \nStation name has been modified");
		System.out.println();
		return Stations;
	case "2":
		System.out.println("Current coordinates are, Latitude:"+Stations.get(index).getLatitude()+" Longitude:"+Stations.get(index).getLongitude());
		System.out.println("Enter new coordinates:");
		double latitude=0;//new latitude value
		double longitude=0;//new longitude value
		boolean done=false;//loop exit variable
		while(!done){
			try {
				System.out.println("Latitude:");
				latitude=Double.parseDouble(input.nextLine());
				System.out.println("Longitude:");
				longitude=Double.parseDouble(input.nextLine());
				done=true;
			}catch(Exception e) {
				System.out.println("Make sure to enter a double");
			}
		}
		Stations.get(index).setLatitude(latitude);
		Stations.get(index).setLongitude(longitude);
		System.out.println("System Alert! \nStation coordinates have been modified");
		System.out.println();
		return Stations;
	case "3":
		System.out.println("Current Description is:"+Stations.get(index).getDescription());
		System.out.println("Enter the new Decription:");
		Stations.get(index).setDescription(input.nextLine());
		System.out.println("System Alert! \nStation Description has been modified");
		System.out.println();
		return Stations;
	case "4":
		System.out.println("The current status of wheelchair access is "+Stations.get(index).getWheelchair());
		done=false;//loop exit variable
		boolean wheelchair=false;//New wheelchair access
		while(!done){
			try {
				System.out.println("Enter whether your station has wheelchair access(true/false):");
				String option=input.nextLine();//temporary to check what the user entered and convert it to boolean
				if((option.toLowerCase().stripIndent()).equals("true")) {
					wheelchair=true;
					done=true;
				}else if((option.toLowerCase().stripIndent()).equals("false")) {
					wheelchair=false;
					done=true;
				}else {
					System.out.println("Make sure to enter a either true or false");
				}
			}catch(Exception e) {
				System.out.println("Make sure to enter a either true or false;");
			}
		}
		Stations.get(index).setWheelchair(wheelchair);
		System.out.println("System Alert! \nStation Wheelchair access has been modified");
		System.out.println();
		return Stations;
	case "5":
		return Stations=modifyLines(Stations,input,index);
	default:
		System.out.println("Returning to main menu");
		System.out.println();
		return Stations;
	}
	}
	
	public static ArrayList<Line> redStations(ArrayList<Line> Stations){//Compiles all the stations on the red line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getRed()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getRed()<temp.get(j-1).getRed()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> greenStations(ArrayList<Line> Stations){//Compiles all the stations on the green line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getGreen()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getGreen()<temp.get(j-1).getGreen()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> blueStations(ArrayList<Line> Stations){//Compiles all the stations on the blue line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getBlue()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getBlue()<temp.get(j-1).getBlue()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> brownStations(ArrayList<Line> Stations){//Compiles all the stations on the brown line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getBrown()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getBrown()<temp.get(j-1).getBrown()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> purpleStations(ArrayList<Line> Stations){//Compiles all the stations on the purple line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getPurple()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getPurple()<temp.get(j-1).getPurple()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> pinkStations(ArrayList<Line> Stations){//Compiles all the stations on the pink line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getPink()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getPink()<temp.get(j-1).getPink()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static ArrayList<Line> orangeStations(ArrayList<Line> Stations){//Compiles all the stations on the orange line into one arrayList 
		//and returns the arrayList
		ArrayList<Line> temp=new ArrayList<Line>();
		for(int i=0;i<Stations.size();i++) {
			if(Stations.get(i).getOrange()>=0) {
				temp.add(Stations.get(i));
			}
		}
		for(int i=1;i<temp.size();i++) {
			int j=i;
			while(j>0 && temp.get(j).getOrange()<temp.get(j-1).getOrange()) {
				Line temp1=temp.get(j-1);
				Line temp2=temp.get(j);
				temp.set(j-1,temp2);
				temp.set(j, temp1);
				j=j-1;
			}
		}
		return temp;
	}
	
	public static void showRoute(Line start,Line end,ArrayList<Line> line) {//Takes in the start station end station and the line
		//both are on and returns the station in between.
		ArrayList<Line> display=new ArrayList<Line>();//Temporary arrayList to display the stations in between
		int count=0;//count of number of important stations passed
		for(int i=0;i<line.size();i++) {
			if(count==0 && (line.get(i).equals(start) || line.get(i).equals(end))){
				display.add(line.get(i));
				count=1;
			}else if(count==1 && (line.get(i).equals(start) || line.get(i).equals(end))) {
				display.add(line.get(i));
				count=2;
			}else if(count==1) {
				display.add(line.get(i));
			}
		}
		if(display.get(0)!=start) {
			Collections.reverse(display);
		}
		System.out.println("Take the route");
		System.out.println();
		System.out.println("***************************************************************************************************************************************************");
		for(int i=0;i<display.size();i++) {
			System.out.print(display.get(i).getName()+" >> ");
		}
		System.out.println("");
		System.out.println("***************************************************************************************************************************************************");
	}
	
	public static int findRoute(ArrayList<Line> Stations,Scanner input) {//this method is responsible for finding the common line at 
		//which both the starting and ending stations lie on , and if such a line does not exits it finds a common transfer station
		//that lies on both the starting and final line.It then uses displayRoute() to show the route
		ArrayList<Line> red=redStations(Stations);ArrayList<Line> green=greenStations(Stations);ArrayList<Line> blue=blueStations(Stations);ArrayList<Line> brown=brownStations(Stations);//arraylist for all the lines
		ArrayList<Line> purple=purpleStations(Stations);ArrayList<Line> pink=pinkStations(Stations);ArrayList<Line> orange=orangeStations(Stations);//arraylist for all the lines
		Line start=null;//starting station reference
		Line end=null;//ending station reference
		System.out.println("Select your starting station");
		int index=search(Stations,input);//index of station in main arrayList
		if(index==-1) {
			System.out.println();
			System.out.println("Returning to main Menu");
			System.out.println();
			return -1;
		}else {
			start=Stations.get(index);
		}
		System.out.println("Select your destination station");
		index=search(Stations,input);
		if(index==-1) {
			System.out.println();
			System.out.println("Returning to main Menu");
			System.out.println();
			return -1;
		}else {
			end=Stations.get(index);
		}
		System.out.println(start.getName());
		System.out.println(end.getName());
		ArrayList<ArrayList<Line>> lines=new ArrayList<ArrayList<Line>>();//arrayList containing all the lines arrayList
		lines.add(red);lines.add(green);lines.add(blue);lines.add(brown);lines.add(purple);lines.add(pink);lines.add(orange);
		ArrayList<ArrayList<Line>> start_lines=new ArrayList<ArrayList<Line>>();//arrayList containing all the start lines arrayList
		ArrayList<ArrayList<Line>> end_lines=new ArrayList<ArrayList<Line>>();//arrayList containing all the end lines arrayList
		for(ArrayList<Line> line:lines) {
			if(line.contains(start)) {
				start_lines.add(line);
			}if(line.contains(end)) {
				end_lines.add(line);
			}
		}
		ArrayList<Line> finalLine=null;//final line arrayList
		for(ArrayList<Line> line: start_lines) {
			if(end_lines.contains(line)) {
				finalLine=line;
			}
		}
		if(finalLine!=null) {
			showRoute(start,end,finalLine);
			System.out.println();
			System.out.println("You have arrived at your destination");
			System.out.println();
		}else {
			Line transfer=null;//transfer station reference
			ArrayList<Line> startLine=start_lines.get(0);//Starting station lines
			finalLine=end_lines.get(0);
			for(Line s: start_lines.get(0)) {
				if(end_lines.get(0).contains(s)) {
					transfer=s;
					break;
				}
			}
			if(transfer==null) {
				System.out.println("No path availabe");
				System.out.println("You have arrived at your destination");
				System.out.println();
				System.out.println();
			}else {
				showRoute(start,transfer,startLine);
				System.out.println();
				System.out.println("Take transfer at "+transfer.getName());
				System.out.println();
				showRoute(transfer,end,finalLine);
				System.out.println();
				System.out.println("You have arrived at your destination");
				System.out.println();
			}
		}
		return -1;
	}
	
	public static void closestStation(ArrayList<Line> Stations,Scanner input) {//this method is responsible for finisng the closest
		//station to the coordinates entered by the user using the distance formula root((x1-x2)**2+(y1-y2)**2) and then displays
		//the details of that station
		System.out.println("Enter the coordinates to which you want to find the closest station");
		boolean done=false;//loop exit/enter variable
		double x=0,y=0;//user entered coordinates
		while(!done){
			try {
				System.out.println("Latitude:");
				x=Double.parseDouble(input.nextLine());
				done=true;
			}catch(Exception e) {
				System.out.println("Make sure to enter a double");
			}
		}
		done=false;
		while(!done){
			try {
				System.out.println("Longitude:");
				y=Double.parseDouble(input.nextLine());
				done=true;
			}catch(Exception e) {
				System.out.println("Make sure to enter a double");
			}
		}
		Line s=Stations.get(0);//closest station
		for(int i=1;i<Stations.size();i++) {
			double shortest_distance=Math.sqrt((Math.pow((x-(s.getLatitude())), 2))+(Math.pow((y-(s.getLongitude())), 2)));
			double distance=Math.sqrt((Math.pow((x-(Stations.get(i).getLatitude())), 2))+(Math.pow((y-(Stations.get(i).getLongitude())), 2)));
			if(distance<shortest_distance) {
				s=Stations.get(i);
			}
		}
		System.out.println("The Station closest to the coordinates "+x+" Latitude and "+y+" Longitude is \n"+s.details());
	}
	
	public static ArrayList<Line> relocateStations(ArrayList<Line> Stations,int red,int green,int blue,int brown,int purple,int pink,int orange){
		//relocates the stations coming after the the added station by changing their pos by +1
		if(red>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getRed()>=red) {
					int temp=Stations.get(i).getRed();
					Stations.get(i).setRed(temp+1);
				}
			}
		}if(blue>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBlue()>=blue) {
					int temp=Stations.get(i).getBlue();
					Stations.get(i).setBlue(temp+1);
				}
			}
		}if(green>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getGreen()>=green) {
					int temp=Stations.get(i).getGreen();
					Stations.get(i).setGreen(temp+1);
				}
			}
		}if(brown>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getBrown()>=brown) {
					int temp=Stations.get(i).getBrown();
					Stations.get(i).setBrown(temp+1);
				}
			}
		}if(purple>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPurple()>=purple) {
					int temp=Stations.get(i).getPurple();
					Stations.get(i).setPurple(temp+1);
				}
			}
		}if(pink>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getPink()>=pink) {
					int temp=Stations.get(i).getPink();
					Stations.get(i).setPink(temp+1);
				}
			}
		}if(orange>=0) {
			for(int i=0;i<Stations.size();i++) {
				if(Stations.get(i).getOrange()>=orange) {
					int temp=Stations.get(i).getOrange();
					Stations.get(i).setOrange(temp+1);
				}
			}
		}
		return Stations;
	}
	
	
	
	public static ArrayList<Line> addStation(Scanner input,ArrayList<Line> Stations) {//allows the user the add a station to the main arrayList
		//and asks the user to enter appropriate details regarding the station.
		Line s=null;//Station reference
		double latitude=0;//latitude of station
		double longitude=0;//longitude of station
		boolean wheelchair=false;//wheelchair access of the station
		int red = -1,green=-1,blue=-1,brown=-1,purple=-1,pink=-1,orange=-1;//lines pos of the station
		System.out.println("Enter the name of the new station you wish to add:");
		String name=input.nextLine();//name of station
		System.out.println("Enter the coordinates of this station");
		boolean done=false;//loop enter/exit variable
		while(!done){
			try {
				System.out.println("Latitude:");
				latitude=Double.parseDouble(input.nextLine());
				System.out.println("Longitude:");
				longitude=Double.parseDouble(input.nextLine());
				done=true;
			}catch(Exception e) {
				System.out.println("Make sure to enter a double");
			}
		}
		System.out.println("Enter its description:");
		String description=input.nextLine();//description of the station
		done=false;
		while(!done){
			try {
				System.out.println("Enter whether your station has wheelchair access(true/false):");
				String option=input.nextLine();
				if((option.toLowerCase().stripIndent()).equals("true")) {
					wheelchair=true;
					done=true;
				}else if((option.toLowerCase().stripIndent()).equals("false")) {
					wheelchair=false;
					done=true;
				}else {
					System.out.println("Make sure to enter a either true or false");
				}
			}catch(Exception e) {
				System.out.println("Make sure to enter a either true or false;");
			}
		}
		done=false;
		while(!done){
			try {
				System.out.println("Enter the position on the station on the lines(-1 if not on the line)");
				System.out.println("Enter the position of your station on the red line:");
				red=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the green line:");
				green=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the blue line:");
				blue=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the brown line:");
				brown=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the purple line:");
				purple=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the pink line:");
				pink=Integer.parseInt(input.nextLine());
				System.out.println("Enter the position of your station on the orange line:");
				orange=Integer.parseInt(input.nextLine());
				done=true;
			}catch(Exception e) {
				System.out.println("Make sure to enter an integer");
			}
		}
		s=new Line(name,latitude,longitude,description,wheelchair,red,green,blue,brown,purple,pink,orange);
		Stations=relocateStations(Stations,red,green,blue,brown,purple,pink,orange);
		Stations.add(s);
		return Stations;
	}
	
	public static void writeToFile(ArrayList<Line> Stations,Scanner input) {//This program writes all the station information
		//to the .csv file using its to string method.It also gives the user the choice on whether to save the changes or not.
		System.out.println("Do you wish to write your changes to the file(yes/no)");
		String choice=input.nextLine().toLowerCase().stripIndent();
		boolean done=false;
		while(!done) {
		switch(choice) {
		case "yes":
			try {
				FileWriter file=new FileWriter("src/project/CTAStops.csv");
				file.write("Name,Latitude,Longitude,Description,Wheelchair,Red:33,Green:28,Blue:33,Brown:27,Purple:27,Pink:22,Orange:16\n");
				for(int i=0;i<Stations.size();i++) {
					file.write(Stations.get(i).toString()+"\n");
				}
				file.flush();
				file.close();
			}catch(Exception e) {
				System.out.println("File not found");
			}
			done=true;
			break;
		case "no":
			System.out.println("Your changes have been reverted");
			done=true;
			break;
		default:
			System.out.println("Invalid option enter either true or false");
		
		}
		}
	}

	public static void main(String[] args) {//the main string method wich contains the option menu letting the user choose what 
		//they wish to change or view.It also contains the main stations arrayList
		Scanner input=new Scanner(System.in);//scanner variable
		ArrayList<Line> Stations=readExistingFile();//main stations arrayList
		boolean done=false;//loop exit/entry variable
		do {
			System.out.println("Chicago Transit Authority(CTA) Terminal");
			System.out.println("1.Add a new Station to the CTA");
			System.out.println("2.Remove a station from the CTA");
			System.out.println("3.Search for a station on the CTA ");
			System.out.println("4.Modify an existing station on the CTA");
			System.out.println("5.Find the closest station to your coordinates");
			System.out.println("6.Find a route between stations");
			System.out.println("7.Exit the application");
			System.out.println("Choose the one of the options:");
			String choice=input.nextLine().stripIndent();//user input choice
			switch(choice) {
			case "1":
				Stations=addStation(input,Stations);
				System.out.println("System Alert!\nStation has been added");
				break;
			case "2":
				Stations=removeStation(Stations,input);
				break;
			case "3":
				showStationDetails(Stations,input);
				break;
			case "4":
				Stations=modifyStation(Stations,input);
				break;
			case "5":
				closestStation(Stations,input);
				break;
			case "6":
				findRoute(Stations,input);
				break;
			case "7":
				writeToFile(Stations,input);
				done=true;
				break;
			default:
				System.out.println("Invalid option");
			}
		}while(!done);
		
		input.close();
	}

}
