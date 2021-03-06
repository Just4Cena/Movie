package com.example.gap.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.gap.R
import com.example.gap.data.model.response.GetContent
import com.example.gap.data.model.response.Result
import com.example.gap.databinding.ItemContentBinding

class ContentAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<GetContent, ContentAdapter.ViewHolder>(CONTENT_COMPARE) {
    inner class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(content: GetContent) {
            binding.apply {
                Glide.with(itemView).load(content.ThumbImage).centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade()).error(
                        R.drawable.ic_default_image
                    ).into(ivContent)

                tvTitle.text = content.Title
                tvZone.text = if (content.ZoneID == 4) "سینمایی" else "سریال"
            }
        }
    }

    companion object {
        private val CONTENT_COMPARE = object : DiffUtil.ItemCallback<GetContent>() {
            override fun areItemsTheSame(oldItem: GetContent, newItem: GetContent): Boolean =
                oldItem.ContentID == newItem.ContentID

            override fun areContentsTheSame(oldItem: GetContent, newItem: GetContent): Boolean =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    interface OnItemClickListener {
        fun onItemClick(content: GetContent)
    }

}