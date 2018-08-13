package me.androidbox.data.respository

import io.reactivex.Completable
import io.reactivex.Observable
import me.androidbox.data.entites.BookDetailsEntity
import me.androidbox.domain.models.BookDetails

interface BookDetailsDataStore {
    fun getBookDetails(): Observable<MutableList<BookDetailsEntity>>

    fun saveBookDetails(bookDetails: MutableList<BookDetailsEntity>): Completable

    fun clearBookDetails(): Completable
}