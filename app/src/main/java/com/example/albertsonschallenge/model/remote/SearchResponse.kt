package com.example.albertsonschallenge.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Acronyms(
    val sf: String,
    val lfs: List<AcronymLongforms>
) : Parcelable
@Parcelize
data class AcronymLongforms(
    val lf: String,
    val freq: String,
    val since: String,
    val vars: List<Variation>
) : Parcelable
@Parcelize
data class Variation(
    val lf: String,
    val freq: String,
    val since: String
) : Parcelable