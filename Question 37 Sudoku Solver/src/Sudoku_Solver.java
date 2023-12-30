public class Sudoku_Solver {
    public static boolean isValid(char[][] board,int row,int col,char num){
        // Check Row
        for (int j=0;j<9;j++){
            if (board[row][j]==num) return false;
        }
        // Check Column
        for (int i=0;i<9;i++){
            if (board[i][col]==num) return false;
        }
        // Check 3X3 Matrix
        int sRow=row/3*3;
        int sCol=col/3*3;
        for (int i=sRow;i<sRow+3;i++){
            for (int j=sCol;j<sCol+3;j++){
                if (board[i][j]==num) return false;
            }
        }
        return true;
    }
    public static void solve(char[][] board,int row,int col,char[][] grid){
        if (row==9) {
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    grid[i][j]=board[i][j];
                }
            }
            return;
        }
        else if (board[row][col]!='.') {
            if (col!=8) solve(board,row,col+1,grid);
            else solve(board,row+1,0,grid);
        }
        else{
            for (char ch='1';ch<='9';ch++){
                if (isValid(board,row,col,ch)){
                    board[row][col]=ch;
                    if (col!=8) solve(board,row,col+1,grid);
                    else solve(board,row+1,0,grid);
                    board[row][col]='.';
                }
            }
        }
    }
    public static void solveSudoku(char[][] board) {
        char[][] grid=new char[9][9];
        solve(board,0,0,grid);
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                board[i][j]=grid[i][j];
            }
        }
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board ={   {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8',',','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }
}
