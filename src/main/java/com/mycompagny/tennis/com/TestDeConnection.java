package com.mycompagny.tennis.com;

import com.mycompagny.tennis.com.service.JoueurService;
import entity.Joueur;

public class TestDeConnection {
    public static void main(String... args) {
        JoueurService joueurServices= new JoueurService();
       Joueur noah = new Joueur();
        noah.setNom("Noah");
        noah.setPrenom("Yannick");
        noah.setSexe('M');
        joueurServices.createJoueur(noah);
        System.out.println("l'identification du joueur cré est"+noah.getId());

        //Joueur bartoli = new Joueur();

        //System.out.println(bartoli.getPreno
        //    joueurRepositorylmpl.create(noah);m()+""+bartoli.getNom());



      /*  Connection conn = null;
        try {
            BasicDataSource dataSource=new  BasicDataSource();
          dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
     //   dataSource.setInitialSize(5);
            dataSource.setUsername("root");
            dataSource.setPassword("root");
// creer une connexion est mettre dans la pool
          conn=dataSource.getConnection();

            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);
    // ouvrir  vers serveur mysql  sur le port 3306 , drivemanagement fonctionne  on rentre dasn le ty sinon cdans le catch
         //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
         // Statement statement=conn.createStatement();
             conn.setAutoCommit(false);

            PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO JOUEUR   (NOM,PRENOM,SEXE ) Values (?,?,?)");
            String  nom="capric";
            String prenom="jenny";
            String sexe="F";
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setString(3,sexe);

            preparedStatement.executeUpdate();

            nom="doub";
             prenom="youb";
             sexe="M";
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setString(3,sexe);

            preparedStatement.executeUpdate();

            /*System.out.println("le nombre d'enregistrement modifié est "+nbEnregristrer);
            //ResultSet rs=statement.executeQuery("SELECT NOM,PRENOM, ID FROM JOUEUR WHERE ID=12");
            preparedStatement.setLong(1,identifiant);
            ResultSet rs=preparedStatement.executeQuery();*/
            /*
           if (rs.next()){
               final String nom=rs.getString("NOM");
                final String prenom=rs.getString("PRENOM");
                final long id=rs.getInt("ID");
                System.out.println("le jour.la joueseur representé par le numero "+id+" est "+prenom+" "+nom);
            }
           else{
                System.out.println("aucun joueur avec l'identifiant "+identifiant+" n'a été trouvé");
           }

            conn.commit();
            System.out.println("success");

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
    */

    }

}