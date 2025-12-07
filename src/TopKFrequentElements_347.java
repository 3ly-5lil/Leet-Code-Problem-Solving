import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int[] nums = {
                1, 1, 1, 2, 2, 3
        };

        int k = 2;

        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, k)));
    }

    static class Solution {
        // O(k.log(m))
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();

            // O(n)
            for (int x : nums) {
                int freq = counter.getOrDefault(x, 0) + 1;
                counter.put(x, freq);
            }

            // ? using the frequency as the index
            List<Integer>[] freq = new ArrayList[nums.length + 1];

            // O(m)
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                if (freq[entry.getValue()] == null) freq[entry.getValue()] = new ArrayList<>();
                List<Integer> freqList = freq[entry.getValue()];
                freqList.add(entry.getKey());
            }

            int[] ans = new int[k];

            int added = 0;

            //  O(k)
            for (int i = nums.length; i >= 0; i--) {
                List<Integer> list = freq[i];
                if (list == null) continue;
                for (int e : list) {
                    ans[added++] = e;
                }
                if (added == k) break;
            }


            return ans;
        }

        // O(k.log(m))
        public int[] topKFrequent2(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();

            // O(n)
            for (int x : nums) {
                int freq = counter.getOrDefault(x, 0) + 1;
                counter.put(x, freq);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b.getValue(), a.getValue())
            );


            // O(m) ? m is unique numbers
            heap.addAll(counter.entrySet());

            // O(k.log(m)) ? k iterations log(m) sorting
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = Objects.requireNonNull(heap.poll()).getKey();
            }

            return ans;
        }

        // O(n.k)
        public int[] topKFrequent3(int[] nums, int k) {
            Map<Integer, Integer> freqs = new HashMap<>();

            // O(n)
            for (int x : nums) {
                int freq = freqs.getOrDefault(x, 0) + 1;
                freqs.put(x, freq);
            }

            List<Integer> sortedFreqs = new LinkedList<>();

            // O(n^2)
            freqs.forEach((key, value) -> {
                boolean added = false;
                for (int i = 0; i < sortedFreqs.size(); i++) {
                    int current = sortedFreqs.get(i);

                    if (value > freqs.get(current)) {
                        sortedFreqs.add(i, key);
                        added = true;
                        break;
                    }
                }

                if (!added) sortedFreqs.addLast(key);
            });

            // O(k)
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = sortedFreqs.get(i);
            }
            return ans;
        }
    }
}
