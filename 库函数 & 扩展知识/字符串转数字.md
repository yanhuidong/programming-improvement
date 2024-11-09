在C++中，你可以使用几种不同的方法将字符串转化为数字。以下是一些常见的方法：

1. `std::stoi` (string to integer):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "123";
    int number;

    try {
        number = std::stoi(str);
        std::cout << "Converted string to integer: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

2. `std::stol` (string to long):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "1234567890123";
    long number;

    try {
        number = std::stol(str);
        std::cout << "Converted string to long: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

3. `std::stoll` (string to long long):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "1234567890123456789";
    long long number;

    try {
        number = std::stoll(str);
        std::cout << "Converted string to long long: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

4. `std::stof` (string to float):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "3.14";
    float number;

    try {
        number = std::stof(str);
        std::cout << "Converted string to float: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

5. `std::stod` (string to double):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "3.14159";
    double number;

    try {
        number = std::stod(str);
        std::cout << "Converted string to double: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

6. `std::stold` (string to long double):
```cpp
#include <iostream>
#include <string>
#include <stdexcept>

int main() {
    std::string str = "3.14159";
    long double number;

    try {
        number = std::stold(str);
        std::cout << "Converted string to long double: " << number << std::endl;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Invalid argument error: " << e.what() << std::endl;
    }

    return 0;
}
```

这些函数都会尝试将字符串转换为相应的数值类型。如果字符串不能被成功转换为数字，它们会抛出一个异常。通常，这些函数可以处理各种格式，包括正数、负数、整数和小数。

请注意，这些函数的行为可能会根据编译器的不同而有所不同，特别是在处理边界情况时。因此，最好总是捕获可能的异常并处理它们。
