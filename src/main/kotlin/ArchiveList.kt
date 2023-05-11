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
            for (archive in archives) {
                println(archive.name)
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

        while (true) {
            archiveMenu.print()
            val exit = archiveMenu.handleInput()
            if (exit) {
                return
            } else {
                println("Выход")
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
        for ((index, archive) in archives.withIndex()) {
            val archiveName = "${index + 1}. ${archive.name}"
            archiveMenu.addOption(archiveName.removePrefix("${index + 1}. ")) { addNoteToArchive(archives[index]) }
        }

        archiveMenu.print()

        var exit = false
        while (!exit) {
            val choice = readLine()?.toIntOrNull()
            exit = choice == null || choice !in 1..archives.size
            if (!exit) {
                val selectedIndex = choice!!
                archiveMenu.options[selectedIndex].action()
            }
        }
    }



    private fun addNoteToArchive(archive: NoteList) {
        archive.addNote()
    }
}
