package com.contacts_application_task.presentation.ui.home

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.contacts_application_task.presentation.ui.contact_details.ContactDetailsActivity
import com.contacts_application_task.data.local.ContactDataBase
import com.contacts_application_task.databinding.ActivityMaincontactBinding
import com.contacts_application_task.domain.models.Contact
import com.contacts_application_task.presentation.ui.add_contact.AddContactFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeContactActivity : AppCompatActivity(){
    private lateinit var viewBinding : ActivityMaincontactBinding
    private var contactsAdapter = ContactsAdapter()
      val viewModel : HomeViewModel by viewModels()
    private val addContactFragment = AddContactFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMaincontactBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }
    private fun initViews(){
        val contacts = viewModel.getAllContacts()
        contactsAdapter = ContactsAdapter(contacts)
        viewBinding.RVContacts.adapter = contactsAdapter
        viewBinding.fab.setOnClickListener {
            addContactFragment.show(supportFragmentManager,"")
        }
        addContactFragment.onContactAddedListener = object : AddContactFragment.OnContactAddedListener{
            override fun onContactAdded() {
                val newContacts = viewModel.getAllContacts()
                contactsAdapter.updateData(newContacts)
            }
        }
        contactsAdapter.onAllItemClickListener =  object : ContactsAdapter.OnItemClickListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemClick(position: Int, contact: Contact) {
                val intent = Intent(this@HomeContactActivity, ContactDetailsActivity::class.java)
                intent.putExtra("contact",contact)
                startActivity(intent)
            }

        }
        contactsAdapter.onItemClickListener = object : ContactsAdapter.OnItemClickListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onItemClick(position: Int, contact: Contact) {
                val dialog = AlertDialog.Builder(this@HomeContactActivity)
                dialog.setMessage("Do you want to delete This Contact ?")
                    .setPositiveButton("Delete"
                    ) { p0, p1 ->
                        viewModel.deleteContact(contact)
                        contactsAdapter.clearContactDeleted(contact)
                    }
                    .setNegativeButton("Cancel"
                    ) { p0, p1 ->
                        p0.dismiss()
                    }
                    .show()
            }
        }
    }
}