abstract class Problem (version: String) {
    protected val inputText: String;
    init {
        this.inputText = readFile(System.getProperty("user.dir") + "/src/main/resources/" + version + "/input.txt");
    }
    abstract fun solve()
    open fun test() {
    }


    protected fun <T>logTest(description: String, expected: T, calculated: T) {
        val res = if (expected == calculated) "(Success)" else "(Failure)"
        println("$res Running $description: Expected '$expected', got '$calculated'")
    }
}
