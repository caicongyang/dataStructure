package com.caicongyang.structure;

/**
 * 动态数组，容器
 * 实现一个支持动态扩容的数组
 *
 *
 */
public class DynamicArray<T> {


    private int initialCapacity = 16;


    //声明初始数组
    private Object[] array;

    private Integer size = 0;

    /**
     * 在对象被创建时创建数组，初始大小为0
     */
    public DynamicArray() {
        array = new Object[initialCapacity];
    }


    public Boolean add(T record) {
        size++;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = record;
                return true;
            }
        }

        //增加数组2倍长度
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = record;
        array = newArray;
        return true;

    }


    public Integer size() {

        return size;
    }


    public DynamicArray(int capacity) {
        array = new Object[capacity];
    }


    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);


        System.out.println(array.size());
    }
}
