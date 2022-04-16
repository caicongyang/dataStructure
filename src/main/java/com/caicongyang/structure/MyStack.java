package com.caicongyang.structure;

public class MyStack {


    public Integer[] arr;

    public int n = 0;


    public MyStack(int cat) {
        arr = new Integer[cat];
    }

    // 入栈
    public MyStack push(Integer person) {
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
        Integer[] newArr = new Integer[size];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    // 出栈
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer person = arr[--n];
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
        MyStack myStack = new MyStack(10);
        myStack.push(5);
        myStack.push(10);
        myStack.print();
        myStack.pop();

    }


}
