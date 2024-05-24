//Mical Bachleda
//11/6/2022
//COP3330-22 0V03

import java.util.Scanner;

public class proj1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		boolean end_game = false;
		Person[] personArray = new Person[100];
		int count = 0;
		
		System.out.println("		Welcome to my Personnel Management Program\n");
		while (!end_game) {
			System.out.println("Choose one of the options:\n\n");
			System.out.println("1-  Enter the information of a faculty\n");
			System.out.println("2-  Enter the information of a student\n");
			System.out.println("3-  Print tuition invoice for a student\n");
			System.out.println("4-  Print faculty information\n");
			System.out.println("5-  Enter the information of a staff member\n");
			System.out.println("6-  Print the information of a staff member\n");
			System.out.println("7-  Exit Program\n");
			System.out.println("	Enter your selection: \n");
			int choice = scan.nextInt();
			
			if (choice == 1){
				System.out.println("Enter the faculty info:\n");
				System.out.println("	Name of the faculty: ");
				String facultyName = scan.nextLine();
				facultyName = scan.nextLine();
				
				System.out.println("	ID: ");
				String facultyID = scan.nextLine();
				
				System.out.println("	Rank: ");
				String facultyRank = scan.nextLine();
				while (!(facultyRank.toLowerCase().equals("professor") && !facultyRank.toLowerCase().equals("adjunct"))){
					System.out.println("			"+facultyRank+ " is invalid");
					System.out.println("	Rank: ");
					facultyRank = scan.nextLine();
				}
				System.out.println("	Department: ");
				String facultyDepartment =scan.nextLine();
				while (!(facultyDepartment.toLowerCase().equals("mathematics") && !facultyDepartment.toLowerCase().equals("engineering") && !facultyDepartment.toLowerCase().equals("science"))){
					System.out.println("			"+facultyDepartment+ " is invalid");
					System.out.println("	Department: ");
					facultyDepartment = scan.nextLine();
				}
				personArray[count] = new Faculty(facultyName, facultyID, facultyDepartment, facultyRank);
				count++;
				System.out.println("\n\nFaculty added!\n\n");
			}
			if (choice == 2){
				System.out.println("Enter the student info:\n");
				System.out.println("	Name of Student: ");
				String studentName = scan.nextLine();
				studentName = scan.nextLine();
				
				System.out.println("	ID: ");
				String studentID = scan.nextLine();
				
				System.out.println("	Gpa: ");
				double studentGPA = scan.nextDouble();
				
				System.out.println("	Credit hours: ");
				int creditHours = scan.nextInt();
				
				personArray[count] = new Student(studentName, studentID, studentGPA, creditHours);
				count++;
				System.out.println("Student added!");
			}
			if (choice == 3) {
				System.out.println("\nEnter the student's id: ");
				String studentID = scan.nextLine();
				studentID = scan.nextLine();
				boolean foundStudent = false;
				for (int i = 0; i<count; i++) {
					if (personArray[i].getId().equals(studentID)) {
						personArray[i].printCheck();
						foundStudent = true;
					}
				}
				if (!foundStudent) {
					System.out.println("No Student Matched!");
				}
			}
			if (choice == 4) {
				System.out.println("\nEnter the Faculty's id: ");
				String facultyID = scan.nextLine();
				facultyID = scan.nextLine();
				boolean foundFaculty = false;
				for (int i = 0; i<count; i++) {
					if (personArray[i].getId().equals(facultyID)) {
						personArray[i].printCheck();
						foundFaculty = true;
					}
				}
				if (!foundFaculty) {
					System.out.println("No Faculty Matched!");
				}
			}
			if (choice == 5) {
				System.out.println("		Name of staff member: ");
				String staffName = scan.nextLine();
				staffName = scan.nextLine();
				
				System.out.println("		Enter the id: ");
				String staffID = scan.nextLine();
				
				System.out.println("		Department: ");
				String staffDepartment = scan.nextLine();
				
				while (!(staffDepartment.toLowerCase().equals("mathematics") && !staffDepartment.toLowerCase().equals("engineering") && !staffDepartment.toLowerCase().equals("science"))){
					System.out.println("			"+staffDepartment+ " is invalid");
					System.out.println("		Department: ");
					staffDepartment = scan.nextLine();
				}
				System.out.println("		Status, Enter P for Part Time, or Enter F or Full Time: ");
				String status = scan.nextLine();
				
				if (status.equalsIgnoreCase("f")) {
					status = "Full Time";
				}
				else if (status.equalsIgnoreCase("p")) {
					status = "Part Time";
				}
				else {
					System.out.printf(status + " is invalid");
				}
				Staff staff = new Staff(staffName, staffID, staffDepartment, status);
				personArray[count++] = staff;
			}
			if (choice == 6) {
				System.out.println("\nEnter the Staff's id: ");
				String staffId = scan.nextLine();
				staffId = scan.nextLine();
				boolean foundStaff = false;
				for (int i = 0; i<count; i++) {
					if (personArray[i].getId().equals(staffId)) {
						personArray[i].printCheck();
						foundStaff = true;
					}
				}
				if (!foundStaff) {
					System.out.println("No Staff member matched!");
				}
			}
			if (choice == 7) {
				System.out.println("\nGoodbye");
				end_game = true;
			}
			
			
			}
		scan.close();
	}
}
//---------------------------------------------------------------------------------------
 	abstract class Person {
	private String name, id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Person() {
		name = id = "-";
	};
	abstract public void printCheck();
}
//-----------------------------------------------------------------------------------------
	class Student extends Person{
		private double gpa;
		private int creditHours;
	
	public Student(String name, String id, double gpa, int creditHours){
		setName(name);
		setId(id);
		this.gpa = gpa;
		this.creditHours = creditHours;
	}
	
	public Student() {
		super();
	}
	public double getGpa() {
		return gpa;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	@Override
	public void printCheck () {
		double total = 52 + 236.45 * getCreditHours();
		
		if (getGpa() >= 3.85) {
			total = total - (total * 25) / 100;
		}
		System.out.println("Here is the tuition invoice for " + getName());
		System.out.println("\n-------------------------------------------------------------------------------------\n");
		System.out.println(getName()+"\t"+getId()+"\nCredit Hours: " + getCreditHours()+ "($236.46/credit hour)");
		System.out.println("Fees: $52");
		System.out.println("\nTotal payment (after discount): $" + String.format("%,3f", total));
		System.out.println("\n-------------------------------------------------------------------------------------\n");
	}
}
//-------------------------------------------------------------------------------------------------------------------
	abstract class Employee extends Person{
		private String department;
		
		public Employee(String name, String id, String department) {
			super(name, id);
			this.department = department;
		}
		
		public Employee() {
			super();
		}
		public String getdepartment() {
			return department;
		}
		
		public void setdepartment(String newdepartment) {
			this.department = newdepartment;
		}
		@Override
		public void printCheck () {
			System.out.println(getName() + "\t" +getId());
		}
	}
//---------------------------------------------------------------------------------------------------------------------------
	class Faculty extends Employee{ 
	    	private String rank;
	    	
	    	public Faculty(String name, String id, String department, String rank) {
	    		super(name, id, department);
	    		this.rank = rank;
	    	}
	    	public Faculty() {
	    		super();
	    	}
	    	public String getRank() {
	    		return rank;
	    	}
	    	public void setRank(String rank) {
	    		this.rank = rank;
	    	}
	    @Override
	    public void printCheck () {
	    	System.out.println("\n-------------------------------------------------------------------------------------\n");
	    	super.printCheck();
	    	System.out.println(getdepartment()+" Department, "+getRank());
	    	System.out.println("\n-------------------------------------------------------------------------------------\n");
	    }
	} 
//------------------------------------------------------------------------------------------------------------------------------
	class Staff extends Employee{ 
    	private String status;
    	
    	public Staff(String name, String id, String department, String status) {
    		super(name, id, department);
    		this.status = status.toLowerCase();
    	}
    	public Staff() {
    		super();
    	}
    	public String getStatus() {
    		return status;
    	}
    	public void setStatus(String rank) {
    		this.status = rank;
    	}
    @Override
    public void printCheck () {
    	System.out.println("\n-------------------------------------------------------------------------------------\n");
    	super.printCheck();
    	System.out.println(getdepartment()+" Department, "+getStatus());
    	System.out.println("\n-------------------------------------------------------------------------------------\n");
    }
	} 
