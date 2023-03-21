
package biblioteca;


public interface ItemBiblioteca {
    // IMPLICITAMENTE STATIC E FINAL
    int diasEmprestimo = 10;
    
    // TODOS OS METODOS EM UMA INTERFACE SÃO PUBLICOS E ABSTRATOS
    boolean estaEmprestado();
    
    void emprestar();
    
    void devolver();
    
    String localizacao();
}
