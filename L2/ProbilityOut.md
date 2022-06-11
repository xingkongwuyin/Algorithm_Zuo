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