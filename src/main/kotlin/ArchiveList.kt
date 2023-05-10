class ArchiveList {
    private val archives = mutableListOf<NoteList>()

    fun addArchive() {
        println("Введите название архива:")
        val name = readLine() ?: ""
        val archive = NoteList(name)
        archives.add(archive)
        println("Архив \"$name\" успешно создан.")
    }

    fun viewArchives() {
        if (archives.isEmpty()) {
            println("Список архивов пуст.")
        } else {
            println("Список архивов:")
            for ((index, archive) in archives.withIndex()) {
                println("$index. ${archive.name}")
            }
        }
    }

    fun viewNotesInArchive() {
        if (archives.isEmpty()) {
            println("Список архивов пуст.")
            return
        }
        println("Выберите архив:")
        val archiveMenu = Menu(mutableListOf<MenuOption>())
        for (archive in archives) {
            archiveMenu.addOption(archive.name) { archive.viewNotes() }
        }
        archiveMenu.addOption("Выход") { }
        while (true) {
            archiveMenu.print()
            val exit = archiveMenu.handleInput()
            if (exit) {
                return
            }
        }
    }

    fun addNoteToArchive() {
        if (archives.isEmpty()) {
            println("Список архивов пуст.")
            return
        }
        println("Выберите архив:")
        val archiveMenu = Menu(mutableListOf<MenuOption>())
        for (archive in archives) {
            archiveMenu.addOption(archive.name) { addNoteToArchive(archive) }
        }
        archiveMenu.addOption("Выход") { }
        while (true) {
            archiveMenu.print()
            val exit = archiveMenu.handleInput()
            if (exit) {
                return
            }
        }
    }

    private fun addNoteToArchive(archive: NoteList) {
        archive.addNote()
    }
}
