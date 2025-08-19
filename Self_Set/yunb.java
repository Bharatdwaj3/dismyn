public class yunb {
    static int[] tree;
    static int[] nums;
    static int n;

    static void build(int srt, int end, int idx){
        if(srt==end){
            tree[idx]=nums[srt];
        }
    }
}
