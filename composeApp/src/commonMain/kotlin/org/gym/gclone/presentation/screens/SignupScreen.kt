package org.gym.gclone.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.apple_icon
import kotlinproject.composeapp.generated.resources.email_icon
import kotlinproject.composeapp.generated.resources.facebook_icon
import kotlinproject.composeapp.generated.resources.google_icon
import kotlinproject.composeapp.generated.resources.gravl_logo
import kotlinproject.composeapp.generated.resources.lock_icon
import kotlinproject.composeapp.generated.resources.person_icon
import org.gym.gclone.presentation.components.GravlTextButton
import org.gym.gclone.presentation.components.GravlTextField
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignupScreen() {

    val scrollableState = rememberScrollState()  //Makes the screen scrollable

    //Input text fields
    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .scrollable(
                scrollableState,
                orientation = Orientation.Vertical
            )  //Makes screen scrollable
            .fillMaxSize()
            .background(Color(0xFF192126))
            .padding(horizontal = 24.dp, vertical = 16.dp),  // Adds padding around the screen
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(48.dp))

        //Loge
        Image(
            painter = painterResource(Res.drawable.gravl_logo),
            contentDescription = "App logo",
            modifier = Modifier.height(64.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        //App logo
        Text(
            text = "Your journey starts here\nTake the first step.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBBF246),  //Neon
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Text field for name
        GravlTextField(
            value = name,
            placeholder = "Name",
            onValueChange = { name = it },
            leadingIcon = painterResource(resource = Res.drawable.person_icon),
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Text field for email
        GravlTextField(
            value = email,
            placeholder = "E-mail",
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            leadingIcon = painterResource(resource = Res.drawable.email_icon),
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Text field for password
        GravlTextField(
            value = password,
            placeholder = "Password",
            onValueChange = { password = it },
            leadingIcon = painterResource(resource = Res.drawable.lock_icon),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            isPasswordField = true
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Text field for confirming password
        GravlTextField(
            value = confirmPassword,
            placeholder = "Confirm Password",
            onValueChange = { confirmPassword = it },
            leadingIcon = painterResource(resource = Res.drawable.lock_icon),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            isPasswordField = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Button that signs you up
        GravlTextButton(
            value = "Sign up",
            onClick = {

            }
        )
        Spacer(modifier = Modifier.height(24.dp))

        // to add text between the divider lines
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                Modifier.weight(1f),  // takes up equal available space horizontally
                color = MaterialTheme.colorScheme.outline
            )

            Text(
                text = "  or  ",
                color = Color(0xFFBBF246),
                fontSize = 14.sp
            )

            HorizontalDivider(
                Modifier.weight(1f),
                color = MaterialTheme.colorScheme.outline
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        //social icons for login
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(Res.drawable.facebook_icon),
                contentDescription = "Facebook",
                tint = Color(0xFFBBF246),
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.apple_icon),
                contentDescription = "Apple",
                tint = Color(0xFFBBF246),
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            )
            Icon(
                painter = painterResource(Res.drawable.google_icon),
                contentDescription = "Google",
                tint = Color(0xFFBBF246),
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        //Redirects to login screen
        Text(
            text = "Already have an account? Sign in",
            fontSize = 14.sp,
            color = Color(0xFFBBF246),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable {
                    // navigation logic
                }
        )
    }
}

