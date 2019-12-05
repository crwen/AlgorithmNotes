#include <iostream>
#include <cstdlib>
#include "adt/Array.h"

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

    cout << "removeFirst()�� " << array->removeFirst() << endl;
    array->print();
    cout << "removeLast()�� " << array->removeLast() << endl;
    array->print();
    cout << "remove(2)�� "  << array->remove(2) << endl;
    cout << "remove(1)�� " << array->remove(1) << endl;
    array->print();

    cout << "contain(1)�� " << array->contain(1) << endl;
    cout << "contain(100)�� " << array->contain(100) << endl;
    cout << "get(1)�� " << array->get(1) << endl;
    cout << "find(1)�� " << array->find(1) << endl;
    array->removeElement(1);
    array->print();


}

int main(){

    array_test();



    return 0;
}
