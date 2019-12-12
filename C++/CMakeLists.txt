cmake_minimum_required(VERSION 3.15)
project(DataStructure)

set(CMAKE_CXX_STANDARD 14)

add_executable(DataStructure main.cpp adt/array/Array.h adt/stack/Stack.h adt/stack/ArrayStack.h adt/queue/Queue.h adt/queue/ArrayQueue.h adt/queue/LoopQueue.h adt/list/List.h adt/list/LinkedList.h adt/stack/LinkedListStack.h adt/queue/LinkedListQueue.h adt/bst/BST.h)
