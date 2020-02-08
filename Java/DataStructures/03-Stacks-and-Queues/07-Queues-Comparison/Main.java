import java.util.Random;

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

	private static double testQueue(Queue<Integer> q, int opCount) {
		long startTime = System.nanoTime();

		Random random = new Random();
		for (int i = 0;  i< opCount; i++) {
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			q.dequeue();
		}
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1e9;
	}

	public static void main(String[] args) {

		int opCount = 100000;

		ArrayQueue<Integer> queue = new ArrayQueue<>();
		LoopQueue<Integer> loop = new LoopQueue<>();

		double time1= testQueue(queue, opCount);
		System.out.println(time1);

		double time2 = testQueue(loop, opCount);
		System.out.println(time2);

	}
}
