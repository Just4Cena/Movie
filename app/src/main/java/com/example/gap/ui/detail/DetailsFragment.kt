package com.example.gap.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.gap.R
import com.example.gap.databinding.DetailsFragmentBinding
import com.example.gap.ui.MainActivity
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.item_content.*

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DetailsFragmentBinding.bind(view)
        binding.apply {
            val content = args.content
            Glide.with(this@DetailsFragment).load(content.ThumbImage)
                .error(R.drawable.ic_default_image)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }
                }).into(ivDetails)

            webView.loadData("<html dir=\"rtl\" lang=\"\"><body>" + content.Summary + "</body></html>",
                "text/html; charset=utf-8",
                "utf-8")
            (activity as MainActivity).supportActionBar?.apply {
                title = content.Title
                
            }
            (activity as MainActivity).supportActionBar?.title = content.Title
        }
    }

}