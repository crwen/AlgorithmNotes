#include <iostream>
#include <cstdlib>
#include "adt/Array/Array.h"
#include "adt/Stack/ArrayStack.h"
#include "adt/Queue/ArrayQueue.h"
#include "adt/Queue/LoopQueue.h"
#include "adt/list/LinkedList.h"
#include "adt/stack/LinkedListStack.h"
#include "adt/queue/LinkedListQueue.h"
#include "adt/bst/BST.h"
#include <ctime>
using namespace std;

void array_test();
void stack_array_test();
void queue_array_test();
void loop_queue_test();
void linkedlist_test();
void stack_list_test();
void queue_list_test();
void bst_test();


int main() {

//    array_test();
//    stack_array_test();
//    queue_array_test();
//    loop_queue_test();
//    linkedlist_test();
//    stack_list_test();
//    queue_list_test();
    bst_test();
//    system("pause");

    return 0;
}


void array_test() {
    Array<int> *array = new Array<int>();

    array->addFirst(1);
    array->addLast(2);
    array->addLast(3);
    array->print();
    array->addLast(5);
    array->addFirst(0);
    array->add(4, 400);
    array->print();

    cout << "removeFirst() " << array->removeFirst() << endl;
    array->print();
    cout << "removeLast() " << array->removeLast() << endl;
    array->print();
    cout << "remove(2) " << array->remove(2) << endl;
    cout << "remove(1) " << array->remove(1) << endl;
    array->print();

    cout << "contain(1) " << array->contain(1) << endl;
    cout << "contain(100) " << array->contain(100) << endl;
    cout << "get(1) " << array->get(1) << endl;
    cout << "find(1) " << array->find(1) << endl;
    array->removeElement(1);
    array->print();

}

void stack_array_test() {
    ArrayStack<int> *stack = new ArrayStack<int>();
    stack->push(1);
    stack->push(2);
    stack->push(3);
    stack->push(4);
    stack->push(5);
    stack->push(6);
    stack->print();
    cout << "stack->pop() " << stack->pop() << endl;
    stack->print();
}

void queue_array_test() {
    ArrayQueue<int> *queue = new ArrayQueue<int>();
    for (int i = 0; i < 5; i++) {
        queue->enqueue(i);
    }
    queue->print();
    int e = queue->dequeue();
    cout << "dequeue() " << e << endl;
    cout << "getFront() " << queue->getFront() << endl;

    queue->print();
}

void loop_queue_test() {
    LoopQueue<int> *queue = new LoopQueue<int>();
    for (int i = 0; i < 5; i++) {
        queue->enqueue(i);
    }
    queue->print();
    while (!queue->isEmpty()) {
        cout << "getFront: " << queue->getFront() << "\t";
        cout << "dequeue: " << queue->dequeue() << endl;
    }

}

void linkedlist_test() {
    LinkedList<int> *list = new LinkedList<int>();
    for (int i = 0; i < 5; i++)
        list->addLast(i);
    list->add(3, 10000);
    list->addFirst(-1);
    list->print();
    cout << "removeFirst: " << list->removeFirst();
    cout << "removeLast: " << list->removeLast();
    list->print();
    cout << "removeElement(10000): \n";
    list->removeElement(10000);
    cout << "removeElement(100): \n";
    list->removeElement(1000);
    list->print();
}

void stack_list_test() {
    LinkedListStack<int> *stack = new LinkedListStack<int>();
    stack->push(1);
    stack->push(2);
    stack->push(3);
    stack->push(4);
    stack->push(5);
    stack->push(6);
    stack->print();
    cout << "stack->pop() " << stack->pop() << endl;
    stack->print();
}

void queue_list_test() {
    LinkedListQueue<int> *queue = new LinkedListQueue<int>();
    for (int i = 0; i < 5; i++) {
        queue->enqueue(i);
    }
    queue->print();
    int e = queue->dequeue();
    cout << "dequeue() " << e << endl;
    cout << "getFront() " << queue->getFront() << endl;

    queue->print();
}

void bst_test() {
    BST<int> *bst = new BST<int>();
    srand(time(0));
    for (int i = 0;i < 10; i++) {
        bst->add(rand());
    }
    bst->inOrder();
    bst->preOrder();
    bst->postOrder();

    cout << bst->getSize() << endl;
}