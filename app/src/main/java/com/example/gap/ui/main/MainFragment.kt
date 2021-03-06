package com.example.gap.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gap.R
import com.example.gap.data.model.response.GetContent
import com.example.gap.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainFragment"

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment), ContentAdapter.OnItemClickListener {

    private val viewModel by viewModels<MainViewModel>()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = MainFragmentBinding.bind(view)
        val adapter = ContentAdapter(this)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        viewModel.content.observe(viewLifecycleOwner) {
            Log.e(TAG, "onViewCreated: $it")
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onItemClick(content: GetContent) {
        val actionMainFragmentToDetailsFragment =
            MainFragmentDirections.actionMainFragmentToDetailsFragment(content)
        findNavController().navigate(actionMainFragmentToDetailsFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}