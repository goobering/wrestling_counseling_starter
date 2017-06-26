package example.codeclan.com.wrestling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Counselor
{
    private int id;
    private String firstName, nickName, lastName, telephone, email, memberSince;

    public Counselor(int id, String firstName, String nickName, String lastName, String telephone, String email, String memberSince)
    {
        this.id = id;
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.memberSince = memberSince;
    }

    public Counselor(String firstName, String nickName, String lastName, String telephone, String email, String memberSince)
    {
        this.id = id;
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.memberSince = memberSince;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getNickName()
    {
        return nickName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getMemberSince()
    {
        return memberSince;
    }

    public static Counselor getCounselorBySubjectId(int id)
    {
        Counselor result = new Counselor(0, "", "", "", "", "", "");

        String sql = String.format("SELECT subjects.description, * FROM counselors INNER JOIN subjects ON counselors.id = subjects.counselor_id WHERE subjects.id = '%d';", id);
        ResultSet rs = SqlRunner.executeQuery(sql);

        try
        {
            while(rs.next())
            {
                result.id = rs.getInt("id");
                result.firstName = rs.getString("first_name");
                result.lastName = rs.getString("last_name");
                result.nickName = rs.getString("nick_name");
                result.email = rs.getString("email");
                result.memberSince = rs.getString("member_since");
                result.telephone = rs.getString("telephone");
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
