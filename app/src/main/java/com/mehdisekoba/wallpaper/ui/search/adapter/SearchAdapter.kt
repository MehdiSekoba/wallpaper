package com.mehdisekoba.wallpaper.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.search.ResponseSearch.Result
import com.mehdisekoba.wallpaper.databinding.ItemImagesBinding
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import javax.inject.Inject

class SearchAdapter @Inject constructor() : PagingDataAdapter<Result, SearchAdapter.ViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val binding = ItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder(private val binding: ItemImagesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.apply {
                // Image
                item.urls?.regular?.let { imageUrl ->
                    item.blurHash?.takeIf { it.isNotBlank() }?.let { blurHash ->
                        itemImage.loadImageByBlurHash(imageUrl, blurHash)
                    }
                }
                // Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item.id!!)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }
}
