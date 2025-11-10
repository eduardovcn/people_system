package apps;

import extensions.*;
import Models.*;
import java.time.LocalDate;


public class Application {
    public static void main(String[] args) {
        /// Scanner input = new Scanner("");


            Funcionario funcionario1 = new Funcionario();

            funcionario1.cadastrarFuncionario("Eduardo Vitor", LocalDate.of(2025, 11, 8), new Telefone("55","83","998252743"), "eduardovcn74@gmail.com", new Endereco("Deputado Geraldo Mariz", "Casa", "Tambauzinho", "João Pessoa", "714", "58042060"));



    }
}
