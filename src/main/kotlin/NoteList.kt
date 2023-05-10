class NoteList(val name: String) {
    private val notes = mutableListOf<String>()

    fun addNote() {
        println("Введите текст заметки:")
        val note = readLine() ?: ""
        notes.add(note)
        println("Заметка успешно добавлена.")
    }

    fun viewNotes() {
        if (notes.isEmpty()) {
            println("Список заметок пуст.")
        } else {
            println("Список заметок в архиве \"$name\":")
            for ((index, note) in notes.withIndex()) {
                println("$index. $note")
            }
        }
    }
}
