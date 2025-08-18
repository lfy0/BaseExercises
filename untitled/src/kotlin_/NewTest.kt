package kotlin_

import java.util.Stack

class NewTest {

}

fun main() {
    printSum(1, 1)
    vars(2, 3, 3, 4, 1, c = 4)
    val sumsome: (Int, Int) -> Int = { x, y -> x + y }
    println(sumsome(1, 2))
    a1 = 2

    println("字符串模版 ${sumsome(3, 4)}")
    println(age2)
    println(age1)
    numFun(listOf("", "22", "33"))
    println("--------------for 打印-------------------------------")
    testForMethed()
    testIntBoxTest()
    numA1.and(numA2)
    numA1.or(numA2)
    var b = decimalDigitValue('1')
    println("转换${b}")
    bool2 = bool//装箱
    bool = bool2!!
    bool2?.and(bool)

    println(array1.contentToString())
    println(array2.contentToString())

    testStrMethod()

    funIFMethod()

    funIF2Method()

    funWhenMethod()

    testForMethod()

    testClassMethod()

    testExceptMethod()

    testInterfaceMetond()
}

fun testExMethod() {
    //定义User类

    //List 值交换

    //扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:

    //拓展函数和成员函数一致优先使用成员函数

    //拓展空对象

    //属性拓展 不允许赋值，只允许通过get /  set 方式设置

    // companion关键字定义伴生对象

    //拓展函数导入作用域
}

fun testInterfaceMetond() {
    //通过interface 定义接口 接口可有默认实现
    //接口中允许有属性值但是只能抽象，实现接口必须实现接口属性值
    val c2 = C2()
    c2.foo()
    c2.bar()
    val d2 = D2()
    d2.foo()
    d2.bar()
    println(d2.date)
    //接口重写可能会遇到多个接口同一方法名的问题
}

interface A2 {

    var date: String

    fun foo() {
        println("A2")
    }

    fun bar()
}

interface B2 {
    fun foo() {
        println("B2")
    }

    fun bar() {
        println("bar")
    }
}

class C2 : A2 {

    override var date: String = "1"

    override fun bar() {
        println("bar")
    }

}

class D2() : A2, B2 {
    override var date: String = "111"

    override fun foo() {
        super<A2>.foo()
        super<B2>.foo()
    }

    override fun bar() {
        super<B2>.bar()
    }


}


fun testExceptMethod() {
    //子类实现继承要接着调用父类的构造方法
    //子类有构造函数
    val dog = Dog1(1, "dog", 1)
    //子类没构造函数
    val cat = Cat1(1, "cat")
    //重写方法 需要加open
    dog.wow()
    cat.wow()
    //通过 open 和 override 重写属性
    println(dog.name)
    println(cat.name)
    println(dog.phone)
    println(dog.age)
    //可以通过var 属性重写val 但是不能通过val 重写var
}

open class Animal1(a: Int, b: String) {
    open var name: String = "未知姓名"
    open val age: Int = 0
    open val phone = 0;
    open fun wow() {
        println("未知叫声")
    }
}

open class A1 {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B1 {
    fun f() {
        print("B")
    } //接口的成员变量默认是 open 的

    fun b() {
        print("b")
    }
}

class C1() : A1(), B1 {
    override fun f() {
        TODO("Not yet implemented")
        super<A1>.f()
        super<B1>.f()
    }
}

interface AnimalAction {
    fun wow() {
        println("动物叫")
    }
}

class Dog1(a: Int, b: String, c: Int) : Animal1(a, b), AnimalAction {

    override var name: String = "狗"
    override var age: Int = 1
    override val phone: Int
        get() = 110

    override fun wow() {
        println("汪汪汪")
        super<AnimalAction>.wow()
        super<Animal1>.wow()
    }

}

class Cat1 : Animal1 {

    override var name: String
        get() = "猫:咪咪"
        set(value) {}

    override val age: Int
        get() = 1

    override val phone: Int
        get() = 555

    constructor(a: Int, b: String) : super(a, b)

    constructor(a: Int, b: String, c: Int) : this(c, b)

