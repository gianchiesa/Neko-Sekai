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
    private lateinit var desc: TextView
    private lateinit var temp: TextView
    private lateinit var origin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        dataDetail()

//        dataImage()
//        println("kampret")
    }

    private fun dataDetail(){
        val url: String = intent.getSerializableExtra("objecturl") as String
        val name: String = intent.getSerializableExtra("objecttv") as String
        val originText: String = intent.getSerializableExtra("objectorigin") as String
        val descText: String = intent.getSerializableExtra("objectdesc") as String
        val tempText: String = intent.getSerializableExtra("objecttemp") as String
        val rate: String = intent.getSerializableExtra("objectintel") as String
        val rateln = rate.length
        if (rateln == 0)
            ratingEnergy.numStars = 2
        else ratingEnergy.rating = rate.toFloat()
        breeds.text = name
        desc.text = descText
        Picasso.get().load(url).into(pic)
        temp.text = tempText
        origin.text = originText


        println("kental")
        println(rate)
    }
    private fun initView() {
        breeds = findViewById(R.id.breeds) as TextView
        pic = findViewById(R.id.imgtest) as ImageView
        rate = findViewById(R.id.ratingEnergy) as RatingBar
        desc = findViewById(R.id.descDetail) as TextView
        temp = findViewById(R.id.temp) as TextView
        origin = findViewById(R.id.origin) as TextView
    }

}