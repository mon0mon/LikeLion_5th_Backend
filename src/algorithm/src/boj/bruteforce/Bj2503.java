/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-03 AM 10:11
 */

package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2503 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 질문 횟수를 입력받는다.
        int tries = Integer.parseInt(reader.readLine());
        int[][] ballInfo = new int[tries][3];

        for (int i = 0; i < tries; i++) {
            StringTokenizer countTokens = new StringTokenizer(reader.readLine());
            ballInfo[i] = new int[]{
                // 민혁이가 질문한 세 자리 수
                Integer.parseInt(countTokens.nextToken()),
                // 영수가 답한 스트라이크 개수
                Integer.parseInt(countTokens.nextToken()),
                // 영수가 답한 볼 수
                Integer.parseInt(countTokens.nextToken())
            };
        }
        // 가능성있는 수의 개수
        int answer = 0;

        // for 반복문으로 자연수 세개를 나열한다.
        for (int i = 1; i < 10; i++) {               // 백의 자리 수
            for (int j = 1; j < 10; j++) {           // 십의 자리 수

                // 같은 숫자가 나와서는 안된다. i == j 이면 continue
                if (j == i) continue;
                for (int k = 1; k < 10; k++) {       // 일의 자리 수

                    // 같은 숫자가 나와서는 안된다. i == k 또는 j == k 이면 continue
                    if (k == j || k == i) continue;

                    // 중복되는 숫자가 없으면 int 배열에 i, j, k를 넣어 세 자리의 숫자를 만든다.
                    int[] answerCandi = new int[]{i, j, k};

                    // 영수가 생각하고 있는 답일 가능성이 있는 숫자인지를 체크하기 위한 isAnswer
                    boolean isAnswer = true;
                    for (int t = 0; t < tries; t++) {

                        // 민혁이 질문한 세 자리의 숫자
                        int select = ballInfo[t][0];

                        // 반복문으로 가져온 세 자리의 숫자와 민혁이 질문한 숫자를 비교
                        // 스트라이크 수와 볼 수를 가져온다.
                        int[] result = getCount(select, answerCandi);

                        // 반복문으로 가져온 수와 비교한 스트라이크 수, 볼 수가
                        // 영수가 답한 스트라이크 수, 볼 수와 다르면
                        // 반복문으로 가져온 수는 답이 될 수 없다.
                        //  -> isAnswer는 false, 민혁의 질문한 수를 하나씩 비교하는 for(t) 반복문 종료
                        if (result[0] != ballInfo[t][1] || result[1] != ballInfo[t][2]) {
                            isAnswer = false;
                            break;
                        }
                    }
                    // isAnswer가 true이면 답이 될 수 있는 가능성이 있는 수이므로 answer 1씩 증가
                    if (isAnswer) answer++;

                }
            }
        }


        return answer;
    }

    // 두 숫자를 비교해서 스트라이크 수와 볼 수를 담은 int 배열을 반환
    public int[] getCount(int select, int[] answer) {
        int strikes = 0;
        int balls = 0;
        // select 숫자를 {백의자리, 십의자리, 일의자리} 형태로 변환
        int[] selectNums = new int[]{select / 100, (select / 10) % 10, select % 10};

        // 한 자리씩 숫자를 비교
        for (int i = 0; i < 3; i++) {
            // 숫자가 같고 자리수도 같으면 스트라이크 1씩 증가
            if (selectNums[i] == answer[i]) {
                strikes++;
            } else {
                for (int j = 0; j < 3; j++) {
                    // 숫자가 같지만 자리가 다르면 볼 1씩 증가
                    if (selectNums[i] == answer[j]) balls++;
                }
            }
        }

        return new int[]{strikes, balls};
    }


    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2503().solution());
    }
}
