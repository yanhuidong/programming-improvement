# [K-divisible Sum](https://codeforces.com/problemset/problem/1476/A)

很快啊，啪的一下就有了思路，然后在错误提交了两三次之后才知道还有不少条件没考虑到。
首先就是在 `n > k` 的部分中，我没有考虑到 `n % k == 0` 的情况，导致结果出错，然后同样的，在 `n < k` 的部分中，我忘了 `k % n == 0` 的情况，这些错误都是不应该出现的，
每次都是**读题读一半，写题错一堆**，毁了啊。