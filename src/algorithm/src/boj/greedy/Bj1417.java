/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-17 AM 9:14
 */

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//  국회의원 선거
//  https://www.acmicpc.net/problem/1417
public class Bj1417 {
/*
3
5
7
7
 */

/*
4
10
10
10
10
 */

/*
1
1
 */
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1417().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  입력부
        int candidates = Integer.parseInt(br.readLine());
        //  첫줄이 내 득표수
        int myVote = Integer.parseInt(br.readLine());
        //  제일 많은 득표자의 표를 먼저 뺏어야 하니까
        PriorityQueue<Integer> otherVotes
//                = new PriorityQueue<>(Collections.reverseOrder());
                = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        for (int i = 1; i < candidates; i++) {
            otherVotes.offer(Integer.parseInt(br.readLine()));
        }

        //  알고리즘
        int answer = 0;
        //  단일 후보가 아닌 경우에만 계산을 진행한다.
        if (!otherVotes.isEmpty()) {
            //  나머지 후보들 득표중 최대값이 나보다 작아질 때 까지
            while(otherVotes.peek() >= myVote) {
                //  최다 득표자의 득표수
                int votes = otherVotes.poll();
                //  그 사람의 지지자를 한명 매수한다.
                otherVotes.offer(votes - 1);
                //  뺏은 표는 내것으로
                myVote++;
                answer++;
            }
        }

        return answer;
    }
}
