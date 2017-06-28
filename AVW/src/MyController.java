import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import module.Map;

public class MyController {
	
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView itemView1;
	@FXML
	private ImageView itemView2;
	@FXML
	private Button fd;
	@FXML
	private Button put1;
	@FXML
	private Button pick1;
	@FXML
	private Button put2;
	@FXML
	private Button pick2;
	
	Map map = new Map();

	
	public void Initialise(){
		map.initialise();
		Image imageToShow = map.showPicture();
		imageView.setImage(imageToShow);
		pick1.setDisable(true);
		pick2.setDisable(true);
	}
	
	public void turnLeft(ActionEvent event){
		Image leftImage = map.turnLeft();
		imageView.setImage(leftImage);
		if(map.isForwardable()==false){
			fd.setDisable(true);
		}
		else
			fd.setDisable(false);
	}
	
	public void turnRight(ActionEvent event){
		Image rightImage = map.turnRight();
		imageView.setImage(rightImage);
		if(map.isForwardable()==false){
			fd.setDisable(true);
		}
		else
			fd.setDisable(false);
	}
	
	
	public void forward(ActionEvent event){
		Image image = map.forward();
		imageView.setImage(image);
		if(map.isForwardable()==false){
			fd.setDisable(true);
		}
		else
			fd.setDisable(false);
	}
	
	
	public void putDown1(ActionEvent event){
		Image item1 = map.putdown1();
		itemView1.setImage(item1);	
		if(map.is1putable()==false){
			put1.setDisable(true);
		}
		else
			put1.setDisable(false);
		if(map.is1pickable()==false){
			pick1.setDisable(true);
		}
		else
			pick1.setDisable(false);
	}
	
    public void putDown2(ActionEvent event){
    	Image item2 = map.putdown2();
    	itemView2.setImage(item2);
    	if(map.is2putable()==false){
			put2.setDisable(true);
		}
		else
			put2.setDisable(false);
    	if(map.is2pickable()==false){
			pick2.setDisable(true);
		}
		else
			pick2.setDisable(false);
	}
    
    public void pickUp1(ActionEvent event){
    	
    	Image item1 = map.pickup1();
		itemView1.setImage(item1);
		if(map.is1putable()==false){
			put1.setDisable(true);
		}
		else
			put1.setDisable(false);
		if(map.is1pickable()==false){
			pick1.setDisable(true);
		}
		else
			pick1.setDisable(false);
    }
    
    public void pickUp2(ActionEvent event){
    	
    	Image item2 = map.pickup2();
		itemView2.setImage(item2);
		
		if(map.is2putable()==false){
			put2.setDisable(true);
		}
		else
			put2.setDisable(false);
		if(map.is2pickable()==false){
			pick2.setDisable(true);
		}
		else
			pick2.setDisable(false);
    }
    
	

}
