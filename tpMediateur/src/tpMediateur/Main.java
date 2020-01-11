package tpMediateur;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	static Connection conn;
	static Statement state;
	static ResultSet result;
	static ResultSetMetaData resultMeta;
	static Object[][] donn;
	static String[] champs;
	static Object[] val;
	static String tableBDD = "albumliste";

	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	
	                String BDD = "tpMediateur";
	                String url = "jdbc:mysql://localhost:3306/" + BDD;
	                String user = "root";
	                String passwd = "";
	               
	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection conn = DriverManager.getConnection(url, user, passwd);
	                    System.out.println("Connecter");
	                 // D�claration de la connexion avec la base de donn�e
	                    Statement state = conn.createStatement();
	                    //L'objet ResultSet contient le r�sultat de la requ�te SQL
	                    ResultSet result = state.executeQuery("SELECT * FROM albumliste");
	                    //On r�cup�re les MetaData
	                    ResultSetMetaData resultMeta = result.getMetaData();
	                     
	                    // Affiche d'un s�parateur visuel (oui, c'est pas tr�s propre, mais libre � vous de le modifi�)
	                    System.out.println("\n*************************************************************");
	                                        
	                    // On affiche le nom des colonnes
	                    for(int i = 1; i <= resultMeta.getColumnCount(); i++) 
	                    System.out.print("  " + resultMeta.getColumnName(i).toUpperCase() + " ");
	                                        
	                    // Un nouveau s�parateur visuel
	                    System.out.println("\n*************************************************************");
	                     
	                    // On affiche les donn�es ligne par ligne
	                    while(result.next()){
	                       for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	                       System.out.print("      " + result.getObject(i).toString() + "      ");
	                       System.out.println("\n-------------------------------------------------------------");
	                    }
	                     
	                    // On ferme tout les connexion � la base de donn�es
	                    result.close();
	                    state.close();
	                } catch (Exception e){
	                    e.printStackTrace();
	                    System.out.println("Erreur");
	                    System.exit(0);
	                }
	            }
	        });

	}

}