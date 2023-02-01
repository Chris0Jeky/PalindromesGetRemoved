import java.util.ArrayList;

public class Solution {

    String solution(String s) {
        String pass = "aba";
        isPalindrome(pass);
        System.out.println(generatePrefixes(s));
        boolean contin = true;
        String stringGiven = s;
        do {
            String result = decideWhichOne(generatePrefixes(stringGiven));
            if(result.equals("")) {
                contin = false;
                return stringGiven;
            }
            else {
                stringGiven.replaceFirst(result, "");
            }

        }
        while (contin);
        return "";
    }

    String decideWhichOne(ArrayList<String> ls){
        String longest = "";
        for (int i = 0; i < ls.size(); i++){
            if(isPalindrome(ls.get(i)) && ls.get(i).length() > 1){
                if(ls.get(i).length() > longest.length()) {
                    longest = ls.get(i);
                }
            }
        }
        return longest;
    }

    ArrayList<String> generatePrefixes(String str) {
        String stringu = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            stringu = stringu + str.charAt(i);
            list.add(stringu);
        }
        return list;
    }

    public boolean isPalindrome(String str) {
        String stringu = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            stringu = stringu + str.charAt(i);
        }

        if(stringu.equals(str)) {
            return true;
        }
        return false;
    }

}
