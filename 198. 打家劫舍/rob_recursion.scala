object Solution{
    def rob(nums : Array[Int], i : Int) : Int = {
    i match {
      case 0 => return 0
      case 1 => return nums(0)
      case 2 => return Math.max(nums(0), nums(1))
      case _ =>
        val A = nums(i) + rob_recursion(nums, i-2)
        val B = rob_recursion(nums, i-1)

        return Math.max(A, B)
    }
  }
}