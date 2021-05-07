#include <iostream>
#include "linear/linear_search.h"

void linear_search_test() {
    int n = 10;
    int *arr = generateIntArray(n, 0, n * 2);
    for (int i = 0; i < n; i ++) {
//        printf("%d ", arr[i]);
        std::cout << arr[i] << " ";
    }
//    printf("\n");
    std::cout << std::endl;
    int idx = search(arr, n, 10);
    if (idx != -1) {
        std::cout << idx << " " << arr[idx] << std::endl;
    } else {
        std::cout << "can not find the target\n";
    }
}

int main() {
    linear_search_test();
    return 0;
}
