cmake_minimum_required(VERSION 3.15)
project(QuickSort)

set(CMAKE_CXX_STANDARD 14)

add_executable(QuickSort main.cpp SortTestHelper.h MergeSort.h)