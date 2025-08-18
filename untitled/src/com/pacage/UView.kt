package com.pacage

import java.util.Scanner

fun main() {
    val uView = UView()
    uView.show()
}

class UView {

    init {
        init()
    }

    private fun init() {
       // LibraryManger.holder.addBook()
    }

    fun show() {
        val scanner = Scanner(System.`in`)
        println("--------------------欢迎使用XXX市图书管理系统-------------------------")
        println("1.添加新图书")
        println("2.删除图书")
        println("3.查询图书")
        println("4.显示所有图书")
        println("5.图书借出操作")
        println("6.图书归还操作")
        println("7.退出")
        println("------------------------------------------------------------------")
        val inSelect = scanner.nextInt()
        while (inSelect == 7) {
            when (inSelect) {
                1 -> {

                }
                2 -> {

                }
            }
        }
    }

}