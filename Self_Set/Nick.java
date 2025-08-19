import java.util.ArrayList;

class Cmbtn_1{
    private void findCombinations(int idx, int[] arr, int targt, List<List<Integer>> ans, List<Integer> ds){
        if(idx=arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx]<=target){
            ds.add(arr[idx]);
            findCombinations(idx, arr, targt, ans, ds);
        }
    }
    public List<List<Integer>>combinationSum(int[], candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans= new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}


public class Nick {
    public static void main(String[] args){
        int arr[]= {2,3,6,7};
        int target=7;
        Solution sol =new Solution();
        List<List<Integer>> ls = sol.combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for(int i=0;i<ls.size;i++){
            for(int j=0;j<ls.get(i).size();j++){
                System.out.println(ls.get(j)+" ");
            }
            System.out.println();
        }
    }
}
