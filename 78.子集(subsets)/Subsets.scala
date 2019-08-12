class Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable.ArrayBuffer

    var list : ArrayBuffer[List[Int]] = ArrayBuffer()

    for (i <- 0 until nums.length) {//0 1 2
      for(j <- 0 until list.length) { //遍历list中的元素，将自己加入每一个元素中,并将加入后的元素保存
        list += list(j):+nums(i)
      }

      list+=List(nums(i))//将自己添加进list中
    }

    list+=List()

    return list.toList
  }
}
