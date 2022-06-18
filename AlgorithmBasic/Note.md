## Lesson01

1. >  常数时间的操作是O(1)

2. >  <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182050050.png" alt="image-20220613160034441" style="zoom:150%;" />
   >
   > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182050531.png" alt="image-20220613160119245" style="zoom:200%;" />
   >
   > * 如果流程随着数据情况的变化而变化，应该估计最难的流程
   >
   >   <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182050532.png" alt="image-20220613162812961" style="zoom:200%;" />

3. > <img src="https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182050516.png" alt="image-20220613162935566" style="zoom:200%;" />

4. > * 额外空间复杂度给的不算额外空间，即除了样本数据之外的空间。在整个算法流程中开辟的空间是有限的，跟样本数据量无关，用户需要的空间不算做空间复杂度，就是在一个函数中，开辟了一个数组，可是这个数组是函数的返回值，那么这个开辟的空间不算做额外空间复杂度。用户要什么，你给什么，输入什么参数，都不算额外空间。如果需要有限个变量，额外空间复杂度为O(1)。
   >
   > * 额外空间也是自主空间，和输入、功能都没有关的
   >
   >   ![image-20220613164238983](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182053634.png)

5. > ![image-20220613170441009](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182054256.png)

6. > * 拼常数项直接测数据运行时间
   >
   > * 算法一定要先对样本有个认识，有了样本数量才能设计更好的算法
   >
   > * 最优解：先PK时间复杂度，再PK额外空间复杂度，如果两者都相同，那么这两个算法都是最优解，不用PK常数项

7. > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > O(1),运行时间和样本没关系，N可以看成样本数量
   >
   > ![image-20220613171727212](https://dawn1314.oss-cn-beijing.aliyuncs.com/typora202206182050549.png)










