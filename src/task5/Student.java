package task5;

public class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade)
    {
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
    }

    public String getName(){
    return name;}

    public int getRollNumber()
    {
        return rollNumber;
    }

    public String getGrade(){
        return grade;
    }

    public void setName(){
        this.name=name;
    }

    public void setRollNumber(){
        this.rollNumber=rollNumber;
    }

    public void setGrade(){
        this.grade=grade;


    }

    public String toString(){
        return "Student{"+ "Name="+ name+ '\''+", Roll Number="+ rollNumber+",Grade='"+grade+'\''+'}';
    }
}


