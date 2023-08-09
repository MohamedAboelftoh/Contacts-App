package com.contacts_application_task

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.util.jar.Attributes.Name

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var Name : TextView
    lateinit var Phone : TextView
    lateinit var Discription : TextView
    lateinit var img : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        img = findViewById(R.id.back)
        Name = findViewById(R.id.name)
        Phone = findViewById(R.id.phone)
        Discription = findViewById(R.id.discription)
        Name.setText(intent.getStringExtra("name").toString())
        Phone.setText(intent.getStringExtra("phone").toString())
        Discription.setText(intent.getStringExtra("dis").toString())
        img.setOnClickListener {
            finish()
        }
    }
}