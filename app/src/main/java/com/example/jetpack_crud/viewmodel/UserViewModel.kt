package com.example.jetpack_crud.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_crud.dataclass.UserInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {
    private var _userStateItems = MutableStateFlow(listOf(UserInfoState()))
    var userStateItems: StateFlow<List<UserInfoState>> = _userStateItems.asStateFlow()

    private var _userName = mutableStateOf("")
    var userName = _userName

    fun getUserName(userName: String) {
        _userName.value = userName
    }

    fun addUser(user: UserInfoState) {
        viewModelScope.launch {
            _userStateItems.value = _userStateItems.value + user
        }
    }

    fun deleteUser(userId: Int) {

        val tempList = _userStateItems.value.toMutableList()

        viewModelScope.launch {
            _userStateItems.value = tempList.apply {
                removeAt(userId)
            }

        }
    }
}