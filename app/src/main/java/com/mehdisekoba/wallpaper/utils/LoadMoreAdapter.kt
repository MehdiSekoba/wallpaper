package com.mehdisekoba.wallpaper.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.databinding.LoadMoreBinding

class LoadMoreAdapter(private val retry: () -> Unit) : LoadStateAdapter<LoadMoreAdapter.ViewHolder>() {

    private lateinit var binding: LoadMoreBinding

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        binding = LoadMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bindData(loadState)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.loadMoreRetry.setOnClickListener { retry.invoke() }
        }

        fun bindData(state: LoadState) {
            // InitViews
            binding.apply {
                loadMoreProgress.isVisible = state is LoadState.Loading
                loadMoreRetry.isVisible = state is LoadState.Error
            }
        }
    }
}
