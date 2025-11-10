package entity;

import core.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuItemDAO implements DAO<MenuItem> {
    public MenuItemDAO() {}

    @Override
    public Optional<MenuItem> get(int id) {
        DB db = DB.getInstance();
        try {
            String sql = "SELECT * FROM MenuItem WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            MenuItem item = null;
            if (rs.next()) {
                item = new MenuItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
            return Optional.ofNullable(item);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Optional.empty();
        }
    }

    @Override
    public List<MenuItem> getAll() {
        DB db = DB.getInstance();
        List<MenuItem> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MenuItem ORDER BY id";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                items.add(new MenuItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            return items;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return items;
        }
    }

    @Override
    public void insert(MenuItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO MenuItem (id, name, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getName());
            stmt.setDouble(3, t.getPrice());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void update(MenuItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE MenuItem SET name = ?, price = ? WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, t.getName());
            stmt.setDouble(2, t.getPrice());
            stmt.setInt(3, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(MenuItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM MenuItem WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MenuItem WHERE id = -1";
            ResultSet rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) headers.add(rsmd.getColumnLabel(i));
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return headers;
        }
    }
}

