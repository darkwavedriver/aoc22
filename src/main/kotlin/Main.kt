import java.io.File

fun main(args: Array<String>) {
    println(System.getProperty("user.dir"))

    val input = readFile(System.getProperty("user.dir") + "/src/main/resources/1/input.txt")
    val itemsPerElves = input.split("\n\n");
    val caloriesPerElves = itemsPerElves.map { items -> items.trim().split("\n").toList()
            .map { item -> Integer.parseInt(item) }
            .reduce{ acc, item -> acc + item }}
    val maxCalories = caloriesPerElves.max()
    println("Most calories carried: $maxCalories")

    val totalOfTopTree = caloriesPerElves.sortedDescending().subList(0, 3).reduce{acc, cals -> acc + cals}
    println("Top 3 elves carrying $totalOfTopTree cals")


}

fun readFile(fileName: String): String = File(fileName).readText()
