class Menu(val options: MutableList<MenuOption>) {
    init {
        options.add(MenuOption("Выход") { })
    }
    fun addOption(name: String, action: () -> Unit) {
        options.add(MenuOption(name, action))
    }

    fun print() {
        for ((index, option) in options.withIndex()) {
            println("$index. ${option.name}")
        }
    }

    fun handleInput(): Boolean {
        val input = readLine() ?: ""
        val choice = input.toIntOrNull()
        if (choice == null || choice !in 0 until options.size) {
            println("Пожалуйста, введите число от 0 до ${options.size-1}.")
            return false
        }
        options[choice].action()
        return options[choice].name == "Выход"
    }
}