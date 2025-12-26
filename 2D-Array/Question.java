package 2D-Array;

public class Question {
    
}
// spiral matrix
class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int sr = 0, sc = 0;
        int er = arr.length - 1;
        int ec = arr[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while (sr <= er && sc <= ec) {

            // top row
            for (int i = sc; i <= ec; i++) {
                ans.add(arr[sr][i]);
            }

            // right column
            for (int i = sr + 1; i <= er; i++) {
                ans.add(arr[i][ec]);
            }

            // bottom row
            if (sr < er) {
                for (int i = ec - 1; i >= sc; i--) {
                    ans.add(arr[er][i]);
                }
            }

            // left column
            if (sc < ec) {
                for (int i = er - 1; i > sr; i--) {
                    ans.add(arr[i][sc]);
                }
            }

            sr++;
            sc++;
            er--;
            ec--;
        }

        return ans;
    }
}
// diagonal sum
class Solution {
    public int diagonalSum(int[][] mat) {
        int output=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==j){
                    output +=mat[i][j];
                }
                else if(i+j==mat.length-1){
                    output +=mat[i][j];
                }
            }
        }
        return output;
    }
}
// transpose of a matrix
class Solution {
    public int[][] transpose(int[][] matrix) {
        int ans[][]=new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans[j][i]=matrix[i][j];
            }
        }
        return ans;
    }
}
// reshape of a matrix
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c !=mat.length*mat[0].length){
            return mat;
        }
        int ans[][]=new int[r][c];
        int k=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
              ans[k/c][k%c]=mat[i][j]; 
              k++;
            }
        }
        return ans;
    }
}
// leetcode-1351
class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}