package com.dheep.employee.presentation.view.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dheep.employee.presentation.view.data.datastore.entity.SchoolEntity


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(viewModel: SchoolsViewModel, navController: NavHostController) {
    val state by viewModel.schoolDataState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        ListSection(state, navController)
    }

}

@Composable
private fun ListSection(state: UIState, navController: NavHostController) {
    when (state) {
        is UIState.Loading -> {

        }

        is UIState.Success -> {
            SchoolsListSection(state.data)
        }

        is UIState.Error -> {

        }

        is UIState.Empty -> {

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun SchoolsListSection(schools: List<SchoolEntity>) {
    Scaffold(topBar = {
        AppBar(title = "Scools List", image = Icons.Filled.Menu)
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(schools) { school ->
                    SchoolsCard(school)
                }
            }
        }
    }
}

@Composable
private fun AppBar(title: String, image: ImageVector) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = image, contentDescription = null)

            }
        }
    )
}

@Composable
private fun SchoolsCard(school: SchoolEntity) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable {},
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start
        ) {
            SchoolContent(school,Alignment.Start )
        }
    }
}

@Composable
private fun SchoolContent(school: SchoolEntity, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = alignment
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(text = school.schoolName, style = MaterialTheme.typography.h6)

        }

        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(text = school.dbn, style = MaterialTheme.typography.body2)

        }
    }
}