[TOC]

# Basic_Zuo

## Code01 SelectionSort

### Relevant Knowledge

### Question

* **SelectionSort**

### Illustration

* ![选择排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291113738.gif)

### Thinking

* **每次从[i   N-1]选出最小的元素，与下标为i的元素进行交换**
* **i到N - 2就可以了，因为经过前面的排序，最后一个元素不用排**

### Code

```java
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 1){
            return;
        }
        int N = arr.length;
        for(int i = 0; i <= N - 2; i++){
            int minIndex = i;
            for(int j = i + 1; j <= N - 1; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```



## Code02 BubbleSort

### Relevant Knowledge

### Question

* **Bubble sort**

### Illustration

* ![冒泡排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291118517.gif)

### Thinking

* **一共要冒泡(N - 1)次，最后一个元素不用冒泡**

### Code

```java
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr ==  null || arr.length < 2){
            return;
        }
        int N = arr.length;
        // 总共要冒(N - 1)次
        for(int i = 0; i <= N - 2; i++){
            int flag = 0;
            // 每次的冒泡的尾部是(N - 1 - i)
            // 以后判断条件尽量写'<=或者>=',因为
            // 这样可以j的结束条件比较好判断
            for(int j = 0; j <= N - 2 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j , j + 1);
                    flag = 1;
                }
            }
            if(flag == 0){
                return;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```



## Code03 InsertSort

### Relevant Knowledge

### Question

* **Insert sort**

### Illustration

* ![插入排序](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291127372.gif)

### Thinking

* **每次拿i位置的元素，先与（i- 1）位置的元素作比较，如果i位置的元素更小，就不用插，否则插入到i位置以前的元素中。每次插完，保持有序。**

### Code

```java
public class Code03_InsertSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i - 1]){
                continue;
            }else {
                for (int pre = i; (pre - 1 >= 0) && arr[pre] < arr[pre - 1]; pre--) {
                    swap(arr, pre, pre - 1);
                }
            }
        }
    }

    // 交换元素
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

```



## Code04 Binary Search 

### Relevant Knowledge

### Question

* **使用二分查找，查询某个升序数组是否存在某个元素**

### Illustration

* ![image-20220729194417074](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207291944248.png)

### Thinking

* **先定范围，再二分，后查找。**
* **二分的体现是`mid = (mid + R) / 2`,是用mid去找**
* **查找怎么查找，找到了怎么样，找不到，下一步又该如何找，去哪个范围找**

### Code

```java
public class Code04_BSExist {
    public static boolean bSExist(int[] arr, int n){
        if(arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        // 在[L R]里面找，包括L和R位置的数
        while(L <= R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] == n){
                return true;
            }else if(arr[mid] < n){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        // 能够出来，就代表没有找到
        return false;
    }
 }
```



## Code05 nearest Left Index And Rightest Index

### Relevant Knowledge

### Question

* **有序数组中找到>=num最左的位置，和>=num最右的位置**

### Illustration

* ![image-20220729200144978](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292001140.png)

### Thinking

* 以找到`>= value`最左的位置为例，但第一次找到`>= value`的位置后，紧接着再去该位置的左边去找，直至`L > R`

### Code

```java
public class Code05_BSNearLeftAndRight {
    // 在arr上找到>= value最左的位置
    public static int bSNearLeft(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    //  在arr上找到 <= value最右的位置
    public static int bSNearRight(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
```



## Code06 Get Local Less Index

### Relevant Knowledge

### Question

* arr[0] < arr[1]，0位置是局部最小；
  arr[N-1] < arr[N-2]，N-1位置是局部最小；
  arr[i-1] > arr[i] < arr[i+1]，i位置是局部最小；
  给定一个数组arr，已知任何两个相邻的数都不相等，找到随便一个局部最小位置返回

### Illustration

* ![image-20220619091420121](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292004107.png)

### Thinking

* 1)  数组长度为1，看arr[0]是否符合条件

  2）数组长度为2，看arr[0] 和arr[1]哪个符合

  3）数组长度长度为3，看arr[0]和arr[1]哪个符合

  4）数组长度大于等于3，找到局部最小值。到这一步，就剩下头部和尾部均不是局部最小值的          数组

### Code

```java
public class Code06_BSLocalMinIndex {
    //数组arr的元素各不相等Index
    public static int BSLocalMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
       // 长度为1的情况
        if (arr.length == 1) {
            return 0;
        }
       // 长度为2的情况
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                return 1;
            } else {
                return 0;
            }
        }
        // 长度为大于2的情况
        if (arr[1] > arr[0]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 长度大于2， 且最左边和最右边的元素都比相临值大
        int L = 1;
        int index = -1;
        int R = arr.length - 2;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                index = mid;
                // 一定加个break，不然找到index后，l和r就不会被改变，就会陷入死循环
                break;
            }

            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }
        }
        return index;
    }
```



