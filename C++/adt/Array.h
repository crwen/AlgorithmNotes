//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_ARRAY_H
#define DATASTRUCTURE_ARRAY_H

#include <iostream>
#include <cassert>

template<class T>
class Array {
private:
    T *data;
    int size;
    int capacity;
    const int DEFAULT_CAPACITY = 5;


    /**
     * 修改容量
     */
    void resize(int newCapacity) {
        T *newData = new T[newCapacity];
        for (int i = 0; i < size; ++i) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }

public:
    Array(int capacity) {
        data = new T[capacity];
        size = 0;
        this->capacity = capacity;
    }

    Array() {
        data = new T[DEFAULT_CAPACITY];
        size = 0;
        this->capacity = DEFAULT_CAPACITY;
    }

    /**
     * 返回数组长度
     */
    int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     */
    int getCapacity() {
        return capacity;
    }

    /**
     * 判断是否为空
     */
    bool isEmpty() {
        return size == 0;
    }

    /**
     * 在数组尾添加元素 e
     */
    void addLast(T e) {
        add(size, e);
    }

    /**
     * 在下标为 0 出添加元素 e
     */
    void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在下标为 index 处添加 元素 e
    */
    void add(int index, T e) {
        assert(index >= 0 && index <= size);
        // 扩容
        if (size == capacity) {
            resize(2 * capacity);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 删除最后一个元素并返回
     */
    T removeLast() {

        return remove(size - 1);
    }
    /**
     * 删除第一个元素并返回
     */
    T removeFirst() {
        return remove(0);
    }

    /**
     * 删除下标为 index 处元素 e，并返回
     */
    T remove(int index) {
        assert(index >= 0 && index < size);
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size <= capacity / 4 && capacity / 2 != 0) {
            resize(capacity / 2);
        }
        return ret;
    }

    /**
     * 删除元素 e
     */
    bool removeElement(T e) {
        int index = find(e);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * 获取下标为 index 的元素
     */
    T get(int index) {
        assert(index >= 0 && index < size);
        return data[index];
    }

    T getFirst() {
        return get(0);
    }

    T getLast() {
        return get(size);
    }

    /**
     * 判断数组中是否包含元素 e
     */
    bool contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素，并返回小标。 如果没有返回 -1
     */
    int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 修改下标为 index 处元素为 e , 返回原来元素
     */
    T set(int index, T e) {
        assert(index >= 0 && index < size);
        T ret = data[index];
        data[index] = e;
        return ret;
    }

    /**
     * 打印数组的所有元素
     */
    void print() {
        std::cout << "Array: size = " << size << ", capacity = " << getCapacity() << std::endl;
        toPrint();
        std::cout << std::endl;
    }

    void toPrint() {
        std::cout << "[ ";
        for (int i = 0; i < size - 1; i++) {
            std::cout << data[i] << ", ";
        }
        std::cout << data[size - 1] << " ]\n";
    }

};

#endif //DATASTRUCTURE_ARRAY_H
