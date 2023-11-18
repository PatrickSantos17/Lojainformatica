/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class ComputadorDAO {

    static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    static String login = "root";
    static String senha = "201311";

    public static boolean salvar(Computador computador) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            //Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir Conecão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("INSERT INTO lojainformatica (hd, processador) values(?,?) " ,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, computador.getHd());
            comandoSQL.setString(2, computador.getProcessador());

            //Executar o comando SQl
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return retorno;
    }
    
    public static ArrayList<Computador> listar(){
        ArrayList<Computador> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        
        try {
            // Passo 1: Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2: Abri a conexão com o mySQL
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Prepara o comando SQL
            comandoSQL= conexao.prepareStatement("SELECT  * FROM lojainformatica");
            
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                // Percorres as linhas do result set
                while(rs.next()){
                    Computador item = new Computador();
                    item.setIdComputador(rs.getInt("idComputador"));
                    item.setHd(rs.getString("HD"));
                    item.setProcessador(rs.getString("processador"));
                    
                    lista.add(item);
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return lista;
    }
      public static ArrayList<Computador> buscarPorProcessador(String buscaProcessador){
        ArrayList<Computador> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        
        try {
            // Passo 1: Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2: Abri a conexão com o mySQL
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Prepara o comando SQL
            comandoSQL= conexao.prepareStatement("SELECT  * FROM lojainformatica WHERE Processador = ?");
            comandoSQL.setString(1, buscaProcessador);
            //Executa Comando SQL
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                // Percorres as linhas do result set
                while(rs.next()){
                    Computador item = new Computador();
                    item.setIdComputador(rs.getInt("idComputador"));
                    item.setHd(rs.getString("HD"));
                    item.setProcessador(rs.getString("processador"));
                    
                    lista.add(item);
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return lista;
    }
     public static boolean alterar(Computador computadorAlterar) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            //Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir Conecão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("UPDATE lojainformatica SET hd = ?, processador = ? WHERE idcomputador = ? ");
            comandoSQL.setString(1, computadorAlterar.getHd());
            comandoSQL.setString(2, computadorAlterar.getProcessador());
            comandoSQL.setInt(3,computadorAlterar.idComputador);

            //Executar o comando SQl
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return retorno;
    }
     
     public static boolean excluir(int idExcluir) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            //Carregar o Drive
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir Conecão com o Banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("DELETE FROM lojainformatica WHERE idcomputador = ? ");
            comandoSQL.setInt(1, idExcluir);

            //Executar o comando SQl
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return retorno;
    }

}
