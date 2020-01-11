package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/contactbd";
	
	public String addContact( final String firstName, final
			String lastName, final String email, final String mobile,
			final String fixe, final String rue, final String ville, final String cp,
			final String pays, final int groupe) {
			try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// adding a new contact
			final PreparedStatement lPreparedStatementCreation =
			lConnection.prepareStatement("INSERT INTO contact(FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER_MOBILE, PHONENUMBER_FIX,"
					+ "RUE,VILLE, CODE_POSTAL, PAYS, GROUP_ID) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			//lPreparedStatementCreation.setLong(1, id);
			lPreparedStatementCreation.setString(1, firstName);
			lPreparedStatementCreation.setString(2, lastName);
			lPreparedStatementCreation.setString(3, email);
			lPreparedStatementCreation.setString(4, mobile);
			lPreparedStatementCreation.setString(5, fixe);
			lPreparedStatementCreation.setString(6, rue);
			lPreparedStatementCreation.setString(7, ville);
			lPreparedStatementCreation.setString(8, cp);
			lPreparedStatementCreation.setString(9, pays);
			lPreparedStatementCreation.setInt(10, groupe);
			lPreparedStatementCreation.executeUpdate();
			return null;
			} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
			} catch (SQLException e) {
			return "SQLException : " + e.getMessage();
			}
			}
	
	public String addGroup( final String groupName) {
			try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource)
			lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// adding a new contact
			final PreparedStatement lPreparedStatementCreation =
			lConnection.prepareStatement("INSERT INTO GROUPE(GROUPNAME) VALUES( ?)");
			//lPreparedStatementCreation.setInt(1, id);
			lPreparedStatementCreation.setString(1,groupName);
			lPreparedStatementCreation.executeUpdate();
			return null;
			} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
			} catch (SQLException e) {
			return "SQLException : " + e.getMessage();
			}
			}
	
	public String deleteGroup(final String groupName) {
		try {
		final Context lContext = new InitialContext();
		final DataSource lDataSource = (DataSource)
		lContext.lookup(RESOURCE_JDBC);
		final Connection lConnection = lDataSource.getConnection();
		// adding a new contact
		final PreparedStatement lPreparedStatementCreation =
		lConnection.prepareStatement("DELETE FROM GROUPE WHERE GROUPNAME=?");
		lPreparedStatementCreation.setString(1,groupName);
		lPreparedStatementCreation.executeUpdate();
		return null;
		} catch (NamingException e) {
		return "NamingException : " + e.getMessage();
		} catch (SQLException e) {
		return "SQLException : " + e.getMessage();
		}
		}
	
	public List<Contact> searchContact(final String motcle){
        List<Contact> lesContacts = new ArrayList<Contact>();
            try {
                    final Context lContext = new InitialContext(); 
                    final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                    final Connection lConnection = lDataSource.getConnection();
                    final String mot_cle=motcle+"%";
                     // delete a  contact
                    final PreparedStatement stmt =lConnection.prepareStatement("SELECT * FROM CONTACT WHERE FIRSTNAME LIKE ? UNION SELECT * FROM CONTACT WHERE LASTNAME LIKE ?");
                    stmt.setString(1, mot_cle);

                stmt.setString(2, mot_cle);  

                    ResultSet rs =stmt.executeQuery();

                  while(rs.next()) {
                            int contactId = rs.getInt("ID_CONTACT");
                            String prenom = rs.getString("FIRSTNAME");
                            String lastname = rs.getString("LASTNAME");
                            String email = rs.getString("EMAIL");
                            String mobile = rs.getString("PHONENUMBER_MOBILE");
                            String fixe = rs.getString("PHONENUMBER_FIX");
                            String rue = rs.getString("RUE");
                            String ville = rs.getString("VILLE");
                            String cp= rs.getString("CODE_POSTAL");
                            String pays = rs.getString("PAYS");
                            lesContacts.add(new Contact(contactId, prenom, lastname, email,mobile,fixe,rue,ville,cp, pays));
                  }}
            catch (SQLException e) {
                    throw new RuntimeException(e);
                    } catch (NamingException e) {
                    e.printStackTrace();
                    }
                    return lesContacts;
                    }

	
	public String updateGroup(final String groupName, final int idGroup) {
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// adding a new contact
			final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE groupe SET GROUPNAME=? WHERE ID_GROUP = ? ");

			lPreparedStatementEdit.setString(1, groupName);
		    
		    lPreparedStatementEdit.setLong(2, idGroup);
		    lPreparedStatementEdit.executeUpdate();
		    return null;
		} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
		}catch (SQLException e) {
			return "SQLException : " + e.getMessage();
		}
	}
	
