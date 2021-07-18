package com.myplanner.demo.controller.crawler

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class TimeTable {
    fun getTimetable(): Document{
        val id = "123"
        val pw = "123"
        val userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Mobile Safari/537.36"

        val response : Connection.Response = Jsoup.connect("https://everytime.kr/user/login")
                .timeout(3000)
                .userAgent(userAgent)
                .header("Origin", "https://everytime.kr")
                .header("Referer", "https://everytime.kr/")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .data("userid", id,
                        "password", pw,
                        "redirect", "/"
                )
                .method(Connection.Method.POST)
                .execute()


        val  loginCookie : Map<String, String> = response.cookies()


        var testdoc : Document = Jsoup.connect("https://api.everytime.kr/find/timetable/table/list/semester")
                .timeout(3000)
                .userAgent(userAgent)
                .cookies(loginCookie)
                .method(Connection.Method.POST)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Connection", "keep-alive")
                .header("Content-Length", "20")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Host", "api.everytime.kr")
                .header("Origin", "https://everytime.kr")
                .header("Referer", "https://everytime.kr/")
                .header("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-site")
                .data("year", "2020",
                        "semester", "2")
                .get()


        val id1  = testdoc.getElementsByAttribute("id").attr("id")


        var tabledoc : Document = Jsoup.connect("https://api.everytime.kr/find/timetable/table")
                .timeout(3000)
                .userAgent(userAgent)
                .cookies(loginCookie)
                .method(Connection.Method.POST)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Connection", "keep-alive")
                .header("Content-Length", "11")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Host", "api.everytime.kr")
                .header("Origin", "https://everytime.kr")
                .header("Referer", "https://everytime.kr/")
                .header("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-site")
                .data("id", id1)
                .get()


        return tabledoc
    }



}
