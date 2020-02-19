/**
 * ClassName: MaxPQ
 * Description:
 * date: 2020/2/19 16:12
 *
 * @author crwen
 * @create 2020-02-19-16:12
 * @since JDK 1.8
 */
public interface PriorityQueue<Key extends Comparable<Key>> {

	void insert(Key v);

	Key max();

	Key delMax();

	boolean isEmpty();

	int size();
}

