package com.example.packagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.packagescreen.PackageModel
import com.example.packagescreen.acumin_pro
import com.example.packagescreen.msnBrightBlue
import com.example.packagescreen.packagesHeaderList

@Composable
fun HeaderPackagesPack(packagesHeaderList: List<PackageModel>,clickedCardName: MutableState<String>) {
    val width = LocalConfiguration.current.screenWidthDp.dp
    LazyRow(
        modifier = Modifier.width(width),
        userScrollEnabled = false,
    ) {
        items(packagesHeaderList) {item ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                    .background(if (clickedCardName.value.equals(item.title)) msnBrightBlue else Color.Gray)
                    .padding(5.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = acumin_pro,
                            fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    if (item.discountPercentage.isNotEmpty()) {
                        Card(
                            modifier = Modifier.wrapContentSize(),
                            colors = CardDefaults.cardColors(Color.White)
                        ) {
                            Text(
                                text = "Save " + item.discountPercentage,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontFamily = acumin_pro,
                                    fontWeight = FontWeight.W600
                                ),
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = item.price,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}