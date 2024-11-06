# [464. 我能赢吗](https://leetcode.cn/problems/can-i-win/description/)

在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。  

如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？  

例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。  

给定两个整数 `maxChoosableInteger` （整数池中可选择的最大数）和 `desiredTotal`（累计和），若先出手的玩家能稳赢则返回 `true` ，否则返回 `false` 。假设两位玩家游戏时都表现 最佳。

---

这道题说实话是真的难，动态规划、递归还有数学、博弈，这几个东西合一起是真难搞，题解都看了我半天，但是说实话，看了这道题之后，我真的收获了许多，也许过了几天我就又会忘了，
但是，这也许就是算法的魅力吧，我很喜欢这种把难题学好的感觉，很爽，虽然这道题我是完全靠别人的题解还有看GPT的解释才懂的但是我希望在不断地学习之后，我可以靠自己写出来，以后我会多多参加leetcode的周赛的，codeforce的如果时间允许的话我也想参加，但是时间是真的阴间，真没办法，看着办吧。

示例一：

> 输入：maxChoosableInteger = 10, desiredTotal = 11  
> 输出：false  
> 解释：
无论第一个玩家选择哪个整数，他都会失败。  
第一个玩家可以选择从 1 到 10 的整数。  
如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。  
第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.  
同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。

