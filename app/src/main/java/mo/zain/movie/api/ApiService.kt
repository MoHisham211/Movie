package mo.zain.movie.api

import mo.zain.movie.models.TvShowsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("shows")
    suspend fun getTvShows():Response<TvShowsResponse>
}