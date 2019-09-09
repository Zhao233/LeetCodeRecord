object Solution{
      def minPathSum_dp(grid: Array[Array[Int]]):Int = {
        var nums : ArrayBuffer[ArrayBuffer[Int]] = new ArrayBuffer[ArrayBuffer[Int]](grid.length)
        val boundary_i = grid.length - 1
        val boundary_j = grid(0).length - 1

        for(i <- 0 until grid.length) {
            var temp_array = new ArrayBuffer[Int]()

            for(j <- 0 until grid(0).length) {

                /**
                  * 从坐上角的第一个元素到达第一行的任一元素的最短路径一定为本身的数值加上左边的最短路径
                  * 其它行在从它的上,左元素中挑选最短路径
                  * 左上角到达任一一行的第一个元素的最短路径都是它上一行的第一个元素的最短路径加上自己的值
                  * */
                if(i == 0){//第一行
                  if(j == 0){//左上角元素
                    temp_array += grid(0)(0)
                  } else {//第一行的其它元素
                    temp_array += ( grid(i)(j) + temp_array(j-1) )
                  }
                } else { //其它行
                  if(j == 0){//第一个元素
                    temp_array += ( grid(i)(0) + nums(i-1)(0) )
                  } else {//其它元素
                    val leftValue = temp_array(j-1)
                    val topValue = nums(i-1)(j)

                    temp_array += grid(i)(j) + Math.min( leftValue, topValue )
                  }
                }
            }

            nums+=temp_array
        }

    return nums(boundary_i)(boundary_j);
  }
}