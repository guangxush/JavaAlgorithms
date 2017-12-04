package cn.shgx.array;

//最大字段和
public class MaxSumSubArray {
	/**
	 * 暴力穷举法 O(n^3)
	 * @param array
	 */
	public static void find1(int[] array) {
		int maxSum = array[0];
		int currentSum = 0;
		int start = 0;
		int end = 0;
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length;j++) {
				for(int k=i;k<=j;k++) {
					currentSum+=array[k];
				}
				//如果本次的和大于之前的累加最大和则更新赋值
				if(currentSum>maxSum) {
					maxSum = currentSum;
					start = i;
					end = j;
				}
				currentSum = 0;//这里在每次计算需要重新初始化当前的和
			}
		}
		System.out.println("连加值最大的和为"+maxSum);
		System.out.print("连加值最大的子数组为:");
		for(int i=start;i<=end;i++) {
			System.out.print(array[i]);
			if(i!=end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	/**
	 * 暴力穷举法优化
	 * @param array
	 */
	public static void find2(int[] array) {
		int maxSum = array[0];
		int currentSum = 0;
		int start = 0;
		int end = 0;;
		for(int i=0;i<array.length;i++) {
			for(int j=i;j<array.length;j++) {
				currentSum += array[j];
				//如果本次和大于之前的累加和，重新赋值
				if(currentSum>maxSum) {
					maxSum = currentSum;
					start = i;
					end = j;
				}
			}
			currentSum = 0;//这里每次计算完之后都要重新初始化当前的和
		}
		System.out.println("连价值最大的和："+maxSum);
		System.out.print("连加值最大的子数组为:");
		for(int i=start;i<=end;i++) {
			System.out.print(array[i]);
			if(i!=end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	/**
	 * 动态规划算法 O(n)
	 * @param array
	 */
	public static void find3(int[] array) {
		int lastSum = 0;
		int maxSum = array[0];
		int start = 0;
		int end = 0;
		for(int i=0;i<array.length;i++) {
			if(lastSum>0) {
				//累加
				lastSum = lastSum + array[i];
			}else {
				//如果需要新起点，重新赋值start
				lastSum = array[i];
				start = i;
			}
			if(maxSum<lastSum) {
				//有新的最大的和了
				maxSum = lastSum;
				end = i;
			}
		}
		System.out.println("连价值最大的和："+maxSum);
		System.out.print("连加值最大的子数组为:");
		for(int i=start;i<=end;i++) {
			System.out.print(array[i]);
			if(i!=end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	/**
	 * 获取矩阵的最大和子矩阵
	 * @param matrix
	 * @return
	 */
	public static int maxSumSubMatrix(int[][] matrix) {
		int[][] total  = matrix;
		for(int i=1;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				total[i][j]+=total[i-1][j];
			}
		}
		int maximum = Integer.MIN_VALUE;
		for(int i=0;i<matrix.length;i++) {
			for(int j=i;j<matrix.length;j++) {
				//result保存的是第i行到第j行所对应矩阵的所有元素的和
				int[] result = new int[matrix[0].length];
				for(int l=0;l<matrix[0].length;l++) {
					if(i==0) {
						result[l]=total[j][l];
					}else {
						result[l]=total[j][l]-total[i-l][l];
					}
				}
				int maximal = maxSubArray(result);
				if(maximal>maximum) {
					maximum = maximal;
				}
			}
		}
		return maximum;
	}
	private static int maxSubArray(int[] array) {
		int lastSum = 0;
		int maxSum = array[0];
		for(int i=0;i<array.length;i++) {
			if(lastSum>0) {
				lastSum = lastSum+array[i];
			}else {
				lastSum = array[i];
			}
			if(maxSum<lastSum) {
				maxSum = lastSum;
			}
		}
		return maxSum;
	}
}
