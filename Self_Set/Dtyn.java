import java.util.*;
class SumSequence{
    static void subsetSumsHelper(int idx, int sum, Array<List>, arr, ){
        if(idx==N){
            subset.add(sum);
            return;
        }
        subsetSumHelper(idx+1, sum+arr.get(idx),arr, N, sumSubset);
        subsetSumHelper(idx+1, sum, arr, N, sumSubset);
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer>arr, int N){
    ArrayList<Integer> sumSubset=new ArrayList<>();
    subsetSumHelper(0, 0, arr, N, sumSubset);
    Collections.sort(sumSubset);
    return sumSubset;
}
    public static void main(String args[]){
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is : ");
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+ " ");
        }
    }

}

