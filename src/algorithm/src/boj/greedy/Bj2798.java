/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 AM 9:03
 */

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  블랙잭
//  https://www.acmicpc.net/problem/2798
public class Bj2798 {
    //  5 21
    //5 6 7 8 9

    //  10 500
    //93 181 245 214 315 36 185 138 216 295

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2798().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  카드 갯수, 목표 숫자
        StringTokenizer infoToken = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(infoToken.nextToken());
        int target = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardTokens = new StringTokenizer(br.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(cardTokens.nextToken());
        }

        int max = 0;
        //  3장의 카드를 뽑는다.
        //  첫번째 카드  -> n장의 카드가 있다면 첫번째는 n - 2 까지
        for (int i = 0; i < cardCount - 2; i++) {
            //  두번째 카드  -> 두번째는 n - 1까지
            for (int j = i + 1; j < cardCount - 1; j++) {
                //  세번째 카드  -> 세번째는 n 까지
                for (int k = j + 1; k < cardCount; k++) {
//                    System.out.printf("%d\t%d\t%d\n", cards[i], cards[j], cards[k]);
                    int sum = cards[i] + cards[j] + cards[k];
                    //  이번 카드 3장의 합이 여태까지 구한 것 중 제일 크다
                    if (sum <= target && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        return max;
    }
}
