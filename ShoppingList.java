import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<String, Integer> availableIngredients = new TreeMap<>();
        Map<String, Integer> ingredientsForRecipe = new TreeMap<>();
        Map<String, Integer> listShoppingSpace = new TreeMap<>();

        int contador = 0;
        while (input.hasNextLine()) {
            input.nextLine();
            while (input.hasNextInt()) {
                int amount = input.nextInt();
                String unit = input.next();
                String ingredients = input.next();
                if (unit.equals("kg")) {
                    amount = amount * 1000;
                }
                if (contador == 0) {
                    availableIngredients.put(ingredients, amount);
                }
                if (contador > 0) {
                    if (ingredientsForRecipe.containsKey(ingredients)) {
                        int amountVar = amount + ingredientsForRecipe.get(ingredients);
                        ingredientsForRecipe.put(ingredients, amountVar);
                    } else {
                        ingredientsForRecipe.put(ingredients, amount);
                    }
                }
            }
            contador++;
        }
        input.close();

        System.out.println("Shopping List:");

        for (String ingredientsForShoppingList : ingredientsForRecipe.keySet()) {

            if (availableIngredients.containsKey(ingredientsForShoppingList)) {
                int amount = availableIngredients.get(ingredientsForShoppingList)
                        - availableIngredients.get(ingredientsForShoppingList);
                if (amount > 0) {
                    listShoppingSpace.put(ingredientsForShoppingList, amount);
                    System.out.println(amount + " g " + ingredientsForShoppingList);
                }
            }
            if (!availableIngredients.containsKey(ingredientsForShoppingList)) {
                int amount = ingredientsForRecipe.get(ingredientsForShoppingList);
                listShoppingSpace.put(ingredientsForShoppingList, amount);
                System.out.println(amount + " g " + ingredientsForRecipe);
            }

        }
    }

}