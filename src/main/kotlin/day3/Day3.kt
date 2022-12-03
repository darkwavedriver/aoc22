package day3

import Problem
import java.util.LinkedList

class Day3(inputFile: String) : Problem(inputFile) {
    override fun solve() {
        // PART 1
        val sum1 = inputText.split('\n')
            .map { str -> Rucksack(str) }
            .mapNotNull { rs -> rs.findMismatch() }
            .map { c -> calculatePriority(c) }
            .reduce { acc, c -> acc + c }
        println("Sum of priorities per misplaced item in rucksacks is $sum1")


        // PART 2
        val groups = LinkedList<LinkedList<Rucksack>>()
        var tempGroup = LinkedList<Rucksack>()
        for ((idx, str) in inputText.split('\n').withIndex()) {
            if (idx % 3 == 0) {
                // make a new group
                tempGroup = LinkedList<Rucksack>()
                groups.add(tempGroup)
            }
            tempGroup.add(Rucksack(str))
        }

        val sum2 = groups.map { g ->
            val r1Chars = g[0].getDistinctChars()
            val r2Chars = g[1].getDistinctChars()
            val r3Chars = g[2].getDistinctChars()
            commonChars(r1Chars, commonChars(r2Chars, r3Chars))[0]
        }
            .map { c -> calculatePriority(c) }
            .reduce{acc, i -> acc + i }

        println("Sum of priorities of bades is $sum2")

    }
}

fun calculatePriority(c: Char): Int {
    return if (c.isLowerCase()) {
        c.code - 96 // Offset for ascii code
    } else {
        c.code - 64 + 26 // offset for ascii code + offset zo start at prio 27
    }
}

fun commonChars(arr1: List<Char>, arr2: List<Char>): List<Char> {
    val ret = LinkedList<Char>();
    arr1.forEach{ c ->
        if (arr2.contains(c)) {
            ret.add(c)
        }
    }
    return ret
}
