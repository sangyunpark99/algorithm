## Longest Consecutive Sequence

Given an array of integers nums, return the length of the longest consecutive sequence of elements hta can be formed.  

A consecutive sequence is a sequence of elements in which each element is exactly `1` greater than the previous element. The elements do not have to be consecutive in the original array.  

## Discussion

## Approach
This solution uses a HashSet to find the longest consecutive sequence in O(n) time.

## Core Idea
The key idea is to only start counting when the current number is the beginning of a sequence.
A number is considered a start if (num - 1) does not exist int the set.

## Steps
1. Insert all numbers into a HashSet.
2. Iterate through the set.
3. For each number, check if it is a starting point.
4. Expand the sequence while (num + 1) exists.
5. Update the maximum length.

## Code
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int answer = 0;

        for(int value: set) {
            if(!set.contains(value - 1)) {
                int len = 1;
                int cur = value;

                while(set.contains(cur + 1)) {
                    len++;
                    cur++;
                }

                answer = Math.max(answer, len);
            }
        }

        return answer;
    }
}

```

## Complexity
- Time: $O(N)$
- Space: $O(N)$