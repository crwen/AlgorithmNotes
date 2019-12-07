//
// Created by crwen on 2019/12/7.
//

#ifndef DATASTRUCTURE_STACK_H
#define DATASTRUCTURE_STACK_H

template<class T>
class Stack {
public:
    virtual int getSize() = 0;

    virtual bool isEmpty() = 0;

    virtual void push(T e) = 0;

    virtual T pop() = 0;

    virtual T peek() = 0;
};

#endif //DATASTRUCTURE_STACK_H
