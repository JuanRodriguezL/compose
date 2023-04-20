package com.example.application

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Slider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Content(modifier: Modifier = Modifier){
  Column(modifier = modifier.verticalScroll(rememberScrollState())) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Column {
            var urlVa by remember { mutableStateOf("") }
            GlideImage(model = "https://img.ecartelera.com/noticias/73000/73067-h3.jpg", contentDescription = null,
            modifier = Modifier
                .background(colorResource(id = R.color.teal_200))
                .fillMaxWidth()
                .height(200.dp), contentScale = ContentScale.Crop)

            Text(text = stringResource(id = R.string.card_title),
            modifier= Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.h5)


            OutlinedTextField(value = urlVa,
                onValueChange ={urlVa=it},
            label = { Text(text = stringResource(id = R.string.img_url))},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp, start = 10.dp, end = 10.dp
                ),

            trailingIcon = {
                if (urlVa.isNotEmpty())
                Icon(imageVector = Icons.Filled.Clear,
                contentDescription = "limpiar",
            modifier = Modifier.clickable {
                urlVa=""
            })}
                )
            Text(text = stringResource(id = R.string.card_required,),
                style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            modifier = Modifier.padding(start = 10.dp, top = 4.dp))

            var isCheck by remember {mutableStateOf(false)}
           var pass by remember {mutableStateOf("")}
            var notVisi by remember {mutableStateOf(false)}

            OutlinedTextField(value = pass,
                onValueChange ={pass=it},
                label = { Text(text = stringResource(id = R.string.pass))},
                singleLine = true,
                enabled = isCheck,
                visualTransformation= if (notVisi) VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                trailingIcon = {

                    Icon(painter = if (notVisi)
                        painterResource(id = R.drawable.no_visibility)
                        else painterResource(id = R.drawable.visibility ),
                        contentDescription = null,
                    modifier = Modifier.clickable { notVisi=!notVisi })}
            )
            

            Row (verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isCheck, onCheckedChange ={ isCheck= it } )
                Text(text = "Enable")
            }

            var context = LocalContext.current
            var sliderValue by remember { mutableStateOf(6f) }
            Slider(value = sliderValue , onValueChange = { sliderValue=it},
            valueRange = 0f..10f,
            steps = 4,
            onValueChangeFinished = {
                Toast.makeText(context,"Vol ${sliderValue.toInt()}",Toast.LENGTH_SHORT).show()
            })

        }
        

    }
      
  }
}