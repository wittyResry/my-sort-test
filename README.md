### Introduction to Algorithms
* 假设下标为A[1..N]，需要对A进行从小到大排序

### 2.1 插入排序
```
INSERT-SORT(A)
 for j <- 2 to length(A)
 	do 	key <- A[j]
 	i <- j - 1
 	while i > 0 and A[i] > key
 		do 	A[i+1]  <- A[i]
			i <- i - 1
	A[i+1] <- key
```


### 2.2-2 选择排序
```
SELECTION-SORT(A)
 for j <- 1 to length(A) - 1
 	do 	key <- A[j]
 		idx <- j
 	i <- j
 	while i to length(A) and A[i] < key
 		if A[i+1]  <- A[i]
 			key <- A[i]
 			idx <- i
		i <- i + 1
	swap(a[j], a[idx])
```

* 思考：	
  * 1）为什么仅需要对n-1哥元素上排序？因为每次选择最小的，n-1个最小的元素排好序以后，最后一个元素一定是排好的。
  * 2）最佳运行时间和最差运行时间？均为O(N^2)

### 2.3 归并排序
```
MERGE-SORT(A, p, r)
	if (p < r)
		do q = (p + r) / 2
		MERGE-SORT(A, p, q)
		MERGE-SORT(A, q+1, r)
		MERGE(A, p, q, r)

MERGE(A, p, q, r)
	n1 <- q - p + 1
	n2 <- r - q
	for i <- 1 to n1
		do L[i] <- A[p + i - 1]
	for j <- 1 to n2
		do R[j] <- A[q + j]
	L[n1 + 1] <- oo
	L[n2 + 1] <- oo
	i <- 1
	j <- 1
	for k <- p to r
		if L[i] <= R[j]
			A[k] = L[i]
			i <- i + 1
		else
			A[k] = R[j]
			j <- j + 1

```


* 思考：
  * 1）归并排序的核心思想是什么？
  ```
  分治算法：
  1 分解（将原问题分解成一系列子问题）;
  2 合并（递归地解各子问题）;
  3. 合并（将子问题的结果合并成原问题的解）
  ```

  ### 2.4 冒泡排序
  ```
  BUBBLE-SORT(A)
  	for i <- 1 to length(A)
  		do for j <- length(A) downto i+1
  			do if A[j] < A[j-1]
  				then exchange(A[j], A[j-1])

  
  ```

  ### 6.1 堆排序

```
MAX-HEAPIFY(A, i)
  l = LEFT(i);
  r = RIGHT(i);
  if l <= HEAP-SIZE(A) and A[l] > A[i]
    then largest = l
    else largest = i
  if r <= HEAP-SIZE(A) and A[r] > A[largest]
    then largest = r
  if largest != i
    then exchange A[i] <-> A[largest]
      MAX-HEAPIFY(A, largest)
BUILD-MAX-HEAD(A)
  HEAD-SIZE(A) = length[A]
  for i <- length[A] downto 1
    do MAX-HEAPIFY(A, i)
HEAPSORT(A)
  BUILD-MAX-HEAP(A)
  for i <- length(A) downto 2
    do exchange A[1] <-> A[i]
      HEAP-SIZE(A) = HEAP-SIZE(A) - 1
      MAX-HEAPIFY(A, 1)
PARENT(i)
  return i/2
LEFT(i)
  return 2*i
RIGHT(i)
  return 2*i+1
```

### 7.1 快速排序
```
QUICKSORT(A, p, r)
    if p < r
        then q = PARTITION(A, p, r)
            QUICKSORT(A, p, q - 1)
            QUICKSORT(A, q + 1, r)
PARTITION(A, p, r)
    x <- A[r]
    i <- p - 1
    for j <- p to r - 1
        do if A[j] <= x
            then i = i + 1
                 exchange A[i] <-> A[j]
    exchange A[i+1] <-> A[r]
    return i + 1
```
思考：快速排序的时间复杂度如何证明？提示：数学期望，因为各个元素仅与主元素进行比较，并且在某次比较PARTITION调用结束以后，该次调用中所有用到的主元素就不会与其他任何其他元素进行比较了。


### 8.1 线性时间排序
思考：排序时间的下界证明？提示：决策树模型

### 8.2 基数排序
```
COUNTING-SORT(A, B, k)
    for i <- 0 to k
        do C[i] = 0
    for j <- 1 to length(A)
        do C[A[j]] = C[A[j]] + 1
    for i <- 1 to k
        do C[i] = C[i] + C[i - 1]
    //C[i] 表示有C[i]个元素小于等于i
    for j <- length(A) downto 1
        do B[C[A[j]]] = A[j]
           C[A[j]] = C[A[j]] - 1

```
