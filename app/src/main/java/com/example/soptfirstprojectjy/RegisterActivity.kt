package com.example.soptfirstprojectjy

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val idEditText = findViewById<EditText>(R.id.register_email)
        val pwEditText = findViewById<EditText>(R.id.register_pw)
        val registerBtn= findViewById<Button>(R.id.register_finish_btn)

        registerBtn.setOnClickListener {
            intent.putExtra("email", idEditText.editableText.toString())
            intent.putExtra("password", pwEditText.editableText.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
