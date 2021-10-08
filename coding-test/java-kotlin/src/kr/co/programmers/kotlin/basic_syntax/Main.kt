package kr.co.programmers.kotlin.basic_syntax

/* Program entry point */
fun main(args: Array<String>){
    println("Hello world!")
    println(args.contentToString())

    /* Print to the standard output */
    print("Hello ")
    print("world!")

    println("Hello world!")
    println(42)

    /* Functions */
    println(sum(3, 5))
    println("sum of 19 and 23 is ${sum(19, 23)}")
    printSum(-1, 8)
}

/* Functions */

/*
fun sum(a: Int, b: Int): Int {
    return a + b
}
 ==> expression */
fun sum(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int) : Unit {
    println("sum of $a and $b is ${a + b}")
}

