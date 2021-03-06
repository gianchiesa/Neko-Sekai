package com.gianchiesamaghriza.nekosekai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    private val searchView: View by lazy {
        LayoutInflater.from(this).inflate(R.layout.search_layout, null)
    }
    private val searchDialog: AlertDialog by lazy {
        AlertDialog.Builder(this).setView(searchView).create()
    }
    private val adapter: CatImageAdapter = CatImageAdapter()
    val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initViewModel()
    }

    private fun initUI() {
        val layoutManager: GridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        searchView.findViewById<Button>(R.id.searchButton)
            .setOnClickListener { view: View? ->
                val checkedCategories: List<CatCategory> =
                    getCheckedCategories(searchView.findViewById(R.id.categoryChipGroup))
                val checkedBreed: List<CatBreed> =
                    getCheckedBreeds(searchView.findViewById(R.id.breedChipGroup))
                viewModel.getImagesFromSearchFilter(checkedBreed, checkedCategories)
                //progressBar.setVisibility(View.VISIBLE)
                searchDialog.dismiss()
            }
        fab.setOnClickListener {
            searchDialog.show()
        }
    }

    private fun initViewModel() {
        viewModel.let {
            viewModel.getRandomCatImages().observe(this,
                Observer<List<CatImage>> { adapter.setImageData(it) })
            viewModel.fetchBreeds().observe(this, Observer {
                for (breed in it) {
                    val chip = Chip(this)
                    chip.setText(breed.name)
                    chip.tag = breed
                    chip.isCheckable = true
                    (searchView.findViewById(R.id.breedChipGroup) as ChipGroup).addView(chip)
                }
            })

//            viewModel.fetchCategories().observe(this, Observer {
//                for (category in it) {
//                    val chip = Chip(this)
//                    chip.setText(category.name)
//                    chip.tag = category
//                    chip.isCheckable = true
//                    (searchView.findViewById(R.id.categoryChipGroup) as ChipGroup).addView(chip)
//                    Log.i("chip", chip.toString())
//                }
//            })
        }
    }

    private fun getCheckedBreeds(cg: ChipGroup): List<CatBreed> {
        val breeds: MutableList<CatBreed> = ArrayList()
        for (i in 0 until cg.childCount) {
            val v = cg.getChildAt(i)
            if (v is Chip) {
                val chip = v
                if (chip.isChecked) {
                    breeds.add(chip.tag as CatBreed)
                }
            }
        }
        return breeds
    }

    private fun getCheckedCategories(cg: ChipGroup): List<CatCategory> {
        val categories: MutableList<CatCategory> = ArrayList()
        for (i in 0 until cg.childCount) {
            val v = cg.getChildAt(i)
            if (v is Chip) {
                val chip = v
                if (chip.isChecked) {
                    categories.add(chip.tag as CatCategory)
                }
            }
        }
        return categories
    }


    fun launchdetailtActivity(view: android.view.View){
        val detailActivity = Intent(this,DetailActivity::class.java)
        startActivity(detailActivity)
    }
}