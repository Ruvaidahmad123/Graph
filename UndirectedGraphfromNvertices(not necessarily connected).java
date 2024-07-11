class Solution {
    static long count(int n) {
        long ans=(long)Math.pow(2,n*(n-1)/2); //nc2 because between two node there can be edge so choose 2 node
        //out of n nodes now between those 2 node there can be an edge or no edge so power of 2
        return ans;
  }
}
