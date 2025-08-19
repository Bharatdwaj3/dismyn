# Modire

---
name: RudraFak
status: running

---

---

```java
class NumArray{
    int[] tree;
    int n;
    public NumArray[int[] nums]{
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=tree[2*idx]+tree[2*idx+1];
    }

    public int sumRange(int left, int right){
        return query(0, n-1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return 0;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return leftSum+rightSum;
    }
}


```

```java
class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=Math.min(tree[2*idx]+tree[2*idx+1]);
    }

    public int sumRange(int left, int right){
        return query(0, n-1,1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return INTEGER.MAX_VALUE;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return Math.min(leftSum+rightSum);
    }
}

```

```java
class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=Math.max(tree[2*idx]+tree[2*idx+1]);
    }

    public int sumRange(int left, int right){
        return query(0, n-1,1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return INTEGER.MAX_VALUE;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return Math.max(leftSum+rightSum);
    }
}
```

```java
class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=Math.max(tree[2*idx]+tree[2*idx+1]);
    }

    public int sumRange(int left, int right){
        return query(0, n-1,1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return INTEGER.MAX_VALUE;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return Math.max(leftSum+rightSum);
    }
}
```

```java
    
class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=Math.max(tree[2*idx]+tree[2*idx+1]);
    }

    public int sumRange(int left, int right){
        return query(0, n-1,1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return INTEGER.MAX_VALUE;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return Math.max(leftSum+rightSum);
    }
}
```

```java
    
class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        tree=new int[4*n];
        build(nums, 0, n-1, 1);
    }
    private void build(int[] a, int start, int end, int idx){
        if(srt==end){
            tree[idx]=a[srt];
            return;
        }
        int mid=(srt+end)/2;
        build(a, srt, mid, 2*idx);
        build(a, mid+1, end, 2*idx+1);
        tree[idx]=tree[2*idx]^tree[2*idx+1];
    }

    public int sumRange(int left, int right){
        return query(0, n-1,1, left, right);
    }
    private int query(int srt, int end, int idx, int l, int r){
        if(end<l || srt>r)
            return INTEGER.MAX_VALUE;
        if(str>=l && end<=r)
            return tree[idx];

        int mid=(start+end)/2;
        int leftSum=query(srt, mid, 2*idx, l, r);
        int rightSum=query(mid+1,end, 2*idx+1, l, r);
        return leftSum^rightSum;
    }
}
```
