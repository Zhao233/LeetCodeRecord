object Solution{
    def main(args : Array[String]) : Unit = {
        //原数据为 1,100,1,1,1,100,1,1,100,1 为了方便计算,说明已经到达楼顶,在最后一个0
        val array = Array(1,100,1,1,1,100,1,1,100,1,0)

        println( minCostClimbingStairs(array, 10) )
    }

    def minCostClimbingStairs(nums : Array[Int], i: Int) : Int = {
    if( i == 0) return nums(0)
    else if (i == 1) return nums(1)
    else {

      val A = minCostClimbingStairs(nums, i-1)
      val B = minCostClimbingStairs(nums, i-2)

      return Math.min(A,B) + nums(i)
    }
  }
}