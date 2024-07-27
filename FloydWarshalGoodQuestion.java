//LEETCODE 2976
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int inf = Integer.MAX_VALUE;
        int alphabetSize = 26;
        int[][] costMatrix = new int[alphabetSize][alphabetSize];
        for (int[] row : costMatrix) {
            Arrays.fill(row, inf);
        }
        for (int i = 0; i < alphabetSize; i++) {
            costMatrix[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            costMatrix[from][to] = Math.min(costMatrix[from][to], cost[i]);
        }
        for (int k = 0; k < alphabetSize; k++) {
            for (int i = 0; i < alphabetSize; i++) {
                for (int j = 0; j < alphabetSize; j++) {
                    if (costMatrix[i][k] < inf && costMatrix[k][j] < inf) {
                        costMatrix[i][j] = Math.min(costMatrix[i][j], costMatrix[i][k] + costMatrix[k][j]);
                    }
                }
            }
        }
        long total=0;
        for(int i=0;i<n;i++){
            int src=source.charAt(i);
            int trgt=target.charAt(i);
            if(costMatrix[src-'a'][trgt-'a']==inf){
                return -1;
            }
            total+=costMatrix[src-'a'][trgt-'a'];
        }
        return total;
    }
}
