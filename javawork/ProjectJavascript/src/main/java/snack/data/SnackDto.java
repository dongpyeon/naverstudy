package snack.data;

import java.sql.Timestamp;

public class SnackDto {
	private String num;
	private String name;
	private String price;
	private String brand;
	private String photo;
	private Timestamp makedate;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Timestamp getMakedate() {
		return makedate;
	}
	public void setMakedate(Timestamp makedate) {
		this.makedate = makedate;
	}
	
}
