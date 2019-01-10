Feature: Create, edit, complete and delete todo
  Story: Customer create todo, after that edit todo and complete todo, at the end delete todo
  Scenario: Create new todo, edit todo, complete todo and delete todo
    Given Open todos site
    When Create todo 'Simple testing todo 0001'
    And Edit todo 'Simple testing todo 0001' with name 'Simple edited testing todo 0001'
    And Complete todo 'Simple edited testing todo 0001'
    Then Delete todo 'Simple edited testing todo 0001'