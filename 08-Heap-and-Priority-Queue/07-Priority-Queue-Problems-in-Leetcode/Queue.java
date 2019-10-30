/**
 * ClassName: Queue
 * Description:
 * date: 2019/10/22 20:26
 *
 * @author crwen
 * @create 2019-10-22-20:26
 * @since JDK 1.8
 */
public interface Queue<T> {

	int getSize();

	boolean isEmpty();

	void enqueue(T e);

	T dequeue();

	T getFront();

}
