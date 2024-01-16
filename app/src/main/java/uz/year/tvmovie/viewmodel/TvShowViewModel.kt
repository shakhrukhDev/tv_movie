package uz.year.tvmovie.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.year.tvmovie.model.TvShowItem
import uz.year.tvmovie.repository.TvShowRepository
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject constructor(private val repository: TvShowRepository) : ViewModel() {


    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
    get() = _response
    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let {response->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d(TAG, "getAllTvShows Error: ${response.code()}")
            }
        }
    }
}