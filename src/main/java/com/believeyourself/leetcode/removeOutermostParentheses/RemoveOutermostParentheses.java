package com.believeyourself.leetcode.removeOutermostParentheses;

/**
 * 1021. Remove Outermost Parentheses
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 *
 *
 *
 * Example 1:
 *
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 *
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 *
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 *
 * Note:
 *
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 *
 */
public class RemoveOutermostParentheses {

    /**
     * 解题思路：
     * 1.考虑去除最外层(),对于'('和')'需要成对存在
     * 2.定义一个变量count来积加'('和')'出现的次数，count初始值为0，初次迭代字符数组，出现'('时count加1，出现')'时count减1
     * 3.如果count大于0(即非外层'('),则拼接此字符'(';如果count大于1（即非最外层')'）,则拼接此字符')'.
     * @param S 回文字符串
     * @return 去除最外层基元后的字符串
     */
    public String removeOuterParentheses(String S) {
        char[] parentheses = S.toCharArray();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for(char c : parentheses){
            if(c == '(' && count ++ > 0){
                builder.append(c);
            }
            if(c == ')' && count -- > 1){
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())"));
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("()()"));
    }

}
