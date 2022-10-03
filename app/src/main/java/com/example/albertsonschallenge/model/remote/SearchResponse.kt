package com.example.albertsonschallenge.model.remote

import android.os.Parcelable
import com.example.albertsonschallenge.model.AcronymItem
import kotlinx.parcelize.Parcelize

data class SearchResponse(
    val acronyms: List<AcronymItem>
)

//@Parcelize
//data class Acronyms(
//    val sf: String,
//    val lfs: List<AcronymLongforms>
//) : Parcelable
//@Parcelize
//data class AcronymLongforms(
//    val lf: String,
//    val freq: String,
//    val since: String,
//    val vars: List<Variation>
//) : Parcelable
//@Parcelize
//data class Variation(
//    val lf: String,
//    val freq: String,
//    val since: String
//) : Parcelable