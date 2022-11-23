package com.edon.mvvm_example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edon.mvvm_example.R
import com.edon.mvvm_example.model.Blog
import com.edon.mvvm_example.viewmodel.MainViewModel

class BlogRecyclerAdapter(val viewModel: MainViewModel, val dataSet: ArrayList<Blog>, val context: Context)
    :RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val blogTitle: TextView = view.findViewById(R.id.txtTitle)
        val deleteButton: ImageButton = view.findViewById(R.id.imgBtnDelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val blog = dataSet[position] //blog at any position

        holder.blogTitle.text = blog.title
        holder.deleteButton.setOnClickListener {
            //dataSet.remove(blog)
            viewModel.delete(blog)
            notifyItemRemoved(dataSet.indexOf(blog))
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}