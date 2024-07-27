class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(map.containsKey(accounts.get(i).get(j))==false){
                    map.put(accounts.get(i).get(j),i);
                }
                else{
                  //make parent if already present
                    ds.unionBySize(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
      // The line ArrayList<String>[] mergedmail = new ArrayList[n]; in Java creates an array of ArrayList<String> objects with a length of n
        ArrayList<String>[]mergedmail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedmail[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer>it:map.entrySet()){
            String mail=it.getKey();
            int node=ds.findUPar(it.getValue()); //if ultimate parent is same then add value to ultimate parent only
            mergedmail[node].add(mail);
        }
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedmail[i].size()==0)continue;
            List<String>temp=new ArrayList<>();
            Collections.sort(mergedmail[i]);
            temp.add(accounts.get(i).get(0));
            for(String mail:mergedmail[i]){
                temp.add(mail);
            }
            ans.add(temp);
        }
        return ans;
    }
}
