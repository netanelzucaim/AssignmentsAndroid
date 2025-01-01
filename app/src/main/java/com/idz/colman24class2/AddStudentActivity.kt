package com.idz.colman24class2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idz.colman24class2.model.Model
import com.idz.colman24class2.model.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.students_details_activity_edit_button)

        val nameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val idEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val phoneEditText: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val addressEditText: EditText = findViewById(R.id.add_student_activity_address_edit_text)
        val enabledCheckBox: CheckBox = findViewById(R.id.add_student_activity_enabled_check_box)

        val savedMessageTextView: TextView = findViewById(R.id.add_student_activity_save_message_text_view)

        cancelButton.setOnClickListener {
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
            finish()
        }

        saveButton.setOnClickListener {
            val student = Student(nameEditText.text.toString(), idEditText.text.toString(),phoneEditText.text.toString(),addressEditText.text.toString(),enabledCheckBox.isChecked )
            Model.shared.students.add(student)
            savedMessageTextView.text = "Name: ${nameEditText.text} ID: ${idEditText.text} is saved!!!..."

        }
    }
}