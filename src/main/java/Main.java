import com.project.management.console.Console;
import com.project.management.console.Controller;
import com.project.management.console.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        View view= new Console();
        Controller controller = new Controller(view);
        controller.askMainOption();
    }
}
