import java.util.*;

public class Tyn {
    static void buildTree(int[]a, int[]tree, int srt, int end,int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        buildTree(a, tree, srt, mid, 2*idx);
        buildTree(a, tree, mid+1, end, 2*idx+1);
        tree[idx]=tree[2*idx]+tree[2*idx+1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=1;i<2*n;i++){
            System.out.println(tree[i]+" ");
        }
        sc.close();
    }
}
