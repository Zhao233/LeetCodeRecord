object Solution {
    
    def minPathSum(grid: Array[Array[Int]], i : Int, j : Int): Int = {
        if(i == 0 && j == 0){
            println("i : " + i + ",j:"+j+",sum : 1")

            return 1
        }

        val sum_1 = getMinValueFromArray( getAround(i, j, grid.length-1, grid(0).length-1), grid )

        val sum = grid(i)(j) + sum_1

        println("i : " + i + ",j:"+j+",sum : "+sum)

        return sum
    }

    def getMinValueFromArray( index : Array[Array[Int]], grid: Array[Array[Int]] ) : Int = {
        var min = Integer.MAX_VALUE;

        for( temp_index <- index){
            val i = temp_index(0)
            val j = temp_index(1)

            val minValue = minPathSum(grid, i,j)

            if( minValue < min ){
                min = minValue
            }
        }

        return min
    }

    def getAround(i : Int, j : Int, boundary_i : Int, boundary_j : Int) : Array[Array[Int]] = {
        var array = new ArrayBuffer[Array[Int]]()

        /**
        * 获取左边的节点
        * */
        val getLeft = () => {
            var temp = new ArrayBuffer[Int]()

            temp += i
            temp += j-1

            array += temp.toArray
        }

        /**
        * 获取右边的节点
        * */
        val getRight = () => {
            var temp = new ArrayBuffer[Int]()

            temp += i
            temp += j+1
            array += temp.toArray
        }

        /**
        * 获取上边的节点
        * */
        val getTop = () => {
            var temp = new ArrayBuffer[Int]()

            temp += i-1
            temp += j
            array += temp.toArray
        }

        /**
        * 获取下边的节点
        * */
        val getButtom = () => {
            var temp = new ArrayBuffer[Int]()

            temp += i+1
            temp += j
            array += temp.toArray
        }


        i match {

            case _ if i > 0 && i < boundary_i =>

            getTop()

            /**
            * 上边界
            * */
            case _ if i == 0 && i < boundary_i =>


            /**
              * 下边界
              * */
            case _ if i == boundary_i && i > 0 =>

            getTop()
        }
     
        j match {
            case _ if j > 0 && j < boundary_j =>

                getLeft()

            /**
              * 左边界
              * */
            case _ if j == 0 && j < boundary_j =>



            /**
              * 右边界
              * */
            case _ if j == boundary_j && j > 0 =>

                getLeft()
        }

        return array.toArray
    }
}