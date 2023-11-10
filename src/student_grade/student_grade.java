package student_grade;
import java.util.*;
public class student_grade {
    public static void main(String[] args) {
        //Student Grade Calculator
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Physics Marks: ");
        int pmarks = scan.nextInt();
        System.out.println("Enter Chemistry Marks: ");
        int cmarks = scan.nextInt();
        System.out.println("Enter Computer Science Marks: ");
        int compmarks = scan.nextInt();
        int total = (pmarks+cmarks+compmarks);
        int avg = (total)/3;
        char grade;
        switch(avg/10){
            case 10: grade = 'O'; break;
            case 9: grade = 'A';break;
            case 8: grade = 'B';break;
            case 7: grade = 'C';break;
            case 6: grade = 'D'; break;
            case 5: grade = 'E'; break;
            default: grade = 'F'; break;
        }
        System.out.println("The total marks of the student is: "+ total);
        System.out.println("The average percentage of the student is: "+avg);
        System.out.println("The grade of the student is: "+grade);
    }
}