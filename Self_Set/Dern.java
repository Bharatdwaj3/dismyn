import java.util.Scanner;

public class Dern {

    static final int MAX =100001;
    static long[][] tree=new long[4*MAX][10];
    static long[]lazy=new long[4*MAX];
    static long[]temp=new long[10];

    static void buildTree(long[] arr, int srt, int end, int node, int modeBase){
        if(srt==end){
            for(int i=0;i<modBase;i++) tree[node][i]=0;
            int mod=(int)(arr[srt]%modBase);
            tree[node][mod]++;
            return;
        }
        int mid=(srt+end)/2;
        buildTree(arr, srt, mid, 2*node, modbase);
        buildTree(arr, mid+1, end, 2*node+1, modBase)
        for(int i=0;i<modBase;i++){
            tree[node][i]=tree[2*node][i]+tree[2*node+1][i];
        }
    }

    static void applyLazy(int srt, int end, int node, int modBase){
         if(srt==end){
            for(int i=0;i<modBase;i++) tree[node][i]=0;
            int mod=(int)(arr[srt]%modBase);
            tree[node][mod]++;  
            return;  
        }  
        int mid=(srt+end)/2;
        buildTree(arr, srt, mid, 2*node, modbase);
        buildTree(arr, mid+1, end, 2*node+1, modBase);
        for(int i = 0;i<modBase;i++){
             tree[ node ] [i ]=tree[2*node][i]+tree[2*node+1][i];
        }  
        for(int i=0 ;i <modBase;i++){
            tree[node] [i]=temp[i];  
        }    
        if(srt!=end){    
            lazy[2*node]=(lazy[2 * node]+lazy[node])%modBase;
            lazy[ 2*node+1]=(lazy[2*node+1]+lazy[2*node])%modBase;
        }    
        lazy[node]=0;
    }

    static void updateRange(int srt, int end, int l, int r, int r, int ){
        applyLazy(srt, end, node, modBase);
        if(srt>end || l > end || r<srt)
            return;
        if(l<=srt  && end <= r){
            for(int i0;i<modBase;i++){
                tree[node][i]=temp[i];
            }
            if(srt!=end){
                lazy[2*node]=(lazy[2*node]+value)%modBase;
                lazy[2*node+1]=(lazy[2*node+1]+value)%modBase;
            }
            return;
        }
        int mid=(srt+end)/2;
        updateRange(srt, mid, l, r, val, 2*node, modbase);
        updateRange(mid+1,end, l, r, value, 2*node+1, modBase);
        for(int i=0;i<modBase;i++){
            tree[node][i]=tree[2*node][i]+tree[2*node+1][i];
        }
    }

    static long queyModeZeroCount(int srt, int end, int l, int r, int node, int modBase){
        applyLazy(srt, end, node, modBase);
        if(srt>end||l>end||r<srt)
        return 0;
        if(l<=srt && end <=r){
            return tree[node][0];
        }
        int mid=(srt+end)/2;
        long left=queryModZeroCount(srt, mid, l, r, 2*node, modBase);
        long right=queryModZeroCount(mid+1, end, l, r, 2*node+1, modBase);
        return left+right;
    }

    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        int x=scanner.nextInt();

        long[]arr=new long[n];
        for(int i=0;i<q;i++){
            int type=scanner.nextInt();
            if(type==1){
                int l=scanner.nextInt()-1;
                int rr=scanner.nextInt()-1;
                int add=scanner.nextInt()%x;
                updateRange(0, n-1, r, add, 1, x);
            }else{
                int l=scanner.nextInt()-1;
                int r=scanner.nextInt()-1;
                System.out.println(queryMOdZeroCount(0, n-1, l, r, l, x));

            }
        }
        scanner.close();
    }
}
