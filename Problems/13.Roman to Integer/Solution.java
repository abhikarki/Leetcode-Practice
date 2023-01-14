import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        // Create a HashMap for accessing the value of Roman numerals.
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // Loop through the string characters.
        for (int i = 0; i < len -1; i ++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                sum = sum - map.get(s.charAt(i));
            }
            else{
                sum = sum + map.get(s.charAt(i));
            }
        }
        return sum + map.get(s.charAt(len - 1));
    }
}