## Code07 EvenTImeOddTimes

### Relevant Knowledge

* 异或

  ```java
  // 相同为0，相异为1
  // 可以看成无进位相加
  // 0 ^ N = N   N ^ N = 0
  // 满足交换律和结合律，且同时满足交换律和结合律
  
  // 交换律
  a ^ b = b ^ a;
  // 结合律
  (a ^ b) ^ c = a ^ (b ^ c);
  // 同时
  (a ^ b) ^ c = (a ^ c) ^ b
  ```

* 交换两个不相等的数，不用第三个

  ```java
  a = a ^ b;
  b = a ^ b;
  a = a ^ b; 
  ```

  ![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292042924.png)

  ![image-20220729210221198](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292102261.png)

  ![image-20220729210242805](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202207292102842.png)

### Question

1. **一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数**

2. **一个数组中有两种数出现了奇数次，其他数出现了偶数次，怎么找到并打印这两种数**
3. **输出一个数中二进制位中1的个数**

### Illustration

### Thinking

### Code

```java
public class Code01_EvenTImeOddTimes {
    // arr中，只有一种数，出现奇数次
    public static int printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        return eor;
    }

    // arr中，有两种数出现奇数次
    public static int[] printOddTimesNums2(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }

        int onlyOne = 0;
        // 找到eor二进制序列最右侧等于1位
        int num = eor & (~eor + 1);
        for(int cur : arr){
            if((cur & eor) != 0){
                onlyOne ^= cur;
            }
        }
        return new int[]{onlyOne, eor ^ onlyOne};
    }
    	// 二进制位中1的个数
       public static int bit1Count(int num){
        int count = 0;
        while(num != 0){
            count++;
            num &= (num - 1);
        }
        return count;
    }
}
```



## Code08 KM

### Relevant Knowledge

### Question

1. 一个数组中有一种数出现K次，其他数都出现了M次， M > k >= 1,找到出现了k次的数，要求额外空间复杂度O(1)

2. 一个数组中，有n种数，n - 1种数出现了M次，剩下一种数出现的次数不确定，但肯定大于等于1，且小于M，求 如果剩下的那个数出现的次数等于K次，则找出这个数，如果不是则返回找不到

### Illustration

### Thinking

* **因为每个数可以看成32为二进制，所以将每个数的32个二进制位求出来，创建一个数组help，来盛放二进制序列，分别加进数组中，然后模M，等于0，则说明那个数在该二进制位为0，否则为1，因为一个数出现了M次，那么这某位二进制为1，剩下的6个相同的数也得为1，所以得是M的倍数。**
* **建立长度为32的数组arr ——》循环求出每个数的2进制位，同时加到数组arr中 ——》对数组的每个元素取模M，如果等于0，那么要求的数在该位为1，否则为0**

### Code

```java
public class Code03_KM {
    public static int  KM(int[] arr, int K, int M){
        int[] help = new int[32];
        for(int cur : arr){
            for(int i = 0; i <= 31; i++){
                // 将每元素的二进制位分别加到位图
                 help[i] += ((cur >> i) & 1);
               // 这样写，不仅仅会把最后的二进制
               // 位显示出来，而且会把其他的二进制
               // 会显示出来，上面那种处理方式，仅仅
               // 会把最后一位显示出来，其他位全部置零
               // help[i] += ((cur >> i) | 0);
            }
        }
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            help[i] %= M;
            if(help[i] != 0){
                // 将某位置1
                ans |= (1 << i);
                // 将某位置0
                // ans &= ~(1 << i);
            }
        }
        return ans;
    }

    // 这个方法不能判断含有K个Integer_MAX的数组
    public static int isKM(int[] arr, int K, int M){
        int[] help = new int[32];
        for(int cur : arr){
            for(int i = 0; i <= 31; i++){
                // 将每元素的二进制位分别加到位图
                help[i] += ((cur >> i) & 1);
                // 这样写，不仅仅会把最后的二进制
                // 位显示出来，而且会把其他的二进制
                // 会显示出来，上面那种处理方式，仅仅
                // 会把最后一位显示出来，其他位全部置零
                // help[i] += ((cur >> i) | 0);
            }
        }
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            if(help[i] % M == 0){
                continue;
            }else if(help[i] % M == K){
                ans |= (1 << i);
            }else {
                return Integer.MAX_VALUE;
            }
        }
        int count = 0;
        if(0 == ans){
            for(int cur : arr){
                if(cur == 0){
                    count++;
                }
            }
        }
        if(count == K){
            return ans;
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
```









