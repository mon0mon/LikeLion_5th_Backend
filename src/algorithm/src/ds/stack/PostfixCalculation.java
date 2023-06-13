/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : AM 9:38
 */

package ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixCalculation {

    public static void main(String[] args) throws IOException {
        new PostfixCalculation().solution();
    }

    public void solution() throws IOException {
        //  입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> digitStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            //  1. 숫자라면, 스택에 push한다.
            //  Character.isDigit(token)  //  token의 숫자가 포현된 글자인지 판단하는 메소드
            //  token을 int로 변환 => token - '0'
            if (Character.isDigit(token)) {
                digitStack.push(token - '0');
                continue;
            }

            //  2. 숫자가 아니라면, (연산자) 스택에서 두 번 pop하고 계산한다.
            int rightNum = digitStack.pop();
            int leftNum = digitStack.pop();
            switch (token) {
                case '+' :
                    digitStack.push(leftNum + rightNum);
                    break;
                case '-' :
                    digitStack.push(leftNum - rightNum);
                    break;
                case '*' :
                    digitStack.push(leftNum * rightNum);
                    break;
                case '/' :
                    digitStack.push(leftNum / rightNum);
                    break;
                default:
                    throw  new IllegalArgumentException("Invalid Operator");
            }
        }

        System.out.println("Answer : " + digitStack.pop());
    }
}
