package com.gianchiesamaghriza.nekosekai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import java.io.Serializable

class DetailActivity : AppCompatActivity() {
    private lateinit var breeds: TextView
    private lateinit var pic: ImageView
    private lateinit var rate: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        dataDetail()

//        dataImage()
//        println("kampret")
    }

    private fun dataDetail(){
        val test: String = intent.getSerializableExtra("objecturl") as String
        Picasso.get().load(test).into(pic)
        val rate: String = intent.getSerializableExtra("objectintel") as String
        val rateln = rate.length
        if (rateln == 0)
            ratingBar2.numStars = 2
        else ratingBar2.rating = rate.toFloat()



        println("kental")
        println(rate)
    }
    private fun initView() {
        breeds = findViewById(R.id.breeds) as TextView
        pic = findViewById(R.id.imgtest) as ImageView
        rate = findViewById(R.id.ratingBar2) as RatingBar

    }

}