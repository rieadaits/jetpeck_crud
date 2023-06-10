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
import androidx.lifecycle.viewmodel.compose.viewModel
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
        UserInputField(label = "User Name")

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        AddUserButton()

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        LazyColumn {
            items(state.value.size) { index ->
                Text(text = "Item: $index")
            }
        }
    }
}

@Composable
fun AddUserButton() {
    Box(modifier = Modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(10.dp))
                .clickable {

                }
                .background(Purple40)) {
            Text(
                text = "Get Started".uppercase(), color = Color.White
            )
        }
    }
}