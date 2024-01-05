package com.mehdisekoba.wallpaper.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.home.ResponseCategories.ResponseCategoriesItem
import com.mehdisekoba.wallpaper.databinding.ItemCategoriesBinding
import com.mehdisekoba.wallpaper.utils.base.BaseDiffUtils
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import javax.inject.Inject

class CategoriesAdapter @Inject constructor() :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    // Binding

    private var items = emptyList<ResponseCategoriesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    inner class ViewHolder(private val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseCategoriesItem) {
            binding.apply {
                // Image
                item.coverPhoto?.urls?.regular?.let {
                    item.coverPhoto.blurHash?.let { it1 -> itemImage.loadImageByBlurHash(it, it1) }
                }
                txtTitle.text = item.title
                // Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        item.coverPhoto?.urls?.regular?.let { photo ->
                            it(
                                item.id!!,
                                item.title!!,
                                photo,
                            )
                        }
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((String, String, String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String, String, String) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<ResponseCategoriesItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}
