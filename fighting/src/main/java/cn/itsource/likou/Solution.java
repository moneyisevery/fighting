package cn.itsource.likou;

class Solution {
    public static boolean judgeCircle(String moves) {
        /*char[] chars = moves.toCharArray();
        int a = 0, b = 0;
        for (char c : chars) {
            if (c == 'U') a++;
            if (c == 'D') a--;
            if (c == 'R') b++;
            if (c == 'L') b--;
        }
        return b == 0 && a == 0;*/
        int[] letters = new int[26 + 'A'];
        for (char c : moves.toCharArray()) {
            letters[c]++;
        }
        return letters['U'] == letters['D'] && letters['L'] == letters['R'];
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("DU"));
    }
}