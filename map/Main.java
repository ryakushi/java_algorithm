package map;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 *
 *  �񎟌��n�}�N�G���̑���
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    sc.nextLine();
    char[][] map = new char[H][W];
    for (int i = 0; i < H; i++) {
      map[i] = sc.nextLine().toCharArray();
    }
    System.out.println();

    int[][] grid = readGrid(map, H, W);
    int[] sumRow = calculateSumRow(H, W, grid);
    int[] sumCol = calculateSumCol(H, W, grid);

    int Q = sc.nextInt();
    processQuery(Q, sumRow, sumCol, grid, sc);
  }

  // �N�G��������
  private static void processQuery(
    int Q,
    int[] sumRow,
    int[] sumCol,
    int[][] grid,
    Scanner sc
  ) {
    for (int k = 0; k < Q; k++) {
      int p = sc.nextInt(); //����̍s
      int q = sc.nextInt(); //����̗�
      //p�̍s��q�̗�̍��}�X�̍��v - p��q�łQ�񐔂����Ă���grid[i][j]��1����
      int ans = sumRow[p] + sumCol[q] - grid[p][q];
      System.out.println(ans);
    }
  }

  //�s���Ƃ̍��v���v�Z
  private static int[] calculateSumRow(int h, int w, int[][] grid) {
    int[] sumRow = new int[h];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        sumRow[i] += grid[i][j];
      }
    }
    return sumRow;
  }

  //�񂲂Ƃ̍��v���v�Z
  private static int[] calculateSumCol(int h, int w, int[][] grid) {
    int[] sumCol = new int[w];
    for (int j = 0; j < w; j++) {
      for (int i = 0; i < h; i++) {
        sumCol[j] += grid[i][j];
      }
    }
    return sumCol;
  }

  //�}�X�𐔒l�ɒu��������
  private static int[][] readGrid(char[][] map, int h, int w) {
    int[][] grid = new int[h][w];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (map[i][j] == '#') {
          grid[i][j] = 1;
        } else if (map[i][j] == '.') {
          grid[i][j] = 0;
        }
      }
    }
    return grid;
  }
}
