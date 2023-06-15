/**
 * @project LikeLion_Backend
 * @author ARA
 */

package string;

public class AlphaToInteger {

    public static void main(String[] args) {
        AlphaToInteger atoi = new AlphaToInteger();
        System.out.println(atoi.atoi("12345"));
        System.out.println(atoi.atoi("-4291"));
    }

    //  숫자로만 이루어진 value 문자열에 대해서
    //  각 글자를 숫자 데이터로 해석한 뒤
    //  - 48 하면 숫자가 된다.
    public int atoi(String value) {
        int result = 0;
        int signedMul =
            value.contains("-") ? -1 : 1;

        //  TODO 문자열을 한글자씩 확인
        for (char ch : value.toCharArray()) {
            if (ch == '-') {
                continue;
            }

            //  TODO 글자를 숫자로 변환
            int hold = (ch - '0') * signedMul;
            result += hold;
            //  TODO 자릿수 변환
            result *= 10;
        }
        result /= 10;

        return result;
    }
}
