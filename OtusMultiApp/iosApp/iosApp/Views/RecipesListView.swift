import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct RecipesListView: View {
    
    @ObservedObject var recipesViewModel: RecipesViewModel = RecipesViewModel()
    
    @State private var dish: String = ""
    @State private var ingredients: String = ""
    
    var body: some View {
        VStack {
            VStack {
                TextField("Enter dish name", text: $dish)
                TextField("Enter ingredients (separated by comas", text: $ingredients)
                Button(action: {
                    recipesViewModel.searchDish(dishName: self.dish,
                                                ingredients: self.ingredients)
                }, label: {
                    Text("Search dish!")
                })
            }.padding()
            List(self.recipesViewModel.recipeItems) { recipe in
                RecipeCell(recipe: recipe)
                    .onAppear() {
                        if self.recipesViewModel.recipeItems.isLast(recipe) {
                            self.recipesViewModel.fetchPage()
                        }
                    }
                    .onTapGesture {
                        print("Recipe tapped")
                        UIApplication.shared.open(URL(string: recipe.href)!)
                    }
            }
        }
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        RecipesListView(recipesViewModel: RecipesViewModel(isMock: true))
    }
}
