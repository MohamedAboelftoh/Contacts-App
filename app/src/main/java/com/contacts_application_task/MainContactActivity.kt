package com.contacts_application_task

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainContactActivity : AppCompatActivity(){
     var ListDis = ArrayList<String>()
    lateinit var btn_add : Button
lateinit var textname : EditText
    lateinit var phone_number : EditText
    lateinit var discription : EditText
lateinit var recycler_view : RecyclerView
 var listOfItem = ArrayList<DataClass_RV>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maincontact)
        btn_add = findViewById(R.id.button_Add)
        textname = findViewById(R.id.Name)
        discription = findViewById(R.id.discription)
        phone_number = findViewById(R.id.Phone)
        recycler_view = findViewById(R.id.RV_Contacts)
        btn_add.setOnClickListener {
            ListDis.add(discription.text.toString())
            if(textname.text.length >= 3 && phone_number.text.length == 11)
            {
                listOfItem.add(DataClass_RV(textname.text.toString(),phone_number.text.toString()))
                var adapter = RV_Adapter(listOfItem)
                recycler_view.adapter = adapter
                adapter.setOnItemClickListener(object : RV_Adapter.OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        var intent = Intent(this@MainContactActivity ,ContactDetailsActivity ::class.java)
                        intent.putExtra("name",listOfItem[position].userName)
                        intent.putExtra("phone",listOfItem[position].userPhone)
                        intent.putExtra("dis",ListDis[position])
                        startActivity(intent)
                    }
                })
            }
            else{
                textname.setError("Name at least 3 char")
                phone_number.setError("Phone should contain 11 number")
            }
            textname.setText("")
            phone_number.setText("")
            discription.setText("")
        }
    }
}