package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers()


    }
    fun getUsers() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://newsapi.org/v2/top-headlines?country=ca&category=business&apiKey=96b71303d883495f9d301f241035b1ce&pageSize=10"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                var strResp = response.toString()
                val jsonObj: JSONObject = JSONObject(strResp)
                val jsonArray: JSONArray = jsonObj.getJSONArray("articles")

                var newsList:ArrayList<NewsItem> = ArrayList<NewsItem>()

                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                    var news:NewsItem =
                            NewsItem(jsonInner.get("title").toString(), jsonInner.get("author").toString(), jsonInner.get("description").toString(),
                                jsonInner.get("publishedAt").toString(), jsonInner.get("urlToImage").toString(), jsonInner.get("content").toString(), jsonInner.get("url").toString())

                    newsList.add(news)
                }
                val myListAdapter = CustomArrayAdapter(this, newsList)
                var resultList =  findViewById<ListView>(R.id.newsListLV);
                resultList.adapter = myListAdapter;

                resultList.setOnItemClickListener { parent, view, position, id ->
                    val selectedNews = newsList[position] // The item that was clicked

                    println("something")


                    val intent = Intent(this@MainActivity, NewDetailActivity::class.java)
                    intent.putExtra("TITLE", selectedNews.getTitle())
                    intent.putExtra("AUTHOR", selectedNews.getAuthor())
                    intent.putExtra("DATE", selectedNews.getDate())
                    intent.putExtra("DESC", selectedNews.getDesc())
                    intent.putExtra("IMAGE", selectedNews.getImg())
                    intent.putExtra("CONTENT", selectedNews.getContents())
                    intent.putExtra("URL", selectedNews.getUrl())
                    startActivity(intent)
                }
            },
            Response.ErrorListener {})
        queue.add(stringReq)
    }
}


