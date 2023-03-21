
package biblioteca;


public class Biblioteca {


    public static void main(String[] args) {
        LivroBiblioteca java = new LivroBiblioteca("Java Como Programar "," Deitel ", 1200 , " Estante A");
        
        java.emprestar();
        System.out.println("Indicador de emprestimo do livro " + java.estaEmprestado());
        System.out.println(java);//possivel através do método toString()
        
        System.out.println("Livro devolvido");
        java.devolver();
        System.out.println("Indicador de emprestimo do livro " + java.estaEmprestado());
        System.out.println(java.toString());
    }
    
}
