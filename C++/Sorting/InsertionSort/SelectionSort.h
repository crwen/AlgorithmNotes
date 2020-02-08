//
// Created by crwen on 2020/2/8.
//

#ifndef INSERTIONSORT_SELECTIONSORT_H
#define INSERTIONSORT_SELECTIONSORT_H

#include <iostream>
#include <algorithm>
using namespace std;

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

#endif //INSERTIONSORT_SELECTIONSORT_H
