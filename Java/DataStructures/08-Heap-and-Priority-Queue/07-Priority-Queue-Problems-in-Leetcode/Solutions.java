import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * ClassName: Solutions
 * Description:
 * date: 2019/10/30 19:55
 *
 * @author crwen
 * @create 2019-10-30-19:55
 * @since JDK 1.8
 */
public class Solutions {

	public class Array<T> {

		private T[] data;
		private int size;

		// 构造函数，传入数组的容量capacity构造Array
		public Array(int capacity) {
			data = (T[]) new Object[capacity];
			this.size = 0;
		}

		// 无参构造函数，默认数组的容量capacity=10
		public Array() {
			this(10);
		}

		public Array(T[] arr){
			data = (T[]) new Object[arr.length];
			for(int i = 0 ; i < arr.length; i++)
				data[i] = arr[i];
			size = arr.length;
		}

		//获取数组中的元素个数
		public int getSize() {
			return this.size;
		}

		//获取数组容量
		public int getCapacity() {
			return data.length;
		}

		//判断数组是否为空
		public boolean isEmpty() {
			return this.size == 0;
		}

		//在数组末尾添加一个新元素
		public void addLast(T e) {
			this.add(size, e);
		}

		//在数组首部添加一个元素
		public void addFirst(T e) {
			this.add(0, e);
		}

		//在第index个位置插入一个新元素
		public void add(int index, T e) {
			if (index < 0 || index > size) {
				throw new IllegalArgumentException("Add Fail! Requild index < 0 || index > size");
			}
			if (size  == data.length) {
				resize(2 * data.length);
			}

			for (int i = size -1; i >= index; i--) {
				data[i + 1] = data[i];
			}
			data[index] = e;
			size++;

		}

		// 获取index索引位置的元素
		public T get(int index) {
			if (index < 0 || index >= size) {
				throw new IllegalArgumentException("Get Failed. Index is illegal");
			}
			return data[index];
		}

		// 修改index索引位置的元素为e
		public void set(int index, T e) {
			if (index < 0 || index >= size) {
				throw new IllegalArgumentException("Get Failed. Index is illegal");
			}
			data[index] = e;
		}

		// 查找数组中是否有元素e
		public boolean contains(T e) {
			for (int i = 0; i < size; i++) {
				if (data[i].equals(e)) {
					return true;
				}
			}
			return false;
		}

		//查找数组中元素e所在的索引，如果找不到返回-1
		public int find(T e) {
			for (int i = 0; i < size; i++) {
				if (data[i].equals(e)) {
					return i;
				}
			}
			return -1;
		}

		// 从数组中删除index位置的元素，并返回删除的元素
		public T remove(int index) {
			if (index < 0 || index >= size) {
				throw new IllegalArgumentException("Remove failed. Index is illegal");
			}
			if (size == data.length / 4 && data.length / 2 != 0 ){
				resize(data.length / 2);
			}
			T e = data[index];
			for (int i = index + 1; i < size; i++) {
				data[i - 1] = data[i];
			}
			size--;
			data[size] = null;
			return e;
		}

		// 从数组中删除第一个元素并返回
		public T removeFirst() {
			return remove(0);
		}

		// 从数组中删除最后一个元素并返回
		public T removeLast() {
			return remove(size - 1);
		}

		public boolean removeElement(T e) {
			int index = find(e);
			if (index != -1) {
				remove(index);
				return true;
			}
			return false;
		}

		public void resize(int newCapacity) {
			T[] newdata = (T[]) new Object[newCapacity];
			for (int i = 0; i < size; i++) {
				newdata[i] = data[i];
			}
			data = newdata;
		}

		public void swap(int i, int j) {
			if (i < 0 || i > size || j < 0 || j > size) {
				throw new IllegalArgumentException("Index is illegal");
			}
			T t = data[i];
			data[i] = data[j];
			data[j] = t;
		}

