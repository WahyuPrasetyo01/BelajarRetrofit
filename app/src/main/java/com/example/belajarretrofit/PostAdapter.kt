package com.example.belajarretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarretrofit.databinding.ActivityMainBinding
import com.example.belajarretrofit.databinding.ItemPostBinding

class PostAdapter (private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    private lateinit var binding: ItemPostBinding
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postResponse: PostResponse){
            with(itemView){
                val text : String = "id: ${postResponse.id}\n" +
                        "title: ${postResponse.title}\n" +
                        "body: ${postResponse.body}"
                binding.tvText.text = text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int = list.size

}

