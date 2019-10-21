package com.dwisatria.tugashal56

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityKedua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kedua)

        val title = intent.getStringExtra("title")
        val directed = intent.getStringExtra("directed")
        val production = intent.getStringExtra("production")
        val checkBoxs1 = intent.getStringExtra("checkBox1")
        val checkBoxs2 = intent.getStringExtra("checkBox2")
        val checkBoxs3 = intent.getStringExtra("checkBox3")
        val checkBoxs4 = intent.getStringExtra("checkBox4")
        val checkBoxs5 = intent.getStringExtra("checkBox5")
        val checkBoxs6 = intent.getStringExtra("checkBox6")
        val ageRes = intent.getStringExtra("ageRes")
        val country = intent.getStringExtra("country")
        val dateRelease = intent.getStringExtra("dateRelease")
        //textview
        val result = findViewById<TextView>(R.id.result)
        //setText
        result.text =
            "\nTitle: " + title + "\nDirected: " + directed + "\nProduction: " + production + "\nGenre: " + checkBoxs1 + checkBoxs2 + checkBoxs3 + checkBoxs4 + checkBoxs5 + checkBoxs6 + "\nAge Restriction: " + ageRes + "\nCountry: " + country + "\nDate Release: " + dateRelease
    }
}