package com.dw.kotlinretrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dw.kotlinretrofit.R
import com.dw.kotlinretrofit.UserAdapter
import com.dw.kotlinretrofit.model.User
import com.dw.kotlinretrofit.networking.ApiClient
import com.dw.kotlinretrofit.networking.ApiService
import retrofit2.Call
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        var recyclerView : RecyclerView =findViewById(R.id.recycle)

        recyclerView.layoutManager = LinearLayoutManager(this)

        var retrofit = ApiClient.getRetrofit()
        var apiService = retrofit.create(ApiService::class.java)
        val user: Call<List<User>> = apiService.getdata()


        user.enqueue(object :retrofit2.Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                Log.d("ufyudifgueyhdiu", "kuhtgkreyghkuerl"+response)
                Log.d("ghfhgfjhmj", "fjklffldfklldfkl"+response.body())

                /*  val data: ArrayList<Animal> = ArrayList<Animal>()
                  data.add(Animal("Tiger","Cat"))
                  data.add(Animal("Tiger2","Cat2"))
  */
                if (response.isSuccessful) {
                    val adapter = UserAdapter(response.body())
                    recyclerView.adapter = adapter

                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@UserActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                Log.d("jkhui8uiy78sdyi", "uyt78er"+t.message)
            }
        }
        )


    }
}