/**
 * ClassName: Stack
 * Description:
 * date: 2019/10/21 20:29
 *
 * @author crwen
 * @create 2019-10-21-20:29
 * @since JDK 1.8
 */
public interface Stack<T> {
	int getSize();
	boolean isEmpty();
	void push(T e);
	T pop();
	T peek();
}
