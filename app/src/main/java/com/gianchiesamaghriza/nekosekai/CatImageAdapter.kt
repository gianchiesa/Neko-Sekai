package com.gianchiesamaghriza.nekosekai


import android.accounts.AccountManager.get
import android.content.Intent
import android.nfc.tech.IsoDep.get
import android.text.AutoText.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewTreeLifecycleOwner.get
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.gianchiesamaghriza.nekosekai.CatImageAdapter.ItemCard
import java.lang.reflect.Array.get

class CatImageAdapter : RecyclerView.Adapter<ItemCard>() {

    class ItemCard(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView
        val tv: TextView
        val tvdesc: TextView
        val btn: TextView

        init {
            iv = itemView.findViewById(R.id.catImageView)
            tv = itemView.findViewById(R.id.catTextView)
            tvdesc = itemView.findViewById(R.id.catDescTextView)
            btn = itemView.findViewById(R.id.detailBtn)
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
//        holder.tv.text = item.toString()
        var x = item.breeds
        if (x != null) {
            if (x.size != 0) {
                for (i in 0 until x.size) {
                    var list = item.breeds
                    var j = list
                    holder.tv.text = j!![0].name
                    holder.tvdesc.text = j[0].description
                    println(j)
                    println("kontol")
                }
//                val j = item.breeds!![position].name
//                holder.tv.text = j
//                holder.tvdesc.text = "stttt"
////                holder.tv.text =
//                println(j)
//                println("kuntul")
            } else {
                holder.tv.text = "Cat Pict From Neko Sekai"
                holder.tvdesc.text = "Let's Get Another Cat Pic and Detail By Filter"
            }
        }

        Picasso.get().load(item.url).into(holder.iv)
        holder.btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("tests", item.toString())
            holder.itemView.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }
}