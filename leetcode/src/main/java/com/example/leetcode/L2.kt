package com.tencent.timecostanalysis.leetcode

class L2 {
    companion object {

        @kotlin.jvm.JvmStatic
        fun main(args: Array<String>) {
            print(lengthOfLongestSubstring("abcabcbb"))
        }

        fun lengthOfLongestSubstring(s: String): Int {

            if (s.isEmpty()) {
                return 0
            }

            var startIndex = 0
            var endIndex = 0
            var longestSize = 0

            val currentMap = HashMap<Char, Int>()
            currentMap[s[0]] = 1

            while (true) {
                if (checkValid(currentMap)) {
                    val currentLength = endIndex - startIndex + 1
                    if(currentLength > longestSize) {
                        longestSize = currentLength
                    }

                    endIndex++
                    if (endIndex == s.length) {
                        break
                    }

                    val element = s[endIndex]
                    if (currentMap.contains(element)) {
                        currentMap[element] = currentMap[element]!! + 1
                    } else {
                        currentMap[element] = 1
                    }
                } else {
                    val element = s[startIndex]
                    startIndex++

                    if (startIndex == s.length - longestSize) {
                        break
                    }

                    if (currentMap.contains(element)) {
                        currentMap[element] = currentMap[element]!! - 1
                    }
                }
            }

            return longestSize
        }

        fun checkValid(map: HashMap<Char, Int>): Boolean {
            for (item in map) {
                if (item.value > 1) {
                    return false
                }
            }
            return true
        }
    }

}