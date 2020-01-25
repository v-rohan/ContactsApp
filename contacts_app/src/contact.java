/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonstine_stark
 */
public class contact {
    
   
    private String name;
    private String phone;
    private String email;
    private String pic;

    public contact( String name, String phone, String email, String pic) {
        
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.pic = pic;
    }

    contact(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPic() {
        return pic;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    
    
}
