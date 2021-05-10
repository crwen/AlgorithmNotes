cmake_minimum_required(VERSION 3.17)
project(Algorithm_Note)

set(CMAKE_CXX_STANDARD 14)

add_executable(Algorithm_Note main.cpp linear/linear_search.h util/array.h test/linear.h sort/selection_sort.h test/sort.h)