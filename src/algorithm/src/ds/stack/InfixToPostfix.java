/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : AM 10:30
 */

package ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfix {
    //  5+3*1+(4-9)*3
    public static void main(String[] args) throws IOException {
        new InfixToPostfix().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //  결과를 담아둘 StringBuilder
        StringBuilder sb = new StringBuilder();
        //  연산자 담는 스택 (연산자 = operator)
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            //  TODO  연산자 (+, -, *, /, '(', )일때
            if (isOperator(token)) {
                //  TODO 스택이 비어있다면 push (if)
                if (opStack.empty()) {
                    opStack.push(token);
                    continue;
                }

                //  TODO 스택이 비어있지 않다면, (else)
                //  TODO 스택의 제일 위의 연산자가 나보다 우선순위가 낮은 연산자가 올때까지 pop (while)
                while (inStackPriority(opStack.peek()) >= inComingPriority(token)) {
                    sb.append(opStack.pop());
                    //  TODO 순회 중 스택이 다 빌 경우 반복 중단 (if break)
                    if (opStack.empty()) {
                        break;
                    }
                }
                //  TODO while 종료 후 스택에 push
                opStack.push(token);

            } else if (token == ')') {
                //  TODO 스택에서 여는 괄호가 나올때까지 POP
                char top = opStack.pop();
                while (top != '(') {
                    sb.append(top);
                    top = opStack.pop();
                }
            }else {
                sb.append(token);
            }
        }

        //  TODO 연산자 스택이 빌때까지 pop
        while (!opStack.empty()) {
            sb.append(opStack.pop());
        }

        System.out.println(sb);
    }

    private boolean isOperator(char token) {
        switch (token) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
                return true;
        }

        return false;
    }

    //  스택 내부에서의 우선순위
    private int inStackPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 0;
            default:
                throw new IllegalArgumentException("not allowed operator");
        }
    }

    //  스택 외부에서의 우선순위
    private int inComingPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 3;
            default:
                throw new IllegalArgumentException("not allowed operator");
        }
    }
}
