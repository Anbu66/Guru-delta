package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class ShopAHotel {
	public ShopAHotel() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}

	@FindBy(xpath = "//a[@id=\"primary-static-link-1\"]")
	private WebElement shop_Hotel;

	@FindBy(xpath = "//input[@id=\"hotelLocation\"]")
	private WebElement hotelLocation;
	@FindBy(xpath = "//input[@id=\"hotelCheckInDate\"]")
	private WebElement hotelCheckInDate;
	@FindBy(xpath = "//input[@id=\"hotelCheckOutDate\"]")
	private WebElement hotelCheckOutDate;

	public WebElement getHotelCheckOutDate() {
		return hotelCheckOutDate;
	}

	@FindBy(xpath = "//span[@id=\"hotelNumberOfRooms-button\"]")
	private WebElement noOfRooms;

	@FindBy(id = "btnSubmit")
	private WebElement btn_bookAHotel;
	@FindBy(id = "btnRoomSubmit")
	private WebElement btn_RoomSubmit;
	@FindBy(id = "hotelNumberOfAdults-button")
	private WebElement drpdown_Adults;

	public WebElement getDrpdown_Adults() {
		return drpdown_Adults;
	}

	public WebElement getBtn_RoomSubmit() {
		return btn_RoomSubmit;
	}

	public WebElement getBtn_bookAHotel() {
		return btn_bookAHotel;
	}

	public WebElement getShop_Hotel() {
		return shop_Hotel;
	}

	public WebElement getHotelLocation() {
		return hotelLocation;

	}

	public WebElement getHotelCheckInDate() {
		return hotelCheckInDate;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

}
