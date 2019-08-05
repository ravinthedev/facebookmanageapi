package socialmediatool;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {
    
    

    @FXML private TableView<Messages> resulttable;
     @FXML private TableColumn<Messages, String> message;
    @FXML private TableColumn<Messages, String> posttime;
    
        ObservableList<Messages> msg = FXCollections.observableArrayList();

    
    @FXML
    private void handleButtonAction(ActionEvent event)  {
        
        


String Token  = "EAAEDJyOWF2oBAKFo6YYUgT2fguPFcKy3oPiFFHVxao8GZCddi5GQxDqTPEIM0xi2uuh7XTA4YItrHlTvFJ1H3mXVoz36LATCLCCAIkkvhJXZCqYvdREd7Rt1JMYwGBFE6q671cV4kpWbDZARqKTbJRgaKUtmdesZAKul5lrfTZAbUS66bvMvn8IZClXUzhaV9c4hO3VCavuLfPPT4AipyD"; // USer access token
   

FacebookClient fb = new com.restfb.DefaultFacebookClient(Token);


      
        Connection<Post> feed = fb.fetchConnection("me/feed", Post.class);
        
        
        ArrayList<String> repos = new ArrayList(); 
        repos.add("Data will go from this point");
        
        String time;
        String mes;
        
        for (List <Post> page : feed) {
        
        for (Post aPost : page){

           
            
        mes = aPost.getMessage();
        time = aPost.getCreatedTime().toString();
        
         if (mes == null)
            {
            mes = "EMPTY";
            
            }
        repos.add(mes);
        repos.add(time);
        
        }
        }
        
        
        
        for (int i = 1;  i < repos.size(); i = i + 2)
        {
            int a, b;
            
            a = i;
            b = i+1;
            
            
      //System.out.println(repos.get(a) + "  " + repos.get(b));
        }
        

        
        resulttable.setItems(getMessages(repos));
    
    }
    
    
    public ObservableList<Messages> getMessages(ArrayList <String> prdata)
    {

       msg = FXCollections.observableArrayList(); 
        
           for(int j = 1; j < prdata.size(); j = j + 2)
           {
               int a, b;
               a = j;
               b = j+1;
               
               System.out.println(prdata.get(a) + "  " + prdata.get(b));
               msg.add(new Messages(prdata.get(a), prdata.get(b)));
               
           } 
    
        return msg;
    
}
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
message.setCellValueFactory(new PropertyValueFactory<Messages, String>("message"));
    posttime.setCellValueFactory(new PropertyValueFactory<Messages, String>("ttime"));
    }    
    
}
