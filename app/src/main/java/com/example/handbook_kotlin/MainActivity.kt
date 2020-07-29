package com.example.handbook_kotlin

import android.content.res.TypedArray
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
    var adapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.addAll(
            fillArras(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)
            )
        )
        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(list, this)
        rc_view.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.id_fish -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)
                    )
                )

            }
            R.id.id_na -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.nash),
                        resources.getStringArray(R.array.nash_content),
                        getImageId(R.array.nash_image_array)
                    )
                )

            }
            R.id.id_sna -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.snasty),
                        resources.getStringArray(R.array.snasty_content),
                        getImageId(R.array.snasty_image_array)
                    )
                )
            }
            R.id.id_history -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.history),
                        resources.getStringArray(R.array.history_content),
                        getImageId(R.array.history_image_array)
                    )
                )
            }
        }

        return true
    }

    fun fillArras(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}