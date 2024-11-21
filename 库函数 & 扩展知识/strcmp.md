在C++中，`strcmp` 是一个用于比较两个 C 风格字符串（即以 null 字符 `'\0'` 结尾的字符数组）的库函数。它的声明在 `<cstring>` 头文件中。

### `strcmp` 函数原型：
```cpp
int strcmp(const char* str1, const char* str2);
```

### 函数参数：
- `str1`：指向第一个 C 风格字符串的指针。
- `str2`：指向第二个 C 风格字符串的指针。

### 函数返回值：
`strcmp` 的返回值是一个整数，根据比较的结果不同，其返回值有三种可能的情况：
1. **返回 0**：如果 `str1` 和 `str2` 相等（即它们的字符逐个匹配，直到遇到 null 字符 `'\0'`）。
2. **返回负值（通常为-1）**：如果 `str1` 小于 `str2`（根据 ASCII 值的字典顺序比较）。
3. **返回正值（通常为1）**：如果 `str1` 大于 `str2`（根据 ASCII 值的字典顺序比较）。

### 比较方式：
`strcmp` 是基于字典顺序进行比较的，从字符串的第一个字符开始逐个比较：
- 如果两个字符不同，`strcmp` 将返回它们的差值（即 `str1[i] - str2[i]`），其中 `i` 是当前比较的字符位置。
- 如果到达字符串的结尾（即遇到 `'\0'`），且两个字符串的长度不同，较短的字符串被认为小于较长的字符串。

### 例子：
```cpp
#include <iostream>
#include <cstring>

int main() {
    const char* str1 = "apple";
    const char* str2 = "banana";
    const char* str3 = "apple";

    // 比较 str1 和 str2
    int result1 = strcmp(str1, str2);
    if (result1 < 0) {
        std::cout << str1 << " is lexicographically less than " << str2 << std::endl;
    } else if (result1 > 0) {
        std::cout << str1 << " is lexicographically greater than " << str2 << std::endl;
    } else {
        std::cout << str1 << " is equal to " << str2 << std::endl;
    }

    // 比较 str1 和 str3
    int result2 = strcmp(str1, str3);
    if (result2 < 0) {
        std::cout << str1 << " is lexicographically less than " << str3 << std::endl;
    } else if (result2 > 0) {
        std::cout << str1 << " is lexicographically greater than " << str3 << std::endl;
    } else {
        std::cout << str1 << " is equal to " << str3 << std::endl;
    }

    return 0;
}
```

### 输出：
```
apple is lexicographically less than banana
apple is equal to apple
```

### 详细解释：
1. `strcmp(str1, str2)` 比较字符串 `"apple"` 和 `"banana"`。由于 `'a' < 'b'`，因此返回一个负值，表示 `"apple"` 小于 `"banana"`。
2. `strcmp(str1, str3)` 比较 `"apple"` 和 `"apple"`，它们相等，所以返回值为 `0`。

### 注意事项：
1. **大小写敏感**：`strcmp` 是大小写敏感的，也就是说，大写字母会被认为小于小写字母。例如，`strcmp("apple", "Apple")` 会返回一个正值，因为 `'a' > 'A'`。
2. **空字符串的比较**：空字符串 `""` 会被认为是小于任何非空字符串。例如，`strcmp("", "abc")` 会返回负值。

### `strncmp` 函数：
如果你只想比较前 `n` 个字符，可以使用 `strncmp` 函数，它的原型如下：
```cpp
int strncmp(const char* str1, const char* str2, size_t n);
```
`strncmp` 会在最多比较 `n` 个字符后停止，适用于需要部分比较的情况。

### 总结：
- `strcmp` 用于比较两个 C 风格字符串，返回值表示它们在字典顺序上的关系。
- 该函数非常常用，在许多 C++ 标准库函数中也会用到它，特别是在排序和查找操作中。

