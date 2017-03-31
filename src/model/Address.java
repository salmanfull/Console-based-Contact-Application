package model;

public class Address {
  private String city;
  private int Door_no;
  private String Area;
  private String street;
  private String state;
  private String country;
  private int zipcode;
  public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getDoor_no() {
	return Door_no;
}
public void setDoor_no(int door_no) {
	Door_no = door_no;
}
public String getArea() {
	return Area;
}
public void setArea(String area) {
	Area = area;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}

}
