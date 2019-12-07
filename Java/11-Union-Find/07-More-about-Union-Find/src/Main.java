import java.util.Random;

/**
 * ClassName: Main
 * Description:
 * date: 2019/12/7 14:52
 *
 * @author crwen
 * @create 2019-12-07-14:52
 * @since JDK 1.8
 */
public class Main {

	private static double testUF(UF uf, int m) {

		int size = uf.getSize();
		Random random = new Random();

		long startTime = System.nanoTime();

		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.isConnection(a, b);
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1e9;
	}

	public static void main(String[] args) {
		int size = 10000000;
		int m = 10000000;

		UnionFind1 uf1 = new UnionFind1(size);
		UnionFind2 uf2 = new UnionFind2(size);
		UnionFind3 uf3 = new UnionFind3(size);
		UnionFind4 uf4 = new UnionFind4(size);
		UnionFind5 uf5 = new UnionFind5(size);
		UnionFind6 uf6 = new UnionFind6(size);

		//System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");
		//System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");
		System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");
		System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");
		System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");
		System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");
	}
}
