//
// Created by crwen on 2021/5/7.
//

#ifndef ALGORITHM_NOTE_ARRAY_H
#define ALGORITHM_NOTE_ARRAY_H
#include <assert.h>
#include <time.h>

/**
 * generate numbers of int
 * @param n：count of numbers to be generate
 * @param rangeL left range of number
 * @param rangeR right range of number
 * @return return a pointer
 */
int* generateIntArray(int n, int rangeL, int rangeR) {
    assert(rangeL <= rangeR);
    int *arr = new int[n];
    srand(time(NULL));
    for (int i = 0; i < n; i ++) {
        arr[i] = rand() % (rangeR - rangeL) + rangeL;
    }
    return arr;
}


#endif //ALGORITHM_NOTE_ARRAY_H
