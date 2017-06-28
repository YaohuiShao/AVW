package module;
import java.util.ArrayList;
import javafx.scene.image.Image;


public class Map {
	
	// room list
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private Room currentRoom;
	public int flag1 = 0;
	public int flag2 = 0;
	/*
	 *  N --0 
	 *  S -- 1
	 *  W --2
	 *  E --3
	 */
	private Direction currentDirection = Direction.N;
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public void initialise(){
				
		Room corridor1 =new Room("c1", new Image("ijp/resources/c1n.jpg"), 
				new Image("ijp/resources/c1s.jpg"), 
				new Image("ijp/resources/c1w.jpg"), 
				new Image("ijp/resources/c1e.jpg"));
		Room corridor2 =new Room("c2", new Image("ijp/resources/c2n.jpg"), 
				new Image("ijp/resources/c2s.jpg"), 
				new Image("ijp/resources/c2w.jpg"), 
				new Image("ijp/resources/c2e.jpg"));
		Room corridor3 =new Room("c3", new Image("ijp/resources/c3n.jpg"), 
				new Image("ijp/resources/c3s.jpg"), 
				new Image("ijp/resources/c3w.jpg"), 
				new Image("ijp/resources/c3e.jpg"));
		Room corridor4 =new Room("c4", new Image("ijp/resources/c4n.jpg"), 
				new Image("ijp/resources/c4s.jpg"), 
				new Image("ijp/resources/c4w.jpg"), 
				new Image("ijp/resources/c4e.jpg"));
		Room corridor5 =new Room("c5", new Image("ijp/resources/c5n.jpg"), 
				new Image("ijp/resources/c5s.jpg"), 
				new Image("ijp/resources/c5w.jpg"), 
				new Image("ijp/resources/c5e.jpg"));
		Room corridor6 =new Room("c6", new Image("ijp/resources/c6n.jpg"), 
				new Image("ijp/resources/c6s.jpg"), 
				new Image("ijp/resources/c6w.jpg"), 
				new Image("ijp/resources/c6e.jpg"));
		
		Room room1 =new Room("r1", new Image("ijp/resources/r1n.jpg"), 
				new Image("ijp/resources/r1s.jpg"), 
				new Image("ijp/resources/r1w.jpg"), 
				new Image("ijp/resources/r1e.jpg"));
		Room room2 =new Room("r2", new Image("ijp/resources/r2n.jpg"), 
				new Image("ijp/resources/r2s.jpg"), 
				new Image("ijp/resources/r2w.jpg"), 
				new Image("ijp/resources/r2e.jpg"));
		Room room3 =new Room("r3", new Image("ijp/resources/r3n.jpg"), 
				new Image("ijp/resources/r3s.jpg"), 
				new Image("ijp/resources/r3w.jpg"), 
				new Image("ijp/resources/r3e.jpg"));
		Room room4 =new Room("r4", new Image("ijp/resources/r4n.jpg"), 
				new Image("ijp/resources/r4s.jpg"), 
				new Image("ijp/resources/r4w.jpg"), 
				new Image("ijp/resources/r4e.jpg"));
		Room room5 =new Room("r5", new Image("ijp/resources/r5n.jpg"), 
				new Image("ijp/resources/r5s.jpg"), 
				new Image("ijp/resources/r5w.jpg"), 
				new Image("ijp/resources/r5e.jpg"));
		Room room6 =new Room("r6", new Image("ijp/resources/r6n.jpg"), 
				new Image("ijp/resources/r6s.jpg"), 
				new Image("ijp/resources/r6w.jpg"), 
				new Image("ijp/resources/r6e.jpg"));
		
		Room bathroom1 =new Room("b1", new Image("ijp/resources/b1n.jpg"), 
				new Image("ijp/resources/b1s.jpg"), 
				new Image("ijp/resources/b1w.jpg"), 
				new Image("ijp/resources/b1e.jpg"));
		Room bathroom2 =new Room("b2", new Image("ijp/resources/b2n.jpg"), 
				new Image("ijp/resources/b2s.jpg"), 
				new Image("ijp/resources/b2w.jpg"), 
				new Image("ijp/resources/b2e.jpg"));
		
		Room kitchen =new Room("ki", new Image("ijp/resources/kn.jpg"), 
				new Image("ijp/resources/ks.jpg"), 
				new Image("ijp/resources/kw.jpg"), 
				new Image("ijp/resources/ke.jpg"));
		
		
		corridor1.setNeighbor(bathroom1,null,null,corridor2);
		corridor2.setNeighbor(corridor3,corridor4,corridor1,room2);
		corridor3.setNeighbor(bathroom2,corridor2,null,room1);
		corridor4.setNeighbor(corridor2,corridor5,room4,room3);
		corridor5.setNeighbor(corridor4,kitchen,room5,corridor6);
		corridor6.setNeighbor(null,room6,corridor5,null);
		room1.setNeighbor(null,null,corridor3,null);
		room2.setNeighbor(null,null,corridor2,null);
		room3.setNeighbor(null,null,corridor4,null);
		room4.setNeighbor(null,null,null,corridor4);
		room5.setNeighbor(null,null,null,corridor5);
		room6.setNeighbor(corridor6,null,null,null);
		bathroom1.setNeighbor(null,corridor1,null,null);
		bathroom2.setNeighbor(null,corridor3,null,null);
		kitchen.setNeighbor(corridor5,null,null,null);
		
		roomList.add(corridor1);
		roomList.add(corridor2);
		roomList.add(corridor3);
		roomList.add(corridor4);
		roomList.add(corridor5);
		roomList.add(corridor6);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		roomList.add(room4);
		roomList.add(room5);
		roomList.add(room6);
		roomList.add(kitchen);
		roomList.add(bathroom1);
		roomList.add(bathroom2);
		
		//show current room
		setCurrentRoom(corridor1);
		setCurrentDirection(Direction.N);
		
	}
	
