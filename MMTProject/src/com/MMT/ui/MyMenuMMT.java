package com.MMT.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.MMT.bean.Admin;
import com.MMT.bean.User;
import com.MMT.bean.Hotel;
import com.MMT.bean.HotelRoom;
import com.MMT.bl.*;
import com.MMT.helper.HotelDataMMT;
import com.MMT.helper.UserDataMMT;
import com.MMT.helper.HotelDataMMT;
import com.MMT.bean.HotelBooking;
import com.MMT.bean.Hotel;
public class MyMenuMMT{
	private UserBlMMT ub = new UserBlMMT();
	private AdminBlMMT ab=new AdminBlMMT();
	private HotelBlMMT hb=new HotelBlMMT();
	private User user=new User();
	private Admin admin=new Admin();
	
	public void displayMenu(){
		System.out.println("1. Login");
		System.out.println("2. Signup ");
		System.out.println("3. Admin ");
		System.out.println("4. Exit");
		choice();
	}
	public void adminMainMenuDisplay()
	{
		System.out.println("ADMIN DISPLAY");
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. Modify");
		System.out.println("4. Logout");
		Scanner sc= new Scanner(System.in);
		int choice1=sc.nextInt();
		if(choice1==4)
		{
			System.out.println("Logged Out");
			displayMenu();
		}
		adminSubMenuDisplay(choice1);
		}
	public void adminSubMenuDisplay(int choice1){
		System.out.println("1. Hotel");
		System.out.println("2. Back");
		
		Scanner sc= new Scanner(System.in);
		int choice2=sc.nextInt();
		
		try {
			adminChoice(choice1,choice2);
		} catch (ClassNotFoundException | IOException e) {
		
			System.out.println("File Does Not Exist!!");
		}
		return ;	
	}
	public void adminChoice(int choice1, int choice2) throws ClassNotFoundException, IOException{
		if(choice1==1){			
			if(choice2==1){
				Hotel newHotel = new Hotel();
				HotelDataMMT hd = new HotelDataMMT();
				hd.input();
				newHotel = hd.getHotel();
				ab.insertHotel(newHotel);	
				adminMainMenuDisplay();
			}
			else if(choice2==2)
			{
				adminMainMenuDisplay();
			}
			else{
				System.out.println("Invalid category!!!");
				adminMainMenuDisplay();
			}
		}
		else if(choice1==2){
			Scanner sc =new Scanner(System.in);
			if(choice2==1){
				System.out.println("Enter hotel id");
				int hid=sc.nextInt();
				ab.deleteHotel(hid);
				adminMainMenuDisplay();
			}
			else if(choice2==2)
			{
				adminMainMenuDisplay();
			}
			else{
				System.out.println("Invalid category!!!");
				adminMainMenuDisplay();
			}
		}
		else if(choice1==3){
			Scanner sc =new Scanner(System.in);
			if(choice2==1){
				Hotel newHotel = new Hotel();
				HotelDataMMT hd = new HotelDataMMT();
				hd.input();
				newHotel = hd.getHotel();
				System.out.println("Enter hotel id");
				int hid=sc.nextInt();
				ab.modifyHotel(hid, newHotel);
				adminMainMenuDisplay();
			}
			else if(choice2==2)
			{
				adminMainMenuDisplay();
			}
			else{
				System.out.println("Invalid category!!!");
				adminMainMenuDisplay();
			}
		}
		else if(choice1 == 4){
			System.out.println("Successfully logged out!!!");
			displayMenu();
		}
		else{
			System.out.println("Invalid operation!!!");
			adminMainMenuDisplay();
		}
	}
	public void userDisplay()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+user.getUserName().toUpperCase());
		System.out.println("1. Hotel Search");
		System.out.println("2. View Past Bookings");
		System.out.println("3. Logout");
		try {
			userChoice();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No Bookings of Hotel");
		}
		catch(Exception e)
		{			
			System.out.println(e);
		}
	}
	public void userChoice() throws ClassNotFoundException, IOException{
		Scanner sc = new Scanner(System.in);
     	int choice=sc.nextInt();
     	switch(choice){	
     	case 1: 
			ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
			hotelList=hb.searchResult();
			
			while(true){							
			
				for(Hotel hot:hotelList){
					System.out.println(hot);
				}
				System.out.println("1. Select Hotel");
				System.out.println("2. Back");
				int ch=sc.nextInt();
				if(ch==1){
					System.out.println("Enter the hotel id for selected hotel : ");
					int hid = sc.nextInt();
					while(true){
						Hotel shotel=new Hotel();
						shotel=hb.displayHotel(hid);
						System.out.println(shotel.getHotelId());			
						System.out.println(shotel.getHotelName());			
						System.out.println(shotel.getHotelInfo());			
						System.out.println(shotel.getHotelLocation());
						System.out.println("1. Book Room");
						System.out.println("2. Back");
						int ch2=sc.nextInt();
						if(ch2==1){
							ArrayList<HotelRoom> aroom=new ArrayList<HotelRoom>();
							aroom=hb.availableRooms(hid);
							for(HotelRoom hr:aroom){
								System.out.println(hr);
							}
							System.out.println("1. Confirm Room");
							System.out.println("2. Back");
							int ch3=sc.nextInt();
							if(ch3==1){				//switch(ch3)
						    	System.out.println("Enter Room No.");
								int rno=sc.nextInt();
							
								if(hb.hotelBooking(hid, user.getUserId(), rno)){
								System.out.println("Booking Success");
								userDisplay();
								}
								else{
								System.out.println("Booking Failed");
								userDisplay();
								}
							break;
						    }
							else if(ch3==2){
 								continue;
							 }
						break;
						}
						else if(ch2==2){//case 2://back to userDisplay
						break;
					}
					}
				}
				else if(ch==2){
					userDisplay();
				}
     	}
     	case 2: 
			
			ArrayList<HotelBooking> hbList=new ArrayList<HotelBooking>();
			hbList=ub.pastHbooking(user.getUserId());
			System.out.println("Hotel Bookings :");
			for(HotelBooking hot:hbList){
			System.out.println(hot);
			}
			userDisplay();
			break;
     	case 3:
     	System.out.println("Successfully logged out!!!");
		user=new User();
		displayMenu();
		break;
     	default:System.out.println("invalid option!!!");
		break;
			
	}}
	public void choice()
	{
		UserDataMMT ud=new UserDataMMT();
		System.out.println("Enter Option :");
		
		Scanner sc= new Scanner(System.in);
		int choice=sc.nextInt();
		
		switch(choice){
		case 1:
		System.out.println("Enter User Name:");
		String name=sc.next();
		System.out.println("Enter Password: ");
		String pass=sc.next();
		user= new User();
		try {
			if(name==null){
				System.out.println("THE USERNAME FIELD IS BLANK!!!");
			}
			else if(pass==null){
				System.out.println("THE PASSWORD FIELD IS BLANK!!!");
			}
			else{
				
				if(ub.checkLogin(name,pass)!=null)
					{
					
					System.out.println(" Successful Login!!");
					user=ub.checkLogin(name, pass);
					userDisplay();
					
					}
				else
				{
					//Login failed
					return;
					//return 0;
				}
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("User File Not Found!!!");
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class Not Found!!!");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Error");
			return;
		}
		catch(Exception e){
			System.out.println("Login Failed");
			displayMenu();
		}
		return;
		case 2:
			ud.input();
			User newuser=ud.getUser();
			try {
				Boolean status=ub.register(newuser);
				if(status==true)
				{
					System.out.println("Registration Successful");
					displayMenu();
				}
				else
				{	
					System.out.println("Registration Failed");
					displayMenu();
				}
			} catch (Exception e) {
				System.out.println("Registration Failed");
				displayMenu();
			}
			
			case 3:
				System.out.println("Enter User Name:");
				String aname=sc.next();
				System.out.println("Enter Password: ");
				String apass=sc.next();
				
				try {
					if(aname==null){
						System.out.println("THE USERNAME FIELD IS BLANK!!!");
					}
					else if(apass==null){
						System.out.println("THE PASSWORD FIELD IS BLANK!!!");
					}
					else{
						
						if(ab.alogin(aname, apass)!=null)
						{
							
							
							System.out.println("Succesful Login!!");
						admin=ab.alogin(aname, apass);
						adminMainMenuDisplay();
						}
						
						else
						{	//Login Failed
							displayMenu();
						}	
					}
				} catch (FileNotFoundException e) {
					System.out.println("No Admin File");
					return;
				} catch (ClassNotFoundException e) {
					System.out.println("Class Exception");
					return;
				} catch (IOException e) {
					System.out.println(" IO Error");
					return;
					}
				catch(Exception e)
				{
					System.out.println("Login Failed!! ");
					displayMenu();
				}
				return;
			case 4: System.out.println("Thank you!!!");
					System.exit(0);
			default: System.out.println("Invalid choice");
					displayMenu();
		}
	}
}