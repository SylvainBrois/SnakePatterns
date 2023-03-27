class PenduModel(private val wordSource: WordSource) : Subject {
    private var word: String = ""
    private var tries: Int = 6
    private val observers = mutableListOf<Observer>()

    private val checker: WordChecker = SimpleWordChecker()

    fun newGame() {
        word = wordSource.getWord()
        tries = 6
        notifyObservers()
    }

    fun guess(letter: Char) {
        if (checker.check(word, letter)) {
            notifyObservers()
        } else {
            tries--
            notifyObservers()
            if (tries == 0) {
                notifyObservers()
            }
        }
    }

    fun getWordWithGuesses(): String {
        return word.map { if (it in guessedLetters()) it else '-' }.joinToString("")
    }

    fun guessedLetters(): Set<Char> {
        return word.filter { it !in guessedSoFar() }.toSet()
    }

    fun guessedSoFar(): Set<Char> {
        return word.filter { it !in guessedLetters() }.toSet()
    }

    fun getTries(): Int {
        return tries
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)


    }