package mo.zain.movie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mo.zain.movie.models.TvShowsResponseItem
import mo.zain.movie.repository.TvShowRepository
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: TvShowRepository):ViewModel() {

    private val _response=MutableLiveData<List<TvShowsResponseItem>>()
    val responseItem:LiveData<List<TvShowsResponseItem>>
    get() = _response
    init {
        getAllTvShows()
    }

    private fun getAllTvShows() =viewModelScope.launch{
        repository.getTvShows().let { response ->

            if (response.isSuccessful){
                _response.postValue(response.body())

            }else{
                //response.code()
            }
        }
    }
}