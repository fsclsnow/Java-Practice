package src;
import java.util.*;

public class ArrayDemo {
    public static double[] inputScore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give the size of the array:");
        int size = sc.nextInt();
        //String ll = sc.nextLine();
        double[] score = new double[size];
        for (int i = 1; i<size+1; i++){
            System.out.println("Please give the data of element " + i);
            score[i-1]=sc.nextDouble();
        }
        return score;
    }

    public static void printScore(double[] score){
        for (double d: score){
            System.out.print(d + " ");
        }
    }

    public static double findAverage (double[] score){
        double sum = 0;
        for (double d: score){
            sum += d;
        }
        return sum/score.length;
    }

    public static double findHighest(double[] score){
        double high = score[0];
        for (double d: score){
            if (d > high){
                high = d;
            }
        }
        return high;
    }

    public static double findLowest(double[] score){
        double low = score[0];
        for (double d: score){
            if (d < low) {
                low = d;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        double[] score = inputScore();
        printScore(score);
        double average = findAverage(score);
        double highest = findHighest(score);
        double lowest = findLowest(score);
        System.out.println("The average is: " + average + "; highest is: " + highest + "; lowest is: " + lowest);
    }
}

