import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_compose_template.composeapp.generated.resources.Res
import kmp_compose_template.composeapp.generated.resources.login
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit, onForgetPasswordClick: () -> Unit, onLoginClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.login),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.TopCenter,
                modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Login into your Account",
                fontSize = 23.43.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
            )
            Text(
                text = "Add account Details",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            )
            LoginForm(modifier = Modifier.fillMaxSize(),
                onSignUpClick = { onSignUpClick() },
                onForgetPasswordClick = { onForgetPasswordClick() },
                onLoginClick = { onLoginClick() })
        }
    }
}

@Composable
private fun LoginForm(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit,
    onForgetPasswordClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var passwords by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    //val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        )
        NameTextFields(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Enter Email",
            textValue = email,
            trailingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "") }) {
            email = it
        }
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )
        PasswordTextFields(placeholder = "Enter Password",
            password = passwords,
            passwordVisibility = passwordVisibility,
            onTextChange = { passwords = it },
            onToggleClick = { passwordVisibility = it }
        )
        Text(text = "Forget Password?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp).align(Alignment.End)
                .clickable { onForgetPasswordClick() }
        )
        KMPButton(
            modifier = Modifier.widthIn(min = 300.dp, max = 600.dp).padding(top = 30.dp),
            buttonText = "Sign In"
        ) {
            onLoginClick()
        }
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxSize().padding(vertical = 30.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Not a Member?", fontSize = 12.sp, fontWeight = FontWeight.Normal
            )
            Text(text = "Create an Account",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Blue,
                modifier = Modifier.padding(start = 5.dp).clickable {
                    onSignUpClick()
                })
        }
    }
}


@Composable
fun NameTextFields(
    modifier: Modifier = Modifier,
    placeholder: String,
    textValue: String,
    trailingIcon: @Composable (() -> Unit)?,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = textValue,
        onValueChange = {
            onTextChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent, textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = placeholder, color = Color.Black)
        },
        textStyle = TextStyle(Color.Black),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        trailingIcon = trailingIcon,
        modifier = modifier
            .padding(top = 10.dp)
            .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(15.dp))
            .background(color = Color.Transparent, shape = RoundedCornerShape(15.dp))
    )
}


@Composable
fun PasswordTextFields(
    placeholder: String,
    password: String,
    passwordVisibility: Boolean,
    onTextChange: (String) -> Unit,
    onToggleClick: (Boolean) -> Unit
) {
    TextField(
        value = password,
        onValueChange = {
            onTextChange(it)
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent, textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(Color.Black),
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = { onToggleClick(!passwordVisibility) }) {
                if (passwordVisibility) {
                    Icon(Icons.Filled.Lock, "")
                } else Icon(Icons.Filled.Lock, "")
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp)
            .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(15.dp))
            .background(color = Color.Transparent, shape = RoundedCornerShape(15.dp))
    )
}


@Composable
fun KMPButton(modifier: Modifier = Modifier, buttonText: String, onButtonClick: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth().height(48.dp),
        onClick = { onButtonClick() },
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(15.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonText,
                fontSize = 17.62.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
