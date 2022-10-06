package com.example.albertsonschallenge.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

typealias SearchResponse = List<AcronymItem>

@Parcelize
data class AcronymItem(
    val lfs: List<Lf>,
    val sf: String
): Parcelable

@Parcelize
data class Lf(
    val freq: Int,
    val lf: String,
    val since: Int,
    val vars: List<Vars>
): Parcelable

@Parcelize
data class Vars(
    val freq: Int,
    val lf: String,
    val since: Int
): Parcelable