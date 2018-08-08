package me.androidbox.domain.repository

import io.reactivex.Observable
import me.androidbox.domain.models.BookDetails

interface BooksRepository {
    fun getBooksDetails(): Observable<List<BookDetails>>
}
