在C++标准库中，`erase` 是一个用于移除容器元素的函数，广泛应用于各种容器中，如 `std::vector`、`std::list`、`std::deque`、`std::set`、`std::map`、`std::unordered_set` 和 `std::unordered_map` 等。根据使用的容器类型，`erase` 的功能和参数有所不同。下面详细介绍不同容器中的 `erase` 函数的用法。

### 1. `std::vector` 和 `std::deque` 中的 `erase`

在 `std::vector` 和 `std::deque` 中，`erase` 用于删除指定位置的元素。其定义如下：

```cpp
iterator erase(iterator pos);
iterator erase(iterator first, iterator last);
```

- **`erase(iterator pos)`**: 删除容器中指定位置 `pos` 的单个元素。
- **`erase(iterator first, iterator last)`**: 删除从 `first` 到 `last` 之间的所有元素（不包括 `last`）。

**示例代码：**

```cpp
#include <iostream>
#include <vector>

int main() {
    std::vector<int> vec = {1, 2, 3, 4, 5};

    // 删除索引位置为2的元素，即数字3
    vec.erase(vec.begin() + 2);

    // 删除索引位置为1到4之间的元素，即数字2, 4, 5
    vec.erase(vec.begin() + 1, vec.end());

    for (int num : vec) {
        std::cout << num << " ";   //输出 1
    }

    return 0;
}
```

在这个示例中，`erase` 先删除了位置为 2 的元素（即 `3`），然后删除了从位置 1 到末尾的元素（即 `2`, `4`, `5`）。

### 2. `std::list` 中的 `erase`

`std::list` 是一个双向链表容器，它的 `erase` 操作效率较高，尤其是在删除元素时不需要移动其它元素。`erase` 的用法与 `std::vector` 相似，但由于 `std::list` 是链表结构，删除元素不会影响其他元素的地址。

```cpp
iterator erase(iterator pos);
iterator erase(iterator first, iterator last);
```

- **`erase(iterator pos)`**: 删除指定位置的单个元素。
- **`erase(iterator first, iterator last)`**: 删除从 `first` 到 `last` 之间的元素。

**示例代码：**

```cpp
#include <iostream>
#include <list>

int main() {
    std::list<int> lst = {1, 2, 3, 4, 5};

    // 删除第二个元素，即数字2
    auto it = lst.begin();
    std::advance(it, 1);
    lst.erase(it);

    // 删除前两个元素，即数字1和3
    it = lst.begin();
    std::advance(it, 1);
    lst.erase(it, lst.end());

    for (int num : lst) {
        std::cout << num << " ";   // 输出 4 5
    }

    return 0;
}
```

### 3. `std::set` 和 `std::map` 中的 `erase`

`std::set` 和 `std::map` 是基于红黑树实现的有序集合，其中的元素是唯一的。`erase` 在这些容器中通常用于删除指定的元素或通过键值删除元素。

```cpp
size_t erase(const key_type& key);
iterator erase(iterator pos);
iterator erase(iterator first, iterator last);
```

- **`erase(const key_type& key)`**: 根据给定的键值删除对应的元素。
- **`erase(iterator pos)`**: 删除迭代器所指向的元素。
- **`erase(iterator first, iterator last)`**: 删除迭代器范围内的元素。

**示例代码：**

```cpp
#include <iostream>
#include <set>

int main() {
    std::set<int> s = {1, 2, 3, 4, 5};

    // 根据元素值删除
    s.erase(3);

    // 删除迭代器范围内的元素
    auto it1 = s.begin();
    auto it2 = s.find(5);
    s.erase(it1, it2);

    for (int num : s) {
        std::cout << num << " ";    //输出 4
    }

    return 0;
}
```

### 4. `std::unordered_set` 和 `std::unordered_map` 中的 `erase`

`std::unordered_set` 和 `std::unordered_map` 是基于哈希表实现的容器。它们的 `erase` 方法用法类似于 `std::set` 和 `std::map`，但它们不保证元素的顺序。

```cpp
size_t erase(const key_type& key);
iterator erase(iterator pos);
iterator erase(iterator first, iterator last);
```

- **`erase(const key_type& key)`**: 根据给定的键值删除对应的元素。
- **`erase(iterator pos)`**: 删除迭代器所指向的元素。
- **`erase(iterator first, iterator last)`**: 删除迭代器范围内的元素。

**示例代码：**

```cpp
#include <iostream>
#include <unordered_set>

int main() {
    std::unordered_set<int> uset = {1, 2, 3, 4, 5};

    // 根据元素值删除
    uset.erase(3);

    // 删除一个迭代器指向的元素
    auto it = uset.begin();
    uset.erase(it);

    for (int num : uset) {
        std::cout << num << " ";    //输出 4 5 2 1
    }

    return 0;
}
```

### 5. 性能考虑

- 对于 `std::vector` 和 `std::deque`，`erase` 会导致后续元素的移动，因此删除操作的时间复杂度为 **O(n)**，其中 `n` 是从删除位置到容器末尾的元素个数。
- 对于 `std::list`、`std::set`、`std::map`、`std::unordered_set` 和 `std::unordered_map`，`erase` 的时间复杂度通常为 **O(log n)** 或 **O(1)**，其中 `n` 是容器的元素个数。对于 `std::unordered_set` 和 `std::unordered_map`，删除操作的时间复杂度是常数时间 **O(1)**，但在最坏情况下可能退化为 **O(n)**，这是由于哈希冲突。

### 总结

- `erase` 是 C++ 标准库中用于删除容器元素的函数，可以用于删除单个元素、多个元素或通过迭代器范围删除。
- 在不同容器中的实现可能有所不同，但基本思想是一样的：通过迭代器定位到要删除的元素或范围，然后执行删除操作。
- 使用 `erase` 时，考虑到容器的底层实现，性能和复杂度可能会有所差异，特别是在 `std::vector` 和 `std::deque` 这种基于动态数组的容器中，删除元素可能需要移动大量元素。
