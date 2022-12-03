package day3

class Rucksack(str: String) {
    private val compartment1: String
    private val compartment2: String
    private val originalString: String

    init {
        this.compartment1 = str.substring(0, str.length / 2)
        this.compartment2 = str.substring((str.length / 2))
        this.originalString = str
    }

    override fun toString(): String {
        return "${this.compartment1}, ${this.compartment2}"
    }

    fun findMismatch(): Char? {
        return this.compartment1.find { c -> this.compartment2.contains(c) }
    }

    fun getOriginalString(): String {
        return this.originalString
    }

    fun getDistinctChars(): List<Char> {
        return this.originalString.toList().distinct().toList()
    }
}