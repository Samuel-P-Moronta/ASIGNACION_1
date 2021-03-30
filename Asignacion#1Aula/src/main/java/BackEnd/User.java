package BackEnd;

public class User {
    /*Atributos del usuario, segun los requerimientos*/
    /*Un formulario con los campos de usuario y contraseña.*/
    private String user;
    private String password;

    public User() {

    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
