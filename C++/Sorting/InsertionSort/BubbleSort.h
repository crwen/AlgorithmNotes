//
// Created by crwen on 2020/2/8.
//

#ifndef INSERTIONSORT_BUBBLESORT_H
#define INSERTIONSORT_BUBBLESORT_H
#include <iostream>
#include <algorithm>
using namespace std;

template <typename T>
void bubbleSort(T arr[], int n) {

    for (int i = 0; i < n; ++i) {
        bool flag = true;
        for (int j = 0; j < n - 1 - i; ++j) {
            if (arr[j+1] < arr[j]) {
                swap(arr[i], arr[j]);
                flag = false;
            }
        }
        if (flag)
            break;

    }
}
#endif //INSERTIONSORT_BUBBLESORT_H