	public Image showPicture(){
		Image show = null;
		if (currentDirection == Direction.N){
			show = currentRoom.getNorth();
		}else if(currentDirection == Direction.S){
			show = currentRoom.getSouth();
		}else if(currentDirection == Direction.W){
			show = currentRoom.getWest();
		}else if(currentDirection == Direction.E){
			show = currentRoom.getEast();
		}	
		return show;
	}
	
	public Image turnLeft(){
		Image returnImage = null;
		if (currentDirection == Direction.N){
			setCurrentDirection(Direction.W);
		}else if(currentDirection == Direction.S){
			setCurrentDirection(Direction.E);
		}else if(currentDirection == Direction.W){
			setCurrentDirection(Direction.S);
		}else if(currentDirection == Direction.E){
			setCurrentDirection(Direction.N);
		}
		returnImage = showPicture();
		return returnImage;
		
	}
	
	public Image turnRight(){
		Image returnImage = null;
		if (currentDirection == Direction.N){
			setCurrentDirection(Direction.E);
		}else if(currentDirection == Direction.S){
			setCurrentDirection(Direction.W);
		}else if(currentDirection == Direction.W){
			setCurrentDirection(Direction.N);
		}else if(currentDirection == Direction.E){
			setCurrentDirection(Direction.S);
		}
		returnImage = showPicture();
		return returnImage;	
	}
	
	public Image forward(){
		Room nextRoom = currentRoom.next(currentDirection);
		setCurrentRoom(nextRoom);
		return showPicture();
			
	}
	
	public boolean isForwardable(){
		if(currentRoom.next(currentDirection) == null){
			return false;
		}
		else
			return true;
	}
	
    
    public boolean is1putable(){
		if(flag1!=0){
			return false;
		}
		else
			return true;
	}
    
    public boolean is2putable(){
		if(flag2!=0){
			return false;
		}
		else
			return true;
	}
    
    public boolean is1pickable(){
		if(flag1==0){
			return false;
		}
		else
			return true;
	}
    
    public boolean is2pickable(){
		if(flag2==0){
			return false;
		}
		else
			return true;
	}
    public Image putdown1(){
    	flag1 = 1;
    	return showItem1();
    }
	
    public Image putdown2(){
    	flag2 = 1;
    	return showItem2();
    }
    
    public Image pickup1(){
    	flag1 = 0;
    	Image returnImage = null;
    	return(returnImage);
    }
    
    public Image pickup2(){
    	flag2 = 0;
    	Image returnImage = null;
    	return(returnImage);
    }
    
    
    public Image showItem1(){
		Image show = new Image("ijp/resources/i1.png");	
		return show;
	}
    
    public Image showItem2(){	
		Image show = new Image("ijp/resources/i2.png");	
		return show;
	}
}
