import static org.junit.Assert.*;

import org.junit.Test;


public class junit {

	@Test
	public void test0() {
		String S1 = "ABCDGH";
		String S2 = "AEDFHR";
		int num = longestCommonSeq.common(S1, S2);
		assertTrue(num == 3);
	}
	@Test
	public void test1() {		
		String S1 = "AGGTAB";
		String S2 = "GXTXAYB";
		int num = longestCommonSeq.common(S1, S2);
		assertTrue(num == 4);
	}
	@Test
	public void test2() {
		String S1 = "";
		String S2 = "";
		int num = longestCommonSeq.common(S1, S2);
		assertTrue(num == 0);
	}
	@Test
	public void test3() {
		int N = 4;
		int[] S  ={1,2,3};
		int num = coinChange.coin(N, S);
		assertTrue(num == 4);
	}
	@Test
	public void test4() {
		int N = 10;
		int[] S  ={2,5,3,6};
		int num = coinChange.coin(N, S);
		assertTrue(num == 5);
	}
	@Test
	public void test5() {
		int[] array = {40, 20, 30, 10, 30};
		int num = MatrixChainMultiply.minCompute(array);
		assertTrue(num == 26000);
	}
	@Test
	public void test6() {
		int[] array = {10, 20, 30, 40, 30};
		int num = MatrixChainMultiply.minCompute(array);
		assertTrue(num == 30000);
	}
	@Test
	public void test7() {
		int num = binomialCoef.binomial(5,  2);
		assertTrue(num == 10);
	}
	@Test
	public void test8() {
		int num = binomialCoef.binomial(4,  2);
		assertTrue(num == 6);
	}
	@Test
	public void test9() {
		int[] values = {20, 30, 66, 40, 60};
		int[] weights = {10, 20, 30, 40, 50};
		int num = knapsack.knap(values, weights, 100);
		assertTrue(num == 156);
	}
}
