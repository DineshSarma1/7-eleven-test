package com.dinesh.testapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dinesh.testapplication.R
import com.dinesh.testapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel : HomeViewModel
    private lateinit var adapter: BookAdapter
    private lateinit var homeBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding = FragmentHomeBinding.bind(view)

        initRecycler()

        observeData()
    }

    fun observeData() {
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        viewModel.data.observe(viewLifecycleOwner){bookList ->
            bookList?.let {
                adapter.updateBooks(it)
            }
        }
    }

    fun initRecycler() {
        adapter = BookAdapter()
        homeBinding.recyclerBook.adapter = adapter
    }
}