package com.idz.colman24class2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idz.colman24class2.model.Model
import com.idz.colman24class2.model.Student

class EditStudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_students)
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

        val saveButton: Button = findViewById(R.id.edit_students_activity_save_button)
        val cancelButton: Button = findViewById(R.id.edit_students_activity_cancel_button)
        val deleteButton: Button = findViewById(R.id.edit_students_activity_delete_button)
        findViewById<TextView>(R.id.edit_students_activity_address_text_view).text = student.address
        findViewById<TextView>(R.id.edit_students_activity_name_text_view).text = student.name
        findViewById<TextView>(R.id.edit_students_activity_id_text_view).text = student.id
        findViewById<TextView>(R.id.edit_students_activity_phone_text_view).text = student.phone
        findViewById<CheckBox>(R.id.edit_students_activity_enabled_check_box).isChecked = student.isChecked


        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
            finish()
        }

        saveButton.setOnClickListener {
            var updatedStudent = Model.shared.students.find { it.id == student.id }
            updatedStudent?.let {
                it.id = findViewById<TextView>(R.id.edit_students_activity_id_text_view).text.toString()
                it.name = findViewById<TextView>(R.id.edit_students_activity_name_text_view).text.toString()
                it.address = findViewById<TextView>(R.id.edit_students_activity_address_text_view).text.toString()
                it.phone = findViewById<TextView>(R.id.edit_students_activity_phone_text_view).text.toString()
                it.isChecked = findViewById<CheckBox>(R.id.edit_students_activity_enabled_check_box).isChecked
            }
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
            finish()

        }

        deleteButton.setOnClickListener {
            Model.shared.students.remove(student)
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}