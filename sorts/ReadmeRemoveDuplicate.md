# Remove Duplicates from Sorted Array — Two Pointer Approach

Suppose we have the following sorted array:

```text
nums = [1, 1, 2, 2, 3]
```

We use two pointers:

```text
slow = 0
fast = 1
```

* `slow` points to the position where the next unique element should go.
* `fast` scans through the array looking for new unique elements.

---

## Step 1

Initially:

```text
[1, 1, 2, 2, 3]
 ↑  ↑
slow fast
```

Both pointers point to `1`.

```text
nums[fast] != nums[slow]

1 != 1  // false
```

Since they are equal, we do nothing.

The duplicate `1` stays there **for now**.

---

## Step 2

`fast` moves forward:

```text
[1, 1, 2, 2, 3]
 ↑     ↑
slow  fast
```

Now:

```text
nums[slow] = 1
nums[fast] = 2
```

They are different:

```text
2 != 1  // true
```

So we execute:

```text
slow++;
nums[slow] = nums[fast];
```

Now:

```text
slow = 1
nums[1] = 2
```

The array becomes:

```text
[1, 2, 2, 2, 3]
    ↑
   slow
```

### What happened to the duplicate `1`?

The duplicate `1` at index `1` was **overwritten by `2`**.

This is the important idea behind the two-pointer approach.

We don't actually delete elements from the array.

Instead, we **overwrite duplicate positions with the next unique elements**.

---

## Step 3

`fast` moves again:

```text
[1, 2, 2, 2, 3]
    ↑     ↑
   slow  fast
```

Now:

```text
nums[slow] = 2
nums[fast] = 2
```

They are equal:

```text
2 == 2
```

So we skip this element.

Nothing changes:

```text
[1, 2, 2, 2, 3]
    ↑     ↑
   slow  fast
```

---

## Step 4

`fast` moves again:

```text
[1, 2, 2, 2, 3]
    ↑        ↑
   slow     fast
```

Now:

```text
nums[slow] = 2
nums[fast] = 3
```

They are different:

```text
2 != 3  // true
```

So:

```text
slow++;
nums[slow] = nums[fast];
```

Now:

```text
slow = 2
nums[2] = 3
```

The array becomes:

```text
[1, 2, 3, 2, 3]
       ↑
      slow
```

---

## Final Result

At this point, the unique elements are at the beginning of the array:

```text
[1, 2, 3, 2, 3]
 ───────
  unique
```

The valid portion is:

```text
[1, 2, 3]
```

We return:

```text
return slow + 1;
```

Since:

```text
slow = 2
```

we get:

```text
k = 2 + 1
k = 3
```

Therefore, the answer is:

```text
[1, 2, 3]
```

with:

```text
k = 3
```

---

## Why Do We Return `slow + 1`?

`slow` stores the **index** of the last unique element.

Since arrays are zero-indexed:

```text
index:  0  1  2
value:  1  2  3
```

The last unique element is at index `2`.

Therefore, the number of unique elements is:

```text
2 + 1 = 3
```

So:

```text
return slow + 1;
```

---

## Complete Code

### Java

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
```

### Complexity

* **Time:** `O(n)` — `fast` scans the array once.
* **Space:** `O(1)` — no extra array is created.

### Key Idea

> **`fast` finds unique elements, and `slow` builds the unique portion of the array.**

The duplicate elements are not explicitly removed. They are simply **overwritten** as new unique elements are found.
