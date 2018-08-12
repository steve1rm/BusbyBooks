package me.androidbox.domain.mocks

import me.androidbox.domain.models.BookDetails
import java.util.*

object BooksDetailsFactory {
    private fun randomUuid() = UUID.randomUUID().toString()

    private fun randomFloat() = Random().nextFloat()

    private fun createBookDetail(): BookDetails {
        return BookDetails(
                randomUuid(),
                randomUuid(),
                randomUuid(),
                randomFloat())
    }

    fun createListBookDetails(howMany: Int): MutableList<BookDetails> {
        val bookDetailsList: MutableList<BookDetails> = mutableListOf()

        repeat(howMany) {
            bookDetailsList.add(createBookDetail())
        }

        return bookDetailsList
    }
}
