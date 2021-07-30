package com.myplanner.demo.controller

import com.myplanner.demo.controller.crawler.TimeTable
import com.myplanner.demo.service.SubjectService
import org.jsoup.select.Elements
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subject")
class SubjectController (
        private val subjectService: SubjectService
        ){

        @PostMapping("/insert")
        fun getTimeTable(@RequestBody loginRequest: LoginRequest) : String{
                subjectService.deleteSubject()
                val table = TimeTable().getTimetable(loginRequest.userId, loginRequest.userPw)
                val subject : Elements = table.select("subject")

                for(element in subject) {
                        val day = element.select("data")
                        for(element1 in day) {


                                subjectService.insertSubject(
                                        element.select("name").attr("value"),
                                        element1.select("data").attr("starttime").toLong(),
                                        element1.select("data").attr("endtime").toLong(),
                                        element1.select("data").attr("day"),
                                        element1.select("data").attr("place"),
                                        element.select("professor").attr("value")
                                )
                        }
                }

                return "/todo"
        }

        @GetMapping("/get")
        fun getSubjects() = subjectService.getSubjects()


}