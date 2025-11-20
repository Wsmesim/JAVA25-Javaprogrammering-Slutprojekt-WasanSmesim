public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public String getUserType() {
        return "Admin";
    }
}
//här skapas nytt objekt, om isAdmin == true så registeras en ny admin (new Admin/samma sak med customer), den nya läggs till i Arraylist och filen sparas.

