package module;

import javafx.scene.image.Image;

public class Room {
	
	private String name;
	private Image north;
	private Image south;
	private Image west;
	private Image east;
	private Room northRoom;
	private Room southRoom;
	private Room westRoom;
	private Room eastRoom;
	
	public Room getNorthRoom() {
		return northRoom;
	}

	public Room getSouthRoom() {
		return southRoom;
	}

	public Room getWestRoom() {
		return westRoom;
	}

	public Room getEastRoom() {
		return eastRoom;
	}

	
	public void setNeighbor(Room north, Room south, Room west, Room east) {
		this.northRoom = north;
		this.southRoom = south;
		this.westRoom = west;
		this.eastRoom = east;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getNorth() {
		return north;
	}

	public void setNorth(Image north) {
		this.north = north;
	}

	public Image getSouth() {
		return south;
	}

	public void setSouth(Image south) {
		this.south = south;
	}

	public Image getWest() {
		return west;
	}

	public void setWest(Image west) {
		this.west = west;
	}

	public Image getEast() {
		return east;
	}

	public void setEast(Image east) {
		this.east = east;
	}

	
	public Room(String name, Image north, Image south, Image west, Image east){
		this.name = name;
		this.north = north;
		this.south = south;
		this.west = west;
		this.east = east;
	}

	public Room next(Direction currentDirection) {
		Room nextRoom = null;
		if (currentDirection == Direction.N){
			nextRoom = getNorthRoom();
		}else if(currentDirection == Direction.S){
			nextRoom = getSouthRoom();
		}else if(currentDirection == Direction.W){
			nextRoom = getWestRoom();
		}else if(currentDirection == Direction.E){
			nextRoom = getEastRoom();
		}
		return nextRoom;
	}

}
