package com.example.androidrecyclerview.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrecyclerview.R
import com.example.androidrecyclerview.model.Clothes
import com.example.androidrecyclerview.service.ClothesAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private val clothes = arrayListOf(
        Clothes(R.drawable.winter_jacket, "Winter jacket", "Зимняя куртка теплая"),
        Clothes(R.drawable.pullover, "Pullover", "Полувер"),
        Clothes(
            R.drawable.the_turtleneck_is_warm,
            "The turtleneck is warm",
            "Водолазка с горлом теплая"
        ),
        Clothes(
            R.drawable.sweater_knitted_jumper,
            "Sweater knitted jumper",
            "Свитер вязаный джемпер"
        ),
        Clothes(R.drawable.jumper, "Jumper", "Джемпер"),
        Clothes(R.drawable.insulated_jeans, "Insulated jeans", "Джинсы утепленные"),
        Clothes(R.drawable.mom_jeans_bananas, "Mom jeans bananas", "Джинсы мом бананы"),
        Clothes(R.drawable.jeans_bananas, "Jeans bananas", "Джинсы бананы"),
        Clothes(
            R.drawable.straight_classic_jeans,
            "Straight classic jeans",
            "Джинсы прямые классические"
        ),
        Clothes(R.drawable.the_jumpsuit_is_warm, "The jumpsuit is warm", "Комбинезон теплый"),
        Clothes(R.drawable.football_uniform, "Football uniform", "Футбольная форма"),
        Clothes(R.drawable.track_suit, "Track suit", "Спортивный костюм"),
        Clothes(
            R.drawable.the_tracksuit_is_warm,
            "The tracksuit is warm",
            "Спортивный костюм теплый"
        ),
        Clothes(R.drawable.home_costume, "Home costume", "Домашний костюм"),
        Clothes(R.drawable.longsleeve_oversize, "Longsleeve oversize", "Лонгслив оверсайз"),
        Clothes(R.drawable.longsleeve_blue, "Longsleeve blue", "Лонгслив голубой"),
        Clothes(R.drawable.sports_t_shirt, "Sports T-shirt", "Майка спортивная"),
        Clothes(R.drawable.collarless_shirt, "Collarless Shirt", "Рубашка без воротника"),
        Clothes(R.drawable.mens_shirt, "Men's shirt", "Рубашка мужская"),
        Clothes(R.drawable.mens_bathrobe, "Men's bathrobe", "Халат мужской")
    )
    private lateinit var toolbar: Toolbar
    private lateinit var listViewLV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        listViewLV = findViewById(R.id.listViewLV)
        listViewLV.layoutManager = LinearLayoutManager(this)
        listViewLV.adapter = ClothesAdapter(clothes)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> {
                finishAffinity()
            }
        }
        return true
    }
}