package mo.zain.movie.repository

import mo.zain.movie.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(private val apiService: ApiService){
    suspend fun getTvShows()=apiService.getTvShows()
}