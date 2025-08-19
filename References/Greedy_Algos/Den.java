package References.Greedy_Algos;
import java.util.*;
public class Den {

    public static int findContentChildren(int[] greed, int[] cookieSize){
        int n=greed.length;
        int m=cookieSize.length;
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l=0,r=0;
        while(l<m&&r<n){
            if(greed[r]<=cookieSize[l]){
                r++;
            }
            l++;
        }
        return r;
    }
    public static void main(String[] args){
        int[] greed={1,5,3,3,4};
        int[] cookieSize={4,2,1,2,1,3};

        System.out.println("Array Representating Greed: ");
        for(int i=0;i<greed.length;i++){
            System.out.println(greed[i]+"");
        }
        System.out.println();
        System.out.println("Array Representing Cookie Size: ");
        for(int i=0;i<cookieSize.length;i++){
            System.out.println(cookieSize[i]+" ");
        }
        int ans=findContentChildren(greed, cookieSize);
        System.out.println();
        System.out.println("No of kids assigned cookies: "+ans);
        System.out.println();
    }
}
