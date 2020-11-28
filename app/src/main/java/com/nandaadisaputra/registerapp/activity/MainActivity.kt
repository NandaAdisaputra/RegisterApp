package com.nandaadisaputra.registerapp.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaadisaputra.registerapp.R
import com.nandaadisaputra.registerapp.adapter.UserAdapter
import com.nandaadisaputra.registerapp.database.UserDatabase
import com.nandaadisaputra.registerapp.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {
    var userDatabase: UserDatabase? = null
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userDatabase = UserDatabase.getInstance(this)
        layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(ArrayList())
        recyclerUser.layoutManager = layoutManager
        recyclerUser.adapter = adapter
        val path = getDatabasePath("User.db").canonicalPath
        Log.d("DATABASE", "Path Database $path")
        buttonRegister.onClick {
            insertNewUser()
        }
    }

    private fun insertNewUser() {
        val user = UserModel(
            name = editName.text.toString(),
            number= editNumberParticipant.text.toString(),
            gender = editGender.text.toString(),
            date = editDateOfBirth.text.toString(),
            age = editAge.text.toString()
        )

            GlobalScope.launch {
                userDatabase?.userDao()?.insertUser(user)
                val list: List<UserModel>? = userDatabase?.userDao()?.getAllUser()
                runOnUiThread {
                    adapter.setListOfUser(list)
                }
            }
        }
    override fun onRestart() {
        super.onRestart()
        insertNewUser()
    }
}