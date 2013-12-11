Feature: Guest opens a recipe
As a Guest
I want to open a recipe
so that I can read a recipe

Scenario: type link in
	Given I have a hyperlink to an existing recipe
	When I open a hyperlink to a recipe
	Then the Website with the requested recipe appears 