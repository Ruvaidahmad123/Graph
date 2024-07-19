class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {  
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>q=new LinkedList<>();
        HashSet<String>st=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedword[]=word.toCharArray();
                    replacedword[i]=ch;
                    String replaced=new String(replacedword);   //hit ->ait,bit,cit,....zit..
                                                                //hit->hat,hbt,hct,...hot.....
                                                                    //hot->hoa,hob,...hoz
                                                                      //hot->aot,bot...dot.....zot
                                                                      //dot->...
                    if(st.contains(replaced)){
                        st.remove(replaced);
                        q.add(new Pair(replaced,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
