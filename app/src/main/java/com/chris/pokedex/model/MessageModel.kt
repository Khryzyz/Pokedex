package com.chris.pokedex.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageModel(
    val messageType: Constants.MessageTypes = Constants.MessageTypes.EMPTY,
    @DrawableRes val messageImage: Int,
    val messageTitle: String,
    val messageText: String
) : Parcelable