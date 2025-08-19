import java.util.*;

public class Tybnhhji {
    static int[] tree, nums;
    static int n;
    static void build(int srt, int end, int idx){
        if(srt==end){
            tree[idx]=nums[srt];
            return;
        } 
        int mid=(srt+end)/2;
        build(srt, mid, 2*idx);
        build(mid+1, end, 2*idx+1);
        tree[idx]=Math.min(tree[2*idx], tree[2*idx+1]);
    }
    static void update(int srt, int end, int idx, int pos, int val){
        if(srt==end){
            tree[idx]=val;
            return;
        }
        int mid=(srt+end)/2;
        if(pos<=mid){
            update(srt, mid, 2*idx, pos, val);
        }else{
            update(mid+1,end, 2*idx+1, pos,val);
        }
        tree[idx]=Math.min(tree[2*idx],tree[2*idx+1]);
    }
    static int minQuery(int srt, int end, int idx, int l, int r){
        
    }
}
