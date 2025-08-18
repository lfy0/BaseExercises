package com.pacage

import kotlin_.b


class LibraryImpl : LibraryInterface {

    private var books = mutableListOf<Book>()
    private var booksStatus = mutableMapOf<Book, Status>()

    override fun addBook(book: Book): Int {
        var isExist = false
        for (b in books) {
            if (b.number == book.number) {
                isExist = true
            }
        }
        return if (!isExist) {
            books.add(book)
            booksStatus[book] = Status.IN
            0
        } else {
            -1
        }
    }

    override fun findBook(index: Int): Book {
        for (b in books) {
            if (b.number == index) {
                return b
            }
        }
        return Book(-1, "", "", "")
    }

    override fun findBook(name: String): Book {
        for (b in books) {
            if (b.title == name) {
                return b
            }
        }
        return Book(-1, "", "", "")
    }

    override fun showAllBooks(): List<Book> {
        return books
    }

    override fun deleteBook(index: Int): Int {
        for (b in books) {
            if (b.number == index) {
                books.remove(b)
                booksStatus[b] = Status.OUT
                return 0;
            }
        }
        return -1;
    }

    override fun checkBookStatus(b: Book): Status {
        if (booksStatus.containsKey(b)) {
            return booksStatus[b]!!
        }
        return Status.OUT
    }

    override fun outBook(b: Book): Int {
        return if (books.contains(b)) {
            books.remove(b)
            booksStatus[b] = Status.OUT
            0
        } else {
            -1
        }
    }

    override fun inBook(book: Book): Int {
        var isExist = false
        for (b in books) {
            if (b.number == book.number) {
                isExist = true
            }
        }
        return if (!isExist) {
            books.add(book)
            booksStatus[book] = Status.IN
            0
        } else {
            -1
        }
    }


}