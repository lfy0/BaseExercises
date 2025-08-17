package kotlin_

fun main() {
    val collection = listOf("111", "22", "3333")
    for (item in collection)
        print(item)

    var ints = intArrayOf(3, 21, 1)
    for (item: Int in ints) {
        println(item)
    }

    for (i in ints.indices) {
        println(ints[i])
    }

    for ((index, value) in collection.withIndex()) {
        println("the element at$index is $value")
    }
//    var i = 0;
//    while (i < 10){
//        println("111")
//        i++
//    }
//    do {
//        println("222")
//        i++
//    }while

//    loop@ for (i in 1..10) {
//        for (j in 1..100) {
//            println("abc")
//            if (true) continue@loop
//        }
//    }
   // foo()

    val s = Student("W3cschool",18,"s1234",89)
    print("学生名：${s.name}")
    print("年龄：${s.age}")
    print("学生号：${s.no}")
    print("成绩：${s.score}")

    val s1 = Student1("W3cschool",18,"s1234",89)

    val s2 = Student111()
    s2.study()

    val c = C()
    c.f()

    val child = Child()
    child.foo()
    child.bar()

    val d = D()
    d.foo()
    d.bar()
    var user = User("W3cshool")
    user.Print()

    val l = mutableListOf(1,2,3)
    l.swap(0,2)
    println(l.toString())

    printFoo(D_2())
    var c_3 = C_3()
    c_3.foo()
    var t = null
    println(t.toString())
    println("no：${MyClass.no}")
    MyClass.foo()
}
class MyClass{
    companion object{}
}

fun MyClass.Companion.foo(){
    println("伴随对象的拓展函数")
}
val MyClass.Companion.no: Int
    get() = 10


val <T> List<T>.lastIndex: Int
    get() = size - 1
fun Any?.toString(): String {
    if (this == null) return "nullll"
    return toString()
}
class C_3{
    fun foo(){
        println("成员函数")
    }
}
fun C_3.foo(){
    println("拓展函数")
}
open class C_2
class D_2: C_2()

fun C_2.foo() = "c"
fun D_2.foo() = "d"

fun printFoo(c: C_2) {
    println(c.foo())
}


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class User(var name: String)
fun User.Print(){
    print("用户名$name")
}



class C_1: A_1 {
    override fun bar() {
        print("bar")
    }
}
class D : A_1, B_1 {

    override fun foo() {
        super<A_1>.foo()
        super<B_1>.foo()
    }
    override fun bar() {
        super<B_1>.bar()
    }

}

interface A_1 {
    fun foo() {
        print("A")
    }
    fun bar()
}

interface B_1{
    fun foo(){
        print("B")
    }
    fun bar(){
        print("bar")
    }
}
interface  MyInterface{
    fun  bar()
    fun foo() {
        println("实现")
    }
}

class Child: MyInterface {
    override fun bar() {
        println("bar")
    }
}

interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Barf2 : Foo {
    override val count: Int = 0
}
open class  A{
    open fun f(){
        print("A")
    }
    fun a() {
        print("a")
    }
}
interface B{
    fun f(){
        print("B")
    }
    fun b(){
        print("b")
    }
}
class C(): A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}
open class Person111{
    open fun study(){
        println("我毕业了")
    }
}
class Student111: Person111(){
    override fun study() {
        println("我在读大学")
    }
}

open class Person1(name: String) {
    constructor(name: String, age: Int):this(name) {
        println("--------------基类次级构造函数-------------------")
    }

}
class Student1: Person1 {
    /**
     * 次级构造函数
     */
    constructor(name: String, age: Int, no: String, score: Int):super(name,age){
        println("------------------继承类次级构造函数--------------------")
        println("学生名： ${name}")
        println("年龄：${age}")
        println("学生号：${no}")
        println("成绩：${score}")

    }
}

class Example{

}

open class Base111(p: Int){

}

class Derived111(p: Int) : Base111(p){

}


open class Person(var name: String, var age: Int){

}

class Student(name: String, age: Int, var no: String, var score: Int): Person(name,age) {


}
fun foo() {
    val ints = listOf("111", "2222", "333")
    ints.forEach(fun(value: String) {
        if (value == "2222") return
        println(value)
    })
    ints.forEach a@{
        if (it == "2222") return@a
        println(it)
    }
}


fun test(arge: Int) {
    println(arge)
}