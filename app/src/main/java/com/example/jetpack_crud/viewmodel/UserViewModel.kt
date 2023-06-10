package com.example.jetpack_crud.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_crud.dataclass.UserInfoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    private var _userStateItems = MutableStateFlow(listOf(UserInfoState()))
    var userStateItems: StateFlow<List<UserInfoState>> = _userStateItems.asStateFlow()

    fun addUser(user: UserInfoState){
        viewModelScope.launch {
            _userStateItems.value = _userStateItems.value + user
        }
    }
}