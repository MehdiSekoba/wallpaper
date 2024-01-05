package com.mehdisekoba.wallpaper.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehdisekoba.wallpaper.data.model.search.ResponseSearch.Result
import com.mehdisekoba.wallpaper.databinding.ItemBannerBinding
import com.mehdisekoba.wallpaper.utils.ITEM_COUNT
import com.mehdisekoba.wallpaper.utils.base.BaseDiffUtils
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BannerAdapter @Inject constructor(@ApplicationContext val context: Context) : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {
    // Binding
    private lateinit var binding: ItemBannerBinding
    private var items = emptyList<Result>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = ITEM_COUNT
    override fun getItemViewType(position: Int) = position
    override fun getItemId(position: Int) = position.toLong()

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("RestrictedApi")
        fun bind(item: Result) {
            // initViews
            binding.apply {
                // Image
                item.urls?.regular?.let { imageUrl ->
                    item.blurHash?.takeIf { it.isNotBlank() }?.let { blurHash ->
                        carouselImage.loadImageByBlurHash(imageUrl, blurHash)
                    }
                }                // Avatar
                item.user?.profileImage?.let {
                    avatar.loadImageByBlurHash(it.medium!!, item.blurHash!!)
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

    fun setData(data: List<Result>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}
