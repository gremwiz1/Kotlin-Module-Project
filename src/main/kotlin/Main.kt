
fun main() {
    val archiveList = ArchiveList()
    val mainMenu = Menu(mutableListOf<MenuOption>())
    mainMenu.addOption("Добавить архив") { archiveList.addArchive() }
    mainMenu.addOption("Просмотреть архивы") { archiveList.viewArchives() }
    mainMenu.addOption("Добавить заметку в архив") { archiveList.addNoteToArchive() }
    mainMenu.addOption("Просмотреть заметки в архиве") { archiveList.viewNotesInArchive() }

    while (true) {
        mainMenu.print()
        val exit = mainMenu.handleInput()
        if (exit) {
            break
        }
    }
}