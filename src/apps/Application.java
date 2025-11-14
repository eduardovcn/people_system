package apps;

import extensions.Routes;
import java.util.Scanner;
import database.*;

public class Application {
    public static void main(String[] args) {
        CriacaoDb.inicializarBanco();

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
