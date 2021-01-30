package com.endhuine.cleanworkshop.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.endhuine.cleanworkshop.ui.userlist.model.UserListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * [ViewModel] of the [UserListFragment]
 */
@HiltViewModel
class UserListViewModel @Inject constructor(): ViewModel() {

    val userList: LiveData<List<UserListModel>> = liveData {
        emit(listOf(
            UserListModel(1,"https://reqres.in/img/faces/1-image.jpg", "user.mock@mail.com"),
            UserListModel(2, "https://reqres.in/img/faces/1-image.jpg", "user.mock@mail.com"),
            UserListModel(3, "https://reqres.in/img/faces/1-image.jpg", "user.mock@mail.com"),
            UserListModel(4, "https://reqres.in/img/faces/1-image.jpg", "user.mock@mail.com"),
            UserListModel(5, "https://reqres.in/img/faces/1-image.jpg", "user.mock@mail.com"),
        ))
    }

}