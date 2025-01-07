package com.idz.colman24class2.model
import kotlin.random.Random

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        val names = arrayOf("Alice", "Bob", "Nati", "Charlie", "David", "Eva", "Noam")

        for (i in 0..20) {
            val randomName = names[Random.nextInt(names.size)]
            val student = Student(
                name = randomName,
                id = (Random.nextInt(1, 101)).toString(),
                phone = "$i",
                address = "$i",
                isChecked = false
            )
            students.add(student)
        }
    }
}