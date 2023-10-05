class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to put sorted String as key and the list of strings as value.
        // The anagrams are equal in their sorted form.
        HashMap <String, List<String>> map = new HashMap<>();

        int len = strs.length;
        for(int i = 0; i < len; i ++){
            char [] arr = strs[i].toCharArray();
            // Sort the characters.
            Arrays.sort(arr);

            String sortedStr = new String(arr);

            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(strs[i]);
            }
            else{
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                map.put(sortedStr, a);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> i : map.entrySet()){
            result.add(i.getValue());
        }
        return result;
    }

}