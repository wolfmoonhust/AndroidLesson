package com.example.tmdbclientexample.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclientexample.R
import com.example.tmdbclientexample.databinding.ActivityTvShowBinding
import com.example.tmdbclientexample.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding :ActivityTvShowBinding

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        val responseLiveData = tvShowViewModel.getTvShows()

        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
        })
    }
}