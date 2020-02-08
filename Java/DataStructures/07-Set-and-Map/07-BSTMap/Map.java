/**
 * ClassName: Map
 * Description:
 * date: 2019/10/29 18:02
 *
 * @author crwen
 * @create 2019-10-29-18:02
 * @since JDK 1.8
 */
public interface Map<K, V> {

	public void add(K key, V value);

	public V remove(K key);

	public boolean contains(K key);

	public void set(K key, V newValue);

	public V get(K key);

	public int getSize();

	public boolean isEmpty();
}
