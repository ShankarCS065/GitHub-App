package com.example.githubapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapp.api.RetrofitClient
import com.example.githubapp.data.model.Repo
import com.example.githubapp.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposViewModel:ViewModel() {
    val listRepos = MutableLiveData<ArrayList<Repo>>()

    fun setListRepo(username:String){
        RetrofitClient.apiInstance
            .getRepos(username)
            .enqueue(object : Callback<ArrayList<Repo>> {
                override fun onResponse(
                    call: Call<ArrayList<Repo>>,
                    response: Response<ArrayList<Repo>>
                ) {
                    listRepos.postValue(response.body())
                }

                override fun onFailure(call: Call<ArrayList<Repo>>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }

    fun getListRepo(): LiveData<ArrayList<Repo>> {
        return listRepos
    }
}