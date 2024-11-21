# [A. Mahmoud and Longest Uncommon Subsequence](https://codeforces.com/problemset/problem/766/A)

这道题是真的水啊，只要找对思路，就可以轻松写出来，但是如果找不到思路的话就会完蛋，幸好我找对了思路[doge]，我的代码粘在下面：

```cpp

#include<bits/stdc++.h>
using namespace std;
string a, b;
int main() {
    cin >> a >> b;
    if (a == b)
        cout << -1 << endl;
    else {
        int l1 = a.length();
        int l2 = b.length();
        cout << (l1 > l2 ? l1 : l2) << endl;
    }
    return 0;
}
```

如你所见，思路很简单，一眼就能看出来我的代码写的是什么意思，下面看看别人用了一些库函数的[解法](https://www.luogu.com.cn/article/a2h3qm16)：

```cpp

#include<bits/stdc++.h>//万能头文件
#define reg register//register将变量存在CPU缓存里面,更快
using namespace std;//在OI中建议都要加
char a[1000000],b[1000000];//char数组 
int main()
{
    scanf("%s%s",a,b);//输入字符数组a,b,注意不加& 
    if(!strcmp(a,b))puts("-1");//不是子串 
    //strcmp:判断两个字符串是否相等,相等返回0，不相等返回一个正数(目前暂未找到规律
    //扩展:strstr(a,b):判断b是否是a的字串
    //strcat(a,b):连接ab并储存在a中
	else printf("%d",max(strlen(a),strlen(b)));//较长的长度 
    //strlen:字符数组有效信息的长度,相当于string.length() or size()
    return 0;//结束 
}
```
