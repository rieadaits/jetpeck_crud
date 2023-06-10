package com.example.jetpack_crud.ui.screens.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpack_crud.dataclass.UserInfoState
import com.example.jetpack_crud.ui.screens.utils.UserInputField
import com.example.jetpack_crud.ui.theme.Purple40
import com.example.jetpack_crud.viewmodel.UserViewModel

@Composable
fun HomeScreen(
    userViewModel: UserViewModel = viewModel()
) {

    val state = userViewModel.userStateItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        UserInputField(label = "User Name", onTextChanged = {
            userViewModel.getUserName(it)
        })

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        AddUserButton(userInfo = UserInfoState(name = userViewModel.userName.value, id= 0))

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        LazyColumn {
            items(state.value.size) { index ->
                Text(text = "Name: ${state.value[index].name}, Id: ${state.value[index].id}",
                    modifier = Modifier.clickable {
                        userViewModel.deleteUser(index)
                    }

                )
            }
        }
    }
}

@Composable
fun AddUserButton(
    userViewModel: UserViewModel = hiltViewModel(),
    userInfo: UserInfoState ? = null
) {
    Box(modifier = Modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    userViewModel.addUser(userInfo!!)
                }
                .background(Purple40)) {
            Text(
                text = "Get Started".uppercase(), color = Color.White
            )
        }
    }
}