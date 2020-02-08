/**
 * ClassName: UF
 * Description:
 * date: 2019/12/7 14:53
 *
 * @author crwen
 * @create 2019-12-07-14:53
 * @since JDK 1.8
 */
public interface UF {

	int getSize();

	boolean isConnection(int p, int q);

	void unionElements(int p, int q);
}
