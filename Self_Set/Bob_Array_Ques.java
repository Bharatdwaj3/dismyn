import java.util.Scanner;

public class Bob_Array_Ques {
    static final int MAX=500005;
    static int[] arr=new int[MAX];
    static int[] tree=new int[4*MAX];

    public static void buildTree(int srt, int end, int idx){
        if(srt==end){
            tree[idx]=arr[srt];
            return;
        }
        int mid=(srt+end)/2;
        buildTree(srt, mid, 2*idx);
        buildTree(mid+1,end,2*idx+1);
        tree[idx]=tree[2*idx]+tree[2*idx+1];
    }

    public static void incValue(int srt, int end, int pos, int idx){
        if(srt==end){
            val[pos]++;
            tree[idx]++;
        }else{
            int mid=(srt+end)/2;
            if(pos<=mid){
                incVal(srt, mid, pos,2*idx);
            }else{
                inVal(mid+1, end, pos,2*idx+1);
            }
            tree[idx]=tree[2*idx]+tree[2*idx+1];
        }
    }

    public static void decVal(int srt, int end, int pos, int idx){
        if(srt==end){
            if(val[pos]>0){
                val[pos]--;
                tree[idx]--;
            }
        }else{
            int mid=(srt+end)/2;
            if(pos<=mid){
                decVal(srt, mid, pos, 2*idx);
            }else{
                decVal(mid+1, end, pos, 2*idx+1);
            }
            tree[idx]=tree[2*idx]+tree[2*idx+1];
        }
    }

    public static int rangeSumQuery(int srt, int end, int qSrt, int qEnd, int idx ){
        if(qEnd<srt||qSrt>end){
            return 0;
        }
        if(qSrt<=srt&&end<=qEnd){
            return tree[idx];
        }
        int mid=(srt+end)/2;
        int lSum=rangeSumQuery(srt, end, qSrt, qEnd, 2*idx);
        int rSum=rangeSumQuery(mid+1, end, qSrt, qEnd, 2*idx+1);
        return lSum+rSum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size=scanner.nextInt();
        int queryCount=scanner.nextInt();

        for(int i=0;i<size;i++){
            values[i]=0;
        }

        buildTree(1, size, 1);
        while(queryCount-- > 0){
            int type=scanner.nextInt();
            if(type==1){
                int idx=scanner.nextInt();
                if(type==1){
                    int idxa=scanner.nextInt();
                    incValue(1, size, idxa, 1);
                }else if(type==2){
                    int idxb=scanner.nextInt();
                    decVal(1, size, idxb, 1);
                }else if(type==3){
                    int left=scanner.nextInt();
                    decVal(1, size, idx, 1);
                }else if(type==3){
                    int left=scanner.nextInt();
                    int right=scanner.nextInt();
                    System.out.println(rangeSumQuery(1, size, left, left, 1));
                }
            }
            scanner.close();
        }
    }

}