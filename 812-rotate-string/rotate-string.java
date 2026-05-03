class Solution {

    private int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0, i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String text = s + s;
        int[] lps = buildLPS(goal);

        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            }

            if (j == goal.length()) {
                return true;
            } else if (i < text.length() && text.charAt(i) != goal.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}