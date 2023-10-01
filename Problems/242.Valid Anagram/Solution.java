class Solution {
     public boolean isAnagram(String s, String t) {
         int len1 = s.length();
         int len2 = t.length();
         // Return false is they are not of equal length.    
         if(len1 != len2){
             return false;
         }

        // Array to keep the frequency of characters.
         int []charArr = new int[26];

        // Increase and decrease the frequency of characters in the array.
         for(int i = 0; i < len1; i ++){
             charArr[s.charAt(i) - 'a']++;
             charArr[t.charAt(i) - 'a']--;
         }

        // Return false if any of the entry in the array is no equal to 0.
         for(int j = 0; j < 26; j ++){
             if(charArr[j] != 0){
                 return false;
             }
         }
         return true;
     }
}


// HASHMAP SOLUTION
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         if(len1!=len2){
//             return false;
//         }
//         // Hashmap to store the frequency of characters.
//         HashMap <Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < len1; i ++){
//             char d = s.charAt(i);
//             if(map.containsKey(d)){
//                 int a = map.get(d);
//                 map.put(d, a + 1);
//             }
//             else{
//                 map.put(d, 1);
//             }
//         }

            // Update the frequency 
//         for(int j = 0; j < len2; j ++){
//             char c = t.charAt(j);
//             if(!map.containsKey(c) || map.get(c) == 0){
//                 return false;
//             }
//             else{
//                 int b = map.get(c);
//                 map.put(c, b - 1);
//             }
//         }

//         return true;
//     }
// }