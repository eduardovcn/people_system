package apps;

import extensions.Routes;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Routes routes = new Routes(input);

        int opcao;
        do {
            opcao = routes.menuPrincipal();
            routes.opcaoSelecionada(opcao);
        } while (opcao != 0);

        input.close();
    }
}
