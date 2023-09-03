package Repository;

import com.mycompagny.tennis.com.DataSourceProvider;
import entity.Joueur;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoueurRepositorylmpl {
public void create (Joueur joueur) {

    Connection conn = null;
    try {
        DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();

// creer une connexion est mettre dans la pool
        conn=dataSource.getConnection();

        //Seulement avant Java 7/JDBC 4
        //Class.forName(DRIVER_CLASS_NAME);
        // ouvrir  vers serveur mysql  sur le port 3306 , drivemanagement fonctionne  on rentre dasn le ty sinon cdans le catch
        //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
        // Statement statement=conn.createStatement();

        PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO JOUEUR   (NOM,PRENOM,SEXE ) Values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,joueur.getNom());
        preparedStatement.setString(2, joueur.getPrenom());
        preparedStatement.setString(3,joueur.getSexe().toString());

        preparedStatement.executeUpdate();
        //contient une seule ligne
       ResultSet rs = preparedStatement.getGeneratedKeys();
    if(rs.next()){
      joueur.setId(rs.getLong(1));

    }


        System.out.println("Joueur creer avec succes");

    } catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        try {
            if (conn!=null) {//proxy vers la connexion, si en utilisation fait 2eme connexion si connexion simultané,
                conn.close();
            }
            //on ferme la connexion
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void update (Joueur joueur) {

        Connection conn = null;
        try {
            DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();

// creer une connexion est mettre dans la pool
            conn=dataSource.getConnection();



            PreparedStatement preparedStatement= conn.prepareStatement("UPDATE  JOUEUR SET NOM=?,PRENOM=?,SEXE=? WHERE ID=?");

            preparedStatement.setString(1,joueur.getNom());
            preparedStatement.setString(2, joueur.getPrenom());
            preparedStatement.setString(3,joueur.getSexe().toString());
            preparedStatement.setLong(4,joueur.getId());

            preparedStatement.executeUpdate();



            System.out.println("Joueur modifier avec succes");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {//proxy vers la connexion, si en utilisation fait 2eme connexion si connexion simultané,
                    conn.close();
                }
                //on ferme la connexion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Joueur delete  (long id ) {

        Connection conn = null;
        Joueur joueur=null;
        try {
            DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();

// creer une connexion est mettre dans la pool
            conn=dataSource.getConnection();

            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);
            // ouvrir  vers serveur mysql  sur le port 3306 , drivemanagement fonctionne  on rentre dasn le ty sinon cdans le catch
            //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
            // Statement statement=conn.createStatement();

            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM JOUEUR WHERE ID=?");


            preparedStatement.setLong( 1, id);

            preparedStatement.executeUpdate();


            System.out.println("Joueur supprimer");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {//proxy vers la connexion, si en utilisation fait 2eme connexion si connexion simultané,
                    conn.close();
                }
                //on ferme la connexion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return joueur;
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  Joueur getById  (long id ) {

        Connection conn = null;
        Joueur joueur=null;
        try {
            DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();

// creer une connexion est mettre dans la pool
            conn=dataSource.getConnection();

            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);
            // ouvrir  vers serveur mysql  sur le port 3306 , drivemanagement fonctionne  on rentre dasn le ty sinon cdans le catch
            //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
            // Statement statement=conn.createStatement();

            PreparedStatement preparedStatement= conn.prepareStatement("SELECT  NOM,PRENOM,SEXE FROM  JOUEUR  WHERE ID=?");


            preparedStatement.setLong( 1, id);

            ResultSet rs=preparedStatement.executeQuery() ;
            if(rs.next()){
                joueur=new Joueur();
                joueur.setId(id);
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
        //notnull pour eviter les nullpointer exception
            }



            System.out.println("Joueur lu");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {//proxy vers la connexion, si en utilisation fait 2eme connexion si connexion simultané,
                    conn.close();
                }
                //on ferme la connexion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return joueur;
    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Joueur> list() {

        Connection conn = null;
        List<Joueur> joueurs=new ArrayList<>();
        try {
            DataSource dataSource=DataSourceProvider.getSingleDataSourceInstance();

// creer une connexion est mettre dans la pool
            conn=dataSource.getConnection();

            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);
            // ouvrir  vers serveur mysql  sur le port 3306 , drivemanagement fonctionne  on rentre dasn le ty sinon cdans le catch
            //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
            // Statement statement=conn.createStatement();

            PreparedStatement preparedStatement= conn.prepareStatement("SELECT  ID,NOM,PRENOM,SEXE FROM  JOUEUR");

            ResultSet rs=preparedStatement.executeQuery() ;
            while(rs.next()){
                Joueur joueur=new Joueur();
                joueur.setId(rs.getLong("ID"));
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
                joueurs.add(joueur);
                //notnull pour eviter les nullpointer exception
            }



            System.out.println("Joueurs lus");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {//proxy vers la connexion, si en utilisation fait 2eme connexion si connexion simultané,
                    conn.close();
                }
                //on ferme la connexion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return joueurs;
    }
}
