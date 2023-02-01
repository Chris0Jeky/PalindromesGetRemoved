import java.util.ArrayList;

public class Solution {

    static String solution(String s) {
        String pass = "aba";
        isPalindrome(pass);
        System.out.println(generatePrefixes(s));
        System.out.println(decideWhichOne(generatePrefixes(s)));
        String stringGiven = s;
        //String result = decideWhichOne(generatePrefixes(stringGiven));
        //System.out.println(result);
        boolean contin = true;

        for (int i = 0; i < 10000; i++){
            String result = decideWhichOne(generatePrefixes(stringGiven));
            if(result.equals("")) {
                System.out.println("Fizz");
                System.out.println(stringGiven);
                return stringGiven;
            }
            else {
                System.out.println("Buzz");
                System.out.println(stringGiven);
                stringGiven = stringGiven.replaceFirst(result, "");
            }
        }

        do {
            String result = decideWhichOne(generatePrefixes(stringGiven));
            System.out.println("Blah");
            if(result.equals("")) {
                contin = false;
                return stringGiven;
            }
            else {
                stringGiven.replaceFirst(result, "");
            }
        }
        while (!contin);
        return stringGiven;
    }

    static String decideWhichOne(ArrayList<String> ls){
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

    static ArrayList<String> generatePrefixes(String str) {
        String stringu = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            stringu = stringu + str.charAt(i);
            list.add(stringu);
        }
        return list;
    }

    public static boolean isPalindrome(String str) {
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
