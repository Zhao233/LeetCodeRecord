object TestKafka {
  def main(args: Array[String]): Unit = {
    print(threeSum(Array(-1, 0, 1, 2)))
  }

  def threeSum(nums: Array[Int]) : List[List[Int]] = {
  //def threeSum(nums: Array[Int]): Unit = {
    var list = ArrayBuffer[ArrayBuffer[Int]]()

    //数组的长度
    var length = nums.length;

    /**
      * 构建矩阵
      **/
    var matrix = ofDim[Int](nums.length, nums.length);

    for (i <- 0 until length) {
      for (j <- 0 until length) {
        matrix(i)(j) = nums(i);
      }
    }

    /**
      * 在矩阵中进行计算
      * 先纵向遍历，后横向遍历
      **/

    import scala.util.control.Breaks._

    var list_not_search = ArrayBuffer[Int]();

    for (j <- 0 until length
          if !list_not_search.contains( matrix(0)(j) )
        ) {
      for (i <- 0 until length //x-axis
           if j != i
           if !list_not_search.contains( matrix(i)(j) ) ) { //跳过与自己进行加法

        var a = nums(j)
        var b  = matrix(i)(j);

        var c = 0-a-b;

        breakable {
          for (x <- 0 until length
               if x != i //跳过自己
          ) {
            if (c == matrix(x)(j)) {
              //list += ArrayBuffer(a, b, c)
              list_not_search += (a,b,c)
              break

            }
          }
        }
      }
    }

    var array_result = ArrayBuffer[List[Int]]()

    for( i <- 0 until list_not_search.length / 3 ){
      var temp_list = List(list_not_search(i), list_not_search(i+1), list_not_search(i+2))

      array_result += temp_list
    }

    return array_result.toList
  }
  
}