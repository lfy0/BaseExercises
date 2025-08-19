package com.pacage

import java.util.Scanner

fun main() {
    val uView = UView()
    uView.show()
}

val List<Book>.addNumber get() = this[size - 1].number + 1

class UView {

    init {
        init()
    }

    private fun init() {
        // 不同种类的书籍伪数据
        LibraryManger.holder.addBook(Book(1, "基督山伯爵", "大仲马", "人民教育出版社"));
        LibraryManger.holder.addBook(Book(2, "红楼梦", "曹雪芹", "中华书局"));
        LibraryManger.holder.addBook(Book(3, "三国演义", "罗贯中", "人民文学出版社"));
        LibraryManger.holder.addBook(Book(4, "西游记", "吴承恩", "商务印书馆"));
        LibraryManger.holder.addBook(Book(5, "水浒传", "施耐庵", "三联书店"));
        LibraryManger.holder.addBook(Book(6, "百年孤独", "加西亚·马尔克斯", "南海出版公司"));
        LibraryManger.holder.addBook(Book(7, "活着", "余华", "北京十月文艺出版社"));
        LibraryManger.holder.addBook(Book(8, "追风筝的人", "卡勒德·胡赛尼", "上海人民出版社"));
        LibraryManger.holder.addBook(Book(9, "解忧杂货店", "东野圭吾", "南海出版公司"));
        LibraryManger.holder.addBook(Book(10, "人类简史", "尤瓦尔·赫拉利", "中信出版社"));
    }

    companion object {

        const val SELECT_1 = "1."
        const val SELECT_2 = "2."
        const val SELECT_3 = "3."
        const val SELECT_4 = "4."
        const val SELECT_5 = "5."
        const val SELECT_6 = "6."
        const val SELECT_7 = "7."

        const val TITLE_ADD_BOOK = "添加新图书"
        const val TITLE_DELETE_BOOK = "删除图书"
        const val TITLE_FIND_BOOK = "查询图书"
        const val TITLE_FIND_ALL_BOOK = "显示所有图书"
        const val TITLE_OUT_BOOK = "图书借出操作"
        const val TITLE_IN_BOOK = "图书归还操作"
        const val TITLE_EXIT_BOOK = "退出"

    }

    private fun showMenu() {
        println("--------------------欢迎使用XXX市图书管理系统-------------------------")
        println("$SELECT_1$TITLE_ADD_BOOK")
        println("$SELECT_2$TITLE_DELETE_BOOK")
        println("$SELECT_3$TITLE_FIND_BOOK")
        println("$SELECT_4$TITLE_FIND_ALL_BOOK")
        println("$SELECT_5$TITLE_OUT_BOOK")
        println("$SELECT_6$TITLE_IN_BOOK")
        println("$SELECT_7$TITLE_EXIT_BOOK")
        println("------------------------------------------------------------------")
    }

    private var isExit = false

    //问题
    //主键自增管理
    //借书前显示全部书籍
    //相同提示内容抽取常量
    //任意键继续逻辑

    fun show() {
        val scanner = Scanner(System.`in`)
        while (!isExit) {
            showMenu()
            when (scanner.nextInt()) {
                1 -> addBook(scanner)
                2 -> deleteBook(scanner)
                3 -> findBook(scanner)
                4 -> findAllBooks(scanner)
                5 -> outBook(scanner)
                6 -> inBook(scanner)
                7 -> exit(scanner)
            }
        }
    }

    private fun exit(scanner: Scanner) {
        println("确认${TITLE_EXIT_BOOK}？")
        println("1.取消 2.确认")
        val exitSelect = scanner.nextInt()
        if (exitSelect == 2) {
            isExit = true
        }
    }

    private fun inBook(scanner: Scanner) {
        getTitle(TITLE_IN_BOOK)
        println("请输入图书编号")
        val number = scanner.nextInt()
        val book = LibraryManger.holder.findBook(number)
        val result = LibraryManger.holder.inBook(book)
        if (result == 0) {
            println("归还图书")
            val books = LibraryManger.holder.showAllBooks();
            if (books.isNotEmpty()) {
                printBook(books)
            } else {
                println("储存图书为空！")
            }
            waitingForIn(scanner)
        } else {
            println("归还失败，未记录该书或该书已在库！")
            waitingForIn(scanner)
        }
    }

    private fun outBook(scanner: Scanner) {
        getTitle(TITLE_OUT_BOOK)
        println("请输入图书编号")
        val number = scanner.nextInt()
        val book = LibraryManger.holder.findBook(number)
        val result = LibraryManger.holder.outBook(book)
        if (result == 0) {
            println("借出成功！")
            printBook(book)//打印借出的图书
            waitingForIn(scanner)
        } else {
            println("借出失败，该书不存在于库中，或已借出！")
            waitingForIn(scanner)
        }
    }

    private fun findAllBooks(scanner: Scanner) {
        getTitle(TITLE_FIND_ALL_BOOK)
        val books = LibraryManger.holder.showAllBooks()
        if (books.isNotEmpty()) {
            printBook(books)
        } else {
            println("储存图书为空！")
        }
        waitingForIn(scanner)
    }

    private fun waitingForIn(scanner: Scanner) {
        println("按回车键继续...")
        System.`in`.read()
    }

    private fun findBook(scanner: Scanner) {
        var isFind = true
        loop@ while (isFind) {
            getTitle(TITLE_FIND_BOOK)
            println("1.输入编号  2.输入书名 3. 退出查询")
            val select = scanner.nextInt()
            when (select) {
                1 -> {
                    println("输入编号")
                    val number = scanner.nextInt()
                    val book = LibraryManger.holder.findBook(number)
                    if (book.number == -1) {
                        println("未查询到该图书！")
                        continue@loop
                    }
                    printBook(book)
                }

                2 -> {
                    println("输入书名")
                    val title = scanner.next()
                    val book = LibraryManger.holder.findBook(title)
                    if (book.number == -1) {
                        println("未查询到该图书！")
                        continue@loop
                    }
                    printBook(book)
                }

                3 -> {
                    isFind = false
                }

                else -> {
                    println("输入错误！")
                }
            }
        }
    }

    private fun printBook(book: Book) {
        printBook(listOf(book))
    }

    private fun printBook(books: List<Book>) {
        println("---------------------------------------------------------")
        for (b in books) {
            val status = LibraryManger.holder.checkBookStatus(b)
            println("$b ${if (status == Status.IN) "在库" else "借出"} |")
        }
        println("---------------------------------------------------------")
    }

    private fun deleteBook(scanner: Scanner) {
        getTitle(TITLE_DELETE_BOOK)
        println("请输入编号")
        val number = scanner.nextInt()
        val result = LibraryManger.holder.deleteBook(number)
        if (result == 0) {
            println("删除成功！")
        } else {
            println("删除失败！")
        }
        waitingForIn(scanner)
    }

    private fun addBook(scanner: Scanner) {
        getTitle(TITLE_ADD_BOOK)
        println("请输入书名")
        val title = scanner.next()
        println("请输入作者")
        val author = scanner.next()
        println("请输入出版社")
        val publish = scanner.next()
        val number = LibraryManger.holder.showAllBooks().addNumber
        val book = Book(number, title, author, publish)
        val result = LibraryManger.holder.addBook(book)
        if (result == 0) {
            println("添加成功！")
            printBook(book)
        } else {
            println("添加失败！")
        }
        waitingForIn(scanner)
    }

    private fun getTitle(str: String): String {
        return "----${str}----"
    }
}