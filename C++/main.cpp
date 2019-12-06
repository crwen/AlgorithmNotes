#include <iostream>
#include <cstdlib>
#include "adt/Array.h"
#include "adt/ArrayStack.h"

using namespace std;

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

    cout << "removeFirst()£º " << array->removeFirst() << endl;
    array->print();
    cout << "removeLast()£º " << array->removeLast() << endl;
    array->print();
    cout << "remove(2)£º "  << array->remove(2) << endl;
    cout << "remove(1)£º " << array->remove(1) << endl;
    array->print();

    cout << "contain(1)£º " << array->contain(1) << endl;
    cout << "contain(100)£º " << array->contain(100) << endl;
    cout << "get(1)£º " << array->get(1) << endl;
    cout << "find(1)£º " << array->find(1) << endl;
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

int main(){

    //array_test();
    stack_array_test();
    system("pause");


    return 0;
}
