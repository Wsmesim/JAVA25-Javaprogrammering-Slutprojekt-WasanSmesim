import java.io.*;
import java.util.ArrayList;
import java.util.List;
//här importeras alla klasser för att lagra data och skriva den, genom ArrayList lagras användarobjekt i minnet.

public class UserManager {
    private List<User> users;
    //här lagras alla användare som är registrerade i systemet.
    private final String FILE_NAME = "users.txt";

//endast usermanager kommer åt variabeln, så att den inte används av misstag på andra ställen i programmet. (Inkapsling)
//att variebeln file name deklareras som privat final innebär att den är endast tillgänglig inom klassen och kan inte ändras efter initialisering (konstant). Skyddar data och förhindrar buggar.

    public UserManager() {
        //List<User> users; //här lagras alla användare som är registrerade i systemet.
        users = new ArrayList<>();
        loadFromFile();
    }
//Oven del är en konstruktor, läser in sparad data för att köra igång

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String username = parts[1];
                String password = parts[1];

                if (type.equals("Admin")) {
                    users.add(new Admin(username, password));
                } else {
                    users.add(new Customer(username, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoden ovan läser användare från filen users.txt och lägger till de i en lista (users). skapar ett File objekt för att kontrollera om filen finns. Om den inte finns avbryts metoden.
//BufferedReader läser filen rad för rad. Raderna förväntas ha formatet: typ, användarnamn, lösenord. IOException= om något går fel så fångas detta och stracktrace skrivs ut. Den visar programmets körningshistorik, från det första anropet till den nuvarande punkten, och används för att felsöka problem genom att identifiera var i koden felet uppstod och hur programmet kom dit.


    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User u : users) {
                writer.write( u.getUsername() + "," + u.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoden sparar alla användare från listan users till filen users.txt. BufferedWriter används för att skriva filen. alla användare i listan avgörs om de är en admin eller customer med hjälp av instanceof. Genom detta tillvägagångsätt, gör jag att användardata återställs när programmet startas om.

    public void register(String username, String password, boolean isAdmin) {
        User user = isAdmin ? new Admin(username, password) :
                new Customer(username, password);
        users.add(user);
        saveToFile();
    }
    //här skapas en ny användare som läggs till i listan users. listan sparas till en fil. Ex på polymorfism (både admin och customer ärver från users men hanteras på samma sätt).


    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) &&
                    u.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}

//loopa igenom alla users i Arraylistan, hitta matchande användarnamn, kontrollera om lösenordet stämmer, returnera true/false, kontrollera om användare finns i lsitan.
