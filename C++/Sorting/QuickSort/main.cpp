#include <iostream>
#include "SortTestHelper.h"
#include "MergeSort.h"

template <typename T>
int partition(T arr[], int low, int high) {

    T v = arr[low];
    int j = low;
    for (int i = low + 1; i <= high; i++) {
        if (arr[i] < v) {
            swap(arr[i], arr[j+1]);
            j++;
        }
    }
    swap(arr[low], arr[j]);
    return j ;
}


template <typename T>
int partition2(T arr[], int low, int high) {

    T v = arr[low];

    int i = low + 1;
    int j = high;
    while (i <= j) {
        while (i <= high && arr[i] < v) {
            i++;
        }
        while (j >= low + 1 && arr[j] > v) {
            j--;
        }
        if (i > j)
            break;
        swap(arr[i], arr[j]);
        i++;
        j--;
    }
    swap(arr[low], arr[j]);
    return j;
}

template <typename T>
void __quickSort(T arr[], int low, int high) {
    if (low >= high)
        return;
    int p = partition2(arr, low, high);
    __quickSort(arr, low, p - 1);
    __quickSort(arr, p + 1, high);
}

template <typename T>
void quickSort(T arr[], int n) {
    __quickSort(arr, 0, n - 1);
}


int main() {

    int n = 10000;
    int *arr = SortTestHelper::generateRandomArray(n, 0, 10);
    int *arr2 = SortTestHelper::copyIntArray(arr, n);
    SortTestHelper::testSort("quickSort", quickSort, arr, n);
    SortTestHelper::testSort("mergeSort", mergeSort, arr2, n);

    return 0;
}