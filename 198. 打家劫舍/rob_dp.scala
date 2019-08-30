object Solution{
    def rob(nums : Array[Int]) : Int = {
        nums.length match {
        case 0 => return 0
        case 1 => return nums(0)
        case 2 => return Math.max(nums(0), nums(1))
        case _ =>
        }

        var result = 0;
        var pre_index_1 = nums(0)
        var pre_index_2 = Math.max(nums(0), nums(1))

        for(i <- 2 until nums.length){
            result = Math.max(pre_index_2, pre_index_1 + nums(i))

            pre_index_1 = pre_index_2
            pre_index_2 = result
        }

        return result
    }
}