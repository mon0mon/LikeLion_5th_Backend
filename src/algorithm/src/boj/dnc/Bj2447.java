/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-12 AM 9:35
 */

package boj.dnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//  백준 별찍기 10
//  https://www.acmicpc.net/problem/2447
public class Bj2447 {
    private char[][] starboard;

    public void solution() throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        starboard = new char[n][n];
        for (char[] row: starboard) {
            Arrays.fill(row, ' ');
        }
        setStar(n, 0, 0);
        StringBuilder drawStar = new StringBuilder();
        for (int i = 0; i < n; i++) {
            drawStar.append(starboard[i]).append('\n');
        }
        System.out.println(drawStar);
    }

    private void setStar(int n, int x, int y) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    starboard[x + i][y + j] = '*';
                }
            }
        } else {
            int offset = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    setStar(offset, x + offset * i, y + offset * j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Bj2447().solution();
    }
}