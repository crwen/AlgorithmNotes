#include <iostream>
#include <algorithm>
#include "SortTestHelper.h"

// 合并 [range, rangeR]
template <typename T>
void merge(T arr[], int rangeL, int mid, int rangeR) {

    T* aux = new int[rangeR - rangeL + 1];
    for (int i = rangeL; i <= rangeR; i++) {
        aux[i - rangeL] = arr[i];
    }

    int i = rangeL, j = mid + 1;
    for (int k = rangeL; k <= rangeR; k++) {
        if (i > mid) { // 如果左半部分已经处理完毕
            arr[k] = aux[j - rangeL];
            j++;
        } else if (j > rangeR) { // 如果右半部分已经处理完毕
            arr[k] = aux[i - rangeL];
            i++;
        } else if (aux[i - rangeL] < aux[j - rangeL]) {
            arr[k] = aux[i - rangeL];
            i++;
        } else {
            arr[k] = aux[j - rangeL];
            j++;
        }
    }


}

template <typename T>
void __mergeSort(T arr[], int rangeL, int rangeR) {
    if (rangeL >= rangeR) {
        return ;
    }

    int mid = (rangeR - rangeL) / 2 + rangeL;
    __mergeSort(arr, rangeL, mid);
    __mergeSort(arr, mid + 1, rangeR);
    if (arr[mid] > arr[mid + 1])
        merge(arr, rangeL, mid, rangeR);

}

void mergeSort(int arr[], int n) {
    __mergeSort(arr, 0, n - 1);
}


template <typename T>
void selectionSort(T arr[], int n) {
    for (int i = 0; i < n; ++i) {
        int minIndex = i;
        for (int j = i + 1; j < n; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[minIndex], arr[i]);
    }
}


int main() {

    int n = 1000000;
    int* arr = SortTestHelper::generateRandomArray(n, 0, n);
    int* arr2 = SortTestHelper::copyIntArray(arr, n);

//    SortTestHelper::testSort("selectionSort", selectionSort, arr2, n);
    SortTestHelper::testSort("mergeSort", mergeSort, arr, n);

    return 0;
}
