package References.Greedy_Algos;

import java.util.*;

public class ADen {
    public static void main(String[] args){
        int[] coins={1,2,5,10,20,50,100,500,1000};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the anount: ");
        int V = scanner.nextInt();

        java.util.List<Integer> ans= new java.util.ArrayList<>();
        for(int i=coins.length-1;i>=0;i--){
            while(V>=coins[i]){
                V-=coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println("The Minimun number of coins is : "+ans.size()   );
        System.out.println("The coins are: ");
        for(int coin: ans){
            System.out.println(coin+ " ");
        }
        System.out.println();
        scanner.close();
    }
}
