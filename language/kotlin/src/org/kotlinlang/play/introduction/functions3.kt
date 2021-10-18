package org.kotlinlang.play.introduction

/**
 * Operator Functions
 * - Certain functions can be "upgraded" to operators, allowing their calls with the corresponding operator symbol
 */
fun main(){
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}

