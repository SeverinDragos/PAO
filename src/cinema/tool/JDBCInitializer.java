package cinema.tool;

import java.sql.*;

public class JDBCInitializer {
    public static void initializeDB() {
        String Query;
        try(
                //Pasul 1: conectarea la BD
                Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "" );
                //Pasul 2: crearea unui obiect de tip Statement
                Statement statement = conn.createStatement();
        )
        {
            Query = "DROP TABLE movies IF EXISTS";
            statement.executeUpdate(Query);
            Query = "CREATE TABLE movies (genre varchar2(25), name varchar2(25), duration number(3), type varchar2(3), id number(3))";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('action','Fast and Furious',103,'3D',1)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('drama','Before I met you',89,'2D',2)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('kids','Frozen',109,'3D',3)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('comedy','Deadpool',113,'3D',4)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('action','Aquaman',136,'3D',5)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('romantic','Set it up',105,'2D',6)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('romantic','Jumping the Broom',112,'2D',7)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('kids','The Polar Express',99,'3D',8)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('kids','Puss in Boots',92,'3D',9)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('comedy','Fist Fight',91,'2D',10)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('action','How it Ends',113,'2D',11)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('action','Run All Night',114,'3D',12)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('kids','Madagascar',87,'3D',13)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('comedy','Get Smart',109,'2D',14)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('drama','Dunkirk',106,'2D',15)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('kids','Megamind',97,'3D',16)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('action','The Revenant',156,'3D',17)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movies VALUES('drama','The Departed',151,'2D',18)";
            statement.executeUpdate(Query);


            Query = "DROP TABLE plays IF EXISTS";
            statement.executeUpdate(Query);
            Query = "CREATE TABLE plays (genre varchar2(25), name varchar2(25), duration number(3), leading_actor varchar2(25), id number(3))";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','Take Ianke si Cadir',150,'Florin Piersic',19)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','O scrisoare pierduta',153,'Horatiu Malaiele',20)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('drama','Hamlet',169,'Horia Căciulescu',21)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','Dineu cu prosti',143,'Ion Haiduc',22)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','Gaitele',150,'Geo Dobre',23)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','O noapte furtunoasa',127,'Grigore Manolescu',24)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('comedy','Visul unei nopti de iarna',127,'Dorel Visan',25)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('romantic','Steaua fara nume',148,'Catalina Murgea',26)";
            statement.executeUpdate(Query);
            Query = "INSERT INTO plays VALUES('drama','Cantareata Cheala',126,'Claudiu Istodor',27)";
            statement.executeUpdate(Query);

            Query = "DROP TABLE movietheaters IF EXISTS";
            statement.executeUpdate(Query);
            Query = "CREATE TABLE movietheaters (capacity number(3), free_seats number(3), show_id number(3), id number(3))";
            statement.executeUpdate(Query);
            Query = "INSERT INTO movietheaters VALUES('drama','Cantareata Cheala',126,'Claudiu Istodor',27)";
            statement.executeUpdate(Query);

        }
        catch(SQLException e) {
            System.out.println("Eroare la conectarea cu BD!" + e);
        }
    }
}
