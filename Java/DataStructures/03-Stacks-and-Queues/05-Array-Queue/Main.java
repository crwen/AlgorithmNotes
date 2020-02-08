/**
 * ClassName: Main
 * Description:
 * date: 2019/10/22 20:22
 *
 * @author crwen
 * @create 2019-10-22-20:22
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) {

		ArrayQueue<Integer> queue = new ArrayQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if (i % 3 == 2)
				queue.dequeue();
		}
	}
}
