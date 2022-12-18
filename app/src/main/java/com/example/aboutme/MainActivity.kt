package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton = findViewById<Button>(R.id.done_button)
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)
        nicknameText.setOnClickListener {
            editText.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            it.visibility = View.GONE
            editText.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, 0)
        }
        doneButton.setOnClickListener {
            nicknameText.text = editText.text
            nicknameText.visibility = View.VISIBLE
            editText.visibility = View.GONE
            it.visibility = View.GONE
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}