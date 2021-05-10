//
// Created by crwen on 2021/5/10.
//

#ifndef ALGORITHM_NOTE_SELECTION_SORT_H
#define ALGORITHM_NOTE_SELECTION_SORT_H

template <typename T>
void swap(T *a, T *b) {
    T tmp = *a;
    *a = *b;
    *b = tmp;
}

// 每次选择数组中最小的元素
template <typename T>
void selection_sort(T *arr, int n) {
    int i, j;
    for (i = 0; i < n; i ++) {
        int minIndex = i;
        for (j = i + 1; j < n; j ++) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }
        swap(&arr[i], &arr[minIndex]);
    }
}



#endif //ALGORITHM_NOTE_SELECTION_SORT_H
