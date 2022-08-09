package com.dw.kotlinretrofit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dw.kotlinretrofit.MyAdapter
import com.dw.kotlinretrofit.R
import com.dw.kotlinretrofit.model.Animal
import com.dw.kotlinretrofit.networking.ApiClient
import com.dw.kotlinretrofit.networking.ApiService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView : RecyclerView=findViewById(R.id.recycvle)
        var button : Button=findViewById(R.id.btn)

        recyclerView.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {

            val intent = Intent(this@MainActivity, UserActivity::class.java)
            startActivity(intent)
        }


        var retrofit = ApiClient.getRetrofit()
        var apiService = retrofit.create(ApiService::class.java)
        val animalCall: Call<List<Animal>> = apiService.getRandomAnimal()


        animalCall.enqueue(object :retrofit2.Callback<List<Animal>> {
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {

                Log.d("ufyudifgueyhdiu", "yegfweygfuyweu"+response)
                Log.d("ghfhgfjhmj", "utujyyyyyyyyyyyjy"+response.body())

              /*  val data: ArrayList<Animal> = ArrayList<Animal>()
                data.add(Animal("Tiger","Cat"))
                data.add(Animal("Tiger2","Cat2"))
*/
               // if (response.isSuccessful) {
                    val adapter = MyAdapter(response.body())
                    recyclerView.adapter = adapter

                //}
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                Log.d("jkhui8uiy78sdyi", "uyt78er"+t.message)
            }
        }
        )

    }

}
