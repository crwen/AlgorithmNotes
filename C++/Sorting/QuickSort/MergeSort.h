//
// Created by crwen on 2020/2/11.
//

#ifndef QUICKSORT_MERGESORT_H
#define QUICKSORT_MERGESORT_H

template <typename T>
void merge(T arr[], int low, int mid, int high) {
    T* aux = new int[high - low + 1];
    for (int i = low; i <= high; i++) {
        aux[i - low] = arr[i];
    }

    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
        if (i > mid) {
            arr[k] = aux[j - low];
            j++;
        } else if (j > high) {
            arr[k] = aux[i - low];
            i++;
        } else if (aux[i - low] < aux[j - low]) {
            arr[k] = aux[i - low];
            i++;
        } else {
            arr[k] = aux[j - low];
            j++;
        }
    }
}

template <typename T>
void __mergeSort(T arr[], int low, int high) {
    if (low >= high)
        return;
    int mid = (high - low) / 2 + low;
    __mergeSort(arr, low, mid);
    __mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
}

template <typename T>
void mergeSort(T arr[], int n) {

    __mergeSort(arr, 0, n - 1);
}

#endif //QUICKSORT_MERGESORT_H
