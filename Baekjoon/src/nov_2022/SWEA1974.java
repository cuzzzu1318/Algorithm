package nov_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1974 {

	static void dfs(ArrayList<ArrayList<Integer>> sudoku, ArrayList<Integer> box, ArrayList<Integer> vertical,
			ArrayList<Integer> width, int x, int y) {
		if (x < 0 || x > 8 || y < 0 || y > 8) {
			return;
		} else if (sudoku.get(x).get(y) != 0) {
			int boxIdx = 0;
			if (x < 3) {
				if (y < 3) {
					boxIdx = 0;
				} else if (y < 6) {
					boxIdx = 1;
				} else {
					boxIdx = 2;
				}
			} else if (x < 6) {
				if (y < 3) {
					boxIdx = 3;
				} else if (y < 6) {
					boxIdx = 4;
				} else {
					boxIdx = 5;
				}
			} else {
				if (y < 3) {
					boxIdx = 6;
				} else if (y < 6) {
					boxIdx = 7;
				} else {
					boxIdx = 8;
				}
			}
			box.set(boxIdx, box.get(boxIdx) * sudoku.get(x).get(y));
			vertical.set(y, vertical.get(y) * sudoku.get(x).get(y));
			width.set(x, width.get(x) * sudoku.get(x).get(y));
			sudoku.get(x).set(y, 0);
			dfs(sudoku, box, vertical, width, x + 1, y);
			dfs(sudoku, box, vertical, width, x, y + 1);
			dfs(sudoku, box, vertical, width, x + 1, y + 1);
		} else {
			return;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			ArrayList<ArrayList<Integer>> sudoku = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				ArrayList<Integer> arr = new ArrayList<>();
				for (String s : br.readLine().split(" ")) {
					arr.add(Integer.parseInt(s));
				}
				sudoku.add(arr);
			}
			ArrayList<Integer> box = new ArrayList<>();
			ArrayList<Integer> vertical = new ArrayList<>();
			ArrayList<Integer> width = new ArrayList<>();
			for(int j = 0;j<9;j++) {
				box.add(1);
				vertical.add(1);
				width.add(1);
			}
			dfs(sudoku, box, vertical, width, 0, 0);
			int isSudoku = 1;
			int fact = 2*3*4*5*6*7*8*9;
			for (int j = 0; j < 9; j++) {
				if (box.get(j) != fact) {
					isSudoku = 0;
				}
				if (vertical.get(j) != fact) {
					isSudoku = 0;
				}
				if (width.get(j) != fact) {
					isSudoku = 0;
				}
			}
			System.out.println("#"+(i+1)+" "+isSudoku);
		}
	}
}