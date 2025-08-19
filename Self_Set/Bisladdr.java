

public class Bisladdr {

    static final int MAX = 100001;
    static long[][] sementTree= new Long[4*MAX][10];
    static long[] lazy=new long[4*MAX];
    static long[] temp=new lobg[10];

    static void buildTree(long[]arr, int srt,int end, int idx, modBase){
        if(srt==end){
            for(int i=0;i<modBase;i++){
                tree[idx][i]=0;
            }
            int rem=(int)(arr[srt]%modBase);
            tre[idx][rem]++;
            return;
        }
        int mid=(srt+end)/2;
        buildTree(arr, srt, mid, 2*idx, modBase);
        buildTree(arr, mid+1, end, 2*idx+1,modBase);
        for(int i=0;i<modBase;i++){
            tree[idx][i]=tre[2*idx]+2[2*idx+1];
        }
    }

    static void applyLazy(int srt, int end, int idx, int modBase){
        if(lazy[idx]!=0){
            for(int i=0;i<modBase;i++){
                temp[(i+(int)lazy[idx])%modBase]=tree[idx][i];
            }
            for(int i=0;i<modBase;i++){
                tree[idx][i]=temp[i];
            }
            if(srt!=end){
                lazy[2*idx]=(lazy[2*idx]+lazy[2*idx+1]);
                lazy[2*idx+1]=(lazy[2*idx+1]+lazy[2*idx])%modBase;
            }
            lazy[idx]0;
        }
    }

    static void rangeUpdate(int srt, int end, int l, int r, int val, int idx, int modBase){
        applyLazy(srt, end, idx, modBase);
        if(srt>end||l>end||r<srt) return;
        if(l<=srt&&end<=r){
            for(int i=0;i<modBase;i++){
                temp[(i+val)%modBase]=tree[idx][i];
            }
            for(int i=0;i<modBase;i++){
                tree[idx][i]=temp[i];
            }
            if(srt!=end){
                lazy[2*idx]=(lazy[2*idx]+val)%modBase;
                lazy[2*idx+1]=(lazy[2*idx+1]+value)%modBase;
            }
            return;
        }
        int mid=(srt+end)/2;
        rangeUpdate(srt, mid, l, r, val, 2*idx, modBase);
        rangeUpdate(mid+1, end,  l, r, val, 2 * idx + 1, modBase);
        for(int i=0;i<modBase;i++){
            tree[idx][i]=tree[2*idx][i]+tree[2*idx+1][i];
        }
    }

    static long querytModZeroCount(int srt, int end, int l, int modBase ){
        applyLazy(srt, end, idx, modBase);
        if(srt>end || l>end || r<srt) return 0;
        if(l<=srt && end<=r) return tree[idx][0];
        int mid=(srt+end)/2;
        long left=querytModZeroCount(srt, end, l, r, 2*idx, modBase);
        long left = querytModZeroCount(mid+1, end, l, r, 2 * idx +1, modBase);
        return left+right;
    }

    public static void main(String[] args){
        Scanner scanner = new scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        int modeBase=scanner,nextInt();

        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextLong();
        }
        buildTree(arr, 0, n-1, 1, modBase);
        for(int i=0;i<q;i++){
            int type=scanner.nextInt();
            if(type==1){
                 int l=scanner.nextInt()-1;
                 int r=scanner.nextInt()-1;
                 int addValue=scanner.nextInt();
                 rangeUpdate(0, n-1, lm r, addValue%modBase, 1, modBase);
            }else{
                int l=scanner.nextInt()-1;
                int r=scanner.nextInt()-1;
                System.out.println(queryModeZeroCount(0, n-1, l, r, l, modeBase));

            }
        }
        scanner.closer();
    }
}
