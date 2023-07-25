package com.example.packagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.packagescreen.PackageModel
import com.example.packagescreen.R
import com.example.packagescreen.packagesHeaderList

@Composable
fun FeaturesRowForHeaderPackages(
    packagesHeaderList: List<PackageModel>,
    clickedCardName: MutableState<String>
) {
    val width = LocalConfiguration.current.screenWidthDp.dp

    Row() {
        LazyColumn(
            Modifier.weight(.5f)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Transparent)
                )
            }
            items(packagesHeaderList) {
                RowUi()
            }
        }
        LazyColumn(
            modifier = Modifier
                .weight(.5f)
                .horizontalScroll(rememberScrollState(), true)
        ) {
            item {
                HeaderPackagesPack(packagesHeaderList = packagesHeaderList,clickedCardName)
            }
            items(packagesHeaderList) {
                LazyRow(
                    modifier = Modifier.width(width),
                    userScrollEnabled = false,
                ) {
                    items(3) {
                        CheckBoxUi()
                    }
                }
            }


        }
    }
}

@Composable
private fun CheckBoxUi() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(90.dp)
            .background(Color.White)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_sizes),
            contentDescription = "TickIcon",
            tint = Color(0xFF007F06),
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
        )
    }
    Spacer(modifier = Modifier.width(2.dp))
}

@Composable
fun RowUi() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(90.dp)
                .padding(end = 2.dp)
                .background(color = Color.White)
        ) {
            Text(
                text = "Access to live Capitals, Wizards, Mystics, and Go-Go games ",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.9.sp,
                    fontWeight = FontWeight(600),
                    color = Color.Black
                ), modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
    }

}