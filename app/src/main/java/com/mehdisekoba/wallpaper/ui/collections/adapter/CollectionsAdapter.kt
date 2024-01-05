package com.mehdisekoba.wallpaper.ui.collections.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.data.model.collections.ResponseCollections.ResponseCollectionsItem
import com.mehdisekoba.wallpaper.databinding.ItemCollectionBinding
import com.mehdisekoba.wallpaper.utils.extensions.loadImageByBlurHash
import com.mehdisekoba.wallpaper.utils.extensions.separating
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CollectionsAdapter @Inject constructor(@ApplicationContext private var context: Context) :
    PagingDataAdapter<ResponseCollectionsItem, CollectionsAdapter.ViewHolder>(differCallback) {

    // Binding
    private lateinit var binding: ItemCollectionBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CollectionsAdapter.ViewHolder {
        binding = ItemCollectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: CollectionsAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResponseCollectionsItem) {
            // initViews
            binding.apply {
                // Title
                itemTitle.text = item.title
                itemDes.text =
                    "${item.totalPhotos?.separating()} ${itemView.context.getString(R.string.photos)}  ${item.coverPhoto?.altDescription}"
                // Tag
                item.tags?.let { tags ->
                    val tagList = mutableListOf<String>()
                    tagList.addAll(tags.mapNotNull { it.title })
                    setupChip(tagList, eventChipGroup)
                }
                // imageview
                item.coverPhoto?.urls?.regular.let { imageUrl ->
                    item.coverPhoto?.blurHash!!.takeIf { it.isNotBlank() }?.let { blurHash ->
                        itemImg.loadImageByBlurHash(imageUrl!!, blurHash)
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

    private fun setupChip(list: MutableList<String>, view: ChipGroup) {
        list.forEach {
            val chip = Chip(context)
            chip.text = it
            view.addView(chip)
        }
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<ResponseCollectionsItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseCollectionsItem,
                newItem: ResponseCollectionsItem,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseCollectionsItem,
                newItem: ResponseCollectionsItem,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
