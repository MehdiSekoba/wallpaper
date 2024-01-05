package com.mehdisekoba.wallpaper.ui.download.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mehdisekoba.wallpaper.data.model.local.InternalStoragePhoto
import com.mehdisekoba.wallpaper.databinding.PhotoLocalBinding
import com.mehdisekoba.wallpaper.utils.base.BaseDiffUtils
import javax.inject.Inject

class PhotoAdapter @Inject constructor() : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    // Binding
    private lateinit var binding: PhotoLocalBinding
    private var items = emptyList<InternalStoragePhoto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PhotoLocalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = items[position]
        holder.bind(photo)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InternalStoragePhoto) {
            // initViews
            binding.apply {
                image.load(item.contentUri)
            }
        }
    }

    private var onItemClickListener: ((String) -> Unit)? = null
    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<InternalStoragePhoto>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}
