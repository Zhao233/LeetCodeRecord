object Solution {
    def uniquePaths(m: Int, n: Int): Int = {
        val nums: ArrayBuffer[ArrayBuffer[Int]] = new ArrayBuffer[ArrayBuffer[Int]](0)

        for (i < -0 until n) {
            var temp: ArrayBuffer[Int] = ArrayBuffer()

            for (j < -0 until m) {
                if (i == 0) { //第一行
                    if (j == 0) { //第一个元素
                        temp += 1
                    } else {
                        if (temp(j - 1) != null) { //左边的元素
                            temp += 1
                        }
                    }
                } else { //其他行
                    if (j == 0) { //第一列
                        if (nums(i - 1)(j) != null) {
                            temp += 1
                        }
                    } else {
                        var value = 0

                        val top = nums(i - 1)(j)
                        val left = temp(j - 1)

                        if (top != null) { //上方的元素
                            value += top
                        }

                        if (left != null) { //左边的元素
                            value += left
                        }

                        if (value != 0) {
                            temp += value
                        }
                    }
                }
            }

            nums += temp

            println(nums)
        }

        return nums(n - 1)(m - 1)
    }
}