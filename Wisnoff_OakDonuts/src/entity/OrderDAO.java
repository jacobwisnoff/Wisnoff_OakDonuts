package entity;

import core.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDAO implements DAO<OrderItem> {
    public OrderDAO() {}

    @Override
    public Optional<OrderItem> get(int id) {
        DB db = DB.getInstance();
        try {
            String sql = "SELECT * FROM Orders WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            OrderItem item = null;
            if (rs.next()) {
                item = new OrderItem(rs.getInt("id"), rs.getInt("menuitemid"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
            }
            return Optional.ofNullable(item);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Optional.empty();
        }
    }

    @Override
    public List<OrderItem> getAll() {
        DB db = DB.getInstance();
        List<OrderItem> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Orders ORDER BY id";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                items.add(new OrderItem(rs.getInt("id"), rs.getInt("menuitemid"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price")));
            }
            return items;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return items;
        }
    }

    @Override
    public void insert(OrderItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Orders (menuitemid, name, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, t.getMenuItemId());
            stmt.setString(2, t.getName());
            stmt.setInt(3, t.getQuantity());
            stmt.setDouble(4, t.getPrice());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void update(OrderItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Orders SET menuitemid = ?, name = ?, quantity = ?, price = ? WHERE id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, t.getMenuItemId());
            stmt.setString(2, t.getName());
            stmt.setInt(3, t.getQuantity());
            stmt.setDouble(4, t.getPrice());
            stmt.setInt(5, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(OrderItem t) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Orders WHERE id = ?";
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
            String sql = "SELECT * FROM Orders WHERE id = -1";
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

