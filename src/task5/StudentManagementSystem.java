package task5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        try(ObjectInputStream out=new ObjectInputStream(new FileInputStream(fileName))){
            out.writeobject(students);
        }
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName))){
            students =(ArrayList<Student>) in.readObject();
        }
    }
}
