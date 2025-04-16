import java.util.*;


public class Dsa01 {
    public static void main (String [] arg){
        
        // display();
        // gradeSystem(64);
        loop(2);
    }

    //use case of input and output in java with the help of Scanner class(input) and System class(output)
    static void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int x = sc.nextInt();
        System.out.println("the input number: "+x);
        sc.close();
    }

    // use case of if elseif and else block
    static void gradeSystem(int marks){
        if(marks >=90){
            System.out.println("grade A");
        } 
        else if(marks<=80 && marks >= 70) {
            System.out.println("grade B");
        }
        else if(marks <= 70 && marks >= 50){
            System.out.println("grade C");
        }
        else if(marks <= 50 && marks >= 35){
            System.out.println("grade D");
        }
        else System.out.println("failed");
    }

    static void loop(int n){
        for (int index = 1; index <= 10; index++) {
            int result = n*index;
            System.out.println(n+ "x "+index+ " = "+result);
        }

        //using of while loop 
        int [] arr = {2,4,6,8,10};
        int i = 0;
        while (i < arr.length){
            System.out.println("the element of array: "+arr[i]);
            i++;
        }
    } 

}