package com.mehdisekoba.wallpaper.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos.ResponsePhotosItem
import com.mehdisekoba.wallpaper.databinding.ItemHomeBinding
import com.mehdisekoba.wallpaper.utils.base.BaseDiffUtils
import com.mehdisekoba.wallpaper.utils.extensions.loadImage
import javax.inject.Inject

class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    // Binding
    private lateinit var binding: ItemHomeBinding
    private var items = emptyList<ResponsePhotosItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponsePhotosItem) {
            binding.apply {
                // Image
                item.urls?.regular?.let {
                    image.loadImage(it)
                }
                // click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        item.urls?.regular?.let { photo ->
                            it(
                                item.id!!,
                            )
                        }
                    }
                }

            }
        }
    }
    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
    fun setData(data: List<ResponsePhotosItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}
