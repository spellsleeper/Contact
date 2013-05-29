package dbInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SqlCon {
	private Connection con = null;
	private Statement stmt = null;
    public static SqlCon sqlCon;
    private static String DB_URI="jdbc:h2:DB/contact;";
    
	public SqlCon() {
		try {
			sqlCon=this;
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException ce) {
			System.out.println("Datenbanktreiber nicht gefunden!");
			ce.printStackTrace();
			return;
		}

		try {
			con = DriverManager.getConnection(DB_URI, "sa", "");
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection konnte nicht initialisiert werden");
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Array String[] contains name,vorname,titel,kuerzel,mail1,mail2,
	 * telefon,handy,privattelefon,icq,plz,ortsname,adresse
	 *
	 * 
	 * @param id
	 * @return
	 */
	public String[] getRow(int id) {
		String[] s;
		try {
			ResultSet rs = stmt
					.executeQuery("SELECT k.name,k.vorname,k.titel,k.kuerzel,k.mail1,k.mail2,k.tel,k.handy,k.privatTel,k.icq,o.plz,o.name,k.adresse FROM "
							+ "kontakt k JOIN ort o "
							+ "ON k.ortid=o.id "
							+ "WHERE k.id=" + id);
			;
			if(!rs.next()){
				s = new String[] {null,null,null,null,null,null,null,null,null,null,null,null,null};
			}else{
			s = new String[] { rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),
					rs.getString(12),rs.getString(13)};
			}
			return s;
			
		} catch (SQLException ex) {
			System.out.println("Fehler in getRow()");
			ex.printStackTrace();
			return null;
		}
	}
	
	public String getLook(){
		String s=new String("javax.swing.plaf.metal.MetalLookAndFeel");
		try {
			ResultSet rs = stmt
					.executeQuery("SELECT l.name FROM "
							+ "look l "
							+ "WHERE l.id=1");
			rs.next();
			s=rs.getString(1);
			return s;
		} catch (SQLException ex) {
			System.out.println("Fehler in getLook()");
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public void setLook(String s){
		try{
			stmt.executeUpdate("UPDATE look" +
					" SET name='"+s+"' " +"WHERE id=1");
		}catch(SQLException e){
			System.out.println("Fehler in setLook()");
			e.printStackTrace();
		}
	}
	
	public boolean existDataRecord(int id){
		try {
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM "
							+ "kontakt k "
							+ "WHERE k.id=" + id);
			boolean b=rs.next();
			return b;
		} catch (SQLException ex) {
			System.out.println("Fehler in existDataRecord()");
			ex.printStackTrace();
			return false;
		}
	}
	/**
	 * m.vorname,m.name,a.name,m.mail,m.tel,m.handy,m.privatTel
	 * @return
	 */
	public String[][] getOverviewData() {
		String[][] sa = new String [this.getMaxContactID()][13];;
		try {
			ResultSet rs = stmt
					.executeQuery("SELECT k.vorname,k.name,k.titel,k.tel,k.privatTel,k.handy,k.mail1,k.mail2,k.icq,k.kuerzel,o.plz,o.name,k.adresse FROM "
							+ "kontakt k JOIN ort o "
							+ "ON k.ortid=o.id");
			int i=0;
			while (rs.next()) {
				sa[i][0]=rs.getString(1);
				sa[i][1]=rs.getString(2);
				sa[i][2]=rs.getString(3);
				sa[i][3]=rs.getString(4);
				sa[i][4]=rs.getString(5);
				sa[i][5]=rs.getString(6);
				sa[i][6]=rs.getString(7);
				sa[i][7]=rs.getString(8);
				sa[i][8]=rs.getString(9);
				sa[i][9]=rs.getString(10);
				sa[i][10]=rs.getString(11)+" "+rs.getString(12);
				sa[i][11]=rs.getString(13);
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Fehler in getOverviewData()");
			e.printStackTrace();
		}
		return sa;
	}

	public int getMaxContactID() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM kontakt");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Fehler in getMaxID");
			e.printStackTrace();
			return -1;
		}
	};
	
	public int getDataRecordID(String firstname,String lastname){
		try {
			ResultSet rs = stmt.executeQuery("SELECT id FROM kontakt  " 
					+"WHERE vorname='"+firstname+"' AND name='"+lastname+"'");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Fehler in getDataRecordID()");
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 
	 * Array String[] contains name,vorname,titel,kuerzel,mail1,mail2,telefon,
	 * handy,privattelefone,icq,plz,ortname,adresse
	 * @param sa
	 */
	public void addDataRecord(String [] sa){
		try{

			int cityID=this.getApendantCityNr(sa[11]);
			if(cityID==0){
				stmt.execute("INSERT INTO ort(id,plz,name)" +
						"VALUES("+(this.getMaxCityNr()+1)+",'"+sa[10]+"','"+sa[11]+"')");
				cityID=this.getMaxCityNr();
			
			}
			if(sa[0].equals("")){
				JOptionPane.showMessageDialog(null, "Sie müssen vollständige Namensangaben machen!");
			}else{
			stmt.execute("INSERT INTO kontakt(id,name,vorname,titel,kuerzel,mail1,mail2,tel,handy,privatTel,icq,ortid,adresse)" +
					"VALUES ("+(this.getMaxContactID()+1)+"," +
							"'"+sa[0]+"',"+
							"'"+sa[1]+"',"+
							"'"+sa[2]+"',"+
							"'"+sa[3]+"',"+
							"'"+sa[4]+"',"+
							"'"+sa[5]+"',"+
							"'"+sa[6]+"',"+
							"'"+sa[7]+"',"+
							"'"+sa[8]+"',"+
							"'"+sa[9]+"',"+
							cityID+","+
							"'"+sa[12]+"')");}
		}catch(SQLException e){
			System.out.println("Fehler in addDataRecord()");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Array String[] contains name,vorname,titel,kuerzel,mail1,mail2,telefon,
	 * handy,privattelefone,icq,plz,ortname,adresse
	 * @param sa
	 */
	public void updateDataRecord(int id,String[] sa ){
		try {
			
			int cityID=this.getApendantCityNr(sa[11]);
			if(cityID==0){
				stmt.execute("INSERT INTO ort(id,plz,name)" +
						"VALUES("+(this.getMaxCityNr()+1)+",'"+sa[10]+","+sa[11]+"')");
				cityID=this.getMaxCityNr();
			}
			stmt.executeUpdate("UPDATE kontakt" +
					" SET 	 name='"+sa[0]+"'," +
							"vorname='"+sa[1]+"'," +
							"titel='"+sa[2]+"'," +
							"kuerzel='"+sa[3]+"',"+
							"mail1='"+sa[4]+"',"+
							"mail2='"+sa[5]+"',"+
							"tel='"+sa[6]+"',"+
							"handy='"+sa[7]+"'," +
							"privatTel='"+sa[8]+"'," +
							"icq='"+sa[9]+"'," +
							"ortid='"+cityID+"'" +
							"adresse='"+sa[12]+"'"+
							"WHERE id="+id);
		} catch (SQLException e) {
			System.out.println("Fehler in updateDataRecord()");
			e.printStackTrace();
		}
	}
	
	public void deleteDataRecord(int id){
		try {
			stmt.executeUpdate("DELETE FROM kontakt " +
							"WHERE id="+id);
		} catch (SQLException e) {
			System.out.println("Fehler in deleteDataRecord()");
			e.printStackTrace();
		}
	}
	
	/**
	 * @return If value=0 the division doesn't exist
	 */
	private int getApendantCityNr(String cityName){
		int i=0;
		try{
			ResultSet rs = stmt
					.executeQuery("SELECT o.name,o.id FROM "
							+ "ort o ");
			while(rs.next()){
				if(rs.getString(1).equalsIgnoreCase(cityName)){
					i=rs.getInt(2);
					break;
				}
			}
		}catch(SQLException e){
			System.out.println("Fehler in getApendantDivisionNr()");
			e.printStackTrace();
		}
		return i;
	}
	
	private int getMaxCityNr() throws SQLException{
		ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM ort");
		rs.next();
		return rs.getInt(1);
	}
	
	
	
	

	public void renewConnection() {
		try {
			con.close();
			con = DriverManager.getConnection(DB_URI, "sa","");
		} catch (SQLException e) {
			System.out.println("Fehler in renewConection()");
			e.printStackTrace();
		}

	}

	protected void finalize() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Fehler in finalize()");
			e.printStackTrace();
		}
	}
	public int getLastDataRecordId(){
		try {
			ResultSet rs = stmt.executeQuery("SELECT r.recid FROM record r " 
					+"WHERE r.id=1");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Fehler in getLastDataRecordID()");
			e.printStackTrace();
			return 1;
		}
	}
	public void setLastDataRecordId(int id){
		try{
			stmt.executeUpdate("UPDATE record" +
					" SET recid="+id+" " +"WHERE id=1");
		}catch(SQLException e){
			System.out.println("Fehler in setLastDataRecordId()");
			e.printStackTrace();
		}
	}
	

}
