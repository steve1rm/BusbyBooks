package me.androidbox.data.respository

import io.reactivex.Observable
import me.androidbox.data.entites.BookDetailsEntity

interface BookDetailsRemote {
    fun getBookDetails(): Observable<MutableList<BookDetailsEntity>>
}
