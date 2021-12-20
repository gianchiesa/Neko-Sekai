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
        val temperament: TextView
        val origin: TextView
        val adapt: TextView
        val rare: TextView
        val affect: TextView
        val child: TextView
        val dog: TextView
        val cat: TextView
        val stranger: TextView
        val energy: TextView
        val health: TextView
        val intel: TextView

        init {
            iv = itemView.findViewById(R.id.catImageView)
            tv = itemView.findViewById(R.id.catTextView)
            tvdesc = itemView.findViewById(R.id.catDescTextView)
            btn = itemView.findViewById(R.id.detailBtn)
            intel = itemView.findViewById(R.id.intel)
            temperament = itemView.findViewById(R.id.temperament)
            origin = itemView.findViewById(R.id.origin)
            adapt = itemView.findViewById(R.id.adapt)
            rare = itemView.findViewById(R.id.rare)
            affect = itemView.findViewById(R.id.affection)
            child = itemView.findViewById(R.id.childfriendly)
            dog = itemView.findViewById(R.id.dogfriendly)
            cat = itemView.findViewById(R.id.catfriendly)
            stranger = itemView.findViewById(R.id.stranger)
            energy = itemView.findViewById(R.id.energy)
            health = itemView.findViewById(R.id.health)
        }
    }

//    private var data: MutableList<AllBreedsItem> = ArrayList()
    private var data: MutableList<CatImage> = ArrayList()
    fun setImageData(ic: List<CatImage>) {
        data.clear()
        data.addAll(ic)
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
                    holder.intel.text = j[0].intelligence.toString()
                    holder.tvdesc.text = j[0].description
                    holder.health.text = j[0].health.toString()
                    holder.energy.text = j[0].energylevel.toString()
                    holder.stranger.text = j[0].stranger.toString()
                    holder.cat.text = j[0].catfriendly.toString()
                    holder.dog.text = j[0].dogfriendly.toString()
                    holder.child.text = j[0].childfriendly.toString()
                    holder.affect.text = j[0].affection.toString()
                    holder.adapt.text = j[0].adaptability.toString()
                    holder.rare.text = j[0].rare.toString()
                    holder.temperament.text = j[0].temperament
                    holder.origin.text = j[0].origin
                }
            } else {
                holder.tv.text = "Cat Pict From Neko Sekai"
                holder.tvdesc.text = "Let's Get Another Cat Pic and Detail By Filter"
                holder.intel.text = ""
                holder.health.text = ""
                holder.energy.text = ""
                holder.stranger.text = ""
                holder.cat.text = ""
                holder.dog.text = ""
                holder.child.text = ""
                holder.affect.text = ""
                holder.adapt.text = ""
                holder.rare.text = ""
                holder.temperament.text = ""
                holder.origin.text = ""
            }
        }

        Picasso.get().load(item.url).into(holder.iv)
        holder.btn.setOnClickListener(View.OnClickListener {

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            val tv = holder.tv.text
            val desc = holder.tvdesc.text
            val url = item.url
            val intel = holder.intel.text
            val temp = holder.temperament.text
            val health = holder.health.text
            val catF = holder.cat.text
            val dogF = holder.dog.text
            val childF = holder.child.text
            val energy = holder.energy.text
            val origin = holder.origin.text
            val rare = holder.rare.text
            val stranger = holder.stranger.text
            val affect = holder.affect.text
            val adapt = holder.adapt.text

            intent.putExtra("objecttv", tv)
            intent.putExtra("objectdesc", desc)
            intent.putExtra("objecturl", url)
            intent.putExtra("objectintel", intel)
            intent.putExtra("objecttemp", temp)
            intent.putExtra("objecthealth", health)
            intent.putExtra("objectcatf", catF)
            intent.putExtra("objectdogf", dogF)
            intent.putExtra("objectchildf", childF)
            intent.putExtra("objectenergy", energy)
            intent.putExtra("objectorigin", origin)
            intent.putExtra("objectrare", rare)
            intent.putExtra("objectstrangerf", stranger)
            intent.putExtra("objectadapt", adapt)
            intent.putExtra("objectaffect", affect)
            holder.itemView.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }
}