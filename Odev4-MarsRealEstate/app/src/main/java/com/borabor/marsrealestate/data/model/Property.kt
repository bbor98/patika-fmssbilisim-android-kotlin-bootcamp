package com.borabor.marsrealestate.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Parcelable data holder class of Mars property.
 *
 * @property id ID of property
 * @property imgSrc image URL of property
 * @property price price of property
 * @property type sale type of property (whether for sale or for rent)
 */
@Parcelize
data class Property(
    @SerializedName("id")
    val id: String,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("type")
    val type: String
) : Parcelable