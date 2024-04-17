package com.infs.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PropertyListing")
public class PropertyDocument {
	
	@Id
	private int id;
	private int price;
	private String desc;
	private String address;
	private int zipcode;
	
	public PropertyDocument(int id, int price, String desc, String address, int zipcode) {
		super();
		this.id = id;
		this.price = price;
		this.desc = desc;
		this.address = address;
		this.zipcode = zipcode;
	}

	public PropertyDocument() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "PropertyDocument [id=" + id + ", price=" + price + ", desc=" + desc + ", address=" + address
				+ ", zipcode=" + zipcode + "]";
	}
	

}
