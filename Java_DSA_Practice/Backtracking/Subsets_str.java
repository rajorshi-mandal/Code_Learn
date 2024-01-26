package Backtracking;

public class Subsets_str {
    public static void subsetsStr(String str, String ans, int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }

            return;
        } 

        //included
        subsetsStr(str, ans + str.charAt(i), i + 1);

        //excluded
        subsetsStr(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        subsetsStr(str, "", 0);
    }
}
