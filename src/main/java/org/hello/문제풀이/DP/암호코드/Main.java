package org.hello.문제풀이.DP.암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1000000;

    private static int[] dp;
    private static char[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        values = br.readLine().toCharArray();

        dp = new int[values.length + 1];

        dp[0] = 1;

        char first = values[0];

        if(first == '0') {
            System.out.println(0);
            return;
        }else {
            dp[1] = 1;
        }

        for(int i = 1; i < values.length; i++) {
            char value = values[i];
            if(value == '0') {
                int sum = Integer.parseInt(String.valueOf(values[i - 1]) + values[i]);
                if((sum == 10 || sum == 20)) {
                    dp[i + 1] += dp[i - 1] % MOD;
                }
            }else {
                dp[i + 1] += dp[i] % MOD;
                int sum = Integer.parseInt(String.valueOf(values[i - 1]) + values[i]);
                if(sum > 10 && sum < 27) {
                    dp[i + 1] += dp[i - 1] % MOD;
                }
            }
        }

        System.out.println(dp[values.length] % MOD);
    }
}