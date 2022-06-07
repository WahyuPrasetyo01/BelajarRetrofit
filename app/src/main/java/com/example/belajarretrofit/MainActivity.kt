package com.example.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPost.setHasFixedSize(true)
        binding.rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val resposeCode = response.code().toString()
                binding.tvResponse.text = resposeCode
                response.body()?.let { list.addAll(it)}
                val adapter = PostAdapter(list)
                binding.rvPost.adapter =  adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }

        })

    }
}
