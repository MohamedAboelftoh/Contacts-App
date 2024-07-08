package com.contacts_application_task.presentation.ui.contact_details

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityContactDetailsBinding
    lateinit var contact : Contact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        contact = ((intent.getSerializableExtra("contact")as? Contact)!!)
        viewBinding.name.text = contact.name
        viewBinding.description.text = contact.description
        viewBinding.phone.text = contact.number
        viewBinding.back.setOnClickListener {
            finish()
        }
        viewBinding.phone.setOnClickListener {
        val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${contact.number}")
            startActivity(intent)
        }
    }
}