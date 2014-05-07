Feature: Create a new recipe
I want to create a new recipe.
So that everybody can see it.
  
Scenario: Create a new recipe
    When I click "Create new recipe" in the menu bar.
    Then the application should show an input formular.
    And save the recipe after the formular is filled in.