package com.qu;

import java.util.Stack;

/*
* write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
*
* Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
* */

public class BalancedBrackets {


    public static boolean isBalanced(String expression) {

// Must be even
        if ((expression.length() & 1) == 1) return false;
        else {
            char[] brackets = expression.toCharArray();
            Stack<Character> s = new Stack<>();
            for (char bracket : brackets)
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.empty() || bracket != s.peek())
                            return false;
                        s.pop();
                }
            return s.empty();
        }

    }
}