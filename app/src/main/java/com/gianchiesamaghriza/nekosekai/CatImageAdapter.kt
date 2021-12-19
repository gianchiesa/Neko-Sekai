package com.gianchiesamaghriza.nekosekai


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.gianchiesamaghriza.nekosekai.CatImageAdapter.ItemCard

class CatImageAdapter : RecyclerView.Adapter<ItemCard>() {

    class ItemCard(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView
        val tv: TextView

        init {
            iv = itemView.findViewById(R.id.catImageView)
            tv = itemView.findViewById(R.id.catTextView)
        }
    }

//    private var data: MutableList<AllBreedsItem> = ArrayList()
    private var data: MutableList<CatImage> = ArrayList()
    fun setImageData(ic: List<CatImage>) {
        data.clear()
        data.addAll(ic)
    println("maslaju")
    println(ic)
    println("tai")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCard {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cat_card_view, parent, false)
        val vh = ItemCard(v)
        return vh
    }

    override fun onBindViewHolder(holder: ItemCard, position: Int) {
        val item: CatImage = data[position]
        if (item.breeds == null)
            holder.tv.text = item.toString()
         else
            holder.tv.text = "tsting"

        Picasso.get().load(item.url).into(holder.iv)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}