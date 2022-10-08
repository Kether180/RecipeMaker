import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      Map<String, Integer> availableIngredients = new TreeMap<>(); // object input of the a.ingredients
      Map<String, Integer> ingredientsForRecipe = new TreeMap<>(); // object input of the a.ingredients /// compare
                                                                   // boths.
      Map<String, Integer> listShoppingSpace = new TreeMap<>();

      int nContador = 0;
      while (input.hasNextLine()) {
        input.nextLine();
        while (input.hasNextInt()) {
          int iAmount = input.nextInt();
          String sUnit = input.next();

          String sIngredients = input.next();

          if (sUnit.equals("kg")) {
            iAmount = iAmount * 1000; // change to gr
          }
          if (nContador == 0) {
            availableIngredients.put(sIngredients, iAmount);
          }
          if (nContador > 0) {
            if (ingredientsForRecipe.containsKey(sIngredients)) {
              int amountIngredientes = iAmount + ingredientsForRecipe.get(sIngredients);
              ingredientsForRecipe.put(sIngredients, amountIngredientes);
            } else
              ingredientsForRecipe.put(sIngredients, iAmount);
          }
          nContador++;
        }
      }

      input.close();

      System.out.println("Shopping List:");

      for (String ingredientShoopingList : ingredientsForRecipe.keySet()) { // ingredients in the shopping list should
                                                                            // be ingredients for the recipe -
        if (availableIngredients.containsKey(ingredientShoopingList)) {
          int iAmount = availableIngredients.get(ingredientShoopingList) -
              availableIngredients.get(ingredientShoopingList);

          if (iAmount > 0) {
            listShoppingSpace.put(ingredientShoopingList, iAmount);
            System.out.println(iAmount + " g " + ingredientShoopingList);
          }

          if (!availableIngredients.containsKey(ingredientShoopingList))
            ;
          int iAmountA = availableIngredients.get(ingredientShoopingList);

          listShoppingSpace.put(ingredientShoopingList, iAmountA);

          System.out.println(iAmount + " g " + ingredientShoopingList);
        }
      }
    }

  }
}
