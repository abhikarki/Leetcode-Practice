class Trie {
    // Node for the trie
    class Node{
        // Char array 
        Node [] currChar = null;
        // boolean to store if it is the end of a word.
        boolean endOfWord = false;

        public Node(){
            currChar = new Node [26];
            endOfWord = false;
        }
    }
    Node root = null;

    public Trie() {
       root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        // Loop through the word's characters,if current node doesn't have
        // a reference for the character, create a new node, update curr.
        for(char ch : word.toCharArray()){
            if(curr.currChar[ch - 'a'] == null){
                curr.currChar[ch - 'a'] = new Node();
            }
            curr = curr.currChar[ch - 'a'];
        }
        // Once the end of the word is reached, set 'endOfWord' to true.
        curr.endOfWord = true;   
    }
    
    public boolean search(String word) {
        Node curr = root;
        // Loop through the word's characters,if current node doesn't have
        // a reference for the character, return false. Else, update the
        // pointer.
        for(char ch : word.toCharArray()){
            if(curr.currChar[ch - 'a'] == null){
                return false;
            }
            else{
                curr = curr.currChar[ch - 'a'];
            }
        }
        // Once the end of the word is reached, check if endOfWord is true
        // for the last node as the word might just be a prefix to some 
        // other word and not a word itself in the trie.
        if(curr.endOfWord == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char ch : prefix.toCharArray()){
            if(curr.currChar[ch - 'a'] == null){
                return false;
            }
            else{
                curr = curr.currChar[ch - 'a'];
            }
        }
        // return true if end of the 'prefix' is reached. This means trie
        // contains the prefix as a word or has a word with this prefix.
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */