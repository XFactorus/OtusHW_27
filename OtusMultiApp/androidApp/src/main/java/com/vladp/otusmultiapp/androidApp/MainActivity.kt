package com.vladp.otusmultiapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vladp.otusmultiapp.shared.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladp.otusmultiapp.shared.presentation.RecipesListViewInterface
import com.vladp.otusmultiapp.shared.presentation.RecipesPresenter
import com.vladp.otusmultiapp.shared.presentation.RecipesPresenterInterface
import dev.icerock.moko.network.generated.models.Recipe


class MainActivity : AppCompatActivity(), RecipesListViewInterface {
    val presenter: RecipesPresenterInterface = RecipesPresenter()
    private var adapter = RecipesAdapter()
    private var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<RecyclerView>(R.id.list)
        list?.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.loadRecipes(dishName = "", ingredients = "carrot", 1, isNewSearch = true)
    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
    }

    override fun setupItems(items: List<Recipe>) {
        list?.adapter = adapter
        this.adapter.updateItems(items)
    }
}