## 新手班第一节课

```C
// 一. 打印整数的32位二进制（从低位到高位输出）
void func1()
{
	int a = 0;
	scanf("%d",&a);    // 输入先打印的数 
	for (int i = 0; i < 32; i++)
	{
		printf("%d ", a & 1);
		a >>= i;	// 让a右移，也可以让i左移
	}
}
// 总结
// 1.任何整数(零、正数和负数)左移一位等于这个数乘以2，即`num << 1  == num * 2`
//   任何整数(零、正数和负数)左移一位等于这个数除以2，即`num >> 1  == num / 2` 
// 2.num的相反数：num = (~num) + 1，所以减号的底层逻辑是取反加1
// 3.char的最小值为-128，取反加一后还是本身，int的最小值为-2^31，取反后还是本身

// 三.插入排序
void func3()
{
	int arr[] = { 4,23,34,235,62,1,234,56 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	for (int i = 1; i < sz; i++)
	{
		int pre = i - 1;
		if (arr[pre] <= arr[i])
		{
			continue;   // 每次循环一开始，如果第i个元素比i-1个大，因为i个元素之前
		}               // 是排好序的，所以就不用排了，直接进入下一个循环  
		else
		{
			for ( pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--)
			{
				int tmp = arr[pre];
				arr[pre] = arr[pre + 1];
				arr[pre + 1] = tmp;
			}
		}
	}
	for (int i = 0; i < sz; i++)
	{
		printf("%d ", arr[i]);
	}
}



// 四.冒泡排序
void bubblesort(int* arr, int len)
{
	int i = 0;
	int j = 0;
	int tmp = 0;
	for (i = 0; i < len - 1; i++)
	{
        int flag = 1;   
		for (j = 0; j < len - 1 - i; j++)
		{
			if (arr[j] > arr[j + 1]) // 每次将最大数升到最前面
			{
				tmp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = tmp;
                flag = 0;  
			}
		}
        if(flag == 1) // 如果发现此次循环没有改变flag的值，说明此次冒泡的序列
        {             // 是有序的，那么以后的循环的序列肯定也是有序的
            break;
        }
	}
}

```

![image-20220609204101268](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206101927822.png)