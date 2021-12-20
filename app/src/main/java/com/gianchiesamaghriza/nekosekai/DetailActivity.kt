package com.gianchiesamaghriza.nekosekai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isGone
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import java.io.Serializable

class DetailActivity : AppCompatActivity() {
    private lateinit var breeds: TextView
    private lateinit var pic: ImageView
    private lateinit var intelRate: RatingBar
    private lateinit var affectRate: RatingBar
    private lateinit var energyRate: RatingBar
    private lateinit var healthRate: RatingBar
    private lateinit var rareRate: RatingBar
    private lateinit var adaptRate: RatingBar
    private lateinit var childRate: RatingBar
    private lateinit var catRate: RatingBar
    private lateinit var dogRate: RatingBar
    private lateinit var strangerRate: RatingBar
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
        val intelRate: String = intent.getSerializableExtra("objectintel") as String
        val affectRate: String = intent.getSerializableExtra("objectaffect") as String
        val energyRate: String = intent.getSerializableExtra("objectenergy") as String
        val healthRate: String = intent.getSerializableExtra("objecthealth") as String
        val rareRate: String = intent.getSerializableExtra("objectrare") as String
        val adaptRate: String = intent.getSerializableExtra("objectadapt") as String
        val dogRate: String = intent.getSerializableExtra("objectdogf") as String
        val catRate: String = intent.getSerializableExtra("objectcatf") as String
        val childRate: String = intent.getSerializableExtra("objectchildf") as String
        val strangerRate: String = intent.getSerializableExtra("objectstrangerf") as String
        val rateln = intelRate.length
        if (rateln == 0) {
            val linearLayout = findViewById(R.id.ratingAll) as LinearLayout
            linearLayout.visibility = View.GONE
            val org = findViewById(R.id.origin) as TextView
            org.visibility = View.GONE
        } else {
            val btn = findViewById(R.id.searchBtn) as Button
            btn.visibility = View.GONE
            ratingIntel.rating = intelRate.toFloat()
            ratingAdapt.rating = adaptRate.toFloat()
            ratingAffect.rating = affectRate.toFloat()
            ratingEnergy.rating = energyRate.toFloat()
            ratingHealth.rating = healthRate.toFloat()
            ratingRare.rating = rareRate.toFloat()
            ratingCat.rating = catRate.toFloat()
            ratingDog.rating = dogRate.toFloat()
            ratingStranger.rating = strangerRate.toFloat()
            ratingChild.rating = childRate.toFloat()
        }
        breeds.text = name
        desc.text = descText
        Picasso.get().load(url).into(pic)
        temp.text = tempText
        origin.text = originText


        println("kental")
        println(intelRate)
    }
    private fun initView() {
        breeds = findViewById(R.id.breeds) as TextView
        pic = findViewById(R.id.imgtest) as ImageView
        intelRate = findViewById(R.id.ratingIntel) as RatingBar
        affectRate = findViewById(R.id.ratingAffect) as RatingBar
        energyRate = findViewById(R.id.ratingEnergy) as RatingBar
        healthRate = findViewById(R.id.ratingHealth) as RatingBar
        rareRate = findViewById(R.id.ratingRare) as RatingBar
        adaptRate = findViewById(R.id.ratingAdapt) as RatingBar
        catRate = findViewById(R.id.ratingCat) as RatingBar
        childRate = findViewById(R.id.ratingChild) as RatingBar
        dogRate = findViewById(R.id.ratingDog) as RatingBar
        strangerRate = findViewById(R.id.ratingStranger) as RatingBar
        desc = findViewById(R.id.descDetail) as TextView
        temp = findViewById(R.id.temp) as TextView
        origin = findViewById(R.id.origin) as TextView
    }

}