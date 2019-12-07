cmake_minimum_required(VERSION 3.15)
project(DataStructure)

set(CMAKE_CXX_STANDARD 14)

add_executable(DataStructure main.cpp adt/Array.h adt/Stack.h adt/ArrayStack.h adt/Queue.h adt/ArrayQueue.h)