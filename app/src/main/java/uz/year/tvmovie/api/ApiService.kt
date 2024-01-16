package uz.year.tvmovie.api

import retrofit2.Response
import retrofit2.http.GET
import uz.year.tvmovie.helper.Constants
import uz.year.tvmovie.model.TvShowResponse

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>
}