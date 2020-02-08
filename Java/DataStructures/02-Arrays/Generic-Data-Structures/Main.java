/**
 * ClassName: Main
 * Description:
 * date: 2019/10/20 15:26
 *
 * @author crwen
 * @create 2019-10-20-15:26
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) {
		Array<Integer> arr = new Array<Integer>(20);
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr);

		System.out.println("==============================================");
		arr.add(1, 100);
		System.out.println(arr);

		System.out.println("==============================================");
		arr.addFirst(-100);
		System.out.println(arr);

		System.out.println("==============================================");
		arr.remove(2);
		System.out.println(arr);

		System.out.println("==============================================");
		arr.removeFirst();
		System.out.println(arr);

		System.out.println("==============================================");
		arr.removeElement(4);
		System.out.println(arr);
	}
}
