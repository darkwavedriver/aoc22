package day2

class RPSRound(str: String, firstMode: Boolean = true) {
    private val opponentMove: RPSOption
    private var myMove: RPSOption

    init {
        if (str.length < 3) {
            throw IllegalArgumentException("$str is too short!")
        }
        this.opponentMove = rpsOptionFactory(str[0].toString())
        if (firstMode) {
            this.myMove = rpsOptionFactory(str[2].toString())
        } else {
            this.myMove = rpsOptionEndGoalFactory(this.opponentMove, str[2].toString())
        }
    }

    fun evaluate(): Int {
        var winPoints = 0
        val shapePoints = when (myMove) {
            RPSOption.ROCK -> 1
            RPSOption.PAPER -> 2
            RPSOption.SCISSORS -> 3
        }

        if (opponentMove == RPSOption.ROCK) {
            if (myMove == RPSOption.ROCK) {
                winPoints = 3;
            } else if (myMove == RPSOption.PAPER) {
                winPoints = 6
            } else /* Scissors */ {
                winPoints = 0
            }
        } else if (opponentMove == RPSOption.PAPER) {
            if (myMove == RPSOption.ROCK) {
                winPoints = 0
            } else if (myMove == RPSOption.PAPER) {
                winPoints = 3
            } else {
                winPoints = 6
            }
        } else /* scissors */ {
            if (myMove == RPSOption.ROCK) {
                winPoints = 6
            } else if (myMove == RPSOption.PAPER) {
                winPoints = 0
            } else {
                winPoints = 3
            }
        }
        // println("Evaluate to $optionPoints + $winPoints")
        return winPoints + shapePoints
    }
}