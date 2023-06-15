/**
 * @project LikeLion_Backend
 * @author ARA
 */

package brute_force.pattern_matching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BFPatternMatching {
    // qwertyuiuiuytrertyuiopopoiuytrqwertyuytrertywqwertyuiuytrewqwertyuiiuiuiytrewert
    // qwert
    public static void main(String[] args) throws IOException {
        new BFPatternMatching().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String pattern = br.readLine();

        int tarIdx = 0;
        int patIdx = 0;

        List<Integer> idxList = new ArrayList<>();
        while (tarIdx + pattern.length() <= target.length()) {
            if (target.charAt(tarIdx) == pattern.charAt(patIdx)) {
                if (pattern.length()-1 == patIdx) {
                    idxList.add(tarIdx - patIdx);
                    tarIdx = tarIdx - patIdx + 1;
                    patIdx = 0;
                    continue;
                }
                tarIdx++;
                patIdx++;
                continue;
            }
            tarIdx = tarIdx - patIdx + 1;
            patIdx = 0;
        }
        //  TODO tarIDX 전체 길이보다 작을 동안에 반복한다.
        //  TODO 존재하는지만 검사하면 된다 했을 경우 patIdx가 pattern.length()보다 작을 동안에 반복한다.
            //  TODO target[tarIdx]가 pattern[patIdx]랑 다를 경우
                //  TODO tarIdx를 여태까지 이동한 만큼 되돌린다.
                //  TODO patIdx를 -1로 할당한다.

            //  TODO 다음칸으로 이동한다.

        //  TODO patIdx == pattern.length() 이면 성공이다. 어디에서 찾았는지 출력한다.
        //  TODO 못찾으면 System.out.println("404 Not Found");
        System.out.println(idxList.isEmpty() ?
            "404 Not Found" : idxList);
    }
}
