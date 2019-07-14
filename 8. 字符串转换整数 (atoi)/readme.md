# 解题思路说明

## 题目地址
[字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)

## 解题过程

在整个提取过程中有三个状态  
* 初始状态：开始提取数字之前
* 开始提取数字时
* 提取数字中

分别为三个状态编号为 0 1 2  

得出状态行为表：

状态 |当前字符 | Action（行为）
 -- | ---- | ---------- 
0 | 空格 | do nothing
0 | 数字 | 将状态标志置为状态3，进入状态3
0 | + - | 置符号，置状态标志为状态3
0 | 其它 | 返回0
1 | 0 | do nothing
1 | 非0 | 叠加数字变量，将状态标志置为状态2
1 | 其它 | 结束提取
2 | 数字 | 叠加数字变量
2 | 非数字 | 结束提取

在循环遍历字符串时，都是针对状态，来决定处理的逻辑  
确认状态行为表后，使用switch case (Scala语言为match)判断字符，在使用if判断状态 (或者继续使用switch)，在将对应的Action放入对应的状态中。  

状态行为表内容说明：    
* 将状态标志置数与进入状态区别：将状态标志置数，直接将状态标志变量赋值。进入状态：将状态标志置数后，随即进入对应的状态中，具体的实现方法为（scala语言）将判断状态的模块根据进入的顺序来排布，例如，将判断状态0的if放到判断状态3的前面，这样在将状态标志置数后还能进入到状态3中。    
如下中的FLAG_INIT和FLAG_NUM_START的位置
``` java
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
```

* 结束提取：返回已经提取到的数字（在getNumber函数中，根据数字字符串的长度，决定是否返回0。根据符号位，决定是正还是负）