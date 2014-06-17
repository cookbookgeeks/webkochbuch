Feature: Member rates a recipe
As a Member
I want to rate a recipe
so that other users can see the quality of the recipe
Scenario: rate recipe
Given I am logged in
When I choose my rating by clicking on the amount of stars I want to give
Then the website should say "Ihre Bewertung wurde erfolgreich übernommen"