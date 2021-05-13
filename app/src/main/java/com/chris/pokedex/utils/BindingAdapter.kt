package com.chris.pokedex.layer.ui

import android.graphics.drawable.GradientDrawable
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.chris.pokedex.R
import com.chris.pokedex.utils.glide.GlideManager

@BindingAdapter("loadArtwork")
fun bindLoadArtwork(imageView: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        GlideManager.loadArtwork(
            target = imageView,
            imageUrl = imageUrl
        )
    }
}

@BindingAdapter("loadDrawable")
fun bindLoadDrawable(imageView: ImageView, drawable: Int) {
    if (drawable != 0) {
        GlideManager.loadDrawable(
            target = imageView,
            drawable = drawable
        )
    }
}

@BindingAdapter("loadSprite")
fun bindLoadSprite(imageView: ImageView, pokemonId: Int?) {
    if (pokemonId != 0) {
        val urlSprite =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/${pokemonId}.gif"
        GlideManager.loadAnimatedSprite(
            target = imageView,
            urlSprite = urlSprite
        )
    }
}

@BindingAdapter("loadStaticSprite")
fun bindLoadStaticSprite(imageView: ImageView, pokemonUrl: String) {
    if (pokemonUrl != "") {
        GlideManager.loadStaticSprite(
            target = imageView,
            urlSprite = pokemonUrl
        )
    }else{
//        val drawable = ResourcesCompat.getDrawable(
//            imageView.context.resources,
//            R.mipmap.bg_pokeball,
//            null
//        )
        GlideManager.loadDrawable(
            target = imageView,
            drawable = R.mipmap.bg_pokeball
        )
    }
}

@BindingAdapter("loadBackground")
fun bindLoadBackground(frameLayout: FrameLayout, color: Int) {
    if (color != 0) {
        val gradient = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(
                ResourcesCompat.getColor(
                    frameLayout.context.resources,
                    color,
                    null
                ),
                ResourcesCompat.getColor(
                    frameLayout.context.resources,
                    R.color.transparent,
                    null
                )
            )
        )
        gradient.shape = GradientDrawable.RECTANGLE
        gradient.cornerRadius = 10f
        frameLayout.setBackgroundDrawable(gradient)
    }
}
