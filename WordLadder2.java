class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String>st=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        Queue<ArrayList<String>>q=new LinkedList<>();
        ArrayList<String>l=new ArrayList<>();
        l.add(beginWord);
        ArrayList<String>usedonlevel=new ArrayList<>();
        usedonlevel.add(beginWord);
        q.add(l);
        List<List<String>>ans=new ArrayList<>();
        int level=0;
        while(!q.isEmpty()){
            ArrayList<String>vec=q.peek();
            q.poll();
            if(vec.size()>level){
                level++;
                for(String it:vec){
                    st.remove(it);
                }
                usedonlevel.clear();
            }
            String word=vec.get(vec.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0){
                    ans.add(vec);
                }
                else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedword[]=word.toCharArray();
                    replacedword[i]=ch;
                    String replaced=new String(replacedword);
                    if(st.contains(replaced)){
                        vec.add(replaced);
                        usedonlevel.add(replaced);
                        ArrayList<String>temp=new ArrayList<>(vec);
                        q.add(temp);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
//approach 2
public class Solution {
    Map<String, Integer> map = new HashMap<>();

    private void dfs(String endWord, String beginWord, List<List<String>> result, List<String> path) {
        if (endWord.equals(beginWord)) {
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
            return;
        }
        for (int j = 0; j < endWord.length(); j++) {
            StringBuilder sb = new StringBuilder(endWord);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(j, c);
                String ss = sb.toString();
                if (map.containsKey(ss) && map.get(ss) + 1 == map.get(endWord)) {
                    path.add(ss);
                    dfs(ss, beginWord, result, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        queue.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                map.put(word, level);
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder sb = new StringBuilder(word);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, result, path);
        }
        return result;
    }
}
