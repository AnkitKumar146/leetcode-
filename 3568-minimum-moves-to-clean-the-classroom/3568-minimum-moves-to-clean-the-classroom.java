class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sr = 0, sc = 0, k = 0;

        int[][] id = new int[m][n];

        for(int[] row : id)
            Arrays.fill(row, -1);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(classroom[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                }

                if(classroom[i].charAt(j) == 'L')
                    id[i][j] = k++;
            }
        }

        int full = (1 << k) - 1;

        if(full == 0)
            return 0;

        int[][][] best = new int[m][n][1 << k];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                Arrays.fill(best[i][j], -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, energy, 0, 0});
        best[sr][sc][0] = energy;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            if(mask == full)
                return moves;

            if(e == 0)
                continue;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if(classroom[nr].charAt(nc) == 'X')
                    continue;

                int ne = e - 1;
                int nm = mask;

                if(id[nr][nc] != -1)
                    nm |= 1 << id[nr][nc];

                if(classroom[nr].charAt(nc) == 'R')
                    ne = energy;

                if(ne > best[nr][nc][nm]){
                    best[nr][nc][nm] = ne;
                    q.offer(new int[]{nr, nc, ne, nm, moves + 1});
                }
            }
        }

        return -1;
    }
}