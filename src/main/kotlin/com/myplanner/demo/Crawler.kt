package com.myplanner.demo

import org.jsoup.Jsoup
import org.jsoup.select.Elements

class Crawler {
    val everytime = "https://everytime.kr/timetable/2021/1"

    fun main(){
        val doc = Jsoup.connect("https://everytime.kr/timetable/2021/1").get()
        System.out.println(doc)
    }

}