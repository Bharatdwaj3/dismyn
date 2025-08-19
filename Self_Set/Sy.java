import java.util.*;

class Bois{
    static void foo(int idx, int[] arr, int target, List<List<Integer>>ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx&&arr[i]==arr[i-1])
                continue;
            if(arr[i]>target)
                break;
            ds.add(arr[i]);
            foo(i+1, arr, target-arr[i], ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}

public class Sy {
    int arr[]={10,1,2,7,6,1,5};
    List<List<Integer>> comb=cmbtn2(arr,8);
    System.out.println(comb.toString().toreplace(",",""));
}
