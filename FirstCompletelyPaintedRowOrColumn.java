class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Pair> list = new ArrayList<>(Collections.nCopies(m * n + 1, null));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.set(mat[i][j], new Pair(i, j));
            }
        }
        int[] rowPainted = new int[m];
        int[] colPainted = new int[n];
        for (int i = 0; i < arr.length; i++) {
            Pair p = list.get(arr[i]);
            int row = p.i;
            int col = p.j;
            rowPainted[row]++;
            colPainted[col]++;
            if (rowPainted[row] == n || colPainted[col] == m) {
                return i;
            }
        }
        return -1; 
    }
}
