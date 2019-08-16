object Solution {
    def surfaceArea(grid : Array[Array[Int]]):Int = {
        val length = grid.length
        var sum    = 0

        for(i <- 0 until length){
            for(j <- 0 until length){
                val num = grid(i)(j)

                if(num != 0){
                    sum += 2
                }

                print("num is :"+grid(i)(j)+"  ")
                print("round is: ")

                var surface = num*4

                for(x <- i-1 to i+1
                    if(x >= 0 && x < length && x != i)
                    ){
                    val index = grid(x)(j)

                    if(index<=num){
                    surface -= index
                    } else {
                    surface -= num
                    }

                    print(index+" ")
                }

                for(y <- j-1 to j+1
                    if(y >= 0 && y < length && y != j)
                ){
                    val index = grid(i)(y)

                    if(index<=num){
                    surface -= index
                    } else {
                    surface -= num
                    }

                    print(index+" ")
                }
                sum += surface

                println(" surface is : "+surface)

            }
        }

        return sum;
        }
    }