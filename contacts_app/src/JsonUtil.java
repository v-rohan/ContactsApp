
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonstine_stark
 */
public class JsonUtil {
    
    
    public void deleteJson(int rowindex) throws ParseException, IOException
    {
        ArrayList<contact> a = toContact();
         ArrayList<JSONObject> list = new ArrayList<JSONObject>();;
         a.remove(rowindex);
         
        for(int i = 0; i<a.size();i++)
        {
            contact con = a.get(i);
           
            JSONObject obj = addToJson(con);
           
            list.add(obj);
            System.out.println("3");
        }
        System.out.println("method perfect");
        addTo(list);
        
        
    }
    
    
   public JSONObject addToJson(contact a) throws IOException 
   {
       JSONObject obj = new JSONObject();
       
       obj.put("name", a.getName());
       obj.put("email", a.getEmail());
       obj.put("phone", a.getPhone());
       obj.put("image", a.getPic());
       
       
       
       return obj;
       
   
       }
   
   
   public ArrayList<JSONObject> toArray() throws IOException, ParseException 
   {
       JSONParser parser = new JSONParser();
        ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
           Object obj = parser.parse(new FileReader("C:\\Users\\bonstine_stark\\Documents\\NetBeansProjects\\contacts_app2\\src\\user.json"));
           JSONObject jsonObject = (JSONObject)obj;
           
           
           try{
           JSONArray list = (JSONArray)jsonObject.get("entries");
                Iterator<JSONObject> iterator = list.iterator();
                
                while(iterator.hasNext())
                {
                    arr.add(iterator.next());
                }
            return arr;
           }
           catch(NullPointerException e)
           {
               return arr;
           }
   }
   
   
   
   
    public ArrayList<contact> toContact() throws IOException, ParseException 
   {
       JSONParser parser = new JSONParser();
        ArrayList<contact> arr = new ArrayList<contact>();
           Object obj = parser.parse(new FileReader("C:\\Users\\bonstine_stark\\Documents\\NetBeansProjects\\contacts_app2\\src\\user.json"));
           JSONObject jsonObject = (JSONObject)obj;
           
           
           try{
           JSONArray list = (JSONArray)jsonObject.get("entries");
                Iterator<JSONObject> iterator = list.iterator();
                
                while(iterator.hasNext())
                {   JSONObject jso = iterator.next();
                    String name = (String)jso.get("name");
                     
                    String email = (String)jso.get("email");
                        
                    String phone = (String)jso.get("phone");
                        
                     String image = (String)jso.get("image");
                      
                     
                    contact con = new contact( name, phone, email, image);
                    arr.add(con);
                }
            return arr;
           }
           catch(NullPointerException e)
           {
               return arr;
           }
   }
       
       
      
   
   
   public void addTo (ArrayList<JSONObject> arr)
   {
       JSONObject obj = new JSONObject();
       JSONArray list = new JSONArray();
       
       try{
        for(int i=0; i< arr.size(); i++)
       {
           list.add(arr.get(i));
       }
       }
       
       catch(NullPointerException e){
       System.out.println("sorted");
       
       }
           
       obj.put("entries", list);
       try
       {
           FileWriter file = new FileWriter("C:\\Users\\bonstine_stark\\Documents\\NetBeansProjects\\contacts_app2\\src\\user.json");
           file.write(obj.toJSONString());
           file.flush();
       }
       catch(IOException e)
               {
                   e.printStackTrace();
               }


} 
   
   
  
   
   
    public void editJson(int rowindex, contact con2) throws IOException, ParseException
    {
        
         ArrayList<contact> a = toContact();
         ArrayList<JSONObject> list = new ArrayList<JSONObject>();
         
         for(int i = 0; i<a.size();i++)
        {
            if (rowindex==i)
                list.add(addToJson(con2));
            else{
            contact con = a.get(i);
            list.add(addToJson(con));
            
            }
            
            
        }
        System.out.println("method perfect");
        addTo(list);
         
        
    }
   
}


