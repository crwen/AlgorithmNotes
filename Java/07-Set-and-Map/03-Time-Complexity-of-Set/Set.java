/**
 * ClassName: Set
 * Description:
 * date: 2019/10/29 16:02
 *
 * @author crwen
 * @create 2019-10-29-16:02
 * @since JDK 1.8
 */
public interface Set<T> {

	public void add(T e);

	public void remove(T e);

	public boolean contains(T e);

	public int getSize();

	public boolean isEmpty();
}
