package tools;

import java.util.*;
import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first Word:");
        String str1 = input.nextLine();
        System.out.print("Enter the second Word:");
        String str2 = input.nextLine();

        String lcs = findLCS(str1, str2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }

    public static String findLCS(String str1, String str2) {
        int[][] lengths = new int[str1.length() + 1][str2.length() + 1];

        // Build the length matrix
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                } else {
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
                }
            }
        }

        // Build the LCS string
        StringBuilder lcs = new StringBuilder();
        for (int i = str1.length(), j = str2.length(); i != 0 && j != 0;) {
            if (lengths[i][j] == lengths[i - 1][j]) {
                i--;
            } else if (lengths[i][j] == lengths[i][j - 1]) {
                j--;
            } else {
                assert str1.charAt(i - 1) == str2.charAt(j - 1);
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
