import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku_36 {
    class Solution {

        public boolean isValidSudoku0(char[][] board) {
            Set<String> seen = new HashSet<>();
            
            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    final char c = board[i][j];

                    if (c == '.') continue;

                    if (!seen.add(c + "@row" + i) ||
                            !seen.add(c + "@col" + j) ||
                            !seen.add(c + "@box" + (i / 3) + (j / 3)))
                        return false;
                }
            }

            return true;
        }

        public boolean isValidSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] boxes = new boolean[9][9];


            // each col & row contain [1-9] digit without repetition
            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;

                    int boxIndex = i / 3 * 3 + j / 3;
                    int num = board[i][j] - '1';

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num])
                        return false;

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }

            return true;
        }

        public boolean isValidSudoku1(char[][] board) {
            HashSet<Character>[] rows = new HashSet[9];
            HashSet<Character>[] cols = new HashSet[9];
            HashSet<Character>[] boxes = new HashSet[9];

            for (int i = 0; i < 9; i++) {
                rows[i] = new HashSet<>(9);
                cols[i] = new HashSet<>(9);
                boxes[i] = new HashSet<>(9);
            }

            // each col & row contain [1-9] digit without repetition
            for (int r = 0; r < 9; r++) {

                for (int c = 0; c < 9; c++) {
                    if (board[r][c] == '.') continue;

                    if (rows[r].contains(board[r][c]) || cols[c].contains(board[r][c]) || boxes[r / 3 * 3 + c / 3].contains(board[r][c]))
                        return false;

                    rows[r].add(board[r][c]);
                    cols[c].add(board[r][c]);
                    boxes[r / 3 * 3 + c / 3].add(board[r][c]);
                }
            }

            return true;
        }

        public boolean isValidSudoku2(char[][] board) {
            Map<String, Set<Character>> rowsSets = new HashMap<>();
            Map<String, Set<Character>> colsSets = new HashMap<>();
            Map<String, Set<Character>> boxesSets = new HashMap<>();

            // each col & row contain [1-9] digit without repetition
            for (int r = 0; r < 9; r++) {

                for (int c = 0; c < 9; c++) {
                    Set<Character> rowSet = rowsSets.getOrDefault("" + r, new HashSet<>());
                    Set<Character> colSet = colsSets.getOrDefault("" + c, new HashSet<>());
                    Set<Character> boxSet = boxesSets.getOrDefault("" + (r / 3) + (c / 3), new HashSet<>());

                    char current = board[r][c];

                    if (current == '.') continue;

                    if (rowSet.contains(current) || colSet.contains(current) || boxSet.contains(current)) return false;

                    rowSet.add(current);
                    colSet.add(current);
                    boxSet.add(current);

                    rowsSets.put("" + r, rowSet);
                    colsSets.put("" + c, colSet);
                    boxesSets.put("" + (r / 3) + (c / 3), boxSet);
                }
            }

            return true;
        }

        public boolean isValidSudoku3Opt(char[][] board) {

            // each col & row contain [1-9] digit without repetition
            for (int i = 0; i < 9; i++) {
                Set<Character> rowSet = new HashSet<>();
                Set<Character> colSet = new HashSet<>();

                for (int j = 0; j < 9; j++) {
                    char rowChar = board[i][j];
                    char colChar = board[j][i];

                    if (rowChar != '.' && rowSet.contains(rowChar)) return false;
                    if (colChar != '.' && colSet.contains(colChar)) return false;

                    rowSet.add(rowChar);
                    colSet.add(colChar);
                }


                Set<Character> boardSet = new HashSet<>();

                // row = board / 3 * 3
                // col = board % 3 * 3
                int rowIndex = i / 3 * 3;
                for (int k = 0; k < 3; k++) {
                    int colIndex = i % 3 * 3;

                    for (int j = 0; j < 3; j++) {
                        char c = board[rowIndex][colIndex];

                        if (c != '.' && boardSet.contains(c)) return false;

                        boardSet.add(c);
                        colIndex++;
                    }
                    rowIndex++;
                }
            }

            return true;
        }

        public boolean isValidSudoku3(char[][] board) {

            // each col & row contain [1-9] digit without repetition
            for (int i = 0; i < 9; i++) {
                Set<Character> rowSet = new HashSet<>();
                Set<Character> colSet = new HashSet<>();

                for (int j = 0; j < 9; j++) {
                    char rowChar = board[i][j];
                    char colChar = board[j][i];

                    if (rowChar != '.' && rowSet.contains(rowChar)) return false;
                    if (colChar != '.' && colSet.contains(colChar)) return false;

                    rowSet.add(rowChar);
                    colSet.add(colChar);
                }
            }

            // each 3x3 sub box contain [1-9] digit without repetition
            // row = board / 3 * 3
            // col = board % 3 * 3
            for (int boardIndex = 0; boardIndex < 9; boardIndex++) {
                Set boardSet = new HashSet<>();

                int rowIndex = boardIndex / 3 * 3;

                for (int i = 0; i < 3; i++) {
                    int colIndex = boardIndex % 3 * 3;

                    for (int j = 0; j < 3; j++) {
                        char c = board[rowIndex][colIndex];

                        if (c != '.' && boardSet.contains(c)) return false;

                        boardSet.add(c);
                        colIndex++;
                    }
                    rowIndex++;
                }
            }
            return true;
        }
    }

}
