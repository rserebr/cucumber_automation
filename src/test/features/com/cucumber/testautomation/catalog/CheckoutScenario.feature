@web
Feature: [Checkout] Buy some goods

    Background: Create unique user
        Given the "Front Page" page is shown
        Given the user clicks on "Sign in" link on header block
        And the "Authentication" block is shown
        When the user enters "@UNIQUE" into "Email Address" field on Authentication block
        And the user clicks on "Create an account" button on Authentication block
        Then the "Create An Account" block is shown
        When the user fills in all mandatory fields
        And the user clicks on "Register" button on Authentication block
        Then the "My Account" block is shown

    Scenario: Select items through the Search field and checkout
        Given the user enters "blouse" into Search field on header block
        And the user clicks on "Search" button on header block
        And the Search header shows "BLOUSE" and "1 result has been found."
        And the product list grid contains "Blouse" item
        When the user clicks on "Add to cart" button against "Blouse" item on product list grid
        Then the "Product Layer Cart" is shown
        When the user clicks on "Proceed to Checkout" button on Product Layer Cart
        Then the "Summary" form is shown on Checkout page
        When the user clicks on Proceed to checkout button on "Summary" form
        Then the "Address" form is shown on Checkout page
        When the user clicks on Proceed to checkout button on "Address" form
        Then the "Shipping" form is shown on Checkout page
        When the user clicks on "Agree" checkbox on Shipping form
        And the user clicks on Proceed to checkout button on "Shipping" form
        Then the "Payment" form is shown on Checkout page
        When the user clicks on "Pay by Bank wire" button on Payment form
        And the user clicks on "I confirm my order" button on Payment form
        Then the "Your order on My Store is complete." is shown on the Payment page

    Scenario: Select items through the basket configuration and checkout
        Given the user navigates with top menu to "Dresses"
        And the "Category block" is shown
        When the user clicks on "Casual Dresses" on Category block
        Then the "Product List grid" is shown
        And the product list grid contains "Printed Dress" item
        When the user clicks on "Add to cart" button against "Printed Dress" item on product list grid
        Then the "Product Layer Cart" is shown
        When the user clicks on "Proceed to Checkout" button on Product Layer Cart
        Then the "Summary" form is shown on Checkout page
        When the user clicks on Proceed to checkout button on "Summary" form
        Then the "Address" form is shown on Checkout page
        When the user clicks on Proceed to checkout button on "Address" form
        Then the "Shipping" form is shown on Checkout page
        When the user clicks on "Agree" checkbox on Shipping form
        And the user clicks on Proceed to checkout button on "Shipping" form
        Then the "Payment" form is shown on Checkout page
        When the user clicks on "Pay by Bank wire" button on Payment form
        And the user clicks on "I confirm my order" button on Payment form
        Then the "Your order on My Store is complete." is shown on the Payment page