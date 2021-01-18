//
//  RecipeCell.swift
//  iosApp
//
//  Created by Vladyslav Pokryshka on 18.01.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import Kingfisher

struct RecipeCell: View {
    @State var recipe: Recipe
    
    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                HStack {
                    Text(recipe.title ?? "Undefined")
                        .font(.headline)
                        .lineLimit(2)
                        .multilineTextAlignment(.leading)
                    if let thumbnail = recipe.thumbnail, !thumbnail.isEmpty {
                        Spacer()
                        KFImage(URL(string: thumbnail)!)
                            .resizable()
                            .frame(width: 80, height: 80)
                            .aspectRatio(contentMode: .fit)
                    } else {
                        EmptyView()
                    }
                }
                VStack(alignment: .leading) {
                    Text("Ingredients:")
                    Text(recipe.ingredients ?? "Undefined")
                        .font(.callout)
                }
            }
            .padding()            
        }
        .contentShape(Rectangle())
    }

}

struct RecipeCell_Previews: PreviewProvider {
    static var previews: some View {
        RecipeCell(recipe: RecipesViewModel.getMockRecipes().first!)
    }
}
