import java.util.*;
import java.time.LocalDate;
class iFRIENDContact{
	
	public static String[] conatctId = new String[5];
	public static String[] conatctNames = new String[5];
	public static String[] phoneNumbers = new String[5];
	public static String[] companyNames = new String[5];
	public static int[] contactSalaries = new int[5];
	public static String[] dobs = new String[5];
	
	public static String genarateContactId(int id){
		//String conatctId = String.format("C%04d",id);
		//return conatctId;
		return String.format("C%04d",id);
	}
	
	public static boolean validateSalary(int salary){
		if (salary < 0){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean validatePhoneNO(String phoneNo){
		//10 cha
		//0
		if( phoneNo.startsWith("0") && (phoneNo.length() == 10) ){
			return true;
		}else{
			return false;
		}		
	}
	
	public static boolean validateDOB(String dob){
		
		LocalDate localdate = LocalDate.parse(dob);
		int birthyear = localdate.getYear();
		
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		
		if(birthyear > 1926 && birthyear < currentYear){
			return true;
		}else{
			return false;
		}
	}
	
	public static int searchContact(String value){
		
		for(int i = 0; i < conatctNames.length; i++){
			
			if(value.equals(conatctNames[i]) || value.equals(phoneNumbers[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static void printContact(int index){
		
		System.out.println("\nContact ID : " + conatctId[index]);
		System.out.println("Name       : " + conatctNames[index]);
		System.out.println("Phone No   : " + phoneNumbers[index]);
		System.out.println("Company    : " + companyNames[index]);
		System.out.println("Salary     : " + contactSalaries[index]);
		System.out.println("Birthday   : " + dobs[index]);
	}
	
	public static void addContacts(){
		
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|       Add Contact to the list        |");
		System.out.println("+--------------------------------------+");
		
		System.out.println('\n');
		
		int id = 1;
		
		//--------------------------------------
		
		char addContactsOption = 'N';
		
		do{
			String contactId = genarateContactId(id);
			
			//------SAVE ID IN ARRAY------
			conatctId[id-1] = contactId;
			//----------------------------
			
			System.out.println(contactId);
			System.out.println("=======");
			
			System.out.println();
			
			System.out.print("Name     : ");
			String contactName = input.next();
			
			//--SAVE NAME IN ARRAY----
			conatctNames[id-1] = contactName;
			//------------------------
			
			//--------GET CONTACT PHONE NUMBER---------------------
			
			String contactNO;
			
			do{
				System.out.print("Phone NO : ");
				contactNO = input.next();
				
				if(!validatePhoneNO(contactNO)){
					System.out.println("\n\t Invalied Phone number......");
				}
			}while(!validatePhoneNO(contactNO));
			
			//------SAVE CONTACT NO IN ARRAY--
			phoneNumbers[id-1] = contactNO;
			//----------------------------------
			
			
			//----------------------------------------------------
			
			System.out.print("Company  : ");
			String companyName = input.next();
			
			//------SAVE COMPANY IN ARRAY--
			companyNames[id-1] = companyName;
			//-----------------------------
			
			System.out.print("Salary   : ");
			int contactSalary = input.nextInt();
			
			if(validateSalary(contactSalary)){
				//------SAVE SALARY IN ARRAY--
				contactSalaries[id-1] = contactSalary;
			}
			
			//----VALIDATE DATE OF BIRTH--------------------
			
			String dob;
			
			do{
				System.out.print("Birthday : ");
				dob = input.next();
				
				if(!validateDOB(dob)){
					System.out.println("\n\t Invalied Date of Birth......");
				}
			}while(!validateDOB(dob));
			
			//------SAVE DOB IN ARRAY--
			dobs[id-1] = dob;
			//-------------------------
				
			//-----------------------------------------------
			
			System.out.println();
			
			System.out.println("\t\t Contact has been added successfully...");
			
			System.out.print("\nDo you want to add another Contact(Y/N) : ");
			addContactsOption = input.next().charAt(0);
			
			if(addContactsOption == 'Y' || addContactsOption == 'y' ){
				id++;
			}
		}while(addContactsOption == 'Y' || addContactsOption == 'y' );
	}
	
	public static void searchContacts(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|          Search Contact              |");
		System.out.println("+--------------------------------------+");
		
		System.out.print("\nSearch Contact by Name or Phone Number : ");
		String value = input.next();
		
		int index = searchContact(value);
		
		if(index == -1){
			System.out.println("\n\tContact not found...");
		}else{
			printContact(index);
		}
	}
	
	public static void deleteContacts(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|          Delete Contact              |");
		System.out.println("+--------------------------------------+");
		
		System.out.print("\nSearch Contact by Name or Phone Number : ");
		String value = input.next();
		
		int index = searchContact(value);
		
		if(index == -1){
			System.out.println("\n\tContact not found...");
		}else{
			
			printContact(index);
			
			System.out.print("\nDo you want to delete this contact(Y/N) : ");
			char option = input.next().charAt(0);
			
			if(option == 'Y' || option == 'y'){
				
				conatctId[index] = null;
				conatctNames[index] = null;
				phoneNumbers[index] = null;
				companyNames[index] = null;
				contactSalaries[index] = 0;
				dobs[index] = null;
				
				System.out.println("\n\tContact deleted successfully...");
			}
		}
	}
	
	public static void updateContacts(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|          Update Contact              |");
		System.out.println("+--------------------------------------+");
		
		System.out.print("\nSearch Contact by Name or Phone Number : ");
		String value = input.next();
		
		int index = searchContact(value);
		
		if(index == -1){
			System.out.println("\n\tContact not found...");
		}else{
			
			printContact(index);
			
			System.out.println("\nWhat do you want to update...");
			System.out.println("\n\t[1] Name");
			System.out.println("\t[2] Phone Number");
			System.out.println("\t[3] Company");
			System.out.println("\t[4] Salary");
			
			System.out.print("\nEnter an option : ");
			int option = input.nextInt();
			
			switch(option){
				
				case 1:{
					System.out.print("\nEnter New Name : ");
					conatctNames[index] = input.next();
					
					System.out.println("\n\tName Updated Successfully...");
				}break;
				
				case 2:{
					
					String phoneNo;
					
					do{
						System.out.print("\nEnter New Phone Number : ");
						phoneNo = input.next();
						
						if(!validatePhoneNO(phoneNo)){
							System.out.println("\n\tInvalied Phone Number...");
						}
					}while(!validatePhoneNO(phoneNo));
					
					phoneNumbers[index] = phoneNo;
					
					System.out.println("\n\tPhone Number Updated Successfully...");
				}break;
				
				case 3:{
					System.out.print("\nEnter New Company : ");
					companyNames[index] = input.next();
					
					System.out.println("\n\tCompany Updated Successfully...");
				}break;
				
				case 4:{
					
					int salary;
					
					do{
						System.out.print("\nEnter New Salary : ");
						salary = input.nextInt();
						
						if(!validateSalary(salary)){
							System.out.println("\n\tInvalied Salary...");
						}
					}while(!validateSalary(salary));
					
					contactSalaries[index] = salary;
					
					System.out.println("\n\tSalary Updated Successfully...");
				}break;
			}
		}
	}
	
	public static void listContacts(){
		
		System.out.println("+--------------------------------------+");
		System.out.println("|            List Contacts             |");
		System.out.println("+--------------------------------------+");
		
		for(int i = 0; i < conatctNames.length; i++){
			
			if(conatctNames[i] != null){
				
				System.out.println("\n--------------------------------");
				printContact(i);
				System.out.println("--------------------------------");
			}
		}
	}
	
	public static void main(String args[]){
		
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
		
		System.out.println("\t[1] Add Contacts");
		System.out.println("\t[2] Update Contacts");
		System.out.println("\t[3] Delete Contacts");
		System.out.println("\t[4] Search Contacts");
		System.out.println("\t[5] List Contacts");
		System.out.println("\t[6] Exit");
		
		System.out.print("\nEnter an option to continue -> ");
		int mainOption = input.nextInt();
		
		switch(mainOption){
			case 1: {
				addContacts();
			}break;
			case 2:{
				updateContacts();
			}break;
			case 3: {
				deleteContacts();
			}break;
			case 4:{
				searchContacts();
			}break;
			case 5:{
				listContacts();
			}break;
			case 6: System.exit(0);break;
		}
	}
}
				
				 
		
		
		
