package com.pacage

interface LibraryStatusInf {

    fun checkBookStatus(b: Book): Status

    fun outBook(b: Book): Int

    fun inBook(b: Book): Int

}