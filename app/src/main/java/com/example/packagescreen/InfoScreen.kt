package com.example.packagescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



val featuresList = mutableListOf<String>(
    "Access to live Capitals, Wizards, Mystics, and Go-Go games ",
    "Number of devices you can watch on at a time",
    "Discount on tickets for select Game of the Month",
    "20% discount on all Fanatics gear",
    "Pre-sale ticket access to regular season & playoff matches",
    "Automatic entry to monthly Monumental sweepstakes",
    "First 10,000 subscribers receive exclusive MSN bobblehead package"
)

@Composable
fun PlansDetails(packagesHeaderList: List<PackageModel>) {
    HeaderTitleUi(packagesHeaderList)
}

@Composable
fun HeaderTitleUi(packagesHeaderList: List<PackageModel>) {
    Column() {
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
            IconButton(modifier = Modifier.size(20.dp), onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        PriceItemUi(packagesHeaderList)

        Column() {
            featuresList.forEach{
                MarketingListItem(text = it,isAvaiableInAnnual = true , isAvaiableInMonthly = true )
            }
        }
    }


}

@Composable
fun PriceItemUi(packagesHeaderList: List<PackageModel>) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
//        Box(
//            modifier = Modifier
//                .weight(2.2f)
//                .aspectRatio(2.2f)
//                .padding(5.dp),
//        ) {
//        }
//        Box(
//            modifier = Modifier
//                .weight(1f)
//                .aspectRatio(1f)
//                .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
//                .background(msnBrightBlue)
//                .padding(5.dp),
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(vertical = 3.dp),
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Text(
//                    text = "Annual",
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        color = Color.White,
//                        fontFamily = acumin_pro,
//                        fontWeight = FontWeight.W700
//                    )
//                )
//                Spacer(modifier = Modifier.height(6.dp))
//                Card(
//                    modifier = Modifier.wrapContentSize(),
//                    colors = CardDefaults.cardColors(Color.White)
//                ) {
//                    Text(
//                        text = "Save 50%",
//                        style = TextStyle(
//                            color = Color.Black,
//                            fontSize = 14.sp,
//                            fontFamily = acumin_pro,
//                            fontWeight = FontWeight.W600
//                        ),
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
//                }
//                Spacer(modifier = Modifier.height(12.dp))
//                Text(
//                    text = "$199.99/yr",
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        color = Color.White,
//                        fontWeight = FontWeight.W400
//                    )
//                )
//            }
//        }
//        Spacer(modifier = Modifier.width(2.dp))
//        Box(
//            modifier = Modifier
//                .weight(1f)
//                .aspectRatio(1f)
//                .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
//                .background(msnBlue)
//                .padding(5.dp),
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(vertical = 3.dp),
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Text(
//                    text = "Monthly",
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        color = Color.White,
//                        fontFamily = acumin_pro,
//                        fontWeight = FontWeight.W700
//                    )
//                )
//                Text(
//                    text = "$199.99/yr",
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        color = Color.White,
//                        fontWeight = FontWeight.W400
//                    )
//                )
//            }
//        }

        LazyRow(){
            items(packagesHeaderList){item->
                Box(
                    modifier = Modifier
//                        .weight(1f)
//                        .aspectRatio(1f)
                        .size(150.dp)
                        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                        .background(msnBrightBlue)
                        .padding(5.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 3.dp),
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
                        Card(
                            modifier = Modifier.wrapContentSize(),
                            colors = CardDefaults.cardColors(Color.White)
                        ) {
                            Text(
                                text = item.discountPercentage,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontFamily = acumin_pro,
                                    fontWeight = FontWeight.W600
                                ),
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
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
}

@Composable
fun MarketingListItem(text : String ,isAvaiableInAnnual: Boolean, isAvaiableInMonthly: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.9.sp,
                fontFamily = acumin_pro,
                fontWeight = FontWeight(600),
                color = Color.Black
            ),
            modifier = Modifier
                .weight(2.2f)
                .padding(16.dp)
        )
        Box(
            Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (isAvaiableInAnnual) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_sizes),
                    contentDescription = "TickIcon",
                    tint = Color(0xFF007F06),
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Box(
            Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (isAvaiableInMonthly) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_sizes),
                    contentDescription = "TickIcon",
                    tint = Color(0xFF007F06),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    PlansDetails(packagesHeaderList)
}