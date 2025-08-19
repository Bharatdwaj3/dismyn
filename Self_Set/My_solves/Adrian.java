package My_solves;

public class Adrian {
    int[] parent;
    int[] rank;

    public Adrian(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        parent[i]=i;
    }

    public int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
            return parent[x];
    }

    public void union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(px!=py){
            if(rank[px]<rank[py]){
                parent[px]=py;
            }else if(rank[py]<rank[px]){
                parent[py]=px;
            }else{
                parent[py]=px;
                rank[px]++;
            }
        }
    }

    public static void main(String[] args){
        Adrian adrian=new Adrian(5);
        adrian.union(0,2);
        adrian.union(4, 2);
        adrian.union(3,1);

        System.out.println("Find(4): " + adrian.find(4));
        System.out.println("Find(4): " + adrian.find(3));
    }

}
