/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpus;

import java.sql.*; 
import java.util.*; 
import connection.Connector;  
import model.*; 
import DAOImplement.dataimplement; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

/**
 *
 * @author Lab Informatika
 */
public class dataperpusDAO implements dataimplement { 
Connection  connection; 
final String select = "select * from dataperpus"; 
final  String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=?"; 
final String insert = "INSERT INTO dataperpus(judul,genre,penulis,penerbit,lokasi,stock) VALUES(?,?,?,?,?,?);"; 

final String delete = "delete from dataperpus where id=?"; 

public dataperpusDAO(){
    connection = Connector.connection();  
     
} 

     
    
    @Override
    public void insert(dataperpus p) {
      PreparedStatement statement = null; 
       try{  
           statement.setString(1, p.getJudul()); 
            statement.setString(2, p.getGenre()); 
             statement.setString(3, p.getPenulis()); 
              statement.setString(4, p.getPenerbit());
               statement.setString(5, p.getLokasi());
              statement.setString(6, p.gettextStock());
              statement.executeUpdate(); 
        } catch(SQLException ex){  
           ex.printStackTrace();
           
           
       } 
       finally{ 
        try{
            statement.close();
        } catch(SQLException ex){   
               ex.printStackTrace();
        }
        
    }
    }

    @Override
    public void update(dataperpus p) {
       PreparedStatement statement = null; 
       try{  
           statement.setString(1, p.getJudul()); 
            statement.setString(2, p.getGenre()); 
             statement.setString(3, p.getPenulis()); 
              statement.setString(4, p.getPenerbit());
               statement.setString(5, p.getLokasi());
              statement.setString(6, p.gettextStock());
              statement.executeUpdate(); 
        } catch(SQLException ex){  
           ex.printStackTrace();
           
           
       } 
       finally{ 
        try{
            statement.close();
        } catch(SQLException ex){   
               ex.printStackTrace();
        }
        
    }
    }

    @Override
    public void delete(int id) { 
        PreparedStatement statement = null; 
      try{ 
          connection.prepareStatement(delete);  
               statement.setInt(1,id); 
               statement.executeUpdate(); 
      }catch(SQLException ex){   
               ex.printStackTrace();
        } finally{ 
        try{
            statement.close();
        } catch(SQLException ex){   
               ex.printStackTrace();
        }
        
    }
    }
    
    @Override
    public List<dataperpus> getAll() {
        List <dataperpus> dp = null; 
        try{
            dp=new ArrayList<dataperpus>(); 
            Statement st = connection.createStatement();  
            ResultSet rs = st.executeQuery(select); 
            while(rs.next()){
                dataperpus pp = new dataperpus(); 
                pp.setId(rs.getInt("id")); 
                   pp.setJudul(rs.getString("judul "));  
                    pp.setGenre(rs.getString("genre "));  
                     pp.setPenulis(rs.getString("penulis "));  
                      pp.setPenerbit(rs.getString("penerbit "));  
                       pp.setLokasi(rs.getString("lokasi "));  
                        pp.setStock(rs.getInt("stock"));   
                  
                        
                        
                             
            }
        }catch(SQLException ex){  
             ex.printStackTrace(); 
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE,null,ex);
        } 
return dp;
        
    }
    
   
    
}
