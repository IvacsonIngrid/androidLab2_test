import kotlin.reflect.typeOf

fun main(args: Array<String>) {
    //1.feladat
    println("Exercise 1 -------------------------------")
    val list1 = listOf("John Smith", "Colleen Hoover", "Karl May")
    val list1new = list1.map{it->it.func1()}
    println("$list1 -> $list1new")

    //2.feladat
    println("\nExercise 2 -------------------------------")
    val list2 = listOf("apple", "pear", "melon", "strawberry")
    val mySeparator = '#'
    println("$list2 -> ${list2.func2(mySeparator)}")

    //3.feladat
    println("\nExercise 3 -------------------------------")
    print("Longest $list2 = ${list2.func3()}")
}

fun String.func1(): String {
    val toFind = " "
    val name1 = this[this.indexOf(toFind) + 1]
    var name2 = "" + this.first()+name1
    return name2
}

fun List<String>.func2(mySeparator: Char): String {
    return this.joinToString("#")
}

fun List<String>.func3(): String {
    return this.first { it.length == this.map { it.length }.maxOrNull() }
}