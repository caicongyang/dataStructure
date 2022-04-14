package com.caicongyang.structure;

public class Stack {


    public String[] arr;

    public int n = 0;


    public Stack(int cat) {
        arr = new String[cat];
    }

    // 入栈
    public Stack push(String person) {
        judgeSize();
        arr[n] = person;
        n++;
        return this;
    }


    private void judgeSize() {
        if (n >= arr.length) {
            resize(2 * arr.length);
        } else if (n < arr.length / 2) {
            resize(arr.length / 2);
        }
    }

    private void resize(int size) {
        String[] newArr = new String[size];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    // 出栈
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String person = arr[--n];
        arr[n] = null;
        return person;
    }


    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("----------");

    }


    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("tom");
        stack.push("json");
        stack.print();
        stack.pop();

    }


}
