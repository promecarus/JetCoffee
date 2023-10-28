package com.promecarus.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.promecarus.jetcoffee.model.Menu
import com.promecarus.jetcoffee.ui.component.Banner
import com.promecarus.jetcoffee.ui.component.BottomBar
import com.promecarus.jetcoffee.ui.component.CategoryRow
import com.promecarus.jetcoffee.ui.component.HomeSection
import com.promecarus.jetcoffee.ui.component.MenuRow
import com.promecarus.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { JetCoffeeTheme { Column { JetCoffeeApp() } } }
    }
}

@Composable
fun JetCoffeeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(bottomBar = { BottomBar() }) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(it)
            ) {
                Banner()
                HomeSection(R.string.section_category) { CategoryRow() }
                HomeSection(R.string.section_best_seller_menu) { MenuRow(Menu.dummy) }
                HomeSection(R.string.section_best_seller_menu) { MenuRow(Menu.dummyBestSeller) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}
