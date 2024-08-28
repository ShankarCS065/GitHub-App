package com.example.githubapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.githubapp.data.local.FavoriteUserDao
import com.example.githubapp.data.local.FavouriteUser
import com.example.githubapp.data.local.UserDatabase

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private var userDao: FavoriteUserDao?
    private var userDb: UserDatabase?

    init {
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavouriteUser>>?{
        return userDao?.getFavoriteUser()
    }

}