package com.example.packagescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.packagescreen.ui.theme.PackageScreenTheme

val annualList = listOf<String>(
    "Access ~225 live Capitals, Wizards, Washington Mystics, and Go-Go Games every year",
    "Watch on 3 supported devices at a time",
    "Discount on tickets for select Game of the Month"
)
val monthlyList = listOf<String>(
    "Monthly access to live Capitals, Wizards, Mystics, and Go-Go Games",
    "Watch on 1 supported device at a time"
)

data class PackageModel(
    var title: String,
    var isDiscountShown: Boolean,
    var discountPercentage: String,
    var price: String,
    var list: List<String>
){}


val packagesHeaderList = listOf<PackageModel>(
    PackageModel("Annual", true, "50%", "$199.99/year", annualList),
    PackageModel("Monthly", false, "", "$24.99/month", monthlyList),
    PackageModel("Monthly", false, "", "$24.99/month", monthlyList),
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PackageScreen()
                }
            }
        }
    }

    @Composable
    private fun PackageScreen() {
        var showInfo by remember {
            mutableStateOf(false)
        }
        Column(
            Modifier
                .background(Color.Gray)
                .padding(10.dp)
        ) {
            if (showInfo) {
                PlansDetails(packagesHeaderList)
            } else {

                LazyColumn(){
                    items(packagesHeaderList){ item->
                        CardItemUi(item) {
                            showInfo = !showInfo
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun CardItemUi(
    item: PackageModel,
    onIconClicked: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp)
        ) {
            HeaderItemUi(
                title = item.title,
                titleColor = if (item.isDiscountShown) msnBrightBlue else Color(0xFF3A4765),
                isDiscountShown = item.isDiscountShown,
                discountPercentage = item.discountPercentage,
                price = item.price
            ) {
                onIconClicked()
            }
            Spacer(modifier = Modifier.height(10.dp))

            item.list.forEach {
                ItemListUi(title = it)
            }
//            Box(modifier = Modifier.height(300.dp)) {
//                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
//                    items(item.list) {
//                        ItemListUi(title = it)
//                    }
//                }
//            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(redButtonColor)
            )
            {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = acumin_pro,
                        color = Color.White,
                        fontWeight = FontWeight.W600
                    )
                )
            }
        }
    }
}

@Composable
fun HeaderItemUi(
    title: String,
    titleColor: Color,
    isDiscountShown: Boolean,
    discountPercentage: String,
    price: String,
    onIconClicked: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TitleWithDiscountBadge(title, titleColor, isDiscountShown, discountPercentage)
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "InfoIcon",
                tint = Color.Gray,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        onIconClicked()
                    }

            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = price,
            style = TextStyle(fontSize = 18.sp, fontFamily = acumin_pro, color = lightgreyTextColor)
        )
    }
}

@Composable
private fun TitleWithDiscountBadge(
    title: String,
    titleColor: Color,
    isDiscountShown: Boolean,
    discountPercentage: String
) {

    Text(
        text = title,
        style = TextStyle(
            fontSize = 24.sp,
            color = titleColor,
            fontFamily = acumin_pro,
            fontWeight = FontWeight.W700
        )
    )
    if (isDiscountShown) {
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            modifier = Modifier.wrapContentSize(),
            colors = CardDefaults.cardColors(Color.Blue)
        ) {
            Text(
                text = "Save " + discountPercentage,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = acumin_pro
                ),
                modifier = Modifier.padding(horizontal = 11.dp)
            )
        }
    }

}


@Composable
fun ItemListUi(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_sizes),
            contentDescription = "TickIcon",
            tint = Color(0xFF007F06),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            style = TextStyle(fontSize = 14.sp, color = Color(0xFF07132D), fontFamily = acumin_pro)
        )
    }
}

//
//@Composable
//fun DiscountUi() {
//    Card(
//        modifier = Modifier.wrapContentSize(),
//        colors = CardDefaults.cardColors(Color.Blue)
//    ) {
//        Text(text = "Save 50%", style = TextStyle(color = Color.White, fontSize = 16.sp,fontWeight = FontWeight.W600), modifier = Modifier.padding(horizontal = 10.dp))
//    }
//}

