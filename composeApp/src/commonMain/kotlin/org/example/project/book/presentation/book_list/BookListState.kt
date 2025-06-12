package org.example.project.book.presentation.book_list

import androidx.room.Query
import coil3.compose.AsyncImagePainter
import org.example.project.book.domain.Book

data class BookListState(
    val searchQuery:String="Kotlin",
    val searchResults:List<Book> = emptyList(),
    val favoriteBooks:List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex:Int=0,
    val errorMessage: String?=null
)