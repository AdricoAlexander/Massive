import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aqua_care.Berita.Model.Post
import com.example.aqua_care.Berita.Retrofit.BeritaRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class BeritaViewModel(
    private val repository: BeritaRepository
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success

    val latestNews: LiveData<List<Post>> = repository.latestNews

    init {
        fetchLatestNews()
    }

    fun fetchLatestNews() {
        viewModelScope.launch {
            _loading.value = true
            try {
                repository.getLatestNews()
                _success.value = true
            } catch (e: HttpException) {
                _error.value = "HttpException: ${e.message()}"
            } catch (e: Throwable) {
                _error.value = "Error: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}

