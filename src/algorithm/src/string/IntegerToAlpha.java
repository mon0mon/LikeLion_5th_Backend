/**
 * @project LikeLion_Backend
 * @author ARA
 */

package string;

public class IntegerToAlpha {

    public static void main(String[] args) {
        IntegerToAlpha itoa = new IntegerToAlpha();
        System.out.println(itoa.itoa(1234));
        System.out.println(itoa.itoa(56789));
        System.out.println(itoa.itoa(1234) + itoa.itoa(56789));
        System.out.println(itoa.itoa(-123));
    }

    public String itoa(int value) {
        StringBuilder answerBuilder = new StringBuilder();
        boolean isNegative = false;

        if (value < 0) {
            value *= -1;
            isNegative = true;
        }

        //  TODO value가 0보다 큰 동안
        while (value > 0) {
            //  TODO value를 10으로 나눈 나머지를 문자로 변환
            answerBuilder.append(value % 10);
            //  TODO value 나누기 10
            value /= 10;
        }

        if (isNegative) {
            answerBuilder.append("-");
        }
        return answerBuilder.reverse().toString();
    }
}