leetcode的[题解](https://leetcode.cn/problems/can-i-win/solutions/1510366/by-fuxuemingzhu-g16c/)，由于篇幅有限，我在这里就只写用GPT -o1的题解吧，但是GPT的题解也是根据这篇leetcode的题解写的，所以一定要看看。

## 以下是o1-mini的题解

这段代码实现了解决“Can I Win”（我能赢吗）问题的算法。该问题的核心在于判断两个玩家轮流从1到`maxChoosableInteger`的整数中选择数字，目标是使得选出的数字总和至少达到`desiredTotal`。玩家无法重复选择已经选过的数字，先达到或超过目标总和的玩家获胜。下面将详细分析这段代码的实现原理和具体细节。

## 问题描述

给定两个整数`maxChoosableInteger`和`desiredTotal`，判断第一个玩家是否能确保获胜。玩家轮流选择1到`maxChoosableInteger`之间的一个整数，且每个整数只能被选一次。选择的数字会累加到总和中，先使总和达到或超过`desiredTotal`的玩家获胜。如果所有数字都被选择过且总和未达到`desiredTotal`，则游戏以平局结束。

## 代码结构概述

代码通过递归和记忆化搜索（Memoization）来判断当前玩家是否能够确保获胜。关键部分包括：

1. **状态表示**：使用整数的二进制位来表示哪些数字已经被选过。
2. **记忆化数组**：`visited`数组用于记录每种状态下玩家是否能赢，避免重复计算。
3. **递归函数`dfs`**：用于判断在当前状态下，当前玩家是否有必胜的策略。

## 详细分析

### 类的成员变量

```cpp
private:
    // visited[i] == 0，说明没有计算过
    // visited[i] == 1，说明计算过，结果为 true
    // visited[i] == 2，说明计算过，结果为 false
    int visited[1 << 21];
```

- **`visited`数组**：这是一个记忆化数组，用于存储每个状态下的计算结果。由于`maxChoosableInteger`最大为20，所以状态可以用一个21位的二进制数表示（`1 << 21`）。`visited[i]`的值表示状态`i`下当前玩家是否能赢：
  - `0`：未计算过。
  - `1`：当前玩家在此状态下可以确保获胜。
  - `2`：当前玩家在此状态下无法确保获胜。

### 主函数`canIWin`

```cpp
bool canIWin(int maxChoosableInteger, int desiredTotal) {
    if (maxChoosableInteger >= desiredTotal)
        return true;
    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
        return false;
    // 判断当前做选择的玩家（先手），是否一定赢
    // 开始时，state = 0，表示「公共整数集」中的所有数字都未被使用过
    return dfs(0, 0, maxChoosableInteger, desiredTotal);
}
```

- **初步判断**：
  1. **直接获胜条件**：如果`maxChoosableInteger`本身大于或等于`desiredTotal`，第一个玩家可以直接选择这个数字获胜。
  2. **总和不足**：如果所有可选数字的总和（即`maxChoosableInteger * (maxChoosableInteger + 1) / 2`）小于`desiredTotal`，则不可能达到目标，总是返回`false`。

- **递归调用**：如果上述条件不满足，调用`dfs`函数开始递归搜索，初始状态`state=0`（所有数字都未被选过），初始总和`sum=0`。

### 递归函数`dfs`

```cpp
bool dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
    if (visited[state] == 1) return true;
    if (visited[state] == 2) return false;
    // 遍历可选择的公共整数
    for (int x = 1; x <= maxChoosableInteger; ++x) {
        // 如果 x 已经被使用过了，则不能选择
        if ((1 << x) & state) continue;
        // 如果选择了 x 以后，大于等于了 desiredTotal，当前玩家赢
        if (sum + x >= desiredTotal) {
            visited[state] = 1;
            return true;
        }
        // 当前玩家选择了 x 以后，判断对方玩家一定输吗？
        if (!dfs((1 << x) | state, sum + x, maxChoosableInteger, desiredTotal)) {
            visited[state] = 1;
            return true;
        }
    }
    visited[state] = 2;
    return false;
}
```

#### 参数解释

- **`state`**：表示当前已选择的数字状态，用二进制位表示。例如，如果`state=5`（即`101`），表示数字1和3已经被选过。
- **`sum`**：当前已选数字的总和。
- **`maxChoosableInteger`**和**`desiredTotal`**：问题的输入参数，保持不变。

#### 递归逻辑

1. **检查记忆化数组**：
   - 如果`visited[state] == 1`，表示在此状态下当前玩家可以赢，直接返回`true`。
   - 如果`visited[state] == 2`，表示在此状态下当前玩家无法赢，直接返回`false`。

2. **遍历所有可选数字**：
   - 对于每个数字`x`（从1到`maxChoosableInteger`），检查其是否已经被选过：
     - 使用位运算`(1 << x) & state`判断，如果结果非零，表示`x`已经被选过，跳过该数字。
   
3. **选择数字`x`后的情况**：
   - **直接获胜**：如果选择`x`后，`sum + x >= desiredTotal`，则当前玩家直接获胜。将`visited[state]`标记为`1`，并返回`true`。
   
   - **递归判断对手情况**：如果选择`x`后，对手在新的状态下无法获胜（即`!dfs(new_state, new_sum, ...)`为`true`），则当前玩家可以通过选择`x`确保获胜。此时，将`visited[state]`标记为`1`，并返回`true`。
   
   - **解释**：这里的逻辑是，如果当前玩家选择某个数字`x`后，无论对手如何选择，当前玩家都能通过后续的选择确保胜利，那么当前玩家就有必胜的策略。

4. **所有选择均无法确保胜利**：
   - 如果遍历所有可能的`x`后，当前玩家无法找到一个必胜的选择，则将`visited[state]`标记为`2`，表示在此状态下无法确保胜利，并返回`false`。

### 状态压缩与位运算

- **状态压缩**：使用一个整数的二进制位来表示哪些数字已经被选过。由于`maxChoosableInteger`最多为20，因此一个`int`类型的二进制位（至少32位）足够表示所有状态。
  
- **位运算**：
  - **检查数字是否被选过**：`(1 << x) & state`，如果结果非零，则表示数字`x`已被选过。
  - **标记数字为已选**：`(1 << x) | state`，将数字`x`的位设置为1，表示在新的状态下数字`x`已经被选过。

### 记忆化的意义

由于在递归过程中，很多状态会被重复计算，使用`visited`数组进行记忆化可以显著减少计算量，提高算法效率。通过记录每个状态下是否可以获胜，避免了重复的递归调用。

### 时间与空间复杂度

- **时间复杂度**：由于状态压缩后共有`2^maxChoosableInteger`种状态，且每个状态最多遍历`maxChoosableInteger`个数字，因此理论上的时间复杂度为`O(maxChoosableInteger * 2^maxChoosableInteger)`。但实际运行中，由于剪枝和记忆化的存在，运行效率会更高。

- **空间复杂度**：主要由`visited`数组决定，为`O(2^maxChoosableInteger)`。

## 总结

这段代码通过递归搜索和记忆化优化，巧妙地解决了“Can I Win”问题。它利用位运算高效地表示和处理状态，通过动态规划的方法判断当前玩家是否存在必胜的策略。该算法在处理较大的`maxChoosableInteger`时，虽然理论复杂度较高，但由于实际应用中的剪枝和记忆化，能够在合理的时间内得出结果。
