`substr` 函数是 C++ 标准库中 `std::string` 类的一个成员函数，用于从一个字符串中提取子串。它的基本用法如下：

```cpp
string substr(size_t pos = 0, size_t len = npos) const;
```

参数说明：
1. `pos`：子串的起始位置（索引从0开始）。默认值为0，表示从字符串开头开始。
2. `len`：要提取的子串长度。默认值为 `string::npos`，表示一直提取到字符串末尾。

返回值：
- 返回一个新的 `string` 对象，包含提取出的子串。

使用示例：

1. 基本用法：

```cpp
#include <iostream>
#include <string>

int main() {
    std::string str = "Hello, World!";
    
    // 从索引 7 开始提取 5 个字符
    std::string sub1 = str.substr(7, 5);
    std::cout << sub1 << std::endl;  // 输出: World

    // 从索引 0 开始提取 5 个字符
    std::string sub2 = str.substr(0, 5);
    std::cout << sub2 << std::endl;  // 输出: Hello

    // 从索引 7 开始提取到末尾
    std::string sub3 = str.substr(7);
    std::cout << sub3 << std::endl;  // 输出: World!

    return 0;
}
```

2. 错误处理：

如果 `pos` 超出字符串范围，`substr` 会抛出 `std::out_of_range` 异常。如果 `pos + len` 超出字符串范围，则只会提取到字符串末尾。

```cpp
#include <iostream>
#include <string>

int main() {
    std::string str = "Hello";
    
    try {
        // 这会抛出异常，因为起始位置超出了字符串长度
        std::string sub = str.substr(10);
    } catch (const std::out_of_range& e) {
        std::cout << "Exception caught: " << e.what() << std::endl;
    }

    // 这不会抛出异常，但会调整长度
    std::string sub = str.substr(2, 10);
    std::cout << sub << std::endl;  // 输出: llo

    return 0;
}
```

3. 实际应用：

`substr` 函数在处理字符串时非常有用，例如：

- 提取文件扩展名：

```cpp
std::string filename = "example.txt";
std::string extension = filename.substr(filename.find_last_of(".") + 1);
```

- 分割字符串：

```cpp
std::string str = "apple,banana,orange";
size_t pos = 0;
std::string token;
while ((pos = str.find(",")) != std::string::npos) {
    token = str.substr(0, pos);
    std::cout << token << std::endl;
    str.erase(0, pos + 1);
}
std::cout << str << std::endl;
```

注意：`substr` 函数会创建一个新的子字符串对象，这在某些情况下可能是一个不必要的性能开销。

扩展：使用字符串的迭代器，可以更加灵活地进行操作，特别是当你需要基于某些条件进行截取时。

示例：

```cpp
#include <iostream>
#include <string>

int main() {
    std::string str = "Hello, World!";

    // 使用字符串的迭代器来创建子字符串
    std::string subStr(str.begin() + 7, str.begin() + 12);

    std::cout << "Original string: " << str << std::endl;
    std::cout << "Sub-string: " << subStr << std::endl;

    return 0;
}

```

输出：

```cpp

Original string: Hello, World!
Sub-string: World

```