public String deleteContact(final long id){
		
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			 // delete a  contact
			final PreparedStatement lPreparedStatementDelete =lConnection.prepareStatement("DELETE FROM CONTACT WHERE ID_CONTACT= ?");
		      //lPreparedStatementDelete.setString(1, firstName);
		      //lPreparedStatementDelete.setString(2, lastName);
		      lPreparedStatementDelete.setLong(1, id);
		      lPreparedStatementDelete.executeUpdate();
		      return null;
		} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
		}catch (SQLException e) {
			return "SQLException : " + e.getMessage();}
	}
	
	public String editContact( String firstName, String lastName, String email, int groupe, String mobile,
			 String fixe, String rue,  String ville, String cp,
			 String pays, long id) {
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			// adding a new contact
			final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET FIRSTNAME = ? ,LASTNAME = ?, EMAIL = ?, PHONENUMBER_MOBILE = ?,"
					+ "PHONENUMBER_FIX = ?, RUE = ?, VILLE = ?, CODE_POSTAL = ?, PAYS = ?, GROUP_ID = ? WHERE ID_CONTACT = ? ");

			lPreparedStatementEdit.setString(1, firstName);
		    lPreparedStatementEdit.setString(2, lastName);
		    lPreparedStatementEdit.setString(3, email);
		    lPreparedStatementEdit.setString(4, mobile);
		    lPreparedStatementEdit.setString(5, fixe);
		    lPreparedStatementEdit.setString(6, rue);
		    lPreparedStatementEdit.setString(7, ville);
		    lPreparedStatementEdit.setString(8, cp);
		    lPreparedStatementEdit.setString(9, pays);
		    lPreparedStatementEdit.setInt(10, groupe);
		    lPreparedStatementEdit.setLong(11, id);
		    lPreparedStatementEdit.executeUpdate();
		    return null;
		} catch (NamingException e) {
			return "NamingException : " + e.getMessage();
		}catch (SQLException e) {
			return "SQLException : " + e.getMessage();
		}
	}
	
	public String editGroupeContact(int groupe, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET GROUP_ID = ? WHERE ID_CONTACT = ? ");

            lPreparedStatementEdit.setInt(1, groupe);
            lPreparedStatementEdit.setLong(2, id);
            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
	}

	public String editPhoneFixContact(String fixe,long id) {
		try {
		                final Context lContext = new InitialContext(); 
		                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
		                final Connection lConnection = lDataSource.getConnection();
		                // adding a new contact
		                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET PHONENUMBER_FIX = ?  WHERE ID_CONTACT = ? ");
		
		
		            lPreparedStatementEdit.setString(1, fixe);
		            lPreparedStatementEdit.setLong(2, id);
		            lPreparedStatementEdit.executeUpdate();
		            return null;
		        } catch (NamingException e) {
		                return "NamingException : " + e.getMessage();
		        }catch (SQLException e) {
		                return "SQLException : " + e.getMessage();
		        }
		}

public String editPhoneMobileContact(  String mobile, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET PHONENUMBER_MOBILE = ? WHERE ID_CONTACT = ? ");


            lPreparedStatementEdit.setString(1, mobile);

            lPreparedStatementEdit.setLong(2, id);
            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
}

public String editRueAdresseContact(String rue, long id) {
	try {
       final Context lContext = new InitialContext(); 
       final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
       final Connection lConnection = lDataSource.getConnection();
       // adding a new contact
       final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET RUE = ? WHERE ID_CONTACT = ? ");
	   lPreparedStatementEdit.setString(1, rue);
	   lPreparedStatementEdit.setLong(2, id);
	   lPreparedStatementEdit.executeUpdate();
	   return null;
	} catch (NamingException e) { return "NamingException : " + e.getMessage();
	}catch (SQLException e) { return "SQLException : " + e.getMessage();
	}
}

public String editVilleAdresseContact(String ville, long id) {
try {
       final Context lContext = new InitialContext(); 
       final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
       final Connection lConnection = lDataSource.getConnection();
       // adding a new contact
       final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET VILLE = ? WHERE ID_CONTACT = ? ");
	
	   lPreparedStatementEdit.setString(1, ville);
	   lPreparedStatementEdit.setLong(2, id);
	   lPreparedStatementEdit.executeUpdate();
	   return null;
} catch (NamingException e) {
       return "NamingException : " + e.getMessage();
}catch (SQLException e) {
       return "SQLException : " + e.getMessage();
}
}

public String editCPAdresseContact(String cp, long id) {
try {
       final Context lContext = new InitialContext(); 
       final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
       final Connection lConnection = lDataSource.getConnection();
       // adding a new contact
       final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET CODE_POSTAL = ? WHERE ID_CONTACT = ? ");


   lPreparedStatementEdit.setString(1, cp);
   lPreparedStatementEdit.setLong(2, id);
   lPreparedStatementEdit.executeUpdate();
   return null;
} catch (NamingException e) {
       return "NamingException : " + e.getMessage();
}catch (SQLException e) {
       return "SQLException : " + e.getMessage();
}
}

public String editPaysAdresseContact(String pays, long id) {
try {
       final Context lContext = new InitialContext(); 
       final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
       final Connection lConnection = lDataSource.getConnection();
       // adding a new contact
       final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET PAYS = ? WHERE ID_CONTACT = ? ");

   lPreparedStatementEdit.setString(1, pays);
   lPreparedStatementEdit.setLong(2, id);
   lPreparedStatementEdit.executeUpdate();
   return null;
} catch (NamingException e) {
       return "NamingException : " + e.getMessage();
}catch (SQLException e) {
       return "SQLException : " + e.getMessage();
}
}

