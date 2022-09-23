package com.borabor.marsrealestate.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.borabor.marsrealestate.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.util.*

/**
 * Loads image from the given URL into the ImageView.
 *
 * @param imageUrl URL of the image
 */
@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .error(R.drawable.ic_outline_broken_image_24)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

/**
 * Adds '$' sign at the start of the text and separates thousands with ','.
 *
 * @param price plain price to format
 */
@BindingAdapter("price")
fun TextView.setFormattedPrice(price: Int) {
    val formattedNumber = String.format(Locale.US, "%,d", price)
    text = context.getString(R.string.price, formattedNumber)
}