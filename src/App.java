import javafx.embed.swing.JFXPanel;

public class App {
    public static void main(String[] args) {
        JFXPanel fxPanel = new JFXPanel();
        View view = new View();
        Controller controller = new Controller(view);
    }
}
