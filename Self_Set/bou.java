import java.util.Arrays;

public class bou {
    int foo(int[] greed, int[]  cookieSize){
        int n=greed.length;
        int m=cookieSize.length;
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l=0;
        int r=0;
        while(l<m&& r<n){
            if(greed[r] <= cookieSize[l]){
                r++;
            }
            l++;
        }
        return r;
    }   
    public static void main(String[] args){
        int[] greed={1,3,5,7,9,11};
        int[] cookieSize={4,2,1,2,1,3};

        System.out.println("Array representing Greed: ");
        for(int i=0;i<greed.length;i++){
            System.out.println(greed[i]+" ");
        }
        System.out.println();
        System.out.println("Array representing Cookie Size: ");
        for (int i = 0; i < cookieSize.length; i++) {
            System.out.println(cookieSize[i] + " ");
        }
        System.out.println();
    }
}
