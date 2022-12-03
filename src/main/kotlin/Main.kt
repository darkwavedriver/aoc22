import day2.Day2
import day3.Day3
import java.io.File

fun main(args: Array<String>) {
    // day1.Day1("1").solve()
    // Day2("2").solve()
    Day3("3").solve()
}

fun readFile(fileName: String): String = File(fileName).readText()
