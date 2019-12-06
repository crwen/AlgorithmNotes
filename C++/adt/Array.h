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
     * �޸�����
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
     * �������鳤��
     */
    int getSize() {
        return size;
    }

    /**
     * ������������
     */
    int getCapacity() {
        return capacity;
    }

    /**
     * �ж��Ƿ�Ϊ��
     */
    bool isEmpty() {
        return size == 0;
    }

    /**
     * ������β���Ԫ�� e
     */
    void addLast(T e) {
        add(size, e);
    }

    /**
     * ���±�Ϊ 0 �����Ԫ�� e
     */
    void addFirst(T e) {
        add(0, e);
    }

    /**
     * ���±�Ϊ index ����� Ԫ�� e
    */
    void add(int index, T e) {
        assert(index >= 0 && index <= size);
        // ����
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
     * ɾ�����һ��Ԫ�ز�����
     */
    T removeLast() {

        return remove(size - 1);
    }
    /**
     * ɾ����һ��Ԫ�ز�����
     */
    T removeFirst() {
        return remove(0);
    }

    /**
     * ɾ���±�Ϊ index ��Ԫ�� e��������
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
     * ɾ��Ԫ�� e
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
     * ��ȡ�±�Ϊ index ��Ԫ��
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
     * �ж��������Ƿ����Ԫ�� e
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
     * ����Ԫ�أ�������С�ꡣ ���û�з��� -1
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
     * �޸��±�Ϊ index ��Ԫ��Ϊ e , ����ԭ��Ԫ��
     */
    T set(int index, T e) {
        assert(index >= 0 && index < size);
        T ret = data[index];
        data[index] = e;
        return ret;
    }

    /**
     * ��ӡ���������Ԫ��
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

#endif // DATASTRUCTURE_ARRAY_H
