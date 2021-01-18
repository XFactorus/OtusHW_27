//
//  RecipesViewModel.swift
//  iosApp
//
//  Created by Vladyslav Pokryshka on 17.01.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

final class RecipesViewModel: ObservableObject, RecipesListViewInterface {
    
    @Published private(set) var recipeItems: [Recipe] = [Recipe]()
    @Published private(set) var page: Int = 1
    
    private var dishName = ""
    private var ingredients = ""
    
    private var initialInfoLoaded = false
    
    private lazy var presenter: RecipesPresenterInterface? = {
        let presenter = RecipesPresenter()
        presenter.attachView(view: self)
        return presenter
    }()
    
    init(isMock: Bool = false) {
        if isMock {
            loadMockData()
            return
        }
        presenter?.attachView(view: self)
    }
    
    func searchDish(dishName:String, ingredients: String) {
        self.page = 1
        self.dishName = dishName
        self.ingredients = ingredients
        self.recipeItems = [Recipe]()
        fetchPage(isNewSearch: true)
    }

    func fetchPage(isNewSearch: Bool = false) {
        self.presenter?.loadRecipes(dishName: dishName, ingredients: ingredients, page: Int32(page), isNewSearch: isNewSearch)
        self.page += 1
    }
    
    // MARK: Delegates
    func setupItems(items: [Recipe]) {
        self.recipeItems = [Recipe]()
        self.recipeItems.append(contentsOf: items)
    }
    
    
    // MARK: Mock data
    func loadMockData() {
        self.recipeItems = RecipesViewModel.getMockRecipes()
    }
}

extension RecipesViewModel {
    static func getMockRecipes() -> [Recipe] {
        return [Recipe(href: "http://cookeatshare.com/recipes/broccoli-oven-omelet-92851",
                title: "Omelet",
                ingredients: "eggs, broccoli, onions, parmesan cheese, lowfat milk, salt, basil, garlic, tomato, parmesan cheese",
                thumbnail: "http://img.recipepuppy.com/514820.jpg"),
         Recipe(href: "http://find.myrecipes.com/recipes/recipefinder.dyn?action=displayRecipe&recipe_id=1622444",
                title: "Onion and Fresh Herb Omelet with Mixed Greens",
                ingredients: "egg substitute, milk, parsley, thyme, salt, black pepper, eggs, flour, nonstick cooking spray, onions, garlic, salad greens, salad greens, red wine vinegar, olive oil, goat cheese, almonds",
                thumbnail: "")]
    }
}
