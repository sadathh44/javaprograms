package backtracking;



public class nqueens {
    public static void main(String[] args) {
      solveNQueens(4);
        
    }
    public static void solveNQueens(int n) {
        boolean[][] matrix = new boolean[n][n];
         NQueens(matrix,0);
        }
        
        

    static void NQueens(boolean[][] matrix, int r) {
    if (r == matrix.length) {
        System.out.println("\n solution");
        queens(matrix,r);
        return ;
    }
    for (int c = 0; c < matrix.length; c++) {
        if (isSafe(matrix, r, c)) {
            matrix[r][c] = true;
            NQueens(matrix, r + 1);
            //adding all answers together from different function calls because new list created everytime.
            matrix[r][c] = false;
            //backtracking
        }
    }
    return ;
}
 static boolean isSafe(boolean[][] matrix, int r, int c) {
    //Vertical up
    for (int i = 0; i <r; i++) {
        if (matrix[i][c]) {
            return false;
        }
    }
    //Diagonal left
	
    int minLeft = Math.min(r,c);
    for (int i = 0; i <= minLeft; i++) {
        if (matrix[r - i][c - i]) {
            return false;
        }
    }
    //Diagonal right
	
    int maxRight = Math.min(r, matrix.length-c-1)  ;
    for (int i = 0; i <=maxRight; i++) {
        if (matrix[r - i][c + i]) {
            return false;
        }
    }
    return true;
}
static void queens(boolean[][] matrix, int r) {
    for (boolean[] row : matrix) {
        String str="" ;
        for (boolean element : row) {
            if (element == true) {
                str+=" Q ";
            } else {
                str+=" X ";
            }
        }
        System.out.println(str);;
    }
    return ;
}
}
