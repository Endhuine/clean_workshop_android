package com.endhuine.cleanworkshop.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    /**
     * Request the loading of a user with id as [userId]
     *
     * @param userId as the required user id
     */
    fun requireUser(userId: Int) {
        user.postValue(UserDetailModel(
            "user.mock@mail.com",
            "user",
            "mock",
            "https://reqres.in/img/faces/1-image.jpg"
        ))
    }

    val user: MutableLiveData<UserDetailModel> = MutableLiveData()
}