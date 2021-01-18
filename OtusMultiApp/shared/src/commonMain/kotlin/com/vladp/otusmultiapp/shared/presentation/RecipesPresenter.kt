package com.vladp.otusmultiapp.shared.presentation

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import com.vladp.otusmultiapp.shared.uiDispatcher
import com.vladp.otusmultiapp.shared.ioDispatcher
import com.vladp.otusmultiapp.shared.network.NetworkService
import dev.icerock.moko.network.generated.apis.RecipeApi
import dev.icerock.moko.network.generated.models.*
import kotlinx.serialization.json.Json

class RecipesPresenter(): RecipesPresenterInterface {

    val coroutineContext: CoroutineContext = ioDispatcher
    private lateinit var scope: PresenterCoroutineScope
    private var recipes: ArrayList<Recipe> =  arrayListOf()

    private val networkService = NetworkService()

    private val recipeApi = RecipeApi(
        basePath = "http://www.recipepuppy.com",
        httpClient = networkService.httpClient,
        json = Json {
            ignoreUnknownKeys = true
        }
    )

    override var view: RecipesListViewInterface? = null

    override fun attachView(view: RecipesListViewInterface) {
        scope = PresenterCoroutineScope(coroutineContext)
        this.view = view
    }

    override fun detachView() {
        scope.viewDetached()
        this.view = null
    }

    override fun loadRecipes(dishName: String?, ingredients: String, page: Int, isNewSearch: Boolean) {
        scope.launch {
            val recipesList = recipeApi.getRecipe(i = ingredients, q = dishName, p = page)
            if (recipesList.results != null) {
                if (isNewSearch) {
                    recipes = arrayListOf()
                }
                recipes.addAll(recipesList.results)
                withContext(uiDispatcher) {
                    view?.setupItems(recipes)
                }
            }
        }
    }

}
