package day2

enum class RPSOption()  {
    ROCK,
    PAPER,
    SCISSORS;
}

fun rpsOptionFactory(str: String): RPSOption {
    if (str == "A" || str == "X") {
        return RPSOption.ROCK
    }
    if (str == "B" || str == "Y") {
        return RPSOption.PAPER
    }
    if (str == "C" || str == "Z") {
        return RPSOption.SCISSORS
    }
    throw IllegalArgumentException("$str is not a valid argument!")
}

fun rpsOptionEndGoalFactory(against: RPSOption, str: String): RPSOption {
    val loose = str == "X"
    val draw = str == "Y"

    if (against === RPSOption.ROCK) {
        if (loose) {
            return RPSOption.SCISSORS
        } else if (draw) {
            return RPSOption.ROCK
        } else {
            return RPSOption.PAPER
        }
    } else if (against === RPSOption.PAPER) {
        if (loose) {
            return RPSOption.ROCK
        } else if (draw) {
            return RPSOption.PAPER
        } else {
            return RPSOption.SCISSORS
        }
    } else {
        if (loose) {
            return RPSOption.PAPER
        } else if (draw) {
            return RPSOption.SCISSORS
        } else {
            return RPSOption.ROCK
        }
    }
}