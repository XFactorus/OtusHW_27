import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    
    @ObservedObject var rmListViewModel: RecipesViewModel = RecipesViewModel()
    
    var body: some View {
        Text(greet())
//            .onAppear {
//                rmListViewModel.loadRecipesList()
//            }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
