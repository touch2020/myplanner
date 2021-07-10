package com.myplanner.demo.repository

import javax.persistence.*

@Entity
class Subject (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var start: Long,

    @Column(nullable = false)
    var end : Long,

    @Column(nullable = false)
    var day : String,

    @Column(nullable = false)
    var place : String,

        @Column(nullable = false)
        var professor : String
)