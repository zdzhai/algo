# 二分查找模板
## 模板1
> 当if (ture) 时，如果更新右边界，
则mid = 1 + (l + r) >> 1，因为是向下取整
```java
while (left < right) {
    int mid = left + 1 + ((right - left) >> 1);
    if (nums[mid] > target) {
        right = mid - 1;
    } else {
        left = mid;
    }
}
```
* 模板1得出的结果会靠右边界

## 模板2
> 当if (ture) 时，如果更新左边界，
则mid = (l + r) >> 1
```java
while (left < right) {
    int mid = left + ((right - left) >> 1);
    if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid;
    }
}
```
* 模板2得出的结果会靠左边界


## 题目：
> leetcode 33.搜索旋转排序数组
  旋转点左边的数都 **大于等于** nums[0],旋转点右边的数都小于nums[0]
  如果nums[mid] >= nums[0],左边界收缩
  如果nums[mid] < nums[0],右边界收缩 r = mid - 1;


> leetcode leetcode. 34.在排序数组中查找元素的第一个和最后一个位置
第一个位置就是：查找大于等于target的第一个元素
当nums[mid] >= target
nums[mid] < target，左边界必须增加 l = mid + 1;
最后一个位置就是：查找小于等于target的最后一个元素
当nums[mid] <= target
nums[mid] > target，右边界必须减小 r = mid - 1;

> 有序数组中第K小元素
小于等于mid的数得刚好等于K，mid就是第K小。
如果小于等于mid的数小于K，mid小了，得往大了去。+- 1
如果小于等于mid的数大于等于K，mid大了，得往小了去。不变

> leetcode 378. 有序矩阵中第K小的元素

> leetcode 778.水位上升的泳池中游泳
首先根据所需的最少时间，可以判断出能够使用二分来筛选
check函数就是判断在该时间下能否游到(n-1,n-1)
能否游到(n-1,n-1)也就是判断在时间time下能否从(0,0)到(n-1,n-1)
或者在时间time下(0,0)到(n-1,n-1)是否是联通的(图 待升级)
leetcode 1631.最小体力消耗路径 和本体类似

> leetcode 1011. 在D天内送达包裹的能力
运输能力为mid，当小于最佳能力时，天数会超出D，所以mid要增大
当大于等于最佳能力时，天数会小于等于D，所以mid要减小。

> leetcode 1208.尽可能使字符串相等
如果将所有字符都变换后需要的cost大于maxCount，那变化字符个数就要严格减小 r = mid - 1;
最终得到在maxCost允许下可变化的最大子字符串长度
题目中说是子字符串，所以应该考虑是连续的

> leetcode 1482.制作m束花所需的最少天数
需要mid天时，能制作的花小于m束，mid增大（天数更多才可能得到更多的花束）
需要mid天时，能制作的花大于等于m束，mid减小

> leetcode 1438.绝对差不超过限制的最长连续子数组 双端单调队列求区间最大最小值不太熟悉
假设最长连续子数组的长度为len，则有存在小于等于len长度的条件数组
一定不存在大于len长度的条件数组，len减小。
```java
//true为存在小于等于len的条件数组，mid可以保持不变
//false一定不存在大于len的条件数组，mid必须减小
int mid = l + 1 + ((r - l) >> 1);
if (!check(nums, mid, limit)) {
    r = mid - 1;
} else {
    l = mid;
}
```

# 二分关键字 最小，最少，第K小，最长