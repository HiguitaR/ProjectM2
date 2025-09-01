# **📜 Project for Module 2: Customer Management System**
This project aims to provide a practical application and integration of 
all Object-Oriented Programming (OOP) concepts covered in Module 2. You 
will design and build a basic system to manage users, differentiate their
permissions through roles, and log a history of the actions they perform.
---

## **1. User Management**
- The system must maintain a registry of several Users.

- Each User in the system must have the following associated information:
  - A Full Name.
  - A User ID that is unique to identify them in the system.
  - A Username that must also be unique and will be used for login.
  - A Password (for simplicity, this will be handled as a simple text 
  string, without applying advanced cryptographic techniques).

- The system must be capable of performing the following user-related 
operations:
  - Create new users: Add a new user to the system with their complete 
  information.
  - Search for a user: Find a specific user, primarily by their User ID
  or Username.
  - Update user information: Modify an existing user's Full Name or 
  Password. The password can only be updated if the correct current 
  password is provided (simple validation).
  - Delete a user: Remove an existing user from the system.
---

## **2. User Roles and Permissions**
- Different Roles can be assigned to users. Initially, the system must 
support at least two roles: "Administrator" and "Standard".

- Each User must have a single Role assigned within the system.

- Operations on users are restricted based on the role of the user 
attempting to perform them:
  - Only users with the "Administrator" role have permission to create,
  delete, and update any user's information in the system 
  (including other administrators).
  - Users with the "Standard" role only have permission to view and
  update their own profile information. They cannot create, delete, or
  update other users.
---

## **3. Action History**
- The system must record an Action History for each user.

- Each recorded action must include:
  - A Description of what the user did (e.g., "Logged in," "Updated 
  profile," "Created user John").
  - A Timestamp indicating when the action occurred 
  (can be a simple number like the result of System.currentTimeMillis()).

- Each User must have their own action history. The actions recorded 
for a user logically belong to that user and not to another.

- The system must allow logging an action for a specific user.

- The system must allow displaying the complete action history of a 
specific user.

---

## **4. Simulated Login**
- The system must include a basic function to simulate a login.

- This function must receive a Username and a Password.

- If the Username and Password match those of a registered user in the 
system, the function should indicate that the login was successful and
provide access to the user's information (return the user object, for 
example).

- If the credentials do not match, the function should indicate that 
the login failed.

---

## **Additional Requirements and Considerations**
- Key Recommendations for Your Implementation:

- Use Arrays to store users and actions, defining a maximum size 
(e.g., 50 users, 100 actions per user).

- Apply OOP principles:
  - Encapsulation: Protect sensitive information like passwords.
  - Inheritance: Use it if you identify natural hierarchies 
  (e.g., if roles justify subclasses).
  - Polymorphism: Allow different objects to respond differently to 
  the same operation (if you use inheritance/interfaces).
  - Abstraction: Hide internal implementation details.
  - Relationships: Correctly model the relationships between entities 
  (composition/aggregation/association).

- Perform basic validations:
  - Check for the existence of an ID/Username before operating.
  - Verify permissions based on the role before executing operations.

- Organize your code into packages and apply a layered structure 
(e.g., model, service, view/controller).

- Use Enums for roles and other fixed states.

- Follow good coding practices:
  - Clear and descriptive names.
  - Legible and commented code.
  - Include Javadoc where relevant.

- This is the canvas on which you will apply all the OOP concepts you
have learned.

Carefully analyze these requirements to design your solution!

