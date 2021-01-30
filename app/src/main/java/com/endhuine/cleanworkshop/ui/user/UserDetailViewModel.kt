package com.endhuine.cleanworkshop.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.endhuine.cleanworkshop.ui.user.model.UserDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * [ViewModel] of the [UserDetailFragment]
 */
@HiltViewModel
class UserDetailViewModel @Inject constructor() : ViewModel() {

    val user: LiveData<UserDetailModel> = liveData {
        emit(UserDetailModel(
            "user.mock@mail.com",
            "user",
            "mock",
            "https://reqres.in/img/faces/1-image.jpg"
        ))
    }
}