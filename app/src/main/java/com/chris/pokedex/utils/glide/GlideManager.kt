package com.chris.pokedex.utils.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chris.pokedex.R


object GlideManager {

    fun loadArtwork(target: ImageView, imageUrl: String) {
        val options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.default_artwork)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontTransform()

        Glide.with(target.context)
            .setDefaultRequestOptions(options)
            .load(imageUrl)
            .into(target)
    }

    fun loadDrawable(target: ImageView, drawable: Int?) {
        val options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.type_normal_name)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontTransform()

        Glide.with(target.context)
            .asDrawable()
            .apply(options)
            .load(drawable)
            .into(target)
    }

    fun loadAnimatedSprite(target: ImageView, urlSprite: String) {

        val options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.default_animated)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontTransform()

        Glide.with(target.context)
            .asGif()
            .apply(options)
            .load(urlSprite)
            .into(target)
    }

    fun loadStaticSprite(target: ImageView, urlSprite: String) {

        val options: RequestOptions = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.default_animated)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontTransform()

        Glide.with(target.context)
            .asBitmap()
            .apply(options)
            .load(urlSprite)
            .into(target)
    }

}