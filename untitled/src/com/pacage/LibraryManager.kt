package com.pacage


class LibraryManager private constructor() : LibraryInterface, LibraryStatusInf {

    companion object {
        val holder = LibraryManager()
    }

    private var libraryImpl: LibraryImpl = LibraryImpl()

    override fun addBook(book: Book): Int {
        return libraryImpl.addBook(book)
    }

    override fun findBook(index: Int): Book? {
        return libraryImpl.findBook(index)
    }

    override fun findBook(name: String): Book? {
        return libraryImpl.findBook(name)
    }

    override fun showAllBooks(): List<Book> {
        return libraryImpl.showAllBooks()
    }


    override fun deleteBook(index: Int): Int {
        return libraryImpl.deleteBook(index)
    }

    override fun checkBookStatus(b: Book): Status {
        return libraryImpl.checkBookStatus(b)
    }

    override fun outBook(b: Book): Int {
        return libraryImpl.outBook(b)
    }

    override fun inBook(b: Book): Int {
        return libraryImpl.inBook(b)
    }

}