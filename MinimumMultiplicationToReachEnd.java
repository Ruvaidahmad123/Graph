class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)return 0;
        Queue<Pair>q=new LinkedList<>();
        int distance[]=new int[100000];
        for(int i=0;i<100000;i++){
            distance[i]=(int)1e9;
        }
        int mod=100000;
        distance[start]=0;
        q.add(new Pair(start,0));
        while(!q.isEmpty()){
            int val=q.peek().first;
            int steps=q.peek().second;
            q.poll();
            for(int i=0;i<arr.length;i++){
                int num=(val*arr[i])%mod;
                if(steps + 1 < distance[num]) {
                    distance[num] = steps + 1; 
                    if(num == end) return steps + 1; 
                    q.add(new Pair(num, steps + 1)); 
                }
            }
        }
        return -1;
    }
}
