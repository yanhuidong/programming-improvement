在C++标准库中，`multiset` 是一个非常有用的容器类，属于 `<set>` 头文件。它与 `set` 类似，但有一个重要的区别：`multiset` 允许存储重复的元素，而 `set` 中的每个元素都是唯一的。

### 1. `multiset` 的基本介绍

`multiset` 是一个基于平衡二叉搜索树（通常是红黑树）实现的容器，它能够自动按元素的排序规则将元素存储在内部。在 `multiset` 中，元素是有序的，可以通过键值来查找，插入的元素会自动按升序（或自定义排序规则）排列。

### 2. `multiset` 的特点

- **允许重复元素**：`multiset` 可以存储重复的元素，而 `set` 不允许。
- **自动排序**：所有插入的元素都会按升序（或自定义的排序规则）自动排序。
- **基于红黑树实现**：元素按照键值排列，可以高效地进行查找、插入和删除。

### 3. `multiset` 的常用操作

`multiset` 提供了许多常用的成员函数来进行元素的插入、查找、删除等操作。下面介绍一些常见的操作。

#### (1) 构造函数

```cpp
std::multiset<T> ms;  // 默认构造函数，创建一个空的 multiset
std::multiset<T, Compare> ms2;  // 使用自定义比较函数创建 multiset
std::multiset<T> ms3 = {1, 2, 2, 3};  // 使用初始化列表
```

#### (2) 插入元素

可以使用 `insert` 来向 `multiset` 中插入元素。

```cpp
std::multiset<int> ms;
ms.insert(5);  // 插入单个元素
ms.insert(10); // 插入单个元素
ms.insert({2, 7, 3});  // 使用初始化列表插入多个元素
```

**注意**：由于 `multiset` 允许重复元素，所以即使插入相同的元素，它们也会被保留。

#### (3) 查找元素

可以通过 `find` 函数查找特定元素，如果找到则返回该元素的迭代器，否则返回 `end()`。

```cpp
auto it = ms.find(10);
if (it != ms.end()) {
    std::cout << "元素 10 找到。" << std::endl;
}
```

#### (4) 计数某个元素的出现次数

`multiset` 中的元素可能出现多次，可以使用 `count` 函数来查询某个元素出现的次数。

```cpp
std::cout << "元素 2 出现了 " << ms.count(2) << " 次。" << std::endl;
```

#### (5) 删除元素

可以通过 `erase` 来删除单个元素、指定范围的元素或所有特定值的元素。

- 删除单个元素：

```cpp
ms.erase(10);  // 删除所有值为 10 的元素
```

- 删除范围内的元素：

```cpp
ms.erase(ms.begin(), ms.find(7));  // 删除从 begin 到第一个值为 7 之间的元素
```

- 删除指定位置的元素：

```cpp
auto it = ms.find(7);
ms.erase(it);  // 删除值为 7 的第一个元素
```

#### (6) 获取元素数量

可以使用 `size()` 来获取 `multiset` 中的元素数量，或者使用 `empty()` 来检查容器是否为空。

```cpp
std::cout << "容器大小: " << ms.size() << std::endl;
std::cout << "容器是否为空: " << (ms.empty() ? "是" : "否") << std::endl;
```

#### (7) 遍历 `multiset`

可以通过迭代器遍历 `multiset` 中的所有元素。由于 `multiset` 是有序的，元素会按照升序排列。

```cpp
for (auto it = ms.begin(); it != ms.end(); ++it) {
    std::cout << *it << " ";
}
std::cout << std::endl;
```

### 4. 示例代码

下面是一个简单的例子，演示了 `multiset` 的基本用法：

```cpp
#include <iostream>
#include <set>

int main() {
    // 创建一个 multiset 并插入元素
    std::multiset<int> ms;
    ms.insert(5);
    ms.insert(3);
    ms.insert(10);
    ms.insert(3);
    ms.insert(7);

    // 遍历并输出 multiset 中的元素
    std::cout << "multiset 中的元素：";
    for (const auto& elem : ms) {
        std::cout << elem << " ";
    }
    std::cout << std::endl;

    // 查找元素
    auto it = ms.find(3);
    if (it != ms.end()) {
        std::cout << "找到元素 3。" << std::endl;
    }

    // 输出元素的数量
    std::cout << "元素 3 的数量： " << ms.count(3) << std::endl;

    // 删除一个元素
    ms.erase(3);
    std::cout << "删除元素 3 后的 multiset：";
    for (const auto& elem : ms) {
        std::cout << elem << " ";
    }
    std::cout << std::endl;

    return 0;
}
```

### 5. `multiset` 的高级用法

#### (1) 自定义排序

如果需要按照自定义规则对元素进行排序，可以通过提供一个比较函数来构造 `multiset`。例如，按降序排序：

```cpp
#include <iostream>
#include <set>

bool compare(int a, int b) {
    return a > b;  // 按降序排序
}

int main() {
    std::multiset<int, decltype(&compare)> ms(compare);
    ms.insert(5);
    ms.insert(3);
    ms.insert(10);
    ms.insert(3);
    ms.insert(7);

    for (const auto& elem : ms) {
        std::cout << elem << " ";
    }
    std::cout << std::endl;

    return 0;
}
```

### 6. 总结

`multiset` 是一个非常强大的容器，适用于需要存储并按排序规则管理重复元素的场景。它提供了高效的查找、插入和删除操作，并且可以自定义排序规则。
通过 `multiset`，你可以轻松地处理重复数据、统计元素频次以及对数据进行有序存储和操作。
