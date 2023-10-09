package com.tencent.timecostanalysis.leetcode

class L1 {
    companion object {

        @kotlin.jvm.JvmStatic
        fun main(args: Array<String>) {

        }

        fun twoSum(nums: IntArray, target: Int): IntArray {
            val set = HashSet<Int>()
            val size = nums.size
            for (i in 0 until size) {
                val anotherNum = target - nums[i]
                if (set.contains(anotherNum)) {
                    return intArrayOf(i, nums.indexOf(anotherNum))
                } else {
                    set.add(nums[i])
                }
            }

            return intArrayOf(0, 0)
        }
    }
}