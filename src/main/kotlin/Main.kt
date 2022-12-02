import day2.Day2
import java.io.File

fun main(args: Array<String>) {
    // day1.Day1("1").solve()
    Day2("2").solve()
    // Day2("2").test()
}

fun readFile(fileName: String): String = File(fileName).readText()
