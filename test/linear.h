//
// Created by crwen on 2021/5/7.
//

#ifndef ALGORITHM_NOTE_LINEAR_H
#define ALGORITHM_NOTE_LINEAR_H

#include <stdio.h>
#include "../linear/linear_search.h"
#include "../util/array.h"

void linear_search_test() {
    int n = 10;
    int *arr = generateIntArray(n, 0, n * 2);
    int taraget = 10;
    for (int i = 0; i < n; i ++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    int idx = search(arr, n, taraget);
    if (idx != -1) {
        printf("find target number: %d\t index: %d, number: %d\n", taraget, idx, arr[idx]);
    } else {
        printf("can not find target number %d in this array\n", taraget);
    }
}
#endif //ALGORITHM_NOTE_LINEAR_H
