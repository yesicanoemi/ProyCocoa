/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosario
 */
public class main {
    
    public static void main(String[] args) {        
        main nuevo=new main();
        String texto="";
        try {
            nuevo.generarLexico();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
                nuevo.generarArchivo();
        
        
    }
    List<Token> listTokens;
    public void generarLexico()throws IOException{
        int contIDs=0;         
        listTokens=new LinkedList<Token>();
        
        Reader leer=new BufferedReader(new FileReader("src\\proyectococoa\\prueba.txt"));
        Lexico lexer=new Lexico(leer);
        String resultado="";
        while(true){
            Token Ntoken = new Token();
            Identificador ident=lexer.yylex();
            if(ident==null){
                   return;
            }
            switch (ident){
               
                case ERROR:
                    resultado=resultado+"Error,simbolo no encontrado";
                    break;
                case NUMERO:                    
                    Ntoken.identificador="NUMERO";
                    Ntoken.cadena=lexer.clasif;                    
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                   
                    break;
                case RESERVADA:
                  // Token Ntoken=new Token();
                    Ntoken.identificador="RESERVADA";
                    Ntoken.cadena=lexer.clasif;                    
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    
                    break;
                 case OPERADOR:
                    Ntoken.identificador="OPERADOR";
                    Ntoken.cadena=lexer.clasif;                    
                    listTokens.add(Ntoken);
                    resultado = resultado + "<" + lexer.clasif + ">";
                    break;
                case ID:
                    Ntoken.identificador = "ID";
                    Ntoken.cadena = lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado = resultado + "<" + lexer.clasif + ">";
                    break;
                case COMENTARIOS:
                    Ntoken.identificador = "COMENTARIOS";
                    Ntoken.cadena = lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado = resultado + "<" + lexer.clasif + ">";                    
                    break;
                case ESPACIOS:
                    Ntoken.identificador="ESPACIOS";
                    Ntoken.cadena=lexer.clasif;                    
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;    
                case ESPECIALES:
                    Ntoken.identificador="ESPECIALES";
                    Ntoken.cadena=lexer.clasif;                    
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;
                case FNLINEA:
                    Ntoken.identificador="FNLINEA";
                    Ntoken.cadena=lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;
                case UNESPACIO:
                    Ntoken.identificador="UNESPACIO";
                    Ntoken.cadena=lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;
                case DOSESPACIOS:
                    Ntoken.identificador="DOSESPACIOS";
                    Ntoken.cadena=lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;
                case TABULADOR:
                    Ntoken.identificador="TABULADOR";
                    Ntoken.cadena=lexer.clasif;
                    listTokens.add(Ntoken);
                    resultado=resultado+"<"+lexer.clasif+">";
                    break;
            }
        }        
    }
    public void generarArchivo(){
      
        String nombreArchivo= "src\\proyectococoa\\AL.txt"; // Aqui se le asigna el nombre y 
        FileWriter fw = null;	// la extension al archivo 
        try { 
            fw = new FileWriter(nombreArchivo); 
            BufferedWriter bw = new BufferedWriter(fw); 
            PrintWriter salArch = new PrintWriter(bw); 
           
            for(int i=0;i<listTokens.size();i++){
                System.out.println("<"+listTokens.get(i).identificador+","+listTokens.get(i).cadena+">");
                salArch.print("<"+listTokens.get(i).identificador+","+listTokens.get(i).cadena+">");
                salArch.println();                
            }
            salArch.close(); 
        }catch (IOException ex) { 
        } 
    }
}
