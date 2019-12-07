//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_QUEUE_H
#define DATASTRUCTURE_QUEUE_H

template<class T>
class Queue {
public:
    virtual int getSize() = 0;

    virtual bool isEmpty() = 0;

    virtual void enqueue(T e) = 0;

    virtual T dequeue() = 0;

    virtual T getFront() = 0;
};

#endif //DATASTRUCTURE_QUEUE_H
