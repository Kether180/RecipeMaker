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
                int iAmount = input.nextInt();
                String sUnit = input.next();
                String sIngredients = input.next();
                if (sUnit.equals("kg")) {
                    iAmount = iAmount * 1000;
                }
                if (contador == 0) {
                    availableIngredients.put(sIngredients, iAmount);
                }
                if (contador > 0) {

                    if (ingredientsForRecipe.containsKey(sIngredients)) {

                        int iAmountA = iAmount + ingredientsForRecipe.get(sIngredients);
                        ingredientsForRecipe.put(sIngredients, iAmountA);
                    } else {
                        ingredientsForRecipe.put(sIngredients, iAmount);
                    }
                }
            }
            contador++;
        }
        input.close();

        System.out.println("Shopping List:");

        for (String ingredientsForShoppingList : ingredientsForRecipe.keySet()) {

            if (availableIngredients.containsKey(ingredientsForShoppingList)) {
                int iAmount = ingredientsForRecipe.get(ingredientsForShoppingList)
                        - availableIngredients.get(ingredientsForShoppingList);
                if (iAmount > 0) {
                    listShoppingSpace.put(ingredientsForShoppingList, iAmount);
                    System.out.println(iAmount + " g " + ingredientsForShoppingList);
                }
            }
            if (!availableIngredients.containsKey(ingredientsForShoppingList)) {
                int iAmount = ingredientsForRecipe.get(ingredientsForShoppingList);
                listShoppingSpace.put(ingredientsForShoppingList, iAmount);
                System.out.println(iAmount + " g " + ingredientsForShoppingList);
            }

        }
    }

}