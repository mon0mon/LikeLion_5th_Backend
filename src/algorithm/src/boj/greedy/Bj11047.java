/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 AM 10:24
 */

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  https://www.acmicpc.net/problem/11047
public class Bj11047 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2798().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());
        //  동전의 종류
        int coinKinds = Integer.parseInt(info.nextToken());
        //  만들고자 하는 금액
        int targetAmount = Integer.parseInt(info.nextToken());
        //  개별 동전 가치 저장
        int[] coinAmounts = new int[coinKinds];

        //  큰 동전을 0에 두기 위해 역순으로 저장한다.
        for (int i = coinKinds - 1; i >= 0; i--) {
            coinAmounts[i] = Integer.parseInt(br.readLine());
        }

        //  실제로 사용한 동전의 갯수
        int coinUsed = 0;

//        //  1. 사전적으로 풀이
//        int currentCoin = 0;
//        //  거슬러 줄 금액이 남아있는 동안 반복한다.
//        while (targetAmount > 0) {
//            //  현재 선택한 동전을 사용할 수 있을때 사용한다.
//            if (targetAmount >= coinAmounts[currentCoin]) {
//                targetAmount -= coinAmounts[currentCoin];
//                coinUsed++;
//                continue;
//            }
//
//            //  다음 동전 사용
//            currentCoin++;
//        }

        //  2. 수학적으로 계산
        //  큰 동전부터 순서대로 확인
        for (int i = 0; i < coinKinds; i++) {
            //  남은 금액에서 현재 동전으로 지불할 수 있는 최대 갯수
            coinUsed += targetAmount / coinAmounts[i];
            targetAmount %= coinAmounts[i];
        }

        return coinUsed;
    }
}
