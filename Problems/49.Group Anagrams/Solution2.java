
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap with Frequency String
        HashMap <String, List<String>> map = new HashMap<>();

        int len = strs.length;
        int len1 = 0;

        for (int i = 0; i < len; i ++){
            len1 = strs[i].length();
            int j = 0;
            int [] arr = new int [26];
            // Fill the array with the frequency of characters.
            while(j < len1){
                int ch = strs[i].charAt(j);
                arr[ch - 'a'] ++;
                j ++;
            }
            // Frequency String. For example: 'aaple' -> 'a2e1l1p1'
            StringBuilder st = new StringBuilder();
            for(int k = 0; k < 26; k ++){
                if(arr[k] != 0){
                    st.append((char)('a' + k));
                    st.append(arr[k]);
                }
            }

            if(map.containsKey(st.toString())){
                map.get(st.toString()).add(strs[i]);
            }
            else{
                map.put(st.toString(), new ArrayList<String>());
                map.get(st.toString()).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> i : map.entrySet()){
           result.add(i.getValue());
         }
        return result;

    }
}