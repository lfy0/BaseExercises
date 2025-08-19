package com.pacage


class LibraryImpl : LibraryInterface, LibraryStatusInf {

    private var books = mutableListOf<Book>()
    private var booksStatus = mutableMapOf<Int, Status>()

    override fun addBook(book: Book): Int {
        return if (books.any { it.number == book.number }) {
            -1
        } else {
            books.add(book)
            booksStatus[book.number] = Status.IN
            0
        }
    }

    override fun findBook(index: Int): Book? {
        for (b in books) {
            if (b.number == index) {
                return b
            }
        }
        return null
    }

    override fun findBook(name: String): Book? {
        for (b in books) {
            if (b.title == name) {
                return b
            }
        }
        return null
    }

    override fun showAllBooks(): List<Book> {
        return books
    }

    override fun deleteBook(index: Int): Int {
        val book = books.find { it.number == index } ?: -1
        books.remove(book)
        booksStatus.remove(book)
        return 0
    }

    override fun checkBookStatus(b: Book): Status {
        if (booksStatus.containsKey(b.number)) {
            return booksStatus[b.number]!!
        }
        return Status.OUT
    }

    override fun outBook(book: Book): Int {
        return if (books.contains(book) &&
            booksStatus.containsKey(book.number) &&
            booksStatus[book.number] != Status.OUT
        ) {
            booksStatus[book.number] = Status.OUT
            0
        } else {
            -1
        }
    }

    override fun inBook(book: Book): Int {
        return if (books.contains(book) &&
            booksStatus.containsKey(book.number) &&
            booksStatus[book.number] != Status.IN
        ) {
            booksStatus[book.number] = Status.IN
            0
        } else {
            -1
        }
    }


}