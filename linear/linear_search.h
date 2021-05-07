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



#endif //ALGORITHM_NOTE_LINEAR_SEARCH_H
