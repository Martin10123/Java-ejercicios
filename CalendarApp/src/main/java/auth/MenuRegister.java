package auth;

import java.io.*;
import java.util.ArrayList;

public class MenuRegister {

    ArrayList<User> usersRegisters;

    public MenuRegister() {
        //Constructor
        usersRegisters = new ArrayList<>();

        if (new File("listUsers.txt").exists()) {
            loadDataFromFile();
        }

    }

    public void addNewUser(User newUser) {
        usersRegisters.add(newUser);

        writeDataToFile();
    }

    public User existUser(String email, String password) {
        for (User user : usersRegisters) {
            if (user.getEmail().contains(email) && user.getPassword().contains(password)) {
                return user;
            }
        }

        return null;
    }

    private void writeDataToFile() {
        try {
            File file = new File("listUsers.txt");
            FileWriter writer = new FileWriter(file, true);

            for (User user : usersRegisters) {
                String userData = user.getName() + "; " + user.getEmail() + "; " + user.getPassword() + "; " + user.getUidUser() + "\n";
                writer.write(userData);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error en consola: " + e);
        }
    }

    private void loadDataFromFile() {
        try {
            File file = new File("listUsers.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(";");
                User user = new User(userData[0], userData[1], userData[2], userData[3]);
                usersRegisters.add(user);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
