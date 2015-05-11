package com.gym.dao.MySql;

import com.gym.dao.DaoNews;
import com.gym.dao.exceptions.PersistException;
import com.gym.entity.News;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nout on 16/03/2015.
 */
public class MySqlDaoNews implements DaoNews {
    //TODO think about more pretty solution
    private String user = "root";
    private String password = "send08";
    private String host = "localhost";
    private String dbName = "gym";
    private String url = "jdbc:mysql://"  + host + "/" + dbName + "?user=" + user + "&password=" + password;;
    private String driver = "com.mysql.jdbc.Driver";

    public MySqlDaoNews() throws PersistException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new PersistException(e);
        }

    }

    @Override
    public List<News> getActual() throws PersistException {
        List<News> list;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select id, publish_date, title, description, admin_id from news order by order_date desc");
            ResultSet rs = ps.executeQuery();
            list = parseResultSet(rs);

        } catch (SQLException e) {
            throw new PersistException(e);
        }
        finally {
            if(con != null)  realiseRes(con);

        }
        return list.subList(0, 3);
    }

    @Override
    public void persist(News n) throws PersistException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into news(publish_date, title, description, admin_id ) values(?, ?, ?, ?);");
            ps.setTimestamp(1, n.getOrderDate());
            ps.setString(2, n.getHeader());
            ps.setString(3, n.getContent());
            ps.setInt(4, n.getAdmin_id());
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist inserted more then 1 record: " + count);
            }
            con.commit();
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        finally {
            if(con != null)  realiseRes(con);

        }
    }

    @Override
    public void delete(News n) throws PersistException  {
        Connection con = null;
        con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from news where id = ?");
            ps.setInt(1, n.getId());
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
            con.commit();
        } catch (SQLException e) {
            throw new PersistException(e);
        } finally {
            if(con != null)  realiseRes(con);

        }
    }


    private Connection getConnection() throws PersistException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            return con;
        } catch (SQLException e) {
            throw new PersistException("Cannot obtain connection", e);
        }

    }

    private  void realiseRes(Connection con) throws PersistException {
        try {
            con.close();
        } catch (SQLException e) {
            throw new PersistException("Cannot realise connection", e);
        }

    }

    private List<News> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<News> res = new LinkedList<News>();
        try {
            while(rs.next()){
                News temp = new News(
                        rs.getInt("id"),
                        rs.getTimestamp("order_date"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("admin_id")

                );
                res.add(temp);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return res;
    }

}
