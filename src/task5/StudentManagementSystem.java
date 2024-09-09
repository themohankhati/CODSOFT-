package task5;

import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem(){
        this.students=new ArrayList<>();
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void removeStudent(int rollNumber)
    {
        students.removeIf(student -> student.getRollNumber()==rollNumber);
    }

    public Student searchStudent(int rollNumber){
        for(Student student:students){
            if(student.getRollNumber()==rollNumber){
                return student;
            }
        }

        return null;
    }
    public void displayAllStudents(){
        if(students.isEmpty())
        {
            System.out.println("No students found");
        }else{
            for(Student student:students){
                System.out.println(student);
            }
        }
    }

    public void saveToFile(String fileName) throws IOException{
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(students);
        }
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName))){
            students =(ArrayList<Student>) in.readObject();
        }
    }
}
