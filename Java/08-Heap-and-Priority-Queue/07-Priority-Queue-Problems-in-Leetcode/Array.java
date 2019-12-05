/**
 * ClassName: Array
 * Description:
 * date: 2019/10/20 15:26
 *
 * @author crwen
 * @create 2019-10-20-15:26
 * @since JDK 1.8
 */
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