package task5;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        StudentManagementSystem studentManagementSystem=new StudentManagementSystem();
        String fileName="students.txt";

        try {
            studentManagementSystem.loadFromFile(fileName);
        }catch (Exception e)
        {
            System.out.println("Data not found. Starting fresh.");
        }

        while(true){
            System.out.println("\n ----Student Management System----");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display all Students");
            System.out.println("5. Save & Exit");
            System.out.println("Choose an option:");
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    //add student
                    System.out.println("Enter student name:");
                    String name= scanner.nextLine();

                    int rollNumber;
                    while(true){
                        System.out.println("Enter Roll Number: ");
                        if(scanner.hasNextInt()){
                            rollNumber=scanner.nextInt();
                            scanner.nextLine();
                            break;
                        }
                        else{
                            System.out.println("Invalid roll number. Please try again.");
                            scanner.next();//clear invalid input
                        }
                    }
                    System.out.println("Enter grade: ");
                    String grade=scanner.nextLine();

                    studentManagementSystem.addStudent(new Student(name, rollNumber, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    //remove student
                    System.out.println("Enter roll number of student to remove");
                    rollNumber=scanner.nextInt();
                    scanner.nextLine();

                    studentManagementSystem.removeStudent(rollNumber);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    //search student
                    System.out.println("Enter roll number to search: ");
                    rollNumber=scanner.nextInt();
                    scanner.nextLine();

                    Student student=studentManagementSystem.searchStudent(rollNumber);
                    if(student!=null){
                        System.out.println("Student found: "+student);
                    }else{
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    //display all students
                    studentManagementSystem.displayAllStudents();
                    break;

                case 5:
                    //save and exit
                    try{
                        studentManagementSystem.saveToFile(fileName);
                        System.out.println("Data saved successfully.");
                    }catch (IOException e){
                        System.out.println("Error saving data: "+ e.getMessage());
                    }
                    System.out.println("exiting..");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }}
        }
    }

