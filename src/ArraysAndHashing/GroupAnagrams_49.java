package ArraysAndHashing;

import java.util.*;

public class GroupAnagrams_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> resultsMap = new HashMap<>(strs.length);

            for (String str : strs) {

                char[] chars = str.toCharArray();
                int[] asciiCount = new int[26];
                for (char c : chars) {
                    asciiCount[c - 'a']++;
                }

                var sb = new StringBuilder();
                for (int i : asciiCount) {
                    sb.append(i);
                }

                String sortedString = sb.toString();
                List<String> matched = resultsMap.getOrDefault(sortedString, new ArrayList<>());
                matched.add(str);

                resultsMap.put(sortedString, matched);
            }

            return new ArrayList<>(resultsMap.values());
        }

        public List<List<String>> groupAnagrams2(String[] strs) {
            Map<String, List<String>> resultsMap = new HashMap<>(strs.length);

            // sort word and compare
            // O(n)
            for (String str : strs) {
                // O(m)
                char[] chars = str.toCharArray();
                // O(m.log(m))
                Arrays.sort(chars);

                String sortedString = new String(chars);

                List<String> matched = resultsMap.getOrDefault(sortedString, new ArrayList<>());
                matched.add(str);

                resultsMap.put(sortedString, matched);
            }

            return new ArrayList<>(resultsMap.values());
        }

        public List<List<String>> groupAnagrams3(String[] strs) {
            List<Map<Character, Integer>> charsCountsList = new ArrayList<>(strs.length);

            // transform each str to Map
            for (String str : strs) {
                Map<Character, Integer> charsCount = new HashMap<>(str.length());

                for (char c : str.toCharArray()) {
                    int count = charsCount.getOrDefault(c, 0);

                    charsCount.put(c, count + 1);
                }

                charsCountsList.add(charsCount);
            }

            // compare maps and group equals
            List<List<String>> result = new ArrayList<>();
            Set<Integer> addedIndecies = new HashSet<>();
            /*
             * get each str
             * add it to list
             * compare the maps to the map at its same index
             *
             * to not iterate on a str added to list before create a set to keep track of the indecies added to a result list
             * */
            for (int i = 0; i < strs.length; i++) {
                if (addedIndecies.contains(i))
                    continue;

                addedIndecies.add(i);

                List<String> equals = new ArrayList<>();
                equals.add(strs[i]);

                var baseMap = charsCountsList.get(i);

                for (int j = i + 1; j < charsCountsList.size(); j++) {
                    if (baseMap.equals(charsCountsList.get(j))) {
                        equals.add(strs[j]);
                        addedIndecies.add(j);
                    }
                }
                result.add(equals);
            }
            return result;
        }
    }
}
