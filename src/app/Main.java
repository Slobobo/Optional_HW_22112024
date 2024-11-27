package app;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Bob", "www.Bob.gmail.com"));
        userRepository.addUser(new User(2, "Bill", "www.Bill.gmail.com"));
        userRepository.addUser(new User(3, "Ben", "www.Ben.gmail.com"));

        findUserByIdAndPrint(userRepository, 2);
        findUserByEmailAndPrint(userRepository, "WWW.ben.gmail.com");
        findAllUserAndPrint(userRepository);

    }

    private static void findUserByIdAndPrint(UserRepository userRepository, int id) {
        userRepository.findUserById(id)
                .ifPresentOrElse(
                        user -> System.out.println("Found user by id: " + user),
                        () -> System.out.println("User with id " + id + " not found")
                );
    }

    private static void findUserByEmailAndPrint(UserRepository userRepository, String email) {
        userRepository.findUserByEmail(email)
                .ifPresentOrElse(
                        user -> System.out.println("Found user by email: " + user),
                        () -> System.out.println("User with email " + email + " not found")
                );
    }

    private static void findAllUserAndPrint(UserRepository userRepository) {
        userRepository.findAllUsers()
                .ifPresentOrElse(
                        userList -> System.out.println("Total users: " + userList.size()),
                        () -> System.out.println("No users found")
                );
    }
}
