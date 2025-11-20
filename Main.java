public class Main {
    public static void main(String[] args){
        UserManager manager = new UserManager();
        manager.loadFromFile();
        new LoginFrame(manager);

    }
}