public String editAdresseContact(  String rue,  String ville, String cp,
                 String pays, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET RUE = ?, VILLE = ?, CODE_POSTAL = ?, PAYS = ?WHERE ID_CONTACT = ? ");


            lPreparedStatementEdit.setString(1, rue);
            lPreparedStatementEdit.setString(2, ville);
            lPreparedStatementEdit.setString(3, cp);
            lPreparedStatementEdit.setString(4, pays);
            lPreparedStatementEdit.setLong(5, id);
            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
}

public String editEmailContact(  String email, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET  EMAIL = ? WHERE ID_CONTACT = ? ");


            lPreparedStatementEdit.setString(1, email);

            lPreparedStatementEdit.setLong(2, id);
            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
}
public String editLastNameContact(String lastName, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET LASTNAME = ?  WHERE ID_CONTACT = ? ");


            lPreparedStatementEdit.setString(1, lastName);
            lPreparedStatementEdit.setLong(2, id);
            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
}
public String editFirstNameContact( String firstName, long id) {
        try {
                final Context lContext = new InitialContext(); 
                final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
                final Connection lConnection = lDataSource.getConnection();
                // adding a new contact
                final PreparedStatement lPreparedStatementEdit =lConnection.prepareStatement("UPDATE CONTACT SET FIRSTNAME = ?  WHERE ID_CONTACT = ? ");

                lPreparedStatementEdit.setString(1, firstName);
            lPreparedStatementEdit.setLong(2, id);

            lPreparedStatementEdit.executeUpdate();
            return null;
        } catch (NamingException e) {
                return "NamingException : " + e.getMessage();
        }catch (SQLException e) {
                return "SQLException : " + e.getMessage();
        }
}
	
	public List<Contact> findAllContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final String requete ="SELECT * FROM CONTACT";
			final PreparedStatement stmt = lConnection.prepareStatement(requete);
			ResultSet rs = stmt.executeQuery(requete);
			while(rs.next()) {
				int contactId = rs.getInt("ID_CONTACT");
				String prenom = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String mobile = rs.getString("PHONENUMBER_MOBILE");
				String fixe = rs.getString("PHONENUMBER_FIX");
				String rue = rs.getString("RUE");
				String ville = rs.getString("VILLE");
				String cp= rs.getString("CODE_POSTAL");
				String pays = rs.getString("PAYS");
				lesContacts.add(new Contact(contactId, prenom, lastname, email,mobile,fixe,rue,ville,cp, pays));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lesContacts;
	}
	
	public List<ContactGroup> findAllGroups() {
		List<ContactGroup> lesGroupes = new ArrayList<ContactGroup>();
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final String requete ="SELECT * FROM GROUPE";
			final PreparedStatement stmt = lConnection.prepareStatement(requete);
			ResultSet rs = stmt.executeQuery(requete);
			while(rs.next()) {
				int group_id = rs.getInt("ID_GROUP");
				String groupname = rs.getString("GROUPNAME");
				lesGroupes.add(new ContactGroup(group_id,groupname));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lesGroupes;
	}
	
	
	public List<Contact> findContactsByGroup(int idGroupe) {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final String requete ="SELECT * FROM CONTACT c";
			final PreparedStatement stmt = lConnection.prepareStatement(requete);
			stmt.setInt(1, idGroupe);
			ResultSet rs = stmt.executeQuery(requete);
			while(rs.next()) {
				int contactId = rs.getInt("ID_CONTACT");
				String prenom = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String mobile = rs.getString("PHONENUMBER_MOBILE");
				String fixe = rs.getString("PHONENUMBER_FIX");
				String rue = rs.getString("RUE");
				String ville = rs.getString("VILLE");
				String cp= rs.getString("CODE_POSTAL");
				String pays = rs.getString("PAYS");
				lesContacts.add(new Contact(contactId, prenom, lastname, email,mobile,fixe,rue,ville,cp, pays));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lesContacts;
	}
	
	public Contact findContact(int idContact) {
		try {
			final Context lContext = new InitialContext(); 
			final DataSource lDataSource = (DataSource)lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final String requete ="SELECT * FROM CONTACT WHERE ID_CONTACT="+idContact;
			final PreparedStatement stmt = lConnection.prepareStatement(requete);
			//stmt.setInt(1, idContact);
			ResultSet rs = stmt.executeQuery(requete);
			while(rs.next()) {
				int contactId = rs.getInt("ID_CONTACT");
				String prenom = rs.getString("FIRSTNAME");
				String nom = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String mobile = rs.getString("PHONENUMBER_MOBILE");
				String fixe = rs.getString("PHONENUMBER_FIX");
				String rue = rs.getString("RUE");
				String ville = rs.getString("VILLE");
				String cp= rs.getString("CODE_POSTAL");
				String pays = rs.getString("PAYS");
				return new Contact(contactId, prenom, nom, email,mobile,fixe,rue,ville,cp, pays);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}