---
title: Summary of Current State
description: Current State, Aesthetic Enhancements and Stretch Goals.
menu: Current State
order: 2
---


## Summary of Current State of App

The application is still in very basic stages of implementation. At this point a user is able to login via Google Sign-in and select the account button. This takes them to a budget fragment that allows them to select a spending type and enter an amount with an optional note. There are still major functions that need to be implemented such as:

- Displaying the stored spending item as a list within the budget fragment
- Refactoring/removing unnecessary classes
- Implementing functional navigation
- Implementing functional settings with user preferences
- Getting Data to populate in Day, Week, and Month categories
- Implementation of some sort of analytics to display spending data in Graphs
- Proper Javadoc Documentation


## Aesthetic Enhancements

Overall I'm pleased with the UI but there are some things that will make the overall user experience better such as:

- Color coded summary of budgets displayed at the top to match specific categories
- Ability for the user to change color to match their preferences
- Icons for all fragments & displays
- More aesthetically pleasing tool-bar
- Ability to add pictures to input screens

## Stretch goals/possible enhancements

- Import information from bank accounts to have up-to-date spending records.
    - [Plaid API](https://plaid.com/docs/api/)
- Take a photo to upload receipts/bills for easy recording. The Camera API seems promising.
    - [Camera API](https://developer.android.com/guide/topics/media/camera)
- Import current credit score
- Supporting multiple users on the same device