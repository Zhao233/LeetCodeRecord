object Solution{
    def minCostClimbingStairs(nums : Array[Int]) : Int = {
        var opt_pre_1 = nums(0);
        var opt_pre_2 = nums(1);

        val length = nums.length

        var now = 0

        for(i <- 2 to length){
            if(i == length){
                now = Math.min( opt_pre_1,opt_pre_2 )

                return now
            }

            now = Math.min( opt_pre_1, opt_pre_2 ) + nums(i)

            opt_pre_1 = opt_pre_2
            opt_pre_2 = now
        }

        return now
    }
}