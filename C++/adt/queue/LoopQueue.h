//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_LOOPQUEUE_H
#define DATASTRUCTURE_LOOPQUEUE_H

#include "Queue.h"
#include <iostream>
#include <cassert>

template <class T>
class LoopQueue : public Queue<T>{
public:

    LoopQueue(int capacity) {
        this->capacity = capacity;
        data = new T[capacity];
    }

    LoopQueue() {
        capacity = 10;
        data = new T[capacity];
    }

    ~LoopQueue() {
        delete [] data;
        data = nullptr;
    }

    /**
     *  返回 队列中元素个数
     * @return
     */
    int getSize() override {
        return (tail + capacity - front) % capacity;
    }

    /**
     *  返回队列容量
     * @return
     */
    int getCapacity() {
        return capacity;
    }

    /**
     *  队列是否为空
     * @return
     */
    bool isEmpty() override {
        return front == tail;
    }

    /**
     *  元素入队
     * @param e
     */
    void enqueue(T e) override {
        // 判满
        if ((tail + 1) % capacity == front) {
            resize(capacity * 2);
        }
        data[getSize()] = e;
        tail = (tail + 1) % capacity; // 更新队尾
    }

    /**
     *  元素出队
     * @return
     */
    T dequeue() override {
        assert(front != tail); // 判空
        T ret = data[front];
        front = (front + 1) % capacity; // 更新队首

        if (getSize() == capacity / 2 && capacity / 2 != 0)
            resize(capacity / 2);
        return ret;
    }

    /**
     *  获取队首元素
     */
    T getFront() override {
        assert(front != tail); // 判空
        return data[front];
    }

    /**
     *  打印元素
     */
    void print() {
        std::cout << "Queue: size = " << getSize() << ", capacity = " <<  getCapacity() << std::endl;
        std::cout << "front [ ";
        for (int i = front; i != tail; i = (i + 1) % capacity) {
            std::cout << data[i];
            if ((i + 1) % capacity != tail)
                std::cout << ", ";
        }
        std::cout << " ] tail" << std::endl;
    }

private:
    T *data;
    int front, tail; // 队首、尾
    int capacity; // 容量

    /**
     *  修改容量
     * @param newCapacity
     */
    void resize(int newCapacity) {
        T *newData = new T[newCapacity + 1];
        for (int i = 0; i < getSize(); ++i) {
            newData[i] = data[(i + front) % capacity];
        }
        data = newData;
        tail = getSize();
        front = 0;
        capacity = newCapacity;
    }
};


#endif //DATASTRUCTURE_LOOPQUEUE_H
