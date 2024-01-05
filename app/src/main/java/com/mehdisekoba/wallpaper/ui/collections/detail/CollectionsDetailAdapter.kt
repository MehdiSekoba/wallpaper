package com.mehdisekoba.wallpaper.ui.collections.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.collections.detail.ResponseDetailCollections.ResponseDetailCollectionsItem
import com.mehdisekoba.wallpaper.databinding.ItemSplashBinding
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import javax.inject.Inject

class CollectionsDetailAdapter @Inject constructor() :
    PagingDataAdapter<ResponseDetailCollectionsItem, CollectionsDetailAdapter.ViewHolder>(differCallback) {
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
        fun bind(item: ResponseDetailCollectionsItem) {
            // initViews
            binding.apply {
                // Image
                item.urls?.regular?.let { imageUrl ->
                    item.blurHash?.takeIf { it.isNotBlank() }?.let { blurHash ->
                        itemImage.loadImageByBlurHash(imageUrl, blurHash)
                    }
                } // click
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
        private val differCallback = object : DiffUtil.ItemCallback<ResponseDetailCollectionsItem>() {
            override fun areItemsTheSame(oldItem: ResponseDetailCollectionsItem, newItem: ResponseDetailCollectionsItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseDetailCollectionsItem, newItem: ResponseDetailCollectionsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
