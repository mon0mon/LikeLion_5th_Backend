/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-11 AM 9:11
 */

package boj.dnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  종이 접기
public class Bj1802 {
/*
3
0
000
1000110
 */

    public static void main(String[] args) throws IOException {
        new Bj1802().solution();
    }

    //  종이의 굴곡이 0과 1로 문자열로 주어진다.
    //  1000110
    private boolean foldable(String paper) {
        assert paper.length() % 2 == 1;

        // 굴곡이 하나라면 확인할 필요가 없다. 반 접었으니
        if (paper.length() > 1) {
            //  절반 지점
            int half = paper.length() / 2;
            //  왼쪽 종이와 오른쪽 종이가 조건을 만족하는지 검사한다.
            if (!foldable(paper.substring(0, half))) return false;
            if (!foldable(paper.substring(half + 1))) return false;

            //  작은 부분들이 만족스러웠으면,
            //  현재 크기에서 서로 좌우 역대칭이 되는지 확인한다.
            for (int i = 0; i < half + 1; i++) {
                //  중간지점에서 i만큼 + 또는 - 한 위치의 굴곡을 확인한다.
                //  굴곡의 모양이 일치하는 경우 조건이 만족되지 않는다.
                if (paper.charAt(half + i) == paper.charAt(half - i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            if (foldable(br.readLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
