package com.example.finalproject

class NewsItem {

    private var title: String = ""
    private var author: String = ""
    private var description: String = ""
    private var publishedAt: String = ""

    private var imageUrl: String=""
    private var contents: String=""
    private var url: String=""

    constructor(title:String, author:String, description:String, publishedAt:String, imageUrl:String, contents:String, url:String){
        this.title = title
        this.author = author
        this.description = description
        this.publishedAt = publishedAt

        this.imageUrl = imageUrl
        this.contents = contents
        this.url = url

    }

    fun getTitle(): String{return title}
    fun getAuthor(): String{return author}
    fun getDesc(): String{return description}
    fun getDate(): String{return publishedAt}

    fun getImg(): String{return imageUrl}
    fun getContents(): String{return contents}
    fun getUrl(): String{return url}


}