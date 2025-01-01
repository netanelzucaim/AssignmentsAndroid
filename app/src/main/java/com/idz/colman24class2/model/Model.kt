package com.idz.colman24class2.model

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Name $i",
                id = "Student ID: $i",
                phone = "Phone: $i",
                address = "Address: $i",
                isChecked = false
            )
            students.add(student)
        }
    }
}