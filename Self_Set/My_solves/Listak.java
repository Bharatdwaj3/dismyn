package My_solves;

public class Listak {
    static int[] parent;
   
    public static int find(int x){
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(px!=py)
        parent[px]=py;
    }

    public static int countComponents(int n , int[][] edges){
        parent=new int[n];
        for(int i=0;)
    }
    
}
