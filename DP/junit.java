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
	@Test
	public void test10() {
		int[] values = {1,5,8,9,10,17,17,20};
		int n = CuttingRod.maxValueInCutting(values);
		assertTrue(n == 22);
	}
	@Test
	public void test11() {
		int[] values = {3,5,8,9,10,17,17,20};
		int n = CuttingRod.maxValueInCutting(values);
		assertTrue(n == 24);
	}
	@Test
	public void test12() {
		int[] value = {1,101,2,3,100,4,5};
		int n = maxSumIncrease.getSum(value);
		assertTrue(n == 106);
	}
	@Test
	public void test13() {
		int[] value = {3,4,5,10};
		int n = maxSumIncrease.getSum(value);
		assertTrue(n == 22);
	}
	@Test
	public void test14() {
		int[] array = {1,11,2,10,4,5,2,1};
		int n = longBitonicSeq.bitonic(array);
		assertTrue(n == 6);
	}
	@Test
	public void test15() {
		int[] array = {12,11,40,5,3,1};
		int n = longBitonicSeq.bitonic(array);
		assertTrue(n == 5);
	}
	@Test
	public void test16() {
		int[] array = {80,60,30,40,20,10};
		int n = longBitonicSeq.bitonic(array);
		assertTrue(n == 5);
	}
	@Test
	public void test17() {
		Integer[][] array = {{4,6,7}, {1,2,3}, {4,5,6}, {10,12,32}};
		int n = BoxStacking.getHeight(array);
		assertTrue(n == 60);
	}
	@Test
	public void test18() {
		int[] freq = {34, 8, 50};
		int n = OptimalBST.minCost(freq);
		assertTrue(n == 142);
	}
	@Test
	public void test19() {
		int n = noConsecutiveOne.count(3);
		assertTrue(n == 5);
	}
}
