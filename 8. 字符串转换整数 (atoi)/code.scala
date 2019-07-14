import java.lang.Exception

object Test {
  val FLAG_INIT = 0
  val FLAG_NUM_START = 1
  val FLAG_NUM = 2

  val SIGN_PLUS = 1
  val SIGN_MINUS = 2
  

  def main(args: Array[String]) {
    val test1 = "42";
    val test2 = "   -42";
    val test3 = "4193 with words";
    val test4 = "-91283472332";
    val test5 = "-000000000000001";
    val test6 = "      -11919730356x";
    val test7 = "2147483646";
    val test8 = "20000000000000000000";
    val test9 = "00000000000000000003";

    var value = myAtoi(test9);
    println(value);
  }

  def myAtoi(str: String): Int = {
    /**
      * 当前的状态
      * 0 初始状态
      * 1 数字
      * 2 数字的开始
      * */
    var flag: Int = 0;


    /**
      * 0: 初始值
      * 1: 正数
      * 2: 负数
      **/
    var sign: Int = 0;

    var num: String = "";

    for (i <- 0 until str.length) {
      val index_char = str.charAt(i);

      index_char match {

        //空格
        case ' ' =>
          if (flag == FLAG_NUM) return getNumber(num, sign)

          if(flag == FLAG_NUM_START) return getNumber(num,sign)

        //运算符
        case '+' =>
          if(flag == FLAG_NUM) return getNumber(num,sign);

          if(flag == FLAG_NUM_START) return getNumber(num, sign);

          if (flag == FLAG_INIT) {
            sign = SIGN_PLUS
            flag = FLAG_NUM_START
          }
        case '-' =>
          if(flag == FLAG_NUM) return getNumber(num,sign);

          if(flag == FLAG_NUM_START) return getNumber(num, sign);

          if(flag == FLAG_INIT){
            sign = SIGN_MINUS;
            flag = FLAG_NUM_START;
          }

        //数字
        case index_char if (index_char >= 48 && index_char <= 57) =>
          if(flag == FLAG_INIT){
            if(index_char == '0'){

            }

            flag = FLAG_NUM_START;
          }

          if(flag == FLAG_NUM){
            num+=index_char;

          }

          if(flag == FLAG_NUM_START){
            if(index_char == '0'){

            } else {
              num+=index_char;

              flag = FLAG_NUM;
            }
          }


        case _ =>
          if(flag == FLAG_NUM) return getNumber(num,sign);

          if(flag == FLAG_NUM_START) return getNumber(num, sign);

          if (flag == FLAG_INIT) return 0
      }

    }


    return getNumber(num, sign)
  }

  def getNumber(str: String, sign: Int): Int = {
    var num : Int = 0;

    if(str.length == 0){
      return 0;
    }

    sign match {
      case 0 =>
          try{
            return str.toInt
          } catch {
            case e : Exception => return 2147483647
          }
      // +
      case SIGN_PLUS =>
        try{
          return str.toInt
        } catch {
          case e : Exception => return 2147483647
        }
      // -
      case SIGN_MINUS =>
        try{
          return -str.toInt
        } catch {
          case e : Exception => return -2147483648;
        }
    }
  }
}