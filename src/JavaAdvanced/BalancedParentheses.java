package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < line.length(); i++) {
            char currentBracket = line.charAt(i);
            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            }else {
                if(stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastBracket = stack.pop();
                if(lastBracket == '(' && currentBracket != ')') {
                    isBalanced = false;
                }
                else if(lastBracket == '{' && currentBracket != '}') {
                    isBalanced = false;
                }
                else if(lastBracket == '[' && currentBracket != ']') {
                    isBalanced = false;
                }
            }
        }
        if(isBalanced) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
