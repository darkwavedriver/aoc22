package day2

import Problem

class Day2(inputFile: String) : Problem(inputFile) {
    override fun solve() {
        val rounds = this.inputText.split("\n");
        val totalScoreV1 = rounds.filter { line -> line.length >= 3 }.map { line -> RPSRound(line) }.sumOf { round -> round.evaluate() }
        println("Total score task 1: $totalScoreV1")
        val totalScoreV2= rounds.filter { line -> line.length >= 3 }.map { line -> RPSRound(line, false) }.sumOf { round -> round.evaluate() }
        println("Total score task 2: $totalScoreV2")
    }

   override fun test() {
       logTest("A A", 3 + 1, RPSRound("A A").evaluate())
       logTest("A B", 6 + 2, RPSRound("A B").evaluate())
       logTest("A C", 0 + 3, RPSRound("A C").evaluate())

       logTest("B A", 0 + 1, RPSRound("B A").evaluate())
       logTest("B B", 3 + 2, RPSRound("B B").evaluate())
       logTest("B C", 6 + 3, RPSRound("B C").evaluate())

       logTest("C A", 6 + 1, RPSRound("C A").evaluate())
       logTest("C B", 0 + 2, RPSRound("C B").evaluate())
       logTest("C C", 3 + 3, RPSRound("C C").evaluate())
   }
}