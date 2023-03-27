class SimpleWordChecker : WordChecker {
    override fun check(word: String, letter: Char): Boolean {
        return letter in word
    }
}