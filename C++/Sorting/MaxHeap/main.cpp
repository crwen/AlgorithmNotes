#include <iostream>
#include <cassert>
#include "MaxHeap.h"
#include "SortTestHelper.h"
using namespace std;

void test_max_heap() {
    MaxHeap<int> maxHeap = MaxHeap<int>(100);

    srand(time(NULL));
    for (int i = 0; i < 15; i++) {
        maxHeap.insert(rand() % 100);
    }
    cout << maxHeap.size() << endl;
    maxHeap.testPrint();

//    maxHeap.heap();
//    maxHeap.testPrint();

    int size = maxHeap.size();
    for (int j = 0; j < size; ++j) {
        cout << maxHeap.heap() << " ";
    }
    cout << endl;
}

template <typename T>
void shiftUp(T arr[], int k) {
    T v = arr[k];
    while (k  > 0 && arr[(k - 1) / 2] > v) {
        arr[k] = arr[(k - 1) / 2];
        k = (k - 1) / 2;
    }
    arr[k] = v;
}

template <typename T>
void shiftDown(T arr[], int k, int size) {
    T v=  arr[k];
    while (k * 2 + 1 < size ) {
        int j = k * 2 + 1;
        if (j + 1 < size && arr[j] > arr[j + 1])
            j += 1;
        if (arr[j] >= v)
            break;
        arr[k] = arr[j];
        k = j;
    }
    arr[k] = v;
}

template <typename T>
void heapSort1(T arr[], int n) {

    T* heap = new T[n];
    int size = 0;
    for (int i = 0; i < n; i++) {
        heap[i] = arr[i];
        size++;
        shiftUp(heap, i);
    }
//    for (int i = (size - 2) / 2; i >= 0; i--) {
//        shiftDown(heap, i, size);
//    }

    for (int i = 0; i < n; i++) {
        arr[i] = heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(heap, 0, size);
    }

}

template <typename T>
void heapSort2(T arr[], int n) {

    T* heap = new T[n];
    int size = 0;
    for (int i = 0; i < n; i++) {
        heap[i] = arr[i];
        size++;
    }
    for (int i = (size - 2) / 2; i >= 0; i--) {
        shiftDown(heap, i, size);
    }

    for (int i = 0; i < n; i++) {
        arr[i] = heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(heap, 0, size);
    }

}

template <typename T>
void heapSort3(T arr[], int n) {

    for (int i = (n - 2) / 2; i >= 0; i--) {
        shiftDown(arr, i, n);
    }

    for (int i = 0; n > 0; i++) {
        swap(arr[n - 1], arr[0]);
        n--;
        shiftDown(arr, 0, n);
    }

}

int main() {
    int n = 100000;
    int* arr = SortTestHelper::generateRandomArray(n, 0, n);
    int* arr2 = SortTestHelper::generateRandomArray(n, 0, n);
    int* arr3 = SortTestHelper::generateRandomArray(n, 0, n);

    SortTestHelper::testSort("heapSort1", heapSort1, arr, n);
    SortTestHelper::testSort("heapSort2", heapSort2, arr3, n);
heapSort3(arr, n);

    for (int i = 0; i < n; i++)
        arr2[i] = arr[n - i - 1];
    cout << SortTestHelper::isSorted(arr2, n);
    cout << endl;
    return 0;
}
