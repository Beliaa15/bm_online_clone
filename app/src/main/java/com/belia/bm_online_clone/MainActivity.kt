package com.belia.bm_online_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belia.bm_online_clone.ui.theme.BM_Online_cloneTheme
import com.belia.bm_online_clone.ui.theme.DarkRed
import com.belia.bm_online_clone.ui.theme.DarkRedFont
import com.belia.bm_online_clone.ui.theme.DisabledButton


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BM_Online_cloneTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val isFormValid = username.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = modifier.padding(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = null,
            )

            Text(
                text = stringResource(id = R.string.eng_exchange),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkRedFont,
                ),
            )

            /*ClickableText(
                text = AnnotatedString(stringResource(id = R.string.eng_exchange)),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkRedFont,
                ),
            ) {}*/
        }
        Spacer(modifier = modifier.padding(10.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = {
                Text(
                    text = stringResource(id = R.string.username),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = stringResource(id = R.string.password), color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            },
            trailingIcon = {
                val image = if (isPasswordVisible) {
                    painterResource(id = R.drawable.ic_visibility)
                } else {
                    painterResource(id = R.drawable.ic_visibility_off)
                }

                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(painter = image, contentDescription = null)
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )

        Text(
            text = stringResource(id = R.string.frgt_usr_pwd),
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, top = 6.dp),
            color = Color.DarkGray,
            )

        /*ClickableText(
            text = AnnotatedString(stringResource(id = R.string.frgt_usr_pwd)),
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, top = 6.dp),
        ) {}*/

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { /**/ },
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkRed,
                contentColor = Color.White,
                disabledContainerColor = DisabledButton,
                disabledContentColor = Color.White
            ),
            shape = ShapeDefaults.Medium,
            enabled = isFormValid
        ) {
            Text(
                text = stringResource(R.string.login),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = stringResource(id = R.string.need_help),
                fontSize = 14.sp,
                modifier = modifier.padding(end = 3.dp),
                color = Color.DarkGray,
            )

            Text(
                text = stringResource(id = R.string.contact_us),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = DarkRedFont,
                textDecoration = TextDecoration.Underline,
            )

            /*ClickableText(
                text = AnnotatedString(stringResource(id = R.string.contact_us)),
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = DarkRedFont,
                    fontWeight = FontWeight.Bold
                ),
            ) {}*/
        }

        Spacer(modifier = Modifier.height(50.dp))

        HorizontalDivider(
            modifier = modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.size(width = 75.dp, height = 130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.our_products),
                    contentDescription = null,
                    modifier = modifier
                        .size(50.dp)
                        .padding(bottom = 3.dp)
                )
                Text(
                    text = stringResource(R.string.our_products),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.size(width = 75.dp, height = 130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exchange_rate),
                    contentDescription = null,
                    modifier = modifier
                        .size(50.dp)
                        .padding(bottom = 3.dp)
                )
                Text(
                    text = stringResource(R.string.exchange_rate),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,
                    )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.size(width = 75.dp, height = 130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.security_tips),
                    contentDescription = null,
                    modifier = modifier
                        .size(50.dp)
                        .padding(bottom = 3.dp)
                )
                Text(
                    text = stringResource(R.string.security_tips),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,

                    )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.size(width = 75.dp, height = 130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                    contentDescription = null,
                    modifier = modifier
                        .size(50.dp)
                        .padding(bottom = 3.dp)
                )
                Text(
                    text = stringResource(R.string.nearest_branch_or_atm),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,

                    )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}