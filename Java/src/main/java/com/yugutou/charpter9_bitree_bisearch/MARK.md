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