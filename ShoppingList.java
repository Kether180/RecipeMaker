import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      Map<String, Integer> availableIngredients = new TreeMap<>(); // object input of the a.ingredients
      Map<String, Integer> ingredientsForRecipe = new TreeMap<>(); // object input of the a.ingredients    /// compare boths.
      Map<String, Integer> listShoppingSpace = new TreeMap<>();

      int c = 0;
      while (input.hasNextLine()) {
        input.nextLine();
        while (input.hasNextInt()) {
          int amount = input.nextInt();
          String unit = input.next();

          String ingredients = input.next();

          if (unit.equals("kg")) {
            amount = amount * 1000; // change to gr
          }
          if (c == 0) {
            availableIngredients.put(ingredients, amount);
          }
          if (c > 0) {
            if (ingredientsForRecipe.containsKey(ingredients)) {
              int amountIngredientes =
                amount + ingredientsForRecipe.get(ingredients);
              ingredientsForRecipe.put(ingredients, amountIngredientes);
            } else ingredientsForRecipe.put(ingredients, amount);
          }
          c++;
        }
      }

      input.close();

      System.out.println("Shopping List:");

      for (String ingredientShoopingList : ingredientsForRecipe.keySet()) { // ingredients in the shopping list should be ingredients for the recipe -
        if (availableIngredients.containsKey(ingredientShoopingList)) {
          int amount =
            availableIngredients.get(ingredientShoopingList) -
            availableIngredients.get(ingredientShoopingList);

          if (amount > 0) {
            listShoppingSpace.put(ingredientShoopingList, amount);
            System.out.println(amount + " g " + ingredientShoopingList);
          }

          if (!availableIngredients.containsKey(ingredientShoopingList));
          int amount1 = availableIngredients.get(ingredientShoopingList);

          listShoppingSpace.put(ingredientShoopingList, amount1);

          System.out.println(amount + " g " + ingredientShoopingList);
        }
      }
    }
  }
}
