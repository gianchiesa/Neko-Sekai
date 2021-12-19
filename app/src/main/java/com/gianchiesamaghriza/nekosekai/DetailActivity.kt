package com.gianchiesamaghriza.nekosekai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var url: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        dataImage()

//        dataImage()
//        println("kampret")
    }

    private fun dataImage(){
        val test: String = intent.getSerializableExtra("tests") as String

        url.text = test
        println("jancok")
        println(url)
    }
    private fun initView() {
        url = findViewById(R.id.testingcok) as TextView
    }

}