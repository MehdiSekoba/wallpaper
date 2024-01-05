package com.mehdisekoba.wallpaper.data.network

import com.mehdisekoba.wallpaper.data.model.collections.ResponseCollections
import com.mehdisekoba.wallpaper.data.model.collections.detail.ResponseDetailCollections
import com.mehdisekoba.wallpaper.data.model.detail.ResponseDetail
import com.mehdisekoba.wallpaper.data.model.home.ResponseCategories
import com.mehdisekoba.wallpaper.data.model.search.ResponseSearch
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("photos")
    suspend fun getNewestPhotos(): Response<ResponsePhotos>

    @GET("search/photos")
    suspend fun getSearchBannerHome(@Query("query") query: String): Response<ResponseSearch>

    @GET("topics")
    suspend fun getCategoriesList(): Response<ResponseCategories>

    @GET("search/photos")
    suspend fun getSearchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
    ): Response<ResponseSearch>

    @GET("collections")
    suspend fun getCollections(
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?,
    ): Response<ResponseCollections>

    @GET("topics/{id}/photos")
    suspend fun getCategoryPhotos(
        @Path("id") id: String,
        @Query("page") page: Int,
    ): Response<ResponsePhotos>

    @GET("photos/{id}")
    suspend fun getDetailPhoto(@Path("id") id: String): Response<ResponseDetail>

    @GET("collections/{id}/photos")
    suspend fun getDetailCollections(@Path("id") id: String, @Query("page") page: Int): Response<ResponseDetailCollections>
}
