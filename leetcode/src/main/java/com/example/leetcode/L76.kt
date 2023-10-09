package com.tencent.timecostanalysis.leetcode

class L76 {
    companion object {

        @kotlin.jvm.JvmStatic
        fun main(args: Array<String>) {
            print(minWindow("ADOBECODEBANC", "ABC"))
        }

        /**
         * 窗口滑动
         */
        fun minWindow(s: String, t: String): String {
            val needMap = HashMap<Char, Int>()
            for (element in t) {
                if (needMap.contains(element)) {
                    needMap[element] = needMap[element]!! + 1
                } else {
                    needMap[element] = 1;
                }
            }

            if(t.length > s.length) {
                return ""
            }

            var resultStartIndex = -1
            var resultEndIndex = -1
            var minLength = Int.MAX_VALUE

            var startIndex = 0
            var endIndex = t.length - 1

            for (i in startIndex..endIndex) {
                val element = s[i]
                if (needMap.contains(element)) {
                    needMap[element] = needMap[element]!! - 1
                }
            }

            while (endIndex < s.length) {
                if (checkValid(needMap)) {
                    val currentLength = endIndex - startIndex + 1
                    if (currentLength < minLength) {
                        resultStartIndex = startIndex
                        resultEndIndex = endIndex
                        minLength = currentLength
                    }
                    if (startIndex == s.length) {
                        break
                    }
                    val element = s[startIndex]
                    if (needMap.contains(element)) {
                        needMap[element] = needMap[element]!! + 1
                    }
                    startIndex++
                } else {
                    endIndex++
                    if (endIndex == s.length) {
                        break
                    }
                    val element = s[endIndex]
                    if (needMap.contains(element)) {
                        needMap[element] = needMap[element]!! - 1
                    }
                }
            }

            if (resultStartIndex == -1) {
                return ""
            } else {
                return s.substring(resultStartIndex, resultEndIndex + 1)
            }
        }

        fun checkValid(needMap: HashMap<Char, Int>): Boolean {
            for (element in needMap) {
                if (element.value > 0) {
                    return false
                }
            }
            return true
        }
    }
}