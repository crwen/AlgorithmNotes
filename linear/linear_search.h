//
// Created by crwen on 2021/5/4.
//

#ifndef ALGORITHM_NOTE_LINEAR_SEARCH_H
#define ALGORITHM_NOTE_LINEAR_SEARCH_H

#include <stdio.h>
#include <assert.h>
#include <time.h>

template <typename T>
int search(T arr[], int n, T target) {
    for (int i = 0; i < n; i ++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

int* generateIntArray(int n, int rangeL, int rangeR) {
    assert(rangeL <= rangeR);
    int *arr = new int[n];
    srand(time(NULL));
    for (int i = 0; i < n; i ++) {
        arr[i] = rand() % (rangeR - rangeL) + rangeL;
    }
    return arr;
}





#endif //ALGORITHM_NOTE_LINEAR_SEARCH_H
