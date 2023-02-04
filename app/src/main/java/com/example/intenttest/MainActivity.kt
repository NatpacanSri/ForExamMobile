package com.example.intenttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.example.intenttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var itemPhone:String = ""
    var price:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDropdown()


    }

    private fun showDropdown(){
        binding.AutoCompleteTextView.setText("somethinglikethat")
        val sub = resources.getStringArray(R.array.model)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,sub)
        binding.AutoCompleteTextView.setAdapter(arrayAdapter)
        binding.AutoCompleteTextView.setOnItemClickListener{ parent,_,position,_ ->
            itemPhone = parent.getItemAtPosition(position) as String
        }
    }

    fun reset(v: View){
        showDropdown()
        binding.AutoCompleteTextView.clearFocus()
        binding.number.text?.clear()
        binding.radio.clearCheck()
        binding.monitor.setChecked(false)
        binding.battery.setChecked(false)
    }


    fun submit(v: View){
        var storagePrice:Int = 0
        var storage:String = ""
        var amount:Int = binding.number.text.toString().toInt()
        var warranty:String = ""
        var warrantyPrice:Int = 0

        var radioButtonChecked: RadioButton = findViewById(binding.radio.checkedRadioButtonId)
        storage = radioButtonChecked.text as String

        when(storage){
            "128GB" -> {
                storagePrice = 0
            }
            "256GB" -> {
                storagePrice = 1200
            }
            "512GB" -> {
                storagePrice = 2400
            }
            "1TB" -> {
                storagePrice = 5600
            }
        }

        if(binding.monitor.isChecked){
            warranty += " " + binding.monitor.text
            warrantyPrice += 2500
        }
        if(binding.battery.isChecked){
            warranty += " " + binding.battery.text
            warrantyPrice += 1500
        }


        when (itemPhone) {
            "Iphone14" -> {
                price = (12000+warrantyPrice+storagePrice)*amount
            }
            "Iphone14pro" -> {
                price = (15000+warrantyPrice+storagePrice)*amount
            }
            "Iphone14proMax" -> {
                price = (20000+warrantyPrice+storagePrice)*amount
            }
        }
        startActivity(Intent(this,SecondActivity::class.java).putExtra("sendData",Data(itemPhone,amount,price,storage,warranty)))
    }






}