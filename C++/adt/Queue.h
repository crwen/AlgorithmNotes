//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_QUEUE_H
#define DATASTRUCTURE_QUEUE_H

template<class T>
class Queue {
public:
    int getSize();

    bool isEmpty();

    void enqueue(T e);

    T dequeue();

    T getFront();
};

#endif //DATASTRUCTURE_QUEUE_H
