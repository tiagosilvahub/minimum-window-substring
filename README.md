# minimum-window-substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

```
String calculate(String s, String t) {
    int[] charCounts = new int[256];
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    int left = 0;
    int right = 0;
    int uniqueCharCount = 0;
    int smallest = Integer.MAX_VALUE;
    int newFrequency;
    String answer = "";

    for (int i = 0; i < charCounts.length; i++) {
      charCounts[i] = 0;
    }

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
