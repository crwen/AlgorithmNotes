//
// Created by crwen on 2021/5/10.
//

#ifndef ALGORITHM_NOTE_SORT_H
#define ALGORITHM_NOTE_SORT_H
#include <stdio.h>
#include "../sort/selection_sort.h"
#include "../util/array.h"

bool is_sorted(int *arr, int n) {
    int i = 1;
    for (i = 1; i < n; i ++) {
        if (arr[i] < arr[i-1]) {
            return false;
        }
    }
    return true;
}

void selection_sort_test() {
    int n = 10000;
    int *arr = generateIntArray(n, 0, 2 * n);
    selection_sort(arr, n);
    if (!is_sorted(arr, n)) {
        printf("the array is not sorted!");
    }
}





#endif //ALGORITHM_NOTE_SORT_H
