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
// leetcode-48
class Solution {
    public void rotate(int[][] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i=0;i<arr.length;i++){
            reverse(arr[i]);
        }
    }
    public static void reverse(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
}
// set matrix zero
import java.util.*;

class Index {
    int row;
    int col;

    Index(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        List<Index> list = new ArrayList<>();
        helper(list, matrix);

        for (int k = 0; k < list.size(); k++) {
            int r = list.get(k).row;
            int c = list.get(k).col;

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }

           
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[r][j] = 0;
            }
        }
    }

    public void helper(List<Index> list, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Index(i, j));
                }
            }
        }
    }
    
}
// leetcode-74
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (helper(arr[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean helper(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
// merge interval
class Solution {
    public int[][] merge(int[][] arr) {

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int s2 = arr[i][0];
            int e2 = arr[i][1];

            if (s2 <= end) {
                end = Math.max(end, e2);
            } else {
                result.add(new int[]{start, end});
                start = s2;
                end = e2;
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
// leetcode 435-non overlapping interval
class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> kept = new ArrayList<>();
        kept.add(arr[0]);

        int prevEnd = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int currStart = arr[i][0];
            int currEnd = arr[i][1];

            if (currStart >= prevEnd) {
                kept.add(arr[i]);
                prevEnd = currEnd;
            }
        }
        return arr.length - kept.size();
    }
}

