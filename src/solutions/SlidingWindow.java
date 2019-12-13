package src.solutions;

public class SlidingWindow implements Solution {
    @Override
    public String minWindow(String s, String t) {
        int[] charCounts = new int[256];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int left = 0;
        int right = 0;
        int uniqueCharCount = 0;
        int smallest = Integer.MAX_VALUE;
        String answer = "";

        for( char c : tChars) {
            if(charCounts[c] == 0){
                uniqueCharCount++;
            }
            charCounts[c]++;
        }

        while(right < s.length()) {
            char rightChar = sChars[right];
            charCounts[rightChar]--;
            if (charCounts[rightChar] == 0) {
                uniqueCharCount--;
            }
            right++;
            while(uniqueCharCount == 0){
                char leftChar = sChars[left];
                if( right-left < smallest ){
                    smallest = right-left;
                    answer = s.substring(left, right);
                }
                charCounts[leftChar]++;
                if( charCounts[leftChar] > 0 ){
                    uniqueCharCount++;
                }
                left++;
            }
        }
        return answer;
    }
}
