//
// Created by crwen on 2019/12/8.
//

#ifndef DATASTRUCTURE_LIST_H
#define DATASTRUCTURE_LIST_H

template <class T>
class List {
public:
    virtual int getSize() = 0;

    virtual bool isEmpty() = 0;

    virtual T get(int index) = 0;

    virtual void add(T e) = 0;

    virtual T remove(int index) = 0;
};

#endif //DATASTRUCTURE_LIST_H
