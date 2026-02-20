package org.hello.문제풀이.비트마스킹.기차가어둠헤치은하수를;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] train = new int[N + 1]; // 기차 1대의 20개 좌석 상태 전체
        int MASK = (1 << 20) - 1;

        for(int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                train[i] |= (1 << (x - 1));
            } else if(cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << (x - 1));
            } else if(cmd == 3) {
                train[i] = (train[i] << 1) & MASK;
            } else {
                train[i] >>= 1;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) set.add(train[i]);

        System.out.println(set.size());
    }
}
