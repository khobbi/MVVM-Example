package com.edon.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edon.mvvm_example.adapter.BlogRecyclerAdapter
import com.edon.mvvm_example.databinding.ActivityMainBinding
import com.edon.mvvm_example.model.Blog
import com.edon.mvvm_example.viewmodel.MainViewModel
import com.edon.mvvm_example.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var bnd: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bnd.root)

        val factory = MainViewModelFactory()
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bnd.btnButton.setOnClickListener {
            addData(viewModel, bnd.recRecycler)
        }

        bnd.recRecycler.layoutManager = LinearLayoutManager(this)

        observeData(viewModel)
    }

    fun observeData(viewModel: MainViewModel){
        viewModel.liveList.observe(this, Observer{
            Log.i("data", it.toString())
            bnd.recRecycler.adapter = BlogRecyclerAdapter(viewModel, it, this)
        })
    }

    fun addData(viewModel: MainViewModel, mainRecyclerView: RecyclerView){
        val title = bnd.edtTitletxt.text.toString()
        if(title.isBlank()){
            Toast.makeText(this,"Enter value!", Toast.LENGTH_SHORT).show()
        }else{
            viewModel.add(Blog(title))
            bnd.edtTitletxt.text.clear()
            mainRecyclerView.adapter?.notifyDataSetChanged()
        }

    }
}