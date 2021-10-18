package org.kotlinlang.play.introduction

/**
 * Functions with vararg Parameters
 * - vararg allow you to pass any number of arguments by separating them with commas
 */
fun main(){
    printAll("Hello", "Hallo", "Salut", "Hola")
    printAllWithPrefix("Hello", "Hallo", "Salut", "Hola", prefix = "Greeting: ")
    log("Hello", "Hallo", "Salut", "Hola")
}

fun printAll(vararg messages: String){
    for(m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String){
    for(m in messages) println(prefix + m)
}

fun log(vararg entries: String){
    printAll(*entries)
}