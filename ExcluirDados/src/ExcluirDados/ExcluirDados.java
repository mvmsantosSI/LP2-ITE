package ExcluirDados;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirDados {

    static final String banco = "jdbc:mysql://localhost:3307/agenciaviagens";
    
    public static void main(String[] args) {
        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhaexclusao = null;
        
        try {
            conexao = DriverManager.getConnection(banco,"root","");
            consulta = conexao.createStatement();
            
            resultados = consulta.executeQuery("Select * from turista");
            
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();
            System.out.println("informações do Banco de dados");
            
            minhaexclusao = conexao.prepareStatement("delete from turista where codigo = ?");
            
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o código do turista a ser excluído"));
            
            minhaexclusao.setInt(1,codigo);
            minhaexclusao.executeUpdate();
                while (resultados.next()){
                    for (int i=1; i <= numeroColunas; i++)
                        System.out.println("dados " + resultados.getObject(i));
                        System.out.println();
                            System.out.println("Dados Excluídos com sucesso");
                }
        }
       catch (SQLException erro){
           erro.printStackTrace();
       }
       finally {
            try{
                resultados.close();
                consulta.close();
                conexao.close();
            }
        catch (Exception erronovo) {
            erronovo.printStackTrace();
        }
        }
        
    }
    
}
