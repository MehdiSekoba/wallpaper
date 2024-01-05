package com.mehdisekoba.wallpaper.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos.ResponsePhotosItem
import com.mehdisekoba.wallpaper.databinding.ItemSplashBinding
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import javax.inject.Inject

class CategoryAdapter @Inject constructor() :
    PagingDataAdapter<ResponsePhotosItem, CategoryAdapter.ViewHolder>(differCallback) {
    // Binding
    private lateinit var binding: ItemSplashBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemSplashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponsePhotosItem) {
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
        private val differCallback = object : DiffUtil.ItemCallback<ResponsePhotosItem>() {
            override fun areItemsTheSame(
                oldItem: ResponsePhotosItem,
                newItem: ResponsePhotosItem,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponsePhotosItem,
                newItem: ResponsePhotosItem,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
