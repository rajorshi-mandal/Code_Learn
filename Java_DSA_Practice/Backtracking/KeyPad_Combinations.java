package Backtracking;

public class KeyPad_Combinations {

    public static void letterCombinations(String KB){
        char[][] keypad = {
            {},{},  // First row is empty
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},  // Seventh row has four characters
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}   // Ninth row also has four characters
        };
        
        if(KB.length() == 0){
            System.out.println("");
            return;
        }
        findKeyPadCombinations(0, KB, keypad, KB.length(), new StringBuilder());
    }

    public static void findKeyPadCombinations(int pos, String KB, char[][] keypad, int len, StringBuilder ans){ //BFS
        if(pos == len){
            System.out.println(ans.toString());
        } else {
            char[] keySet = keypad[Character.getNumericValue(KB.charAt(pos))];
            for(int i = 0; i < keySet.length; i++){
                findKeyPadCombinations(pos + 1, KB, keypad, len, new StringBuilder(ans).append(keySet[i]));
            }
        }
        
    }

    public static void main(String[] args) {
        String keyButtons = "23";

        letterCombinations(keyButtons);
    }
}
