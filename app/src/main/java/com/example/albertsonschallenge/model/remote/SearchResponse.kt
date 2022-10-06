package com.example.albertsonschallenge.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

typealias SearchResponse = List<AcronymItem>

data class AcronymItem(
    val lfs: List<Lf>,
    val sf: String
)

data class Lf(
    val freq: Int,
    val lf: String,
    val since: Int,
    val vars: List<Vars>
)

data class Vars(
    val freq: Int,
    val lf: String,
    val since: Int
)