import java.util.*;

public class Dermac {

    static Map<Integer, Integer> digitSumToIndex=new HashMap<>();
    static int didgitSum(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            sum/=10;
        }
        return sum;
    }

    static void buildTree(int[], arr, int[] tree, int srt, int end, int node){
        if(srt==end){
            tree[node]=digitSum(arr[srt]);
            digitSumToIndex.put(tree[node],srt);
            return;
        }
        int mid=(srt+end)/2;
        buildTree(arr, tree, srt, mid, 2*node);
        buildTree(arr, tree, mid+1, end, 2*node+1);
        tree[node]=
    }

    public static void main(String[] args){

    }
}
