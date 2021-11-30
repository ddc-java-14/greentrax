---
title: Overview page
description: Project summary, documentation, intend user.
menu: Overview
order: 0
---


## Summary

_GreenTrax_ is a simple Android App, intended for use by individuals looking to track their monthly expenses coming in and going out while being able to visualize in an accessible format.
Initial implementation of this app will allow users to manually input their account info along with transactions and create a budget based off these categories. 

I chose this particular application because I knew it would be a challenge which definitely lived up to my expectations. 

The app will store information about transactions such as time created, type, and will even allow for notes. Users will also receive an easy-to-understand summary of previous spending habits. Stretch goals include adding an API that allows users to connect with their bank accounts along with the addition of a Camera API that will allow a user to take pictures of receipts for easy uploading. 





## Intended users

- A college student that is looking to budget appropriately for the semester.

  > As a new college student just learning to manage my own budget, it would be nice to have the ability to enter my finances for the month and have them organized in a simple yet efficient way that allows me to understand my spending habits. 

- Individuals who are looking to understand their spending habits.

  > As someone who has always struggled with having enough money at the end of the month, being able to record my expenses and having them organized in an understandable way would help me trim my budget.  


## Functionality

- Input of monthly expense including outgoing expenses
- Date and Time of incoming/outgoing expenses
- Organization of expenses into different categories (Rent,Utilities, Groceries, Important Bills, Vacations, etc.)
- Representation of monthly expenses in an easy-to-read format.
- Simple interface to allow users to quickly understand their budget



## Persistent data

- Monthly expenses
- Current cash flow
- Past monthly expenses
- Recent Entries
- Past Selections
- Names and categories

## Device/external services

- Use Google Sign In to identify current user.




## Stretch goals/possible enhancements 

- Take a photo to upload receipts/bills for easy recording. The Camera API seems promising.
  - [Camera API](https://developer.android.com/guide/topics/media/camera)
    - This feature is an added convenience and the app will be fully functional without this feature.
- Import information from bank accounts to have up-to-date spending records. 
  - [Plaid API](https://plaid.com/docs/api/) 
    - This is another feature for added convenience as the user will still be able to manually input all this information if desired.
- Import current credit score 
- Supporting multiple users on the same device

