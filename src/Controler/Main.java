package Controler;

import Controler.SystemController;
import Model.SinalRepository;
import Model.UsuarioRepository;
import View.ConsoleView;
/* Contas: admin@ines.gov.br senha: admin123
 *  conta: joao@gmail.com senha:aluno123
 */
public class Main {
 public static void main(String[] args) {
     SinalRepository sinalRepo = new SinalRepository();
     UsuarioRepository usuarioRepo = new UsuarioRepository();
     
     ConsoleView view = new ConsoleView();
     
     SystemController controller = new SystemController(sinalRepo, usuarioRepo, view);
     
     controller.iniciar();
 }
}