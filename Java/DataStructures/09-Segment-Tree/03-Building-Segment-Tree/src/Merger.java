/**
 * ClassName: Merger
 * Description:
 * date: 2019/11/14 16:54
 *
 * @author crwen
 * @create 2019-11-14-16:54
 * @since JDK 1.8
 */
public interface Merger<T> {
	T merge(T a, T b);
}
