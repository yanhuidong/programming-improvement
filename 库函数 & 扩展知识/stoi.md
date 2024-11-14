在C++中，`stoi`函数是字符串转换为整数的标准库函数之一。以下是对`stoi`函数的详细解释：

### 1. 函数定义
`stoi`函数定义在 `<string>` 头文件中，完整的函数原型如下：

```cpp
int stoi (const string& str, size_t* idx = 0, int base = 10);
```

### 2. 参数解释

- **str**: 要转换的字符串。
- **idx**（可选）: 指向一个 `size_t` 类型的指针，用于存储解析字符串时读取了多少字符。如果转换成功，`*idx` 将被设置为转换后第一个未使用的字符的位置。如果不提供此参数，`stoi` 只会尝试从字符串开头转换数字。
- **base**（可选）: 数字的基数，默认为10（十进制）。可以是2到36之间的值，代表从二进制到36进制。

### 3. 功能

`stoi` 会尝试从字符串的开头将数字字符转换为整数，直到遇到一个非数字字符或字符串结束。以下是一些关键点：

- **空格处理**: 字符串前导的空格会被忽略。
- **符号处理**: 支持正负号，如果字符串以 '+' 或 '-' 开头，`stoi` 会正确处理这些符号。
- **非数字字符**: 一旦遇到非数字字符（根据指定的基数），转换会停止。
- **异常处理**: 如果字符串不能转换为有效的整数（例如，全是空格或非数字字符），`stoi` 会抛出 `invalid_argument` 异常。如果转换导致溢出（超出 `int` 范围），会抛出 `out_of_range` 异常。

### 4. 使用示例

```cpp
#include <iostream>
#include <string>

int main() {
    std::string str1 = "123";
    std::string str2 = "  456xyz";
    std::string str3 = "0xABC";
    std::string str4 = "-789";

    // 基本使用
    int num1 = std::stoi(str1);
    std::cout << "num1: " << num1 << std::endl; // 输出 123

    // 使用 idx 参数
    size_t pos;
    int num2 = std::stoi(str2, &pos);
    std::cout << "num2: " << num2 << ", position: " << pos << std::endl; // 输出 num2: 456, position: 7

    // 使用不同基数
    int num3 = std::stoi(str3, nullptr, 16);
    std::cout << "num3: " << num3 << std::endl; // 输出 2748

    // 处理负数
    int num4 = std::stoi(str4);
    std::cout << "num4: " << num4 << std::endl; // 输出 -789

    return 0;
}
```

### 5. 注意事项

- `stoi` 只能转换到 `int` 类型，如果需要更大的数字类型，可以使用 `stol`（转换到 `long`）或 `stoll`（转换到 `long long`）。
- 确保处理可能的异常，因为字符串转换可能失败或导致溢出。
