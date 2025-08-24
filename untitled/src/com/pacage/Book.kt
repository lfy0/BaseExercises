package com.pacage

//Number, title, author, publisher, whether to lend
//编号、书名、作者、出版社、是否借出
data class Book(var number: Int, var title: String, var author: String, var publisher: String) {
    override fun toString(): String {
        return "|编号：${number}|书名：${title}|作者：${author}|出版社：${publisher}|"
    }
}
