# minimum-window-substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

https://leetcode.com/problems/minimum-window-substring/

Example:
```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```
Note:

If there is no such window in S that covers all characters in T, return the empty string "".

If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

O(n) solution using sliding window technique. First count the frequency of each character using an vector (or HashMap). Keep track of the number of unique characters inside the window as we move the left and right pointers across the original string. 


```
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
```
