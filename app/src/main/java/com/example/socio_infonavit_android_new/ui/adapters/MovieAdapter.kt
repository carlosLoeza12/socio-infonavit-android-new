package com.example.socio_infonavit_android_new.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.socio_infonavit_android_new.application.AppConstants
import com.example.socio_infonavit_android_new.data.model.Movie
import com.example.socio_infonavit_android_new.databinding.ItemMovieBinding

class MovieAdapter(
    private val movieList: List<Movie>,
    private val itemClickListener: OnMovieOnclickListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    interface OnMovieOnclickListener{
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val itemBindig = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(itemBindig)

        itemBindig.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onMovieClick(movieList[position])
        }

        return holder

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
       holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class ViewHolder(private val itemMovieBinding: ItemMovieBinding): RecyclerView.ViewHolder(itemMovieBinding.root){
        fun bind(item: Movie){
            itemMovieBinding.txtTitle.text = item.title
            itemMovieBinding.txtRelease.text = item.release_date
            itemMovieBinding.imgMovie.load(AppConstants.BASE_IMAGE_MOVIE+ item.poster_path)

        }
    }
}