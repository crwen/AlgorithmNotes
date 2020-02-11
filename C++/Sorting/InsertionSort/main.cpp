#include <iostream>
#include <algorithm>
#include "SortTestHelper.h"
#include "SelectionSort.h"
#include "BubbleSort.h"

using namespace std;

template <typename T>
void insertionSort(T arr[], int n) {
    for (int i = 1; i < n; ++i) {

        T e = arr[i];
        int j; // j保存元素e应该插入的位置
        for (j = i; j > 0 && e < arr[j-1]; j--) {
            arr[j] = arr[j-1];
        }
        arr[j] = e;
    }
}


int main() {

    int n = 10000;
    int *arr = SortTestHelper::generateRandomArray(n, 0, n);
    int *arr2 = SortTestHelper::copyIntArray(arr, n);

    SortTestHelper::testSort("insertionSort", insertionSort, arr, n);
    SortTestHelper::testSort("selectionSort", selectionSort, arr2, n);
//    SortTestHelper::testSort("bubbleSort", bubbleSort, arr, n);

    cout << "==========================near sorted array==========================\n";

    int *arr3 = SortTestHelper::generateNearlyOrderedArray(n, n / 10);
    int *arr4 = SortTestHelper::copyIntArray(arr, n);
    SortTestHelper::testSort("insertionSort", insertionSort, arr, n);
    SortTestHelper::testSort("selectionSort", selectionSort, arr, n);
    SortTestHelper::testSort("bubbleSort", bubbleSort, arr, n);

    delete [] arr;

    return 0;
}
