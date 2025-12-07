public class LongestCommonPrefix {
    public String longestCommonPrefix(String [] words){
        if(words == null || words.length == 0){
            return "";
        }
        String pref = words[0];
        int pref_len = pref.length();

        for (int i = 1;i<words.length;i++){
            String s = words[i];
            while(pref_len > s.length() || !pref.equals(s.substring(0,pref_len))){
                pref_len--;
                if(pref_len == 0){
                    return "";
                }
                pref = pref.substring(0,pref_len);
            }
        }
        return pref;
    }
}
