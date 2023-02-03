package com.example.intenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.intenttest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var bidingSecond : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bidingSecond = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bidingSecond.root)

        var phoneData = intent.extras
        var newData:Data? = phoneData?.getParcelable("sendData")

        bidingSecond.phoneName.text = "phoneName: ${newData?.name}"
        bidingSecond.amount.text = "Amount: ${newData?.amount}"
        bidingSecond.price.text = "Price: ${newData?.price}"
        bidingSecond.storage.text = "Storage: ${newData?.storage}"
        bidingSecond.warranty.text = "Warranty: ${newData?.warranty}"

    }

    fun back(v: View){
        finish()
    }

}