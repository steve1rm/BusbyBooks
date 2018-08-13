package me.androidbox.data.respository

import me.androidbox.data.entites.BookDetailsEntity

interface BookDetailsRemote {
    fun getBookDetails(): MutableList<BookDetailsEntity>
}
