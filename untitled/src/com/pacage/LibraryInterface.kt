package com.pacage

interface LibraryInterface: LibraryStatusInf {

    fun addBook(book: Book): Int

    fun findBook(index: Int): Book

    fun findBook(name: String): Book

    fun showAllBooks(): List<Book>

    fun deleteBook(index: Int): Int

}