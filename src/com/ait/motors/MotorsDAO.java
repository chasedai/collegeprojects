package com.ait.motors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class MotorsDAO {

    public List<Motors> findAll() {
        List<Motors> list = new ArrayList<Motors>();
        Connection c = null;
    	String sql = "SELECT * FROM motorbikes ORDER BY make";
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return list;
    }

    
   
    protected Motors processRow(ResultSet rs) throws SQLException {
        Motors motors = new Motors();
        motors.setId(rs.getInt("moto_id"));
        motors.setMake(rs.getString("make"));
        motors.setYear(rs.getString("year"));
        motors.setMileage(rs.getString("mileage"));
        motors.setColour(rs.getString("colour"));
        motors.setEngine(rs.getString("engine"));
        motors.setDescription(rs.getString("description"));
        motors.setPicture(rs.getString("picture"));
        return motors;
    }
    
    
    public Motors findById(int id){
    	
    	String sql = "SELECT * FROM motorbikes WHERE MOTO_ID = ?";
    	Motors motors = null;
    	Connection c = null;
    	try{
    		c = ConnectionHelper.getConnection();
    		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()){
    			motors = processRow(rs);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}finally{
    		ConnectionHelper.close(c);
    	}
    	
    	return motors;
    	
    }
  
    public Motors findByMake(String make){
    	
    	String sql = "SELECT * FROM motorbikes WHERE MAKE = ?";
    	Motors motors = null;
    	Connection c = null;
    	try{
    		c = ConnectionHelper.getConnection();
    		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
    		ps.setString(1, make);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()){
    			motors = processRow(rs);
    			System.out.println(motors.getMake());
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}finally{
    		ConnectionHelper.close(c);
    	}
    	
    	return motors;
    	
    }
    
    public boolean remove(int id){
    	Connection c = null;	
    	try{
    		c = ConnectionHelper.getConnection();
    		PreparedStatement ps = c.prepareStatement("DELETE FROM motorbikes WHERE moto_id=?");
    		ps.setInt(1, id);
    		int count = ps.executeUpdate();
    		return count == 1;
    	} catch (Exception e){
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	finally{
    		ConnectionHelper.close(c);
    	}
    }
   
    
    public Motors update(Motors motors){
    	Connection c = null;
    	try{
    		c = ConnectionHelper.getConnection();
    		PreparedStatement ps = (PreparedStatement) c.prepareStatement("UPDATE motorbikes SET make=?, year=?," +
    		  "mileage=?,  colour=?, engine=?, description=?, picture=? WHERE MOTO_ID=?");	
    	ps.setString(1,  motors.getMake());
    	ps.setString(2,  motors.getYear());
    	ps.setString(3,  motors.getMileage());
    	ps.setString(4,  motors.getColour());
    	ps.setString(5,  motors.getEngine());
    	ps.setString(6,  motors.getDescription());
    	ps.setString(7,  motors.getPicture());
    	ps.setInt(8,  motors.getId());
    	ps.executeUpdate();
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}finally{
    		ConnectionHelper.close(c);
    	}
    	return motors;
    }   
    
    public Motors create(Motors motors){
    	Connection c = null;
    	PreparedStatement ps = null;
    	try{
    		c = ConnectionHelper.getConnection();
    		ps = (PreparedStatement) c.prepareStatement("INSERT INTO motorbikes" +
    		" (make, year, mileage,  colour, engine, description, picture)" +
    	    " VALUES (?,?,?,?,?,?,?)",
    		new String[] {"ID"});
    		
    	ps.setString(1,  motors.getMake());
    	ps.setString(2,  motors.getYear());
    	ps.setString(3,  motors.getMileage());
    	ps.setString(4,  motors.getColour());
    	ps.setString(5,  motors.getEngine());
    	ps.setString(6,  motors.getDescription());
    	ps.setString(7,  motors.getPicture());
    	  
    ps.executeUpdate();
	ResultSet rs = ps.getGeneratedKeys();
	rs.next();
	
	int id = rs.getInt(1);
	motors.setId(id);
	}catch(Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
	}finally{
		ConnectionHelper.close(c);
	}
	
	return motors;
}
    
    
    public List<Motors> Search(String search){
        List<Motors> list = new ArrayList<Motors>();
        Connection c = null;
        String[] text = search.split("=");
    	String sql = "SELECT * FROM motorbikes WHERE " + text[0] + " LIKE '%" + text[1] +"%';";
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return list;
    }    
        
    
}
