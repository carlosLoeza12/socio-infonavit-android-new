package com.example.socio_infonavit_android_new.ui.benevits

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.socio_infonavit_android_new.R
import com.example.socio_infonavit_android_new.core.Result
import com.example.socio_infonavit_android_new.core.extensions.loadDialog
import com.example.socio_infonavit_android_new.data.model.Movie
import com.example.socio_infonavit_android_new.databinding.FragmentBenevitsBinding
import com.example.socio_infonavit_android_new.presentation.MovieViewModel
import com.example.socio_infonavit_android_new.ui.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BenevitsFragment : Fragment(R.layout.fragment_benevits), MovieAdapter.OnMovieOnclickListener {

    private val viewModel by activityViewModels<MovieViewModel>()
    private lateinit var  binding: FragmentBenevitsBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var animationController: LayoutAnimationController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBenevitsBinding.bind(view)

        val toolbar = binding.toolbar
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            (activity as AppCompatActivity).setTitle(R.string.movie)
        }

        //show item toolbar
        setHasOptionsMenu(true);

        getMovies()
    }

    private fun getMovies(){
        viewModel.getMovies().observe(viewLifecycleOwner, Observer {
            when(it){
                is  Result.Loading -> {
                    binding.progressMovie.visibility = View.VISIBLE
                }
                is Result.Success ->{
                    Log.e("results", it.data.results.toString() )
                    binding.progressMovie.visibility = View.GONE
                    recyclerConfig(it.data.results)
                }
                is Result.Failure ->{
                    binding.progressMovie.visibility = View.GONE
                }
            }
        })
    }

    private fun recyclerConfig(movieList: List<Movie>){
        animationController = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_top)
        binding.recyclerMovie.layoutAnimation = animationController

        movieAdapter = MovieAdapter(movieList,this)

        binding.recyclerMovie.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

    }

    override fun onMovieClick(movie: Movie) {
        val action = BenevitsFragmentDirections.actionBenevitsFragmentToMovieDetailFragment(
            movie.poster_path,
            movie.backdrop_path,
            movie.vote_average,
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date
        )
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itemClose ->{
               requireContext().loadDialog(getString(R.string.close_app),2)
            }
            R.id.itemSettings -> {
                Log.e("aaa","settings")
            }

        }

        return super.onOptionsItemSelected(item)
    }

}
