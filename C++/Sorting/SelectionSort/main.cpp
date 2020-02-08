#include <iostream>
#include <algorithm>
#include "Student.h"
#include "SortTestHelper.h"

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
        swap(arr[i], arr[minIndex]);
    }
}

int main() {
    int n = 10000;
    int *arr = SortTestHelper::generateRandomArray(n, 0, n);
    selectionSort(arr, n);
    SortTestHelper::printArray(arr, n);
    SortTestHelper::testSort("selectionSort", selectionSort, arr, n);

    delete [] arr;

//    float arr2[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//    selectionSort(arr2, 10);
//    for (int i = 0; i < 10; ++i) {
//        cout << arr2[i] << " ";
//    }
//    cout << endl;
//
//    string s[4] = {"D", "C", "B", "A"};
//    selectionSort(s, 4);
//    for (int i = 0; i < 4; ++i) {
//        cout << s[i] << " ";
//    }
//    cout << endl;
//
//    Student stu[4] = {
//            {"D", 90},
//            {"C", 100},
//            {"B", 95},
//            {"A", 95}
//    };
//    selectionSort(stu, 4);
//    for (int i = 0; i < 4; ++i) {
//        cout << stu[i] ;
//    }


    return 0;
}
