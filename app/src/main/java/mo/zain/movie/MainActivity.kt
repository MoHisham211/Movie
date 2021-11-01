package mo.zain.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import mo.zain.movie.adapter.TvShowAdapter
import mo.zain.movie.viewModel.TvShowViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        recyclerView=findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        getData()

    }
    fun getData(){
        viewModel.responseItem.observe(this,{tvSows->
            tvShowAdapter= TvShowAdapter(tvSows)
            recyclerView.adapter=tvShowAdapter
        })
    }
}