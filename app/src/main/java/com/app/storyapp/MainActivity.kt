package com.app.storyapp

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.storyapp.adapters.ItemAdapter
import com.app.storyapp.databinding.ActivityMainBinding
import com.app.storyapp.databinding.ContentMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{

    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.tbHeader)
        setSupportActionBar(toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)


        toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        val storyTitles = resources.getStringArray(R.array.storyTitles)
        val storyContents = resources.getStringArray(R.array.storyContents)
        val storyImages = resources.getStringArray(R.array.storyImages)

        val adapter = ItemAdapter(this,storyTitles,storyContents,storyImages)
        val storyList = findViewById<RecyclerView>(R.id.rvStoryList)
        storyList.layoutManager = LinearLayoutManager(this)
        storyList.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}