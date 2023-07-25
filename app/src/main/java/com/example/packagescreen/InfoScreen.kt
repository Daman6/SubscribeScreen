package com.example.packagescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.packagescreen.components.FeaturesRowForHeaderPackages


@Composable
fun PlansDetails(packagesHeaderList: List<PackageModel>,clickedCardName : MutableState<String>) {
    HeaderTitleUi(packagesHeaderList,clickedCardName)
}

@Composable
fun HeaderTitleUi(packagesHeaderList: List<PackageModel>,clickedCardName : MutableState<String>) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Plans Details",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = acumin_pro,
                    fontWeight = FontWeight.W700
                )
            )
            IconButton(modifier = Modifier.size(20.dp), onClick = {}) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        FeaturesRowForHeaderPackages(packagesHeaderList,clickedCardName)
    }
}