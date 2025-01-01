package com.idz.colman24class2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
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
        val intent = intent
        val id = intent.getStringExtra("student_id")
        val name = intent.getStringExtra("student_name")
        val address = intent.getStringExtra("student_address")
        val phone = intent.getStringExtra("student_phone")
        val enabled = intent.getBooleanExtra("student_enabled",false)
        val student = Student(
            name = name!!,
            id = id!!,
            phone = phone!!,
            address = address!!,
            isChecked = enabled
        )
        findViewById<TextView>(R.id.students_details_activity_address_text_view).text = student.address
        findViewById<TextView>(R.id.students_details_activity_name_text_view).text = student.name
        findViewById<TextView>(R.id.students_details_activity_id_text_view).text = student.id
        findViewById<TextView>(R.id.students_details_activity_phone_text_view).text = student.phone
        findViewById<CheckBox>(R.id.students_details_activity_enabled_check_box).isChecked = student.isChecked


        val editButton: Button = findViewById(R.id.students_details_activity_edit_button)
        editButton.setOnClickListener {
            val intent = Intent(this@StudentsDetailsActivity, EditStudentsActivity::class.java)
            intent.putExtra("student_id", student?.id)
            intent.putExtra("student_name", student?.name)
            intent.putExtra("student_address", student?.address)
            intent.putExtra("student_phone", student?.phone)
            intent.putExtra("student_enabled", student?.isChecked)
            startActivity(intent)
            Log.d("TAG", "On student clicked name: ${student?.name} open edit activity")
        }
    }
}