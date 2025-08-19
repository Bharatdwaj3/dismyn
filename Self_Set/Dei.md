# Mon

```java
   class NumArray{
        int[] tree;
        int n;
        public NumArray(int [] nums){
            n=nums.length;
            tree=new int[int*n];
            build(nums, 0, n-1, 1);
        }
        private void build(int [], int srt, int end, int end, int idx){
            if(srt==end){
                tree[idx]=a[srt];
                return;
            }
            int mid=(std+end)/2;
            build(a, srt, mid, 2*idx);
            build(a, mid+1, end, 2*idx+1);
            tree[idx]=tree[2*idx]+tree[2*idx+1];
        }
        public int sumRange(int left, right){
            return query(0, n-1, left, right);
        }
        private int query(int srt, int end, int idx, int l , int r){
            if(end<l||srt>r){
                return 0;
            }
            if(srt>=1 && end<=r){
                return tree[idx];
            }

            int mid=(start+end)/2;
            int leftSum=query(srt, mid, 2*idx, l, r);
            int rightSum=query(mid+1, end, 2*inx, l, r);
            return leftSum+rightSum;
        }
   } 
```
```java
    class numArray{
        int[] tree;
        int n;
        public NumArray
    }
```