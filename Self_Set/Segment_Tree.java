class Soda{
    public Soda(){
        int[] a={1,2,3,4,5,6,7,8,9};
        int n=a.length;
        int[] tree= new int[2*n];
        buildTree(a, tree, 0, n-1, 1);
        for(int i=1;i<2*n;i++){
            System.out.println(tree[i]+" ");
        }
    }
    void buildTree(int[] a, int[] tree, int srt, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        buildTree(a, tree, srt, mid, 2*idx);
        buildTree(a, tree, mid+1, end, 2*idx+1);
        tree[idx]=tree[2*idx]+tree[2*idx+1];
    }
}

public class Segment_Tree {
    public static void main(String[] args){
        new Soda();
    }
}
