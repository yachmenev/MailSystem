package client;

/**
 * Created by Eugene on 04.10.14.
 */
public interface IUser {

        public User createUser(String name, String pass);
        public boolean deleteUser(String name);
        public User findUser(String name);
        public boolean UpdateUser(User user);

}
