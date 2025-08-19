import java.util.Arrays;

public class mo {
    public static int foo(int[] greed, int[] cookieSize){
        int n = greed.length;
        int m = cookieSize.length;
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l=0;
        int r=0;
        while(l<m && r < n){
            if(greed[r] <= cookieSize[l]){
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args){
        int[] greed={1,5,3,3,4};
        int[] cookieSize={4,2,1,2,1,3};
        System.out.println("Array Representing Greed: ");
        for(int i=0;i<greed.length;i++){
            System.out.println(greed[i]+" ");
        }        
        System.out.println();

        System.out.println("Array Representing Cookie Size: ");
        for(int i=0;i<greed.length;i++){
            System.out.println(greed[i]+ " ");
        }
        System.out.println();

        int ans=foo(greed, cookieSize);

        System.out.println();
        System.out.println("No of assigned cookies: "+ans);
        System.out.println();
    }
}
