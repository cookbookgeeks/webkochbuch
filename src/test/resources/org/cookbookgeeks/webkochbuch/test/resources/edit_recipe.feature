Feature: Edit a recipe
I want to edit a recipe
So that the recipe is more delicious

Scenario: press the edit-recipe-button
Given I am on the Page of a recipe
When I press the edit-recipe-button
Then I should be forwarded to a formular site in which I can edit my recipe

Scenario: save changes
Given I am on the edit-recipe-formular
When I press the save-button
Then the changes should be saved and the recipe should be shown