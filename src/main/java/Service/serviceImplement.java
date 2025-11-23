package Service;

import Model.Role;
import Model.User;

/**
 * Interface that defines a set of methods to manage user-related operations.
 * This includes user authentication, viewing user history, and performing
 * administrative tasks such as creating, updating, and deleting users.
 * The interface also provides methods to update user's personal details.
 * Functionalities are divided into:
 * - General Users: Authentication and viewing user-specific history.
 * - Admin Services: Higher-level management such as creating, updating, or
 *   deleting users.
 * - User Services: Updating personal details such as name and password.
 */
public interface serviceImplement {

    //General Users

    /**
     * Authenticates a user based on their username and password.
     * Validates the provided credentials and returns a matching user object
     * if the authentication is successful.
     *
     * @param userName the username of the user attempting to log in
     * @param userPassword the password associated with the username
     * @return the authenticated User object if credentials are valid;
     *         otherwise, returns null
     */
    User logging(String userName, String userPassword);

    /**
     * Displays the history of actions performed by the given user.
     * If the user has any recorded actions, they will be printed; otherwise,
     * a message indicating no available history is displayed.
     *
     * @param currentUser the user whose history is to be displayed; must not be null
     */
    void showHistory(User currentUser);

    //Admin service

    /**
     * Creates a new user in the system. This operation can only be
     * performed by an administrator. The method validates the
     * provided input parameters before creating the user.
     *
     * @param currentUser the user performing the operation; must have the ADMIN role
     * @param fullName the full name of the new user
     * @param id the unique identifier for the new user
     * @param userName the username for the new user; must be unique
     * @param password the password for the new user
     * @param role the role assigned to the new user
     * @return true if the user is successfully created; false otherwise
     */
    Boolean createUser(User currentUser, String fullName, Integer id, String userName,
                       String password, Role role);

    /**
     * Updates the full name of a user identified by their unique ID. This operation
     * can only be performed by an authorized user with appropriate permissions.
     *
     * @param currentUser the user performing the update operation; must not be null
     * @param newfullName the new full name to assign to the user; must not be null or empty
     * @param userId the unique ID of the user whose name is to be updated; must not be null
     * @return true if the user's name is successfully updated; false otherwise
     */
    Boolean updateUserName(User currentUser, String newfullName,
                           Integer userId);

    /**
     * Updates the password of a user identified by their unique ID. This operation
     * can only be performed by an authorized user with appropriate permissions. The
     * new password must meet the required security standards.
     *
     * @param currentUser the user performing the update operation; must not be null
     * @param newPassword the new password to assign to the user; must not be null or empty
     * @param userId the unique ID of the user whose password is to be updated; must not be null
     * @return true if the user's password is successfully updated; false otherwise
     */
    Boolean updateUserPassword(User currentUser, String newPassword,
                               Integer userId);

    /**
     * Deletes a user from the system based on their username. This operation can only
     * be performed by an authorized user with appropriate permissions. The method validates
     * the current user's role and the existence of the specified username before performing
     * the deletion.
     *
     * @param currentUser the user performing the delete operation; must have the ADMIN role
     * @param userName the username of the user to be deleted; must not be null or empty
     * @return true if the user is successfully deleted; false otherwise
     */
    Boolean deleteUser(User currentUser, String userName);



    //User service

    /**
     * Updates the name of the specified user if the provided password is correct.
     * This operation validates the user's credentials before updating their name.
     *
     * @param currentUser the user attempting to update their name; must not be null
     * @param password the current password of the user; must not be null or empty
     * @param newName the new name to assign to the user; must not be null or empty
     * @return true if the user's name is successfully updated; false otherwise
     */
    Boolean updateName(User currentUser, String password, String newName);

    /**
     * Updates the password of the given user. This method validates the
     * user's current password before updating it to the new password. The
     * new password must meet the required security standards.
     *
     * @param currentUser the user requesting the password update; must not be null
     * @param oldPassword the current password of the user; must not be null or empty
     * @param newPassword the new password to set for the user; must not be null or empty
     * @return true if the password is successfully updated; false otherwise
     */
    Boolean updatePassword(User currentUser, String oldPassword, String newPassword);

}
