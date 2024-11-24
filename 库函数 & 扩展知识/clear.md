在 C++ 中，`clear` 是一种常见的成员函数，通常用于 STL（标准模板库）容器类，如 `std::vector`、`std::list`、`std::map`、`std::set` 等。它的作用是**清空容器**，即删除容器中的所有元素，使容器变为空容器。

### 1. 用法概述

`clear` 函数的基本用法是：

```cpp
container.clear();
```

其中，`container` 是 STL 容器的一个实例，如 `std::vector`、`std::set` 等。调用 `clear()` 后，容器中的所有元素会被删除，但容器本身的内存分配和大小（`size()`）会发生变化。容器的大小变为 0，但容器的容量（`capacity()`）通常保持不变，除非容器本身会通过其他操作进行内存重分配。

### 2. 适用容器

`clear` 函数适用于大多数 STL 容器，包括但不限于以下类型：

- **`std::vector`**：动态数组
- **`std::list`**：双向链表
- **`std::deque`**：双端队列
- **`std::set`**：集合（无重复元素的有序容器）
- **`std::map`**：映射（键值对集合）
- **`std::unordered_set`**、**`std::unordered_map`**：无序集合/无序映射

### 3. 使用示例

#### 示例 1：`std::vector`

```cpp
#include <iostream>
#include <vector>

int main() {
    std::vector<int> vec = {1, 2, 3, 4, 5};
    
    std::cout << "Size before clear: " << vec.size() << std::endl; // 输出 5
    
    vec.clear();  // 清空 vector 中的元素
    
    std::cout << "Size after clear: " << vec.size() << std::endl; // 输出 0
    
    return 0;
}
```

在此示例中，`clear()` 删除了 `vec` 中的所有元素，使其大小变为 0。注意，尽管容器的大小变为 0，`capacity()`（即分配的内存大小）通常不变，直到进行其他操作（例如，`shrink_to_fit()`）时才可能释放多余的内存。

#### 示例 2：`std::map`

```cpp
#include <iostream>
#include <map>

int main() {
    std::map<int, std::string> m;
    m[1] = "apple";
    m[2] = "banana";
    m[3] = "cherry";
    
    std::cout << "Size before clear: " << m.size() << std::endl; // 输出 3
    
    m.clear();  // 清空 map 中的所有元素
    
    std::cout << "Size after clear: " << m.size() << std::endl; // 输出 0
    
    return 0;
}
```

在此示例中，`clear()` 会删除 `std::map` 中所有的键值对，`size()` 返回 0，表示容器为空。

#### 示例 3：`std::set`

```cpp
#include <iostream>
#include <set>

int main() {
    std::set<int> s = {1, 2, 3, 4, 5};
    
    std::cout << "Size before clear: " << s.size() << std::endl; // 输出 5
    
    s.clear();  // 清空 set 中的所有元素
    
    std::cout << "Size after clear: " << s.size() << std::endl; // 输出 0
    
    return 0;
}
```

类似于 `std::map`，`std::set` 的 `clear()` 也会删除所有元素。

### 4. 注意事项

- **性能影响**：`clear()` 通常是一个高效的操作，时间复杂度为 O(n)，其中 n 是容器中的元素个数，因为它需要删除所有元素。但是，容器的内存分配（`capacity()`）通常不受影响，除非容器进行了额外的内存管理操作。
  
- **指针的生命周期**：如果容器中存储的是指针或动态分配的对象，`clear()` 会删除容器中的指针或对象，但不会删除它们指向的内存。开发者需要确保在调用 `clear()` 后正确管理内存，防止内存泄漏。

- **与其他方法的区别**：
  - `resize(0)`：虽然 `resize(0)` 也会清空容器，但它会尝试保持容器的当前容量，不同于 `clear()`，它不会释放容器的内部内存。
  - `shrink_to_fit()`：`clear()` 不会释放容器分配的内存，而 `shrink_to_fit()` 可以要求容器缩减其容量，但并不是所有容器实现都保证会回收内存。

### 5. 总结

`clear()` 是一个非常简单而且常用的 C++ STL 函数，用于清空容器中的所有元素。它操作起来非常方便，可以高效地将容器大小设置为零，但并不直接改变容器的容量。它广泛适用于各种 STL 容器类型，包括 `std::vector`、`std::list`、`std::set`、`std::map` 等。
