package com.vladp.otusmultiapp.shared.presentation
import dev.icerock.moko.network.generated.models.*

interface RecipesListViewInterface {
    fun setupItems(items: List<Recipe>)
}