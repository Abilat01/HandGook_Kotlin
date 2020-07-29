package com.example.handbook_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.add(ListItem(R.drawable.som, "Сом", "Я слеп, но вижу что ты аххуел"))
        list.add(ListItem(R.drawable.nalim, "Налим", "Я глух, но слышу что ты ахуел?"))
        list.add(ListItem(R.drawable.shuca, "Щука", "Я нем, но я говорю -Ты ахуел!"))
        list.add(ListItem(R.drawable.caras, "Карась", "А теперь ответь на вопрос кто дважды"))
        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        rc_view.adapter = Adapter(list, this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.id_fish -> Toast.makeText(this, "тут будет что то про рыб", Toast.LENGTH_SHORT)
                .show()
            R.id.id_na -> Toast.makeText(this, "тут будет что про наживки", Toast.LENGTH_SHORT)
                .show()
            R.id.id_sna -> Toast.makeText(this, "тут будет что то про снасти", Toast.LENGTH_SHORT)
                .show()
            R.id.id_history -> Toast.makeText(this, "тут будут истории", Toast.LENGTH_SHORT).show()

        }

        return true
    }
}