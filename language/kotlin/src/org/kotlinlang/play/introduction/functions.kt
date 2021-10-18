package org.kotlinlang.play.introduction

/**
 * Default Paramter Values and Named Arguments
 */
fun main(){
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))
}

/* 1. A simple function that take a parameter of type String and returns Unit(no retuns value) */
fun printMessage(message: String): Unit{
    println(message)
}

/* 2. A function that takes a second optional parameter with default value Info.
 *    The return type is omitted, meaning that it's actually Unit */
fun printMessageWithPrefix(message: String, prefix: String = "Info"){
    println("[$prefix] $message")
}

/* 3. A function that returns an integer */
fun sum(x: Int, y: Int): Int {
    return x + y
}

/* 4. A single-express function that returns an integer */
fun multiply(x: Int, y: Int) = x * y

