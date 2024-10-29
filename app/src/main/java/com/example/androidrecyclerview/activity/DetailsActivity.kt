package com.example.androidrecyclerview.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidrecyclerview.R
import com.example.androidrecyclerview.model.Clothes

class DetailsActivity : AppCompatActivity() {
    private lateinit var main: LinearLayout
    private lateinit var toolbar: Toolbar
    private lateinit var clothes: Clothes
    private lateinit var imageIV: ImageView
    private lateinit var nameTV: TextView
    private lateinit var descriptionTV: TextView
    private var position = -1
    private lateinit var intentBack: Intent

    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        main.setOnLongClickListener {
            val dialog = AlertDialog.Builder(this)
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_update, null)
            dialog.setView(dialogView)
            val nameET = dialogView.findViewById<EditText>(R.id.nameET)
            val descriptionET = dialogView.findViewById<EditText>(R.id.descriptionET)
            dialog.setTitle("Обновить запись")
            dialog.setPositiveButton("Обновить") { _, _ ->
                nameTV.text = nameET.text.toString()
                descriptionTV.text = descriptionET.text.toString()
                clothes =
                    Clothes(clothes.image, nameET.text.toString(), descriptionET.text.toString())
                position = intent.getStringExtra("position")!!.toInt()
                intentBack.putExtra(Clothes::class.java.simpleName, clothes)
                intentBack.putExtra("position", position.toString())
                setResult(RESULT_OK, intentBack)
            }
            dialog.setNegativeButton("Отмена"){_,_->
            }
            dialog.create().show()
            false
        }

    }

    private fun init() {
        main = findViewById(R.id.main)
        clothes = intent.getSerializableExtra(Clothes::class.java.simpleName) as Clothes
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = clothes.name
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        imageIV = findViewById(R.id.imageIV)
        imageIV.setImageResource(clothes.image)
        nameTV = findViewById(R.id.nameTV)
        nameTV.text = clothes.name
        descriptionTV = findViewById(R.id.descriptionTV)
        descriptionTV.text = clothes.description
        intentBack = Intent(this, RecyclerViewActivity::class.java)
        setResult(RESULT_CANCELED, intentBack)
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