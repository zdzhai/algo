package com.yugutou.charpter20_graphe;

import java.util.*;

/**
 * leetcode. 127. 单词接龙
 * @author dongdong
 * @Date 2024/1/14 19:17
 */
public class LadderLength {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    /**
     * 这里其实就是   连通性判断以及最小连通路径。
     * 无向无权图
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        //构建Set,判断有无endWord
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);

        //初始化队列和标记元素
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (compareString(current, queue, endWord, visited, set)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 依次改变current中的每个字符，判断wordSet中是否包含
     * @param current
     * @param queue
     * @param visited
     * @return
     */
    private static boolean compareString(String current,
                                         Queue<String> queue,
                                         String endWord,
                                         Set<String> visited,
                                         Set<String> wordsSet) {
        int size = current.length();
        char[] chars = current.toCharArray();
        for (int i = 0; i < size; i++) {
            char ch = chars[i];
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String var = String.valueOf(chars);
                if (wordsSet.contains(var)) {
                    //到最后的endWord了
                    if (var.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(var)) {
                        visited.add(var);
                        queue.add(var);
                    }
                }
            }
            //恢复原位置字符
            chars[i] = ch;
        }
        return false;
    }
}
