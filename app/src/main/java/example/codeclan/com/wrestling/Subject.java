package example.codeclan.com.wrestling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Subject
{
    private int id, counselorId;
    private String name, description;

    public Subject(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public Subject(int id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public int getCounselorId()
    {
        return counselorId;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public static String getSubjectDescriptionById(int id)
    {
        String result = "";

        String sql = String.format("SELECT description FROM subjects WHERE id = '%d';", id);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try
        {
            while(rs.next())
            {
                result = rs.getString("description");
            }
        }
        catch(SQLException ex)
        {
            System.exit(0);
        }
        finally
        {
            SqlRunner.closeConnection();
        }

        return result;
    }

    public static ArrayList<String> allNames()
    {
        ArrayList<String> result = new ArrayList<String>();

        String sql = "SELECT name FROM subjects";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try
        {
            while(rs.next())
            {
                String name = rs.getString("name");
                result.add(name);
            }
        }
        catch(SQLException ex)
        {
            System.exit(0);
        }
        finally
        {
            SqlRunner.closeConnection();
        }

        return result;
    }

    public static ArrayList<Subject> all()
    {
        ArrayList<Subject> result = new ArrayList<Subject>();

        String sql = "SELECT * FROM subjects";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try
        {
            while(rs.next())
            {
                result.add(new Subject(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        }
        catch(SQLException ex)
        {
            System.exit(0);
        }
        finally
        {
            SqlRunner.closeConnection();
        }

        return result;
    }
}
