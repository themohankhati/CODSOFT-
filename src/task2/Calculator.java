package task2;

import java.util.Scanner;

public class Calculator {
    public static void main (String [] args )
    {
        //scanner object
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects.");
        int numOfSubjects=sc.nextInt();

        //Array to store marks for each subject
        double []marks=new double[numOfSubjects];

        for(int i=0; i<numOfSubjects; i++)
        {
            System.out.println("Enter the marks");
            marks[i] =sc.nextDouble();
        }

        //total marks
        double totalMarks=0;
        for(double mark:marks)
        {
            totalMarks+=mark;
        }

        //average percentage
        Double avgPercentage=totalMarks/numOfSubjects;

        //grade calcualtion
        calcGrade(avgPercentage);

        System.out.println("Total Marks:" + totalMarks);
        System.out.println("Average Percentage:"+ avgPercentage+ "%");
        System.out.println("Grade:"+ calcGrade(avgPercentage));

    }

    public static String calcGrade(double avgPercentage)
    {
        if (avgPercentage>=90)
        {
            return "A+";
        }

        else if(avgPercentage>=80)
        {
            return "A";
        }
        else if(avgPercentage>=70)
        {
            return "B+";
        }
        else if(avgPercentage>=60)
        {
            return "B";
        }
        else if(avgPercentage>=50)
        {
            return "C";
        }
        else if(avgPercentage>=40)
        {
            return "D";
        }
        else {
            return "F";
        }

    }

}
