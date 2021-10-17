package com.example.githubuserapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rv_user: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv_user = findViewById(R.id.rv_user)

        list.addAll(listUsers)
        recyclerList()

    }

    private val listUsers: ArrayList<User>
    get() {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataCompani = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepo= resources.getStringArray(R.array.repository)
        val dataName = resources.getStringArray(R.array.name)
        val listUser = ArrayList<User>()

        for (i in dataUsername.indices) {
            val user = User(
                dataUsername[i],
                dataName[i],
                dataAvatar.getResourceId(i, -1),
                dataCompani[i],
                dataLocation[i],
                dataRepo[i].toInt(),
                dataFollowers[i].toInt(),
                dataFollowing[i].toInt(),
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun recyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rv_user.adapter = listUserAdapter
    }

//    fun getJson(context: Context, fileName: String) : String? {
//        val jsonString: String
//        try {
//            jsonString = context.assets.open(fileName).bufferedReader().use { it.readLine() }
//        } catch (iOException: IOException) {
//            iOException.stackTrace
//            return null
//        }
//        return jsonString
//    }
//
//    private val listUsers:ArrayList<User>
//    get() {
//        val gson = Gson()
//        val jsonFile = getJson(this@MainActivity,"githubuser.json")
//        Log.i("data", jsonFile.toString())
//        val listUserType = object : TypeToken<List<User>>() {}.type
//        var userGit: List<User> = gson.fromJson(jsonFile, listUserType)
//        val listUser = ArrayList<User>()
////        val dataName = userGit.
//
//        for (i in userGit) {
//            val user = User(username = "username",)
//            listUser.add(user)
//        }
//
//        return listUsers
//    }
}


