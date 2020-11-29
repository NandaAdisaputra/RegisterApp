package com.nandaadisaputra.registerapp.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaadisaputra.registerapp.R
import com.nandaadisaputra.registerapp.adapter.UserAdapter
import com.nandaadisaputra.registerapp.database.UserDatabase
import com.nandaadisaputra.registerapp.databinding.ActivityMainBinding
import com.nandaadisaputra.registerapp.model.UserModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userDatabase: UserDatabase? = null
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userDatabase = UserDatabase.getInstance(this)
        layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(ArrayList())
        binding.recyclerUser.layoutManager = layoutManager
        binding.recyclerUser.adapter = adapter
        val path = getDatabasePath("User.db").canonicalPath
        Log.d("DATABASE", "Path Database $path")
        binding.buttonRegister.onClick {
            insertNewUser()
        }
    }

    private fun insertNewUser() {
        val user = UserModel(
            name = binding.editName.text.toString(),
            number = binding.editNumberParticipant.text.toString(),
            gender = binding.editGender.text.toString(),
            date = binding.editDateOfBirth.text.toString(),
            age = binding.editAge.text.toString()
        )
        binding.buttonData.onClick {
            GlobalScope.launch {
                userDatabase?.userDao()?.insertUser(user)
                val list: List<UserModel>? = userDatabase?.userDao()?.getAllUser()
                runOnUiThread {
                    adapter.setListOfUser(list)
                }
            }
        }
    }
    override fun onRestart() {
        super.onRestart()
        insertNewUser()
    }
}