package com.example.finalproject

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CustomArrayAdapter(private val context: Activity, private val newsList: ArrayList<NewsItem> )
    : ArrayAdapter<NewsItem>(context, R.layout.custom_list, newsList) {

    //get view of one row of the list
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.titleTV) as TextView
        //val authorText = rowView.findViewById(R.id.authorTV) as TextView
        //val dateText = rowView.findViewById(R.id.dateTV) as TextView
        //val descText = rowView.findViewById(R.id.descTV) as TextView
        val image = rowView.findViewById<ImageView>(R.id.imgView)


        var imageData: String = newsList[position].getImg()


        titleText.text = newsList[position].getTitle()
        //authorText.text = "Author: ${newsList[position].getAuthor()}"
        //dateText.text = "Published at: ${newsList[position].getDate()}"
        //descText.text = newsList[position].getDesc()

        Picasso.get().load(imageData).into(image)
        return rowView
    }
}