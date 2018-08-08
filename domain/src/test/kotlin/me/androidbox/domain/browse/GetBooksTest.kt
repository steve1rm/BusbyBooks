package me.androidbox.domain.browse

import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import me.androidbox.domain.executor.PostExecutionThread
import me.androidbox.domain.models.BookDetails
import me.androidbox.domain.repository.BooksRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import kotlin.properties.Delegates

class GetBooksTest {

    private val booksRepository: BooksRepository = Mockito.mock(BooksRepository::class.java)
    private val postExecutionThread: PostExecutionThread = Mockito.mock(PostExecutionThread::class.java)
    private var getBooks: GetBooks by Delegates.notNull()

    @Before
    fun setup() {
           getBooks = GetBooks(booksRepository, postExecutionThread)
    }

    @Test
    fun `getBooks should not be null`() {
        assertThat(getBooks).isNotNull()
    }

    @Test
    fun `books repository return a list of book details`() {
        val bookDetails = BookDetails("title", "description", "author", 5.99F)
        val list = listOf(bookDetails)
        whenever(booksRepository.getBooksDetails()).thenReturn(Observable.just(list))

        getBooks.buildUseCaseObservable().test()
                .assertComplete()

        verify(booksRepository).getBooksDetails()
        verifyNoMoreInteractions(booksRepository)
    }

    @Test
    fun `test execute subscribe to the list of books`() {
    }
}