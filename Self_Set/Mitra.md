


```java
class Soda{
    
        int[] a={1,2,3,4,5,6,7,8,9};
        int n=a.length;
        int[] tree = new int[4*n];
        int[] lazy = new int[4*n];
    
    public Soda(){
        
        buildTree(a, n-1, 1);
        System.out.println("Initial Segment Tree: ");
        printTree();
        updateRange(0, n-1, 1, 2, 5, 5);
        System.out.println("\nAfter updateRange(2, 5, +5): ");
        printTree();

        int sum=queryRange(0, n-1, 1, 2, 5);
        System.out.println("\nSum of Range 2 to 5: "+sum); 
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
    void updateTree(int srt, int end, int idx, int l, int r, int val){
       if(lazy[idx]!=0){
            tree[idx]+=(end-srt+1)*lazy[idx];
            if(srt!=end){
                lazy[2*idx]+=lazy[idx];
                lazy[2*idx+1]+=lazy[idx];
            }
            lazy[idx]=0;
       }
       if(srt>r||end<1){
            return;
       }
       if(srt>=1&&end<=r){
            tree[idx]+=(end-srt+1)*val;
            if(srt!=end){
                lazy[2*idx]+=val;
                lazy[2*idx+1]+=val;
            }
            return;
       }
       int mid=(srt+end)/2;
       updateRange(srt, mid, 2*idx, l,r, val);
       updateRange(mid+1, end, 2*idx+1, l, r, val);
       tree[idx]=tree[2*idx]+tree[2*idx+1];
    }

    void queryrange(int srt, int end, int idx, int l, int r, int val){
       if(lazy[idx]!=0){
            tree[idx]+=(end-srt+1)*lazy[idx];
            if(srt!=end){
                lazy[2*idx]+=lazy[idx];
                lazy[2*idx+1]+=lazy[idx];
            }
            lazy[idx]=0;
       }
       if(srt>r||end<1){
            return 0;
       }
       if(srt>=1||end<=r){
            return tree[idx];
       }
       
       int mid=(srt+end)/2;
       int left = queryRange(srt, mid, 2 * idx, l, r);
       int right = queryRange(mid+1, end, 2 * idx + 1, l, r);
       return left + right;
    }

    void printTree(){
        for(int i=1;i<2*n;i++){
            System.out.println(tree[i]+ " ");
        }
        System.out.println();
    }
}

public class Segment_Tree {
    public static void main(String[] args){
        new Soda();
    }
}



```