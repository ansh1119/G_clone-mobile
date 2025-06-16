package org.gym.gclone.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GravlTextField(
    value: String,
    onValueChange: (String) -> Unit,  //Takes a String input and doesn't return anything
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    imeAction: ImeAction = ImeAction.Done,  // Action button behaviour,
    isPasswordField: Boolean = false,
    leadingIcon: Painter? = null, //defined as nullable
) {

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

//    val isPassword = keyboardOptions.keyboardType == KeyboardType.Password

    val visualTransformation = if (isPasswordField && !passwordVisibility)
        PasswordVisualTransformation() // hides password
    else VisualTransformation.None  // shows the text as it is

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF8B8F92)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (isPasswordField) KeyboardType.Password
            else keyboardOptions.keyboardType,
            imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.White
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF192126),    //BLACK
            unfocusedTextColor = Color(0xFFBBF246),   //NEON
            focusedContainerColor = Color(0xFF5E6468),  // GRAY
            unfocusedContainerColor = Color(0xFF5E6468),  // GRAY
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
//            unfocusedLabelColor = Color(0xFFBBF246)   //GRAY
        ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }


        },
        trailingIcon = {
            if (isPasswordField) {
                val icon = if (passwordVisibility) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisibility) "Hide Password" else "Show Password"

                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = description,
                        tint = Color.White,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                }
            }
        },
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(Color(0xFF192126)),
        shape = RoundedCornerShape(12.dp)

    )
}