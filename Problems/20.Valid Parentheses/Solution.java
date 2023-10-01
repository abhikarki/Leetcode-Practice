class Solution {
    public boolean isValid(String s) {

        int len = s.length();
        // Using a stack to know the previous open character 
        Stack <Character> charStack = new Stack<Character>();

        // Loop through the characters and check for validity.
        for(int i = 0; i < len; i ++){
            char a = s.charAt(i);
            if(a == '('){
                charStack.push('(');
            }
            else if(a == '{'){
                charStack.push('{');
            }
            else if(a == '['){
                charStack.push('[');
            }
            else if(a == ')'){
                if(charStack.empty() || charStack.pop() != '('){
                    return false;
                }
            }
            else if(a == '}'){
                if(charStack.empty() || charStack.pop() != '{'){
                    return false;
                }
            }
            else if(a == ']'){
                if(charStack.empty() || charStack.pop() != '['){
                    return false;
                }
            }
        }

        // if the last character was an open bracket, return false.
        if(charStack.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}