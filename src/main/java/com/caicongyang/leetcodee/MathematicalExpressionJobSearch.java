package com.caicongyang.leetcodee;

import com.caicongyang.structure.MyStack;

import java.util.Stack;

/**
 * 实现 3+11*2+8-15/5 公式计算
 * 当优先级的操作符低于栈顶的操作符的时候，取出操作符栈的操作符 & 取出数字栈的两个进行操作，得到的值进行入栈
 */
public class MathematicalExpressionJobSearch {

    public static void main(String[] args) {

        String mathExpress = "3+11*2+8-15/5";
        mathExpress = insetBlanks(mathExpress);

        MyStack stackNum = new MyStack(32);

        Stack<String> stackOp = new Stack();

        /**
         * 第一个循环把优先级高进行计算，并将结算结果进行压栈（除了最后一个）
         */
        String[] tokens = mathExpress.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];

            if (i == 0) {
                if (!org.apache.commons.lang3.StringUtils.isNumeric(c)) {
                    throw new RuntimeException("math express error");
                }
            }
            if (org.apache.commons.lang3.StringUtils.isNumeric(c)) {
                stackNum.push(Integer.valueOf(c));
                continue;
            }
            if (!org.apache.commons.lang3.StringUtils.isNumeric(c)) {
                if (!stackOp.empty()) {
                    String peek = stackOp.peek();
                    // 当前的操作把比上一个优先级低，先操作上一个操作
                    while (validOpPriorityLevel(c, peek.toString()) < 0) {
                        Integer pop1 = stackNum.pop();
                        Integer pop2 = stackNum.pop();
                        stackNum.push(op(pop2, pop1, String.valueOf(stackOp.pop())));
                        peek = stackOp.peek();
                    }
                    stackOp.push(c);
                } else {
                    stackOp.push(c);
                }
                continue;
            }
        }

        /**
         * 计算优先级相等的情况
         */

        do {
            Integer pop1 = stackNum.pop();
            Integer pop2 = stackNum.pop();
            stackNum.push(op(pop2, pop1, String.valueOf(stackOp.pop())));
        } while (!stackOp.isEmpty());


        System.out.println(stackNum.pop());

    }


    public static String insetBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }


    public static Integer op(Integer a, Integer b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return null;
        }

    }


    public static Integer validOpPriorityLevel(String a, String b) {
        //不行进行计算
        if ((a.equalsIgnoreCase("+") || a.equalsIgnoreCase("-")) && (b.equalsIgnoreCase("*") || b.equalsIgnoreCase("/"))) {
            return -1;
            //不进行计算
        } else if ((a.equalsIgnoreCase("+") || a.equalsIgnoreCase("-")) && (b.equalsIgnoreCase("+") || b.equalsIgnoreCase("-"))) {
            return 0;
            //不 进行计算
        } else if ((a.equalsIgnoreCase("*") || a.equalsIgnoreCase("/")) && (b.equalsIgnoreCase("*") || b.equalsIgnoreCase("/"))) {
            return 0;
        } else {
            return 1;
        }

    }

}
