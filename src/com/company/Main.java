package com.company;

public class Main {

        public static int calculateDistance(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();

            // Loome maatriksi, mis hoiab kauguste väärtusi
            int[][] dp = new int[m + 1][n + 1];

            // Initsialiseerime esimese rea ja veeru
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }

            // Arvutame kaugused
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // Kui sümbolid on samad, võrdleme eelmise diagonaaliga
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // Kui sümbolid on erinevad, leia miinimum sissejuhatuse, kustutamise ja asendamise vahel
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
            }

            // Tagastame Levenshtein distance'i
            return dp[m][n];
        }

        public static void main(String[] args) {
            String A = "koer";
            String B = "kass";
            int distance = calculateDistance(A, B);
            System.out.println("Levenshtein distance between \"" + A + "\" and \"" + B + "\" is " + distance);
        }
}
