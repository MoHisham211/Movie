package mo.zain.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mo.zain.movie.R
import mo.zain.movie.models.TvShowsResponseItem

class TvShowAdapter(private val movieList: List<TvShowsResponseItem>):
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imageView: ImageView
        lateinit var textView: TextView
        init {
            imageView=itemView.findViewById(R.id.imageShow)
            textView=itemView.findViewById(R.id.movieShow)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tv_show_items,parent,false))
    }

    override fun onBindViewHolder(holder: TvShowAdapter.ViewHolder, position: Int) {
        val tvShowsResponseItem=movieList.get(position)

        holder.textView.setText(tvShowsResponseItem.name)

        Glide
            .with(holder.itemView.context)
            .load(tvShowsResponseItem.image.original)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}