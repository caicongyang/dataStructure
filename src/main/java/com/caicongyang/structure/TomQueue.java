package com.caicongyang.structure;

/**
 * 队列： 先进先出
 * 用数组实现队列
 */
public class TomQueue<T> {

    public T data[];

    private int head = 0;
    private int tail = 0;
    private int n = 0; // 数组大小
    private int size = 0;


    /**
     * Initialize your data structure here.
     */
    public TomQueue(int cap) {
        data = (T[]) new Object[cap];
        n = cap;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(T t) {
        if (tail == n) {

            if (size == n) {
                throw new RuntimeException("queue is full");
            } else {
                if (size < (n / 3)) {
                    move();
                }
            }
        }
        data[tail] = t;
        tail++;
        size++;
    }


    private void move() {
        T newData[] = (T[]) new Object[data.length];
        int index = head;
        for (int i = head; i < data.length; i++) {
            newData[head - index] = data[head];
        }
        data = newData;

        head = head - index;
        tail = tail - index;

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T t = data[head];
        data[head] = null;
        head++;
        size--;
        return t;
    }

    /**
     * Get the front element.
     */
    public T peek() {
        return data[head];
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean isEmpty() {
        if (head == tail) return true;
        return false;
    }


    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        TomQueue<Integer> tomQueue = new TomQueue<>(6);
        tomQueue.push(1);
        tomQueue.push(2);
        tomQueue.push(3);
        tomQueue.push(4);
        tomQueue.push(5);
        tomQueue.push(6);

        tomQueue.print();

        tomQueue.pop();
        tomQueue.pop();
        tomQueue.pop();
        tomQueue.pop();
        tomQueue.pop();

        tomQueue.print();

        tomQueue.push(1);
        tomQueue.print();


    }


}
