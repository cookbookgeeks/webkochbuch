Feature: Guest searches a recipe
	As a Guest
	I want to type in a search word
	so that I either get a list of recipes or an explicit recipe
	
	Scenario: search recipe
		Given I have a search word
		When I type in a search word into the search panel and press ENTER
		Then a list with all corresponding recipes should appear