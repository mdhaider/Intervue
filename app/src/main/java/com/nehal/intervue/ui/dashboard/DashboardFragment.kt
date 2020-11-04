package com.nehal.intervue.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nehal.intervue.adapter.PostAdapter
import com.nehal.intervue.repository.PostRepository
import com.nehal.intervue.viewModel.PostViewModel
import com.nehal.intervue.viewModel.PostViewModelFactory
import com.nehal.intervue.R
import com.nehal.intervue.model.Mcq
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private val TAG = "main"
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerView = root.findViewById(R.id.recyclerView)

        initUi()
        return root
    }


    private fun initUi() {
        postAdapter = PostAdapter(requireActivity(), ArrayList())

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = postAdapter
        }

        val postViewModelFactory = PostViewModelFactory(PostRepository())
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]
        val data: MutableMap<String, String> = HashMap()
        data["count"] = "1"
        data["limit"] = "30"
        data["order"] = "quoteText"
        // data["where"] = "{"+"quoteAuthor"+":"+"Liam Neeson"+"}"

        postViewModel.getPost(data)
        postViewModel.postData.observe(requireActivity(), Observer {
            Log.d(TAG, "onCreate: ${it[0].question}")
            postAdapter.setPostData(it as ArrayList<Mcq>)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }
}
