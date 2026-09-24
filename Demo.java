import java.util.*;
import java.time.LocalDate;
class Demo{	
	
	public static String[] contactIdArray = new String[5];
	public static String[] nameArray = new String[5];
	public static String[] phoneNumberArray = new String[5];
	public static String[] companyArray = new String[5];
	public static int[] salaryArray = new int[5];
	public static String[] BirthdayArray = new String[5];
	
	public static String genarateContactId(int contactId){
		return String.format("C%04d",contactId);
	}
	
	public static boolean validePhoneNumber(String No){
		if( No.startsWith("0") && (No.length() == 10) ){
			return true;
		}else{
			return false;
		}		
	}
	
	public static boolean validateSalary(int salary){
		if(salary > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkBirthday(String birthday){
		LocalDate localdate = LocalDate.parse(birthday);
		int birthyear = localdate.getYear();
		
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		
		if(birthyear > 1926 && birthyear < currentYear){
			return true;
		}else{
			return false;
		}
	}
	
	public static void AddContact(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("\t +-------------------------+");
		System.out.println("\t | add contact to the list |");
		System.out.println("\t +-------------------------+");
		
		int id = 1;
		
		do{
			String contactId = genarateContactId(id);
			contactIdArray[id-1] = contactId;
			
			System.out.println(contactId);
			System.out.println("=========");
			
			System.out.println();
			
//===============name=============================		
			System.out.print("Name         	  : ");
			String Name = input.next();
			
			nameArray[id-1] = Name;
		
//===============phone number======================
			String PhoneNumber;
			do{
				System.out.print("Phone Number 	  : ");
				PhoneNumber = input.next();
		
				if(!validePhoneNumber(PhoneNumber)){
					System.out.println("Invalide Phone Number...... Pleas enter correct phone Number");
				}
			}while(!validePhoneNumber(PhoneNumber));
			
			phoneNumberArray[id-1] = PhoneNumber;

//================Company Name===========================		
			System.out.print("Company Name 	  : ");
			String CompanyName = input.next();
			
			companyArray[id-1] = CompanyName;

//=================salary================================		
			System.out.print("Salary		 	  : ");
			int Salary = input.nextInt();
		
			if(validateSalary(Salary)){
				salaryArray[id-1] = Salary;
			}
	
//==============birthday=================================		
		
			String DOB;
		
			do{
		
				System.out.print("B'day(YYYY-MM-DD) : ");
				DOB = input.next();
			
				if(!checkBirthday(DOB)){
					System.out.println("Invalide b'day...........Enter valide b'day");
				}
			
			}while(!checkBirthday(DOB));
			
			BirthdayArray[id-1] = DOB;
		
		}while(id < 1);
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("	                      /$$ / $$$$$$$$/$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$    ");
		System.out.println("	                      |__/  $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$  ");
		System.out.println("	                       /$$  $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$  ");
		System.out.println("	                      | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$  ");
		System.out.println("	                      | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/  ");
		System.out.println("	                      |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/   ");
		
		System.out.println('\n');
		
		System.out.println("   _____             _             _              ____                         _                   ");
		System.out.println("  / ____|           | |           | |            / __ \\                       (_)                 ");
		System.out.println(" | |      ___  _ __ | |_ __ _  ___| |_ ___      | |  | |_ __ __ _       _ __  _ ____ __ _ __     ");
		System.out.println(" | |     / _ \\| '_ \\| __/ _` |/ __| __/ __|     | |  | | `_/  _` |/ _` | '_ \\| |_  / _ \\ `__|    ");
		System.out.println(" | |____| (_) | | | | || |_| | |__| |_\\__ \\     | |__| | | | |_| | |_| | | | | |/ /  __/| |      ");
		System.out.println("  \\_____ \\___/|_| |_|\\__\\__,_|\\___|\\__|___/      \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___||_|      ");
		System.out.println("                                                             __/ |                               ");
		System.out.println("                                                            |___/                                ");
				
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println('\n');
		
		System.out.println("\t [01] ADD Contact");
		System.out.println("\t [02] UPDATE Contact");
		System.out.println("\t [03] DELETE Contact");
		System.out.println("\t [04] SEARCH Contact");
		System.out.println("\t [05] LIST Contacts");
		System.out.println("\t [06] Exit");
		System.out.println("");
		
		System.out.print("Enter an option to continue ->");
		int mainOption = input.nextInt();
		
		switch(mainOption){
			case 1: {
				AddContact();
			}break;
			
			case 2: {
				System.out.println("Update contact");
			}break;
			
			case 3: {
				System.out.println("delete contact");
			}break;
			
			case 4: {
				System.out.println("search contact");
			}break;
			
			case 5: {
				System.out.println("list contact");
			}break;
			
			case 6: {
				System.out.println("Exit");
			}break;
			
			default:
			System.out.println("Error");
		}
	}
}
