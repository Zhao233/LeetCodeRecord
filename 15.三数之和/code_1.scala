
import Array._
import scala.collection.mutable.ArrayBuffer

object TestKafka {
  val aliServer = "127.0.0.1"
  val port = "9092"

  def main(args: Array[String]): Unit = {



    print(threeSum(Array(-1, 0, 1, 2)))

    var list = ArrayBuffer[Int]();

    list+=(1)

    println( list.toString )
  }

  //def threeSum(nums: Array[Int]) : List[List[Int]] = {
  def threeSum(nums: Array[Int]) : Unit = {
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

    for (j <- 0 until length) {
      for (i <- 0 until length //x-axis
           if j != i
           if list_not_search.contains(i) ) { //跳过与自己进行加法

        var a = nums(j)
        var b  = matrix(i)(j);

        var c = 0-a-b;

        breakable {
          for (x <- 0 until length
               if x != i
                 ) {
            if (c == matrix(x)(j)) {
              list += ArrayBuffer(a, b, c)
              list_not_search += (x)
              break

            }
          }
        }
      }
    }

    print(list.toList)
  }
}

