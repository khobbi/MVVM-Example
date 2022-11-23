package com.edon.mvvm_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edon.mvvm_example.model.Blog

class MainViewModel: ViewModel() {
    val liveList = MutableLiveData<ArrayList<Blog>>() //observable
    val tempList = ArrayList<Blog>()

    fun add(blog: Blog){
        tempList.add(blog) //put the blog in the list form
        liveList.value = tempList //assign the list to the livedata to become observable to others
    }

    fun delete(blog: Blog){
        tempList.remove(blog) //remove blog from the list
        liveList.value = tempList //update the livedata
    }

}