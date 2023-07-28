package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.background_color)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OwnerInfo(Modifier.weight(3F))
                        SocialInfo(Modifier.weight(1F))
                    }
                }
            }
        }
    }
}


@Composable
fun OwnerInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .background(Color.DarkGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.full_name),
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 4.dp),
            fontWeight = FontWeight.Light
        )

        Text(text = stringResource(id = R.string.title), fontSize = 18.sp, letterSpacing = 1.sp)
    }
}

@Composable
fun SocialInfo(modifier: Modifier = Modifier) {
    val spacerHeight = 15.dp
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialInfoItem(
            icon = Icons.Sharp.Phone,
            text = stringResource(id = R.string.phone),
            contentDescription = "Social Network",
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        SocialInfoItem(
            icon = Icons.Sharp.Share,
            text = stringResource(id = R.string.social),
            contentDescription = "Social Network",
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        SocialInfoItem(
            icon = Icons.Sharp.Email,
            text = stringResource(id = R.string.email),
            contentDescription = "Social Network",
        )
    }
}

@Composable
fun SocialInfoItem(
    icon: ImageVector,
    text: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = modifier.padding(end = 30.dp)
        )
        Text(text = text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun OwnerCardPreview() {
    BusinessCardTheme {
        OwnerInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun SocialInfoItemPreview() {
    BusinessCardTheme {
        SocialInfoItem(
            icon = Icons.Sharp.Phone,
            text = stringResource(id = R.string.phone),
            contentDescription = "Phone number"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SocialInfoPreview() {
    BusinessCardTheme {
        SocialInfo()
    }
}