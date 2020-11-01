package com.abdullahalamodi.roomtest

import StudentViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var numberView: EditText;
    private lateinit var nameView: EditText;
    private lateinit var passBtn: CheckBox;
    private lateinit var addBtn: Button;
    private lateinit var contentView: TextView;

    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberView = findViewById(R.id.number);
        nameView = findViewById(R.id.name);
        passBtn = findViewById(R.id.pass);
        passBtn = findViewById(R.id.pass);
        contentView = findViewById(R.id.content_view);

//        studentViewModel.studentsLiveData.observe(
//            this,
//            { students ->
//                students?.let {
//                    updateUI(students);
//                }
//            }
//        )

        addBtn.setOnClickListener {
            val student = fillStudent();
            studentViewModel.addStudent(student);
            contentView.append(student.toString());
        }
    }


    private fun fillStudent(): Student {
        return Student(
            name = numberView.text.toString(),
            number = nameView.text.toString().toInt(),
            passed = passBtn.isChecked,
        )
    }

    private fun updateUI(students :List<Student>) {
        for(student in students){
            contentView.append(student.toString())
        }
    }
}