		@Override
		public String toString() {
			StringBuilder res = new StringBuilder();
			res.append(String.format("Array：size = %d, capacity = %d\n", size, data.length));
			res.append("[");
			for (int i = 0; i < size; i++) {
				res.append(data[i]);
				if (i != size - 1) {
					res.append(", ");
				}
			}
			res.append("]");
			return res.toString();
		}
	}

	public class MaxHeap<T extends Comparable<T>> {

		private Array<T> data;

		public MaxHeap(int capacity) {
			data = new Array<>(capacity);
		}

		public MaxHeap() {
			data = new Array<>();
		}

		public MaxHeap(T[] arr) {
			data = new Array<T>(arr);
			for (int i = parent(arr.length - 1); i >= 0; i--) {
				siftDown(i);
			}
		}

		// 返回堆中元素个数
		public int size() {
			return data.getSize();
		}

		// 返回一个布尔值，表示堆中是否为空
		public boolean isEmpty() {
			return data.isEmpty();
		}

		// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
		private int parent(int index) {
			if (index == 0)
				throw new IllegalArgumentException("indexx-0 doesn't have parent");
			return (index - 1) / 2;
		}

		// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
		private int rightChild(int index) {
			return index * 2 + 2;
		}

		// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
		private int leftChild(int index) {
			return index * 2 + 1;
		}

		// 向堆中添加元素
		public void add(T e) {
			data.addLast(e);
			siftUp(data.getSize() - 1);
		}

		private void siftUp(int k) {
			while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
				data.swap(k, parent(k));
				k = parent(k);
			}
		}

		// 取出堆中最大元素
		public T extractMax() {
			T res = findMax();
			data.swap(0, data.getSize() - 1);
			data.removeLast();
			siftDown(0);

			return res;
		}

		// 查看堆中的最大元素
		public T findMax() {
			if (isEmpty())
				throw new IllegalArgumentException("The heap is empty!");
			return data.get(0);
		}

		private void siftDown(int k) {
			while (leftChild(k) < data.getSize()) {

				int left = leftChild(k);
				int right = left + 1;
				int max = left;
				if (right < data.getSize() &&
						data.get(right).compareTo(data.get(left)) > 0)
					max = rightChild(k);
				// data[max] 时leftChild 和rightChild中的最大值

				if (data.get(k).compareTo(data.get(max)) > 0)
					break;

				data.swap(k, max);
				k = max;
			}
		}

		// 取出堆中的最大元素，并且替换成元素 e
		public T replace(T e) {
			T res = findMax();
			data.set(0, e);
			siftDown(0);
			return res;
		}


		public void heapify(T[] arr) {
			int k =  parent(arr.length - 1);
			while (k-- >= 0) {
				siftDown(k);
			}
		}

	}


	public class PriorityQueue<T extends Comparable<T>> {

		private MaxHeap<T> maxHeap;

		public PriorityQueue() {
			maxHeap = new MaxHeap<>();
		}

		public int getSize() {
			return maxHeap.size();
		}

		public boolean isEmpty() {
			return maxHeap.isEmpty();
		}

		public void enqueue(T e) {
			maxHeap.add(e);
		}

		public T dequeue() {
			//if (maxHeap == null)
			//	throw new IllegalArgumentException("The queue is empty!");
			return maxHeap.extractMax();
		}

		public T getFront() {
			return maxHeap.findMax();
		}
	}


	private class Freq implements Comparable<Freq>{
		public int e, freq;

		public Freq(int e, int freq) {
			this.e = e;
			this.freq = freq;
		}
		@Override
		public int compareTo(Freq another) {
			if (this.freq < another.freq)
				return 1;
			else if (this.freq > another.freq)
				return -1;
			else
				return 0;
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (Integer n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		PriorityQueue<Freq> pq = new PriorityQueue<>();
		for (int key : map.keySet()) {
			if (pq.getSize() < k) {
				pq.enqueue(new Freq(key, map.get(key)));
			} else {
				Freq front = pq.getFront();
				if (front.freq < map.get(key)) {
					pq.dequeue();
					pq.enqueue(new Freq(key, map.get(key)));
				}
			}
		}

		LinkedList<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.dequeue().e);
		}
		return res;
	}
}

