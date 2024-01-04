package com.example.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summery_screen.text_view_user_email
import kotlinx.android.synthetic.main.activity_summery_screen.text_view_user_full_name
import kotlinx.android.synthetic.main.activity_summery_screen.text_view_user_phone

@Suppress("DEPRECATION")
class SummeryScreen : AppCompatActivity() {
    private lateinit var user:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summery_screen)
        retrieveUser()
        displayUser()
        setClickListeners()
    }

    private fun retrieveUser() {
       user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
      text_view_user_full_name.text = user.getFullName()
        text_view_user_email.text = user.email
        text_view_user_phone.text = user.phone
    }

    private fun setClickListeners() {
       text_view_user_email.setOnClickListener {
           val intent = Intent(Intent.ACTION_SENDTO)
           intent.data= Uri.parse("mailto:${user.email}")
           startActivity(intent)
       }
        text_view_user_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }
}