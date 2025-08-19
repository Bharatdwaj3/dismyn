package References.Greedy_Algos;

import java.util.Scanner;
import java.util.Array;
import java.util.Arrays;

public class Tyn {
    static class Item{
        int value, weight;
        Item(int value, int weight){
            this.value=value;
            this.weight=weight;
        }
    }
    static void sortItemByratio(Item[] arr){
        Arrays.sort(arr, (a, b)->{
            double r1=(double)a.value/a.weight;
            double r2=(double)b.value/b.weight;
            return Double.compare(r2,r1);
        });
    }
    static double fractionalKnapsack(int capacity, Item[]arr){
        sortItemByratio(arr);
        int currentWeight=0;
        double finalValue=0.0;
        for(Item item:arr){
            if(currentWeight+item.weight<=capacity){
                currentWeight+=item.weight;
                finalValue+=item.value;
            }else{
                int remain=capacity-currentWeight;
                finalValue+=((double)item.value/item.weight)*remain;
                break;
            }
        }
        return finalValue;
    }
    public static void main(String[] args){
        System.out.print("Enter the number of items: ");
        int n=sc.nextInt();
        System.out.println("Enter knapsack capacity: ");
    }
}
