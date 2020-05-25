package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class NewDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_detail)

        val title = findViewById<TextView>(R.id.titleTV)
        val author = findViewById<TextView>(R.id.authorTV)
        val date = findViewById<TextView>(R.id.dateTV)
        val desc = findViewById<TextView>(R.id.descTV)

        val image = findViewById<ImageView>(R.id.imgView)
        val content = findViewById<TextView>(R.id.contentTV)
        val url = findViewById<TextView>(R.id.urlTV)


        var bundle :Bundle ?=intent.extras

        var titleData: String = intent.getStringExtra("TITLE")
        var authorData: String = "Author: " + intent.getStringExtra("AUTHOR")
        var dateData: String = "Date: " +intent.getStringExtra("DATE")
        var descData: String = intent.getStringExtra("DESC")

        var imageData: String = intent.getStringExtra("IMAGE")
        var contentData: String = intent.getStringExtra("CONTENT")
        var urlData: String = intent.getStringExtra("URL")

        title.text = titleData
        author.text = authorData
        date.text = dateData
        desc.text = descData

        Picasso.get().load(imageData).into(image);
        content.text = contentData
        url.text = urlData

    }
}
