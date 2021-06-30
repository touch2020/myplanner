package com.myplanner.demo.repository

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
class Todo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,


    @Column(nullable = false)
    @ColumnDefault(value = "false")
    var completed: Boolean = false,

    @Column(nullable = false)
    var todoName: String

)