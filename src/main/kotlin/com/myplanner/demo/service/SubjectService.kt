package com.myplanner.demo.service

import com.myplanner.demo.repository.Subject
import com.myplanner.demo.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService (
        private val subjectRepository: SubjectRepository
        ){
    fun getSubjects() = subjectRepository.findAll()

    fun insertSubject(name : String, start : Long, end : Long, day : String, place : String , professor : String){
        subjectRepository.save(Subject(name = name, start = start, end = end, day = day, place = place, professor = professor))

    }

    fun deleteSubject() = subjectRepository.deleteAll()
}