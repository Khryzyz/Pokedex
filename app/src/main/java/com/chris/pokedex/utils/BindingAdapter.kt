package com.chris.pokedex.utils

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.ColorUtils
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

@BindingAdapter("loadCatchIcon")
fun bindLoadCatchIcon(imageView: ImageView, action: Constants.TravelAction) {

    when (action) {
        Constants.TravelAction.UNEXPECTED -> {
            imageView.visibility = View.GONE
        }
        Constants.TravelAction.CATCH -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    imageView.context.resources,
                    R.drawable.ic_pokemon_catch,
                    null
                )
            )
        }
        Constants.TravelAction.REJECT -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    imageView.context.resources,
                    R.drawable.ic_pokemon_reject,
                    null
                )
            )
        }

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
    } else {
        GlideManager.loadDrawable(
            target = imageView,
            drawable = R.mipmap.bg_pokeball
        )
    }
}

@BindingAdapter("loadGradientBackground")
fun bindLoadGradientBackground(frameLayout: FrameLayout, color: Int) {
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
        frameLayout.background = gradient
    }
}

@BindingAdapter("loadSolidBackground")
fun bindLoadSolidBackground(frameLayout: FrameLayout, color: Int) {
    if (color != 0) {
        val colorAlpha = ColorUtils.setAlphaComponent(
            ResourcesCompat.getColor(
                frameLayout.context.resources,
                color,
                null
            ), 60
        )
        frameLayout.setBackgroundColor(colorAlpha)
    }
}

@BindingAdapter("loadImageBackground")
fun bindLoadImageBackground(frameLayout: FrameLayout, drawable: Int) {
    if (drawable != 0) {
        frameLayout.setBackgroundResource(drawable)
    }
}

@BindingAdapter("loadDrawableTextview")
fun bindLoadDrawableTextview(textView: TextView, drawable: Int) {
    if (drawable != 0) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    } else {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
    }
}