package com.coding.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ12100 {

	final int BLANK = 0;
	final int MAX = 5;

	int map[][];
	int N;
	int maxValue;

	public BOJ12100() {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(map, 0);
		System.out.println(maxValue);

	}

	public void dfs(int[][] map, int step) {

		if (step == MAX) {

			MaxValue(map);
			return;

		}

		for (int i = 0; i < 4; i++) {

			int[][] mapCopy = new int[N][N];
			for (int j = 0; j < N; j++) {

				mapCopy[j] = Arrays.copyOf(map[j], N);

			}

			dfs(action(mapCopy, i), step + 1);

		}
	}

	public int[][] action(int[][] mapCopy, int dir) {

		switch (dir) {

		case 0:// LEFT

			for (int row = 0; row < N; row++) {
				int nBlank = 0;

				for (int col = 1; col < N; col++) {

					if (mapCopy[row][col] == 0) {

						nBlank++;
						continue;
					} else {

						if (mapCopy[row][col] == mapCopy[row][col - 1 - nBlank]) {
							mapCopy[row][col - 1 - nBlank] *= 2;
							mapCopy[row][col] = 0;

						} else if (mapCopy[row][col - 1 - nBlank] == 0) {
							mapCopy[row][col - 1 - nBlank] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;

						} else {
							mapCopy[row][col - nBlank] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}

			break;

		case 1:// UP

			for (int col = 0; col < N; col++) {

				int nBlank = 0;

				for (int row = 1; row < N; row++) {

					if (mapCopy[row][col] == 0) {
						nBlank++;
						continue;
					} else {

						if (mapCopy[row - 1 - nBlank][col] == mapCopy[row][col]) {
							mapCopy[row - 1 - nBlank][col] *= 2;
							mapCopy[row][col] = 0;

						} else if (mapCopy[row - 1 - nBlank][col] == 0) {
							mapCopy[row - 1 - nBlank][col] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;

						} else {
							mapCopy[row - nBlank][col] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}

			break;

		case 2:// RIGHT

			for (int row = 0; row < N; row++) {

				int nBlank = 0;

				for (int col = N - 2; col >= 0; col--) {

					if (mapCopy[row][col] == 0) {
						nBlank++;
						continue;

					} else {

						if (mapCopy[row][col] == mapCopy[row][col + 1 + nBlank]) {
							mapCopy[row][col + 1 + nBlank] *= 2;
							mapCopy[row][col] = 0;

						} else if (mapCopy[row][col + 1 + nBlank] == 0) {
							mapCopy[row][col + 1 + nBlank] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;

						} else {

							mapCopy[row][col + nBlank] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}

			break;

		case 3:// DOWN

			for (int col = 0; col < N; col++) {

				int nBlank = 0;

				for (int row = N - 2; row >= 0; row--) {

					if (mapCopy[row][col] == 0) {
						nBlank++;
						continue;
					} else {

						if (mapCopy[row + 1 + nBlank][col] == mapCopy[row][col]) {
							mapCopy[row + 1 + nBlank][col] *= 2;
							mapCopy[row][col] = 0;

						} else if (mapCopy[row + 1 + nBlank][col] == 0) {
							mapCopy[row + 1 + nBlank][col] = mapCopy[row][col];
							mapCopy[row][col] = 0;
							nBlank++;

						} else {

							mapCopy[row + nBlank][col] = mapCopy[row][col];
							if (nBlank != 0)
								mapCopy[row][col] = 0;
						}
					}
				}
			}

			break;

		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j<N; j++){
				System.out.print(mapCopy[i][j] + " ");
			}
			System.out.println();
		}

		return mapCopy;
	}

	public void MaxValue(int[][] mapCopy) {

		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if(temp < mapCopy[i][j]){
					temp = mapCopy[i][j];
				}
			}
		}

		if(maxValue < temp){
			maxValue = temp;
		}
	}

	public static void main(String[] args) {
		new BOJ12100();
	}

}
