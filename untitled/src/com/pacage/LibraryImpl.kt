package com.pacage


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
                booksStatus.remove(b)
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

    override fun outBook(book: Book): Int {
        return if (books.contains(book) &&
            booksStatus.containsKey(book) &&
            booksStatus[book] != Status.OUT
        ) {
            booksStatus[book] = Status.OUT
            0
        } else {
            -1
        }
    }

    override fun inBook(book: Book): Int {
        return if (books.contains(book) &&
            booksStatus.containsKey(book) &&
            booksStatus[book] != Status.IN
        ) {
            booksStatus[book] = Status.IN
            0
        } else {
            -1
        }
    }


}