    override fun wow() {
        println("喵喵喵")
    }

}

open class Test3 {
    constructor(age: Int)
    constructor(age: Int, name: String)
}

class TT(name: String) : Test3(0, name) {

}

fun testClassMethod() {

    //可以定义一个类和一个空类，类里也可以有方法

    //var 属性可变val属性不可变
    var p = Person2()
    //类有主构造器和次构造器 constructor 在类没有注解和没背关键词修饰的情况下可以省略

    //getter 和 setter

    //person   // 将变量赋值后转换为大写 // 如果传入的值小于 10 返回该值 // 如果传入的值大于等于 10 返回 -1 私有化set

    // lateinit 延迟初始化 setup 初始化 test 测试

    //主构造器不能包含任何代码 ，初始化代码放到init 代码段中

    //构造器中的参数可以再初始化代码段init 中使用，也可以再类主体属性定义的时候使用

    /*创建一个w3school 类，通过构造函数传入网站名， 这个类包含一个网址，国家属性，
    在初始化代码块打印传入的网站名 这个类包含一个测试方法输出我是测试类，输出传入的属性调用方法*/
    val w3 = W3Shool("编程师", 12)
    w3.printLine()

    /*次级构造函数 通过constructor声明 次级构造函数要间接调用主构造函数  一个非抽象类如果没有写主构造函数会创建一个空的公共的构造函数
    * 可以将其私有化 */
    val tCalss: TestClass1 = TestClass1()
    //次级构造函数可以加入排名 在次级构造函数显示排名 init块显示网站名

    //抽象类实现 open一个类 里面提供方法 继承他的抽象类克实现他的 方法，也可将他的方法继续抽象

    //类中可以继续嵌套类 // 调用格式：外部类.嵌套类.嵌套类方法/属性
    var wther = Wther.Owner()
    wther.foo()
    //内部类使用inner 关键字来表示内部类可以访问外部类属性和变量
    var innerOwner = Wither().Owner()
    println(innerOwner.foo())
    innerOwner.testOwner()
    //创建匿名内部类
    val tc2: TestClass2 = TestClass2()
    tc2.setUp(object : TestInterface {
        override fun result() {
            println("result")
        }
    })
    tc2.call()
    var tc3: TestClass3 = TestClass3("1")
}

class TestClass3(name: String, age: Int) {

    var name = ""
    var age = 0

    constructor(name: String) : this(name, 0)

    init {
        this.name = name
        this.age = age
    }
}

class TestClass2 {

    lateinit var t: TestInterface

    fun setUp(inter: TestInterface) {
        t = inter
    }

    fun call() {
        println("call")
        t.result()
    }
}

interface TestInterface {
    fun result()
}


open class Wither {

    var name: String = "张三"
    var age: Int = 0

    inner class Owner {

        fun foo() = name

        fun testOwner() {
            println(this@Wither)
        }
    }
}

open class Wther {
    class Owner {
        fun foo() {
            println("owner foo")
        }
    }
}

//抽象类
open class Animal {
    open fun cry() {

    }
}

abstract class Dog : Animal() {
    abstract override fun cry()
}

class TestClass1 {
    var name: String = ""
    var age: Int = 0
    // private constructor()
}

class W3Shool(name: String) {

    private var url: String = "http//:www.baidu.com"
    private var cun: String = "CN"
    private var name: String = name
    private var arx: Int = 0

    init {
        println("我的网站名是:$name")
    }

    constructor(name: String, arx: Int) : this(name) {
        println("我的网站排名：$arx")
        this.arx = arx
    }

    fun printLine() {
        println("网址：" + url)
        println("国家：" + cun)
        println("网站名：" + name)
        println("网站排名：" + arx)
    }

}

class Person2(name: String, age: Int, hige: Int) {

    var name: String = name
    var age: Int = age

    //这个地方要在看下
    var sex: Int? = 1
        get
        set(value) {
            value?.let {
                if (value > 1 || value < 0) {
                    0
                } else {
                    1
                }
            }
            field = value
        }

    val phone: String? = ""
        get() = field?.toUpperCase()

    var value: Int = 0
        get
        set(value) {
            field = if (value < 10) value
            else -1
        }

    var tt: String = "1"
        private set

    constructor(name: String, age: Int) : this(name, age, 180)
    constructor(name: String) : this(name, 0)
    constructor() : this("")

    //可以通过构造函数初始化也可以不初始化，不初始化=null
    var hige: Int?

    init {
        this.hige = hige
    }

