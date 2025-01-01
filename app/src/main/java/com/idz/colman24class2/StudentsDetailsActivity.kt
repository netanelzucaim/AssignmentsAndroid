package com.idz.colman24class2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idz.colman24class2.model.Student

class StudentsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

val student = Student(
    name = "1",
    id = "1",
    avatarUrl = "1",
    phone = "1",
    address = "1",
    isChecked = false
)
        findViewById<TextView>(R.id.students_details_activity_address_text_view).text = student.address
        findViewById<TextView>(R.id.students_details_activity_name_text_view).text = student.name
        findViewById<TextView>(R.id.students_details_activity_id_text_view).text = student.id
        findViewById<TextView>(R.id.students_details_activity_phone_text_view).text = student.phone
        findViewById<CheckBox>(R.id.students_details_activity_enabled_check_box).isChecked = student.isChecked

//        findViewById<TextView>(R.id.students_details_activity_id_text_view).text = student.id
//        findViewById<TextView>(R.id.students_details_activity_phone_text_view).text = student.phone
//        findViewById<TextView>(R.id.students_details_activity_address_text_view).text = student.address
////        findViewById(R.id.students_details_activity_enabled_check_box).text = student.name
////

//        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
//        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)
//
//
//        cancelButton.setOnClickListener {
//            finish()
//        }
//
//        saveButton.setOnClickListener {
//        }
    }
}