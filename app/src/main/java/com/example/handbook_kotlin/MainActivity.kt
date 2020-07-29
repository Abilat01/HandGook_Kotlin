package com.example.handbook_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_fish -> Toast.makeText(this, "тут будет что то про рыб", Toast.LENGTH_SHORT).show()
            R.id.id_na -> Toast.makeText(this, "тут будет что про наживки", Toast.LENGTH_SHORT).show()
            R.id.id_sna -> Toast.makeText(this, "тут будет что то про снасти", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "тут будут истории", Toast.LENGTH_SHORT).show()

        }

        return true
    }
}