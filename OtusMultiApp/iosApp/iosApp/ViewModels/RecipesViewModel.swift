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
    
    private var items: [Recipe] = [Recipe]()
    
    private lazy var presenter: RecipesPresenterInterface? = {
        let presenter = RecipesPresenter()
        presenter.attachView(view: self)
        return presenter
    }()
    
    init(isMock: Bool = false) {
        presenter?.attachView(view: self)
        self.loadRecipesList()
    }
    
    func loadRecipesList() {
        self.presenter?.loadRecipes(dishName: "", ingredients: "carrot", page: 1)
    }
    
    
    // MARK: Delegates
    func setupItems(items: [Recipe]) {
        self.items = [Recipe]()
        self.items.append(contentsOf: items)
    }
    
    
    
}
