```C
    // 一.求某个数组第i个位置到j个位置的累加和
    int func4(int l, int r) {
	int arr[] = { 1,2,3,4,5 };
	int num[10] = { 0 }; // arr数组从第0个位置开始，分别到0位置的累加和
	int sz = sizeof(arr) / sizeof(arr[0]);
	
	num[0] = arr[0];
	for (int i = 1; i < sz; i++){
		num[i] = arr[i] + num[i - 1];  // 从0位置到i位置的累加和等于i位置的元素，加上从0位置
	}                                  // 到i-1位置的累加和

	if (0 == l) {
		return num[r];                 // 从l位置到r位置的累加和 == 从0位置到r位置的累加和减去 
	}                                  // 从0位置到（l-1）位置的累加和，如果l等于0，那么就等于
	else                               // 从0到r位置的累加和，因为num数组就是从0位置到各个位置
		return num[r] - num[l - 1];    // 的累加和
	
}

// 总结
// 1. 求累加和次数不多时，将各个位置到0位置的累加和做成一个一位数组，可以用这种方法求；
//    但如果求累加和次数多时，可以考虑将从任意开始到一个位置到另一个位置的累加和（后面的位置要大于前面的位置）
//    做成一个二维数组，用到累加和，直接查表就可以了
// 2. 虽然二维数组占的空间大，可是查询次数频繁时，就可以节约空间，这种就是空间换时间，一维数组的方法就是用时间换空间
```

```java
    Math.random()               // 返回的是[0 1)，且是等概率出现
    Math.random() * k           // 返回的是[0 k)
    (int)Math.random() * K      // 返回的是[0 k-1]上的整数 即 0 1 2 …… k-2 k-1
    
    public static double XToXPower2() {            // 任意的x，x属于[0,1),[0,x)范围上的数出现的概率由原来的x调整                                                    // x的平方
    return Math.max(Math.random(),Math.random());  
//  return Math.max(Math.random(),Math.random(),Math.random()); //调成x的三次方
    }
// 分析
// 当求 XToPower2 < x时，需要满足(Math.random() < x) && (Math.random() < x)，那么他的概率时x的平方（x是在[0        1)）

	    
```