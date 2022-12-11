package com.example.navigationdrawersampletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private  lateinit var  drawerLayout: DrawerLayout
    private  lateinit var navController: NavController
    private lateinit var navView:NavigationView

    private lateinit var  appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navController = findNavController(R.id.nav_host)
        navView = findViewById(R.id.navView)

    // appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)
        appBarConfiguration = AppBarConfiguration(
           setOf(R.id.nav_home,R.id.nav_setting,R.id.nav_help),drawerLayout
       )


        setupActionBarWithNavController(navController,drawerLayout)
        navView.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}