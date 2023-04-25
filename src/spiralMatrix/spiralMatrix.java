package spiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class spiralMatrix {

	public static void main(String[] args) {
//		int rows = 3;
//		int columns = 4;
//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		// int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		spiralOrder(matrix);
		int A[] = { 1, 3, 6, 4, 1, 2 };
		int B[] = { 1, 2, 3 };
//		System.out.println(solution(B));
		System.out.println(solutionString("air", "way", "airway"));

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int columnsIni = 0;
		int rowsIni = 0;
		List<Integer> spiral = new ArrayList<Integer>();
		for (int i = rowsIni; rowsIni < rows; i++) {

			for (int j = rowsIni; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
				spiral.add(matrix[i][j]);
			}
			rowsIni++;
			i++;
			while (i != rows) {
				System.out.print(matrix[i][columns - 1] + " ");
				spiral.add(matrix[i][columns - 1]);
				i++;
			}
			columns--;
			for (int j = columns - 1; j != columnsIni; j--) {
				System.out.print(matrix[i - 1][j] + " ");
				spiral.add(matrix[i - 1][j]);
			}
			rows--;
			while (i != rowsIni) {
				spiral.add(matrix[i - 1][columnsIni]);
				System.out.print(matrix[i - 1][columnsIni] + " ");
				i--;
			}
			i++;
			System.out.println(rowsIni + " " + rows);
		}
		return spiral;
	}

//	public static int solution(int[] A) {
//		Integer num = 0;
//		List<Integer> list = Arrays.stream(A)        
//                .boxed()    
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//		
//		for (int i = 0; i < list.size(); i++) {
//			num = list.get(i);
//			if (i == list.size() - 1) {
//				break;
//			}
//			if (list.get(i + 1) != num + 1) {
//				break;
//			}
//		}
//		if (num > 0) {
//			num++;
//			return num.intValue();
//		}else {
//			return 1;
//		}
//    }

	public static boolean solutionString(String S, String T, String U) {
		if (S.length() + T.length() != U.length()) {
			return false;
		}
		boolean verified = false;
		for (int i = 0; i < S.length(); i++) {
			if (U.contains(String.valueOf(S.charAt(i)))) {
				if (!verified) {
					if (!verifyOrder(S, U)) {
						return false;
					} else {
						verified = true;
					}
				}
				U = U.replaceFirst(String.valueOf(S.charAt(i)), "");
			}
		}
		verified = false;
		for (int i = 0; i < T.length(); i++) {
			if (!verified) {
				if (!verifyOrder(T, U)) {
					return false;
				} else {
					verified = true;
				}
			}
			U = U.replaceFirst(String.valueOf(T.charAt(i)), "");
		}
		return U.trim().length() == 0;
	}

	private static boolean verifyOrder(String S, String U) {
		for (int i = 0; i < S.length(); i++) {
			if (i != S.length() - 1) {
				int num1 = U.indexOf(String.valueOf(S.charAt(i)));
				int num2 = U.indexOf(String.valueOf(S.charAt(i + 1)));

				if (num1 > num2) {
					return false;
				}
			}
		}
		return true;
	}
}
