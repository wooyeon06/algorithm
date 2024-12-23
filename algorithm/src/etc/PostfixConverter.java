package etc;

import java.util.*;

public class PostfixConverter {
    public static void main(String[] args) {
        String infix = "3+5*(2-8)";
        String postfix = infixToPostfix(infix);
        System.out.println("후위 표기식: " + postfix);  // 예: 3528- * +
    }

    // 후위 표기식 변환 함수
    public static String infixToPostfix(String infix) {
        // 연산자 우선순위
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        // 후위 표기식을 저장할 StringBuilder
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // 문자열을 하나씩 처리
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            // 피연산자(숫자)는 바로 출력
            if (Character.isDigit(current)) {
                postfix.append(current);
            }
            // 여는 괄호는 스택에 넣기
            else if (current == '(') {
                stack.push(current);
            }
            // 닫는 괄호는 여는 괄호를 만나기 전까지 연산자 처리
            else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            }
            // 연산자 처리
            else if (precedence.containsKey(current)) {
                // 연산자 우선순위가 낮거나 같은 연산자는 스택에서 꺼내어 후위 표기식에 추가
                while (!stack.isEmpty() && precedence.containsKey(stack.peek()) &&
                        precedence.get(current) <= precedence.get(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(current);
            }
        }

        // 스택에 남아 있는 연산자들을 후위 표기식에 추가
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}

