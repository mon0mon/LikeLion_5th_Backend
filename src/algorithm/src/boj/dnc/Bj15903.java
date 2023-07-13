/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-13 AM 9:33
 */

package boj.dnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//  카드 합체 놀이
//  https://www.acmicpc.net/problem/15903
public class Bj15903 {
/*
3 1
3 2 6
 */

/*
4 2
4 2 3 1
 */
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj15903().solution());
    }
    
    public long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(infoToken.nextToken());
        int actions = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardToken = new StringTokenizer(br.readLine());
        //  우선순위 큐에 넣어준다.
        PriorityQueue<Long> smallestCards = new PriorityQueue<>();
        for (int i = 0; i < cardCount; i++) {
            smallestCards.offer(Long.parseLong(cardToken.nextToken()));
        }

        //  두개의 숫자를 뽑아서 합한 뒤
        //  다시 우선순위 큐에 두 번 넣어준다.
        for (int i = 0; i < actions; i++) {
            long num1 = smallestCards.poll();
            long num2 = smallestCards.poll();
            smallestCards.offer(num1 + num2);
            smallestCards.offer(num1 + num2);
        }
        //  정답을 구한다.
        long answer = smallestCards
                .stream()
                .mapToLong(Long::valueOf)
                .sum();

        return answer;
    }
}
