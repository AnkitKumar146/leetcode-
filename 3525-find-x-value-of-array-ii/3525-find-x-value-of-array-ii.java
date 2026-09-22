class Solution {
    static class Node {
        int prod;
        long[] cnt;

        Node(int k) {
            cnt = new long[k];
        }
    }

    int k;
    Node[] tree;

    Node merge(Node a, Node b) {
        Node c = new Node(k);
        c.prod = a.prod * b.prod % k;

        for(int i = 0; i < k; i++)
            c.cnt[i] += a.cnt[i];

        for(int i = 0; i < k; i++){
            int r = a.prod * i % k;
            c.cnt[r] += b.cnt[i];
        }

        return c;
    }

    void build(int node, int l, int r, int[] nums) {
        if(l == r){
            tree[node] = new Node(k);
            tree[node].prod = nums[l] % k;
            tree[node].cnt[tree[node].prod] = 1;
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int pos, int val) {
        if(l == r){
            tree[node] = new Node(k);
            tree[node].prod = val % k;
            tree[node].cnt[tree[node].prod] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if(pos <= mid)
            update(node * 2, l, mid, pos, val);
        else
            update(node * 2 + 1, mid + 1, r, pos, val);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int start) {
        if(r < start)
            return null;

        if(l >= start)
            return tree[node];

        int mid = (l + r) / 2;

        Node a = query(node * 2, l, mid, start);
        Node b = query(node * 2 + 1, mid + 1, r, start);

        if(a == null) return b;
        if(b == null) return a;

        return merge(a, b);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start);
            ans[i] = (int)res.cnt[x];
        }

        return ans;
    }
}