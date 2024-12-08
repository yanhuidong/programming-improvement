1. 基本定义：
lower_bound是C++标准模板库(STL)中的一个二分查找算法函数，定义在<algorithm>头文件中。它返回指向容器中第一个不小于给定值的元素的迭代器。

2. 函数原型：
```cpp
// 版本1 - 使用默认的小于运算符比较
template <class ForwardIterator, class T>
ForwardIterator lower_bound (ForwardIterator first, ForwardIterator last, const T& val);

// 版本2 - 使用自定义比较函数
template <class ForwardIterator, class T, class Compare>
ForwardIterator lower_bound (ForwardIterator first, ForwardIterator last, const T& val, Compare comp);
```

3. 参数说明：
- first: 容器的起始迭代器
- last: 容器的结束迭代器
- val: 要查找的值
- comp: 可选的比较函数对象

4. 基本用法：
```cpp
vector<int> vec = {10, 20, 30, 40, 50};
// 查找第一个不小于25的元素
auto it = lower_bound(vec.begin(), vec.end(), 25);
// it 将指向30，即vec[2]
```

5. 重要特点：
- 要求序列必须是有序的（升序）
- 如果没有找到大于或等于目标值的元素，返回last迭代器
- 时间复杂度为O(log n)
- 可以用于各种容器，包括vector、array、set等

6. 常见应用场景：
- 在有序序列中查找插入位置
- 检查元素是否存在
- 查找不小于某个值的第一个元素
- 在自定义数据结构中实现二分查找

7. 示例：使用自定义比较函数
```cpp
bool comp(int a, int value) {
    return a < value;
}
vector<int> vec = {10, 20, 30, 40, 50};
auto it = lower_bound(vec.begin(), vec.end(), 25, comp);
```

8. 注意事项：
- 使用前确保容器是有序的
- 返回值是迭代器，需要注意是否等于end()
- 对于关联容器(如set)，优先使用成员函数版本的lower_bound
- 如果需要找到第一个大于某个值的元素，应该使用upper_bound
