/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Week 8 Intents
*/

package edu.rockvalleycollege.week8intents

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtSend = findViewById<EditText>(R.id.txtSend)
        var btnPage2 = findViewById<Button>(R.id.btnPage2)

        btnPage2.setOnClickListener {

            if(txtSend.text.isEmpty()){
                hideKeyboard()
                txtSend.requestFocus()
                Toast.makeText(this,"The input string is empty",Toast.LENGTH_LONG).show()
                    }else {
                //Intent is used to send data between activities
                val intent = Intent(this, MainActivity2::class.java)
                //putExtra sets value to name SendStuff (Could be called whatever you want
                intent.putExtra("SendStuff", txtSend.text.toString())

                //Go to second activity
                startActivity(intent)
                hideKeyboard()
                txtSend.requestFocus()
            }
        }// End of Onclick Listener

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hide keyboard

    }// End of OnCreate

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }

}// End of Main Activity