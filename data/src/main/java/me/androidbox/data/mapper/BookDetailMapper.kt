package me.androidbox.data.mapper

import me.androidbox.data.entites.BookDetailsEntity
import me.androidbox.domain.models.BookDetails

class BookDetailMapper : EntityMapper<BookDetailsEntity, BookDetails> {
    override fun fromEntity(entity: BookDetailsEntity): BookDetails {
        return BookDetails(entity.title, entity.description, entity.author, entity.price)
    }

    override fun toEntity(domain: BookDetails): BookDetailsEntity {
        return BookDetailsEntity(domain.title, domain.description, domain.author, domain.price)
    }
}
