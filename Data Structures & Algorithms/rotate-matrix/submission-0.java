class Solution {

    public void reverse(int low, int high, int arr[]){
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            reverse(0, matrix[0].length-1, matrix[i]);
        }

        //==========================
        // N x M MATRIX CLOCKWISE
        //==========================


        // int[][] rotate90CW(int[][] matrix) {
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][] result = new int[n][m]; // dimensions flip!

        // for (int i = 0; i < m; i++)
        //     for (int j = 0; j < n; j++)
        //         result[j][m - 1 - i] = matrix[i][j];

        //     return result;
        // }

        //==========================
        // N x M MATRIX ANTI CLOCKWISE
        //==========================

        // int[][] rotate90CCW(int[][] matrix) {
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][] result = new int[n][m];

        // for (int i = 0; i < m; i++)
        //     for (int j = 0; j < n; j++)
        //         result[n - 1 - j][i] = matrix[i][j];

        // return result;
    }
}
    

