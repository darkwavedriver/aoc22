package day1

import Problem

class Day1(inputFile: String) : Problem(inputFile) {
    override fun solve() {
        val itemsPerElves = this.inputText.split("\n\n");
        val caloriesPerElves = itemsPerElves.map { items -> items.trim().split("\n").toList()
            .map { item -> Integer.parseInt(item) }
            .reduce{ acc, item -> acc + item }}
        val maxCalories = caloriesPerElves.max()
        println("Most calories carried: $maxCalories")

        val totalOfTopTree = caloriesPerElves.sortedDescending().subList(0, 3).reduce{acc, cals -> acc + cals}
        println("Top 3 elves carrying $totalOfTopTree cals")
    }
}