package com.amanaryan.corona.newsbox

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class News( val profileImageUrl: String,val link:String): Parcelable {
    constructor():this("","")
}