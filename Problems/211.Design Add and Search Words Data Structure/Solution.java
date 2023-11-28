class WordDictionary {
    // Trie node
    class Node{
        // Array of nodes, each element points to null or another node.
        Node [] charArr = null;
        // boolean to store if the node is a end of a word in dictionary.
        boolean endOfWord = false;

        public Node(){
            charArr = new Node [26];
            endOfWord = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        // Loop through the characters and add nodes to the trie.
        for(char ch : word.toCharArray()){
            if(curr.charArr[ch - 'a'] == null){
                curr.charArr[ch - 'a'] = new Node();
            }
            curr = curr.charArr[ch - 'a'];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        return searchWord(word, curr);
    }

    public boolean searchWord(String word, Node curr){
        // If the end of the word is reached, check if the current node's
        // endOfWord is true i.e. check if dictionary has the word.
        if (word.length() == 0){
            return curr.endOfWord;
        }
        // If the character is a '.', loop through the char Array of the
        // current node and traverse the trie for each non-null node.
        if(word.charAt(0) == '.'){
            for(int i = 0; i < 26; i ++){
                // Check if the array's element is null.
                if(curr.charArr[i] != null){
                    // recursive call with substring from 2nd character.
                    if(searchWord(word.substring(1), curr.charArr[i])){
                        return true;
                    }
                }
            }
            return false;
        }
        // If the character is not a '.', traverse through the nodes.
        else{
            char ch = word.charAt(0);
            if(curr.charArr[ch - 'a'] != null){
               return searchWord(word.substring(1), curr.charArr[ch-'a']);
            }
            else{
                return false;

            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */