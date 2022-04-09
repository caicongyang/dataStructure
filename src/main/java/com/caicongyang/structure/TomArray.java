package com.caicongyang.structure;

/**
 * 数组
 *
 * @param <T>
 */
public class TomArray<T> {

    //当前数组大小
    private Integer capacity;


    private Integer lenth = 0;

    private int defaultInitialCapacity = 16;


    public Object[] array;

    public TomArray() {
        this.capacity = defaultInitialCapacity;
        array = new Object[defaultInitialCapacity];
    }

    public TomArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    /**
     * 增加
     *
     * @param loc
     * @param t
     */
    public void insert(int loc, T t) {
        lenth++;
        //扩容
        if (lenth > capacity) {
            array = expansion(array);
        }
        if (null == get(loc)) {
            update(loc, t);
        } else {
            for (int i = capacity - 1; i > loc; i--) {
                array[i] = array[i - 1];  // 数据后移
            }
            array[loc] = t;
        }
    }

    /**
     * 删除
     *
     * @param loc
     */
    public void delete(int loc) {
        lenth--;
        for (int i = loc; i < capacity; i++) {
            if (i == capacity - 1) {  //数组越界
                array[i] = null;
            } else {
                array[i] = array[i + 1]; // 数据前移
            }
        }
    }


    /**
     * 默认扩容2倍
     *
     * @param oldArr
     * @return
     */
    private Object[] expansion(Object[] oldArr) {
        capacity = oldArr.length * 2;
        Object[] newArr = new Object[capacity];
        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);

        return newArr;
    }


    /**
     * update
     *
     * @param loc
     * @param t
     */
    public void update(int loc, T t) {
        array[loc] = t;
    }

    /**
     * get
     *
     * @param loc
     * @return
     */
    public T get(int loc) {
        return (T) array[loc];
    }


    /**
     * 数组大小
     *
     * @return
     */
    public Integer getLenth() {
        return lenth;
    }


    /**
     * print
     */
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        TomArray tom = new TomArray<Integer>(3);
        tom.insert(0, 1);
        tom.insert(1, 2);
        tom.insert(2, 3);

//        tom.print();
//
//        System.out.println("---------");
//        tom.delete(0);
//        tom.print();
//
//
//
//        System.out.println("---------");
//
//        tom.insert(2,4);
//        tom.print();
//
//
//
//        System.out.println("---------");

        tom.insert(3, 5);
        tom.print();


    }

}
