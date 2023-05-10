class Menu(private val options: MutableList<MenuOption>) {
    fun addOption(name: String, action: () -> Unit) {
        options.add(MenuOption(name, action))
    }

    fun print() {
        for ((index, option) in options.withIndex()) {
            println("$index. ${option.name}")
        }
        println("${options.size}. Выход")
    }

    fun handleInput(): Boolean {
        val input = readLine() ?: ""
        val choice = input.toIntOrNull()
        if (choice == null || choice !in 0 until options.size + 1) {
            println("Пожалуйста, введите число от 0 до ${options.size}.")
            return false
        }
        if (choice == options.size) {
            return true
        }
        options[choice].action()
        return false
    }
}