    fun foo() {

    }

}

class MProject {

    lateinit var age: String

    fun setup() {
        age = "15"
    }

    fun test() {
        println(age)
    }
}


fun testForMethod() {
    //存在迭代器的基本for in 用法
    val arr = mutableListOf(1, 2, 3)
    for (a in arr) {
        print(a)
    }
    println()
    //正序带索引的用法
    for (i in arr.indices) {
        print(arr[i])
    }
    println()
    //倒序遍历
    for (a in arr.lastIndex downTo 0 step 1) {
        print(arr[a])
    }
    println()
    //withIndex 返回int 和value 的用法
    for ((index, value) in arr.withIndex()) {
        println("value is $value index is $index");
    }
    //do while 循环 和while 循环和java 相同 break 和 continue 相同
    var index = 0
    while (index < 100) {
        if (index == 5) {
            println("第五十次")
            break
        }
        index++
    }
    var b = true
    var count = 0
    do {
        println("b:$count")
        if (count == 5) {
            b = false;
        }
        count++
    } while (b)
    //loop 标签标记循环测试
    var loopArr = arrayOf(3, 2, 1)

    loop@ for (i in loopArr) {
        println("i = $i")
        for (j in loopArr.indices) {
            print("j = ${loopArr[j]}")
            if (loopArr[j] == 2)
                break@loop;
        }
    }
    println()
    println("----------------------------------------")
    // Kotlin 的函数可以被嵌套 允许从lamand 表达式返回最外侧函数，默认返回最外层函数
    for (i in loopArr) {
        println("i = $i")
        loopArr.forEach fore@{ value ->
            print("value = $value ")
            if (value == 2) {
                print("return 2 ")
                return@fore
            }
            print(".")
        }
        println()
    }
    println()
    println("----------------------------------------")
    // 可以指定标签返回到指定方法
//    loop1@for (i in loopArr) {
//        println("i = $i")
//        loopArr.forEach { value ->
//            print("value = $value ")
//            if (value == 2) {
//                print("return 2 ")
//                break@loop1
//            }
//            print(".")
//        }
//        println()
//    }
    println()
    println("----------------------------------------")
    // forEach 包含隐式标签
    for (i in loopArr) {
        println("i = $i")
        loopArr.forEach { value ->
            if (value == 2) {
                println("return forEach")
                return@forEach
            }
            print("value = $value ")
        }
    }
    println()
    println("----------------------------------------")
    // forEach 从标签处返回landbad
    loopArr.forEach(
        fun(value: Int) {
            println("value = $value")
            return
        }
    )
    //函数字面量
    println(cul(1, 2) { x, y -> x + y })
    println(cul(1, 2) { x, y -> x * y })
    //匿名函数
    val nonFun = fun(x: Int, y: Int): Int {
        return x + y
    }
    println("fun val ${nonFun(4, 5)}")
    //局部函数
    fun myCenterFun(x: Int, y: Int): Int {
        return x + y
    }
    println(myCenterFun(3, 1))
    //对象表达式
    val callMethon = object : Gender {
        override fun callMethod(): String {
            return "aaaa"
        }
    }
    println(callMethon.callMethod())
}

interface Gender {
    fun callMethod(): String
}


fun cul(a: Int, b: Int, oper: (a: Int, b: Int) -> Int): Int {
    return oper(a, b)
}

fun hasPrefix(x: Any): Boolean = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun funWhenMethod() {
    //when 带else的基本使用
    val x1 = 10;
    when (x1) {
        1 -> println("x is 1")
        2 -> println("x is 2")
        else -> println("x else 1 and 2")
    }
    //when的多个case 公用一个条件的情况
    var s1: String = ""
    when (s1) {
        "", "0", "1" -> println("为空或则 为 0 或则 为 1")
        else -> println()
    }
    //in 的用用法和集合
    val c = 'c'
    val set = mutableListOf('3', '2', 'c')
    when (c) {
        in 'a'..'z' -> println("是字母")
        in set -> println("in set")
        else -> println("啥都不是")
    }
    //Prefix检测一个值是活着不是Sting 类型
    val sss = "1prefix is string"
    println(hasPrefix(sss))
    // x.isOdd() 取代if else if 分支链
    var xFailed = ""
    when (xFailed) {
        "22" -> {
            println("我来执行 22逻辑")
        }

        "" -> {
            println("我来执行空的逻辑")
        }

        else -> {
            println("我来执行 else 的逻辑")
        }
    }
}

fun funIF2Method() {
    val x = 5
    val y = 9
    val c = 7
    if (c in x..y) {
        println("c in x y")
    } else {
        println("not in x y")
    }
}


fun funIFMethod() {
    var a = 3;
    var b = 2;
    //传统用法
    var max = a
    if (a < b) max = b
    //使用else
    var max3: Int = 0;
    if (a > b) {
        max3 = a
    } else {
        max3 = b
    }
    //作为表达式
    var max2 = if (a > b) {
        println("case max2 a > b")
        a
    } else {
        println("case max2 a < b")
        b
    }

    var x = 1
    if (x == 0) {
        println("x 等于0")
    } else if (x > 0) {
        println("x大于0")
    } else if (x < 0) {
        println("x 小于0")
    }

}

fun testStrMethod() {
    var s: String = "string"
    for (sc in s) {
        println(sc)
    }
    println(s[0])

    var sShow = "我是展示字符串"

    //模版字符串
    var s2: String = """
        |ddd
        
        |sdfasd
        
        
             fa
        dfasdf
        $sShow
        
        fa
    """.trimIndent()
    println(s2)

    val s3 = """
        衬衫的价额价格是${'$'}9.15
    """.trimIndent()
    println(s3)
}


val intArr: IntArray = intArrayOf(4, 5, 6)
val byteArr: ByteArray = byteArrayOf(1, 0, 2, 4)
val longArr: LongArray = longArrayOf(0, 1, 4, 8)

var array1 = arrayOf(1, 2, 3, 4, 5)
var array2 = Array(5) { i -> i + 2 }


var bool: Boolean = true
var bool2: Boolean? = null


fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("c is out num.")
    }
    return c - '0'
}

