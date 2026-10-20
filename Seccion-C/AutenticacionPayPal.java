package Taller3_Team1_SOLID.SeccionC;

public class AutenticacionPayPal {

    private boolean loggedIn;

    public boolean iniciarSesion() {
        // Verificar credenciales
        loggedIn = true;
        return loggedIn;
    }
}
