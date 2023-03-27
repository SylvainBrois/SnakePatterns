class FileWordSource(private val fileName: String) : WordSource {
    override fun getWord(): String {
        val words = File(fileName).readLines()
        return words.random().toUpperCase()
    }
}