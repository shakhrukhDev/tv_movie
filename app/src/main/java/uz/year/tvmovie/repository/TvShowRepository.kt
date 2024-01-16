package uz.year.tvmovie.repository

import uz.year.tvmovie.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}