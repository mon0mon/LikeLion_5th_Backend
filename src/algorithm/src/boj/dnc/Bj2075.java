/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-13 AM 9:14
 */

package boj.dnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//  n번째 큰 수
//  https://www.acmicpc.net/problem/2075
public class Bj2075 {
/*
5
12 7 9 15 5
13 8 11 19 6
21 10 26 31 16
48 14 28 35 25
52 20 32 41 49
 */
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2075().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //  우선순위 큐를 만든다.
        //  최소 값이 먼저 나오는 우선순위 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            //  숫자 입력을 지속적으로 받으면서
            int[] ary = Arrays
                    .stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                //  우선순위 큐의 크기를 일정하게 유지한다.
                priorityQueue.offer(ary[j]);
                if (priorityQueue.size() > n) {
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }
}
