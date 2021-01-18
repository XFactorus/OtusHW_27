package com.vladp.otusmultiapp.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.moko.network.generated.models.Recipe

class RecipeViewHolder (inflater: LayoutInflater, container: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recipes,container,false)) {

    private  var image: ImageView? = null
    private var titleText: TextView? = null
    private  var overviewText: TextView? = null

    init {
        image = itemView.findViewById<ImageView>(R.id.image)
        titleText = itemView.findViewById<TextView>(R.id.title_text)
        overviewText = itemView.findViewById<TextView>(R.id.overview_text)
    }

    fun bindItem(item: Recipe) {
        titleText?.text = item.title
        overviewText?.text = item.ingredients
    }
}