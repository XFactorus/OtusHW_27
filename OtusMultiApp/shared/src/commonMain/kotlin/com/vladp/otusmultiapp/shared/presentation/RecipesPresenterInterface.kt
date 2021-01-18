package com.vladp.otusmultiapp.shared.presentation

interface RecipesPresenterInterface {

    fun loadRecipes(dishName: String?, ingredients: String, page: Int, isNewSearch: Boolean)
    var view: RecipesListViewInterface?
    fun attachView(view: RecipesListViewInterface)

    fun detachView()

}