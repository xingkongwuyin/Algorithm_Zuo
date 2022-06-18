[TOC]

函数等概率和不等概率输出

## 一. Java中的Math.random() 

1. > ```java
   > int num = Math.random();
   > ```
   >
   > 等概率返回[0 1)区间上的数（包括浮点数）

2. > ```java
   > int num = Math.random() * k;
   > ```
   >
   > 等概率返回[0 k)区间上的数（包括浮点数）

3. > ```java
   > int num = (int)（Math.random() * K）;     
   > ```
   >
   > 等概率返回`[0 k-1]`上的整数，即` 0 1 2 …… k-2 k-1`。原因如下：
   >
   > * 因为该函数返回值强制类型转换，所以最终返回的是整数。
   > * 因为`Math.random() * k`是等概率输出，所以最终强制类型转换输出的整数的概率为1/k,等概率输出

4. > ```Java
   >  int a = Math.random() < n ? x : y;  // 0 < n <= 1
   > ```
   >
   > 以n的概率返回x，以`（1 - n）`的概率返回y，原因如下。通常我们将`x == 1`,`y == 0`,这样就成了一个0和1发生器，通过组合就可以表示其他的数，相当于用二进制来表示其他的数 
   >
   > * 因为`Math.random < n `条件成立的概率是n,所以`x == a`的概率就是n

5. > ```Java
   > Math.max(Math.random() ,Math.random());
   > 
   > // 测试
   > int count = 0;
   > int TestTimes = 10000;
   > for(int i = 0; i < TestTimes; i++)
   > if(Math.max(Math.random() ,Math.random()) < x)
   > {
   >     count++;
   > }
   > int n = count / TestTimes;
   > ```
   >
   > 任意的`0<= x <1`,`[0,x)`范围上的数出现的概率为`1/x^2`。原因如下，
   >
   > * `Math.max(Math.random() ,Math.random()) < x`成立的条件是`Math.random() < x && Math.random() < x `，
   >
   >   又因为`Math.random() < x`,成立的概率是`1/x` ,所以`Math.max(Math.random() ,Math.random()) < x`成立的概率是
   >
   >   `1/x^2`

## 二. 任意函数f

1. > Question: 假设函数f可以等概率输出一串数字（具体要求如下），设计一个0、1等概率发生器
   >
   > Solution：
   >
   > ```java
   > // f输出奇数个数字 1 2 3 4 5
   > public static int g() {
   >     int tmp = 0;
   >     do {
   >         tmp = f();
   >     }while(3 == f());
   >     return tmp > 3 ? 0 : 1;
   > }
   > 
   > // f输出偶数个数字 1 2 3 4
   > public static g() {
   >     return tmp => 3 ? 0 : 1;
   > }
   > ```

2. > Qesstion：假设f是一个等概率的0和1发生器，那么设计出任意区间的发生器g
   >
   > Solution:
   >
   > ```java
   > // 假设区间[2 4]
   > public static int g1() {
   >     int tmp  = 0;
   >     do {
   >         tmp = (f() << 2) + (f() << 1) + (f() << 0);
   >     }while( (tmp >= 5 && tmp <<7) && ( (tmp >= 0) && (tmp <=1) ) );
   >     return tmp;
   > } 
   > ```
   >
   > Analysize：
   >
   > * ` tmp = (f() << 2) + (f() << 1) + (f() << 0)`，因为f是0、1发生器，所以区间上的数，可以用f组成的二进制序列表示，最大的左移应该看，组成的二进制序列的所能表示的最大值，应该大于区间上最大的数，且这个二进制序列的数最少
   >
   >   例：max([2 4]) = 4,那么三位二进制就可以表示，所以最大左移为2，即二进制序列位数减1.
   >
   > * `while( (tmp >= 5 && tmp <<7) && ( (tmp >= 0) && (tmp <=1) ) )`,因为二进制序列产生的区间可能大于给定的区间，所以这一步的目的是排除不符合区间的数

3. >  Question: 假设函数f可以以概率p输出5，以概率（1 - p）输出2，设计一个等概率输出5和2的函数
   >
   > Solution：
   >
   > ```java
   > public static int g() {
   >     int tmp = 0;
   >     do{
   >         tmp = f();       // (1)
   >     }while(tmp == f())   // (2)
   >      return tmp;
   > }
   > ```
   >
   > 
   >
   > Analysize：如果g()返回5，那么（1）处应该tmp = 5,且其概率为p,（2）处f()应该返回2，且概率为`1-p`,则`g() == 5 `的概率为
   >
   > ​                    `p * (1 - p)`,同理 `g() == 2`的概率是`(1 - p) * p`,这样就能等概率输出2和5 

## 三. Summary

> 1. 当从某一个函数等概率输出一串数字，通过其设计出来的函数，也能等概率输出一串数字，可这个输出的概率可能不一样
>
> 2. 当给出一个函数，且知道它的输出值的概率，那么就可以设计出不同概率输出的函数，常见的有设计成0、1等概率发生器
>
> 3. 给出一个0、1发生器，那么就可以求出任意区间等概率输出整数的函数。

































