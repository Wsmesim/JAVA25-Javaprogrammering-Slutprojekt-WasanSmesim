public abstract class User { //abstract för att man inte ska kunna skapa User-objekt direkt. User är en mall som ska ärva från Admin och Customer.
        private String username; //detta läggs till i superklassen för att de ska båda ha samma inloggningsdata
        private String password; //detta läggs till i superklassen för att de ska båda ha samma inloggningsdata

    public  User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username){
        this.username = username;
    }
    //Getter och Setter
    //alla användare kan hanteras polymorfiskt via user- typen.


    public String getPassword() {
     return password;
    }
     public void setPassword(String password) {
    this.password = password;
    }

    }






