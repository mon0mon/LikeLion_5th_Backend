/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-04 AM 10:32
 */

package brute_force;

import java.util.Arrays;

public class Combination {

    public static void main(String[] args) {
        int n = 5;
        //  r == 3이라 가정
        //  i는 0부터 n - 2까지 반복해야 나머지 두 숫자를 고를 수 있다.
        for (int i = 0; i < n - 2; i++) {
            //  j도 최소한 하나의 숫자는 남겨둬야 나머지 한 숫자를 마저 고를 수 있다.
            for (int j = i + 1; j < n - 1; j++) {
                //  k는 선택할 수 있는 나머지 중 하나 선택
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d\t%d\t%d\n", i, j, k);
                }
            }
        }
        System.out.println("\n---\n");

        int[] numbers = new int[]{5, 6, 7, 8, 9};
        //  r == 3이라 가정
        //  i는 0부터 n - 2까지 반복해야 나머지 두 숫자를 고를 수 있다.
        for (int i = 0; i < n - 2; i++) {
            //  j도 최소한 하나의 숫자는 남겨둬야 나머지 한 숫자를 마저 고를 수 있다.
            for (int j = i + 1; j < n - 1; j++) {
                //  k는 선택할 수 있는 나머지 중 하나 선택
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d\t%d\t%d\n", numbers[i], numbers[j], numbers[k]);
                }
            }
        }

        new Combination().combNumbers(5, 3, 0, 0, new int[3]);
    }

    private void combNumbers(
        //  nCr
        int n, int r,
        //  지금까지 고른 원소의 갯수 (완성될 조합의 몇번째 원소를 고르는 중인지)
        int k,
        //  현재 조합에 포함시킬지 고려중인 숫자
        int next,
        //  작성중인 조합
        int[] comb
    ) {
        //  고를 만큼 골랐다.
        if (k == r) {
            System.out.println(Arrays.toString(comb));
            return;
        }

        //  아직 다 안골랐는데 더 이상 고를 숫자가 없다.
        if (next == n) {
            //  조합 생성 실패
            return;
        }

        //  현재 만드는 조합의 k 번째에 next를 넣는다.
        comb[k] = next;
        //  next를 선택했다면, k + 1 번째에
        //  next + 1을 할당할지 말지를 결정하러 재귀호출
        combNumbers(n, r, k+1, next+1, comb);
        //  next를 선택하지 않았다면, k 번째에
        //  next + 1을 할당할지 말지를 결정하러 재귀호출
        //  이때 comb[k] = next에서 할당한 값이 덮어씌워진다.
        combNumbers(n, r, k, next+1, comb);
    }
}
