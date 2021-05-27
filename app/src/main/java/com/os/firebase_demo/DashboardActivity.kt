package com.os.firebase_demo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        findViewById<TextView>(R.id.id_value).text = currentUser?.uid
        findViewById<TextView>(R.id.name_value).text = currentUser?.displayName
        findViewById<TextView>(R.id.email_value).text = currentUser?.email

        val image = findViewById<ImageView>(R.id.user_image)

        Glide.with(this).load(currentUser?.photoUrl).into(image)
    }
}