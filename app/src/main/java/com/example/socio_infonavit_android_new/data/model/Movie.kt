package com.example.socio_infonavit_android_new.data.model

data class Movie(val id: Int,
                 val adult: Boolean,
                 val genre_id: List<Int>,
                 val backdrop_path: String,
                 val original_language: String,
                 val original_title: String,
                 val overview: String,
                 val popularity: Float,
                 val poster_path: String,
                 val release_date: String,
                 val title: String,
                 val video: Boolean,
                 val vote_average: Float,
                 val vote_count: Int,
)

data class MovieList(val results: List<Movie> = listOf())