var numA1 = 1
var numA2 = 2

var byteT: Byte = 1

//var intT:Int = byteT;
var intT: Int = byteT.toInt();

var byteT2: Byte = intT.toByte()

var charT: Char = 'x'

var byteT3: Byte = charT.toByte()

var charT2: Char = intT.toChar()

val conviertNum: Long = 1L + 3


fun testIntBoxTest() {
    val a: Int = 10000
    if (a === a) {
        println("a = a 地址相同")
    }
    val boxA: Int? = a
    val otherBoxA: Int? = a;
    println("此处应为false 经历过装箱后 地址不同${boxA === otherBoxA}")
    println("此处应为相等值比较${boxA == otherBoxA}")
}

var sortType: Short = 0x123//16进制
var intType = 123
var longTyp = 1234L
var byteType = 0B0101010101010
var floatType = 1323F
var doubleType = 132.5
var doubleType2 = 132e113

fun testForMethed() {
    for (i in 1..4) print(i)
    println()
    for (i in 4..1) print(1)
    println()
    for (i in 1..4 step 2) print(i)
    println()
    for (i in 4 downTo 1 step 2) print(i)
    println()
    for (i in 1 until 10 step 1) print(i)
}

fun getStringLength(any: Any): Int? {
    if (any is String) {
        return any.length
    }
    return null
}

fun getStringLength2(any: Any): Int? {
    if (any is String && any.length > 0) {
        return any.length
    }
    return null
}


fun numFun(args: List<String>) {
    if (args.size < 2) {
        println("exception is args size")
        return
    }
    val a = parseInt(args[0])
    val b = parseInt(args[1])
    //plan1:
    if (a != null && b != null) {
        println(a * b)
    }
    var s: Stack<String> = Stack()
    if (!s.empty()) {

    }
}

fun parseInt(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        return null
    }
}

var str: String? = null

//为空抛出空异常
//var str2 = str!!.toString()

val age1 = str?.toInt()
val age2 = str?.toInt() ?: -1


var a: Int = 1
var a1 = 1

val b: Int = 1;
val b1 = 1;


fun vars(vararg vs: Int, c: Int) {
    for (v in vs) {
        print("$v,")
    }
}


//kotlin 方法
fun test(): String? {
    return null;
}

//类定义
class MyW3School {

}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b


public fun sum3(a: Int, b: Int): Int = a + b

fun printSum(a: Int, b: Int): Unit {
    println(a + b);
}