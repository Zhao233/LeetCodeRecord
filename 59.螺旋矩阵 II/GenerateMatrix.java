class Solution{
    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];

        /**
         * 矩阵的左右上下边界
         * */
        int boundary_left = 0;
        int boundary_right = n-1;
        int boundary_top = 0;
        int boundary_bottom = n-1;

        int limitation = n*n;
        int num = 1;

        while(num <= limitation){
            /**
             * 从左到右
             * */
            for(int i = boundary_left; i <= boundary_right; i++){
                array[boundary_top][i] = num++;
            }

            boundary_top++;

            /**
             * 从上到下
             * */
             for(int i = boundary_top; i <= boundary_bottom; i++){
                array[i][boundary_right] = num++;
             }

            boundary_right--;

            /**
             * 从右到左
             * */
            for(int i = boundary_right; i >= boundary_left; i--){
                array[boundary_bottom][i] = num++;
            }

            boundary_bottom--;

            /**
             * 从下到上
             * */
            for(int i = boundary_bottom; i >= boundary_top; i-- ){
                array[i][boundary_left] = num++;
            }

            boundary_left++;
        }

        return array;
    }
}