/**
 * ClassName: Main
 * Description:
 * date: 2019/10/21 20:47
 *
 * @author crwen
 * @create 2019-10-21-20:47
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();

		for (int i = 0; i < 5; i++) {
			stack.push(i);
			System.out.println(stack);
		}

		stack.pop();
		System.out.println(stack);
	}

}
