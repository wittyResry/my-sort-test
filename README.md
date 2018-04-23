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