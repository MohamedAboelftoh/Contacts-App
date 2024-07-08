package com.contacts_application_task.presentation.ui.add_contact

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.contacts_application_task.data.local.ContactDataBase
import com.contacts_application_task.R
import com.contacts_application_task.databinding.FragmentAddContactBinding
import com.contacts_application_task.domain.models.Contact
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactFragment : BottomSheetDialogFragment() {
private lateinit var viewBinding : FragmentAddContactBinding
 private val viewModel: AddContactViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAddContactBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
        viewBinding.buttonAdd.setOnClickListener {
            viewModel.addContact()
            if(!viewModel.added)return@setOnClickListener
            onContactAddedListener?.onContactAdded()
            dismiss()
        }
    }

    var onContactAddedListener : OnContactAddedListener?= null

    interface OnContactAddedListener{
        fun onContactAdded()
    }
}