object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
        var max = nums(0)

        var opt_pre = nums(0)
        var opt_now = opt_pre

        for(i <- 1 until nums.length){
            if(opt_pre > 0 ){
                opt_now = opt_pre + nums(i)
            } else {
                opt_now = nums(i)
            }

            if(opt_now > max){
                max = opt_now
            }

            opt_pre = opt_now
        }

        return max
    }
}