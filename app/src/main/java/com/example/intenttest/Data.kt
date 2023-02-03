package com.example.intenttest

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(val name:String,val amount:Int ,val price:Int,val storage: String,val warranty:String) :Parcelable{
}