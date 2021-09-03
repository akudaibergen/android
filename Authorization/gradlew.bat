package com.example.news

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapp.Movie
import com.example.myapp.MoviesAdapter
import com.example.myapp.RetrofitService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var recyclerView: RecyclerView
    private var movieAdapter: MoviesAdapter? = null
    private lateinit var movieList: List<Movie>
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var toolbar: Toolbar
    private lateinit var textView: TextView
    private var movieDao: MovieDao? = null
    private val job = Job()
    private var page = 1
    private var isLoading = false
    private var limit = 10

    private val LIST_STATE = "list_state"
    private val BUNDLE_RECYCLER_LAYOUT = "recycler_layout"
    private var savedRecyclerLayoutState: Parcelable? = null
    private var moviesInstance: ArrayList<Movie>? = ArrayList()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        textView = findViewById(R.id.toolbar_title)
        textView.text = "News"

        movieDao = MovieDatabase.getDatabase(context = this).movieDao()

        swipeRefreshLayout = findViewById(R.id.main_refresh)
        recyclerView = findViewById(R.id.recycler_view)
        movieAdapter = MoviesAdapter(this)
        swipeRefreshLayout.setOnRefreshListener {
            refreshViews()
        }
        refreshViews()
    }

    private fun ref