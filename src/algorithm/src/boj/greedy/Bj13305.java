/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-10 AM 9:10
 */

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  주유소
//  https://www.acmicpc.net/problem/13305
public class Bj13305 {

/*
4
2 3 1
5 2 4 1
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj13305().solution());
    }

    public long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long cityCount = Integer.parseInt(br.readLine());
        StringTokenizer cityDistToken = new StringTokenizer(br.readLine());
        StringTokenizer cityFuelToken = new StringTokenizer(br.readLine());

        //  각 도시들 간의 거리기 때문에 배열의 크기는 n-1
        long[] cityDistance = new long[(int) (cityCount - 1)];
        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = Integer.parseInt(cityDistToken.nextToken());
        }

        //  각 도시의 기름값 정보
        long[] cityFuel = new long[(int) cityCount];
        for (int i = 0; i < cityCount; i++) {
            cityFuel[i] = Integer.parseInt(cityFuelToken.nextToken());
        }

        //  여태까지 확인한 최소기름값 저장용 변수
        long currentMin = Integer.MAX_VALUE;
        //  현재 도시에서 현재 도시보다 기름값이 싼 도시까지 걸린 거리
        long needToGo = 0;
        //  총 주유비
        long totalPrice = 0;
        //  이동하는 횟수 만큼만 반복 (마지막 도시에선 계산이 필요 없음)
        for (int i = 0; i < cityCount - 1; i++) {
            //  현재 도시의 기름값이 여태까지 중 제일 싸다
            if (cityFuel[i] < currentMin) {
                //  이 도시까지 도달하는데 걸린 거리만큼은
                //  이전 최소값 도시에서 넣어야한다.
                totalPrice += currentMin * needToGo;
                //  기름값 최솟값 갱신
                currentMin = cityFuel[i];
            }
        }

        return 0L;
    }
}
