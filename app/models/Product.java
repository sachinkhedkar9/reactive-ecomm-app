package models;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_id", "name", "category", "sub_category", "pricing",
		"peatures", "image", "specifications", "items_in_stock", "seller",
		"cities_for_delivery" })
@Entity("products")
public class Product {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("_id")
	@Property("_id")
	private String id;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("name")
	@Property("name")
	private String name;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("category")
	@Property("category")
	private String category;
	@JsonProperty("sub_category")
	@Property("sub_category")
	private String subCategory;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("pricing")
	@Embedded("pricing")
	private Pricing pricing;
	@JsonProperty("features")
	@Property("features")
	private List<String> features = new ArrayList<String>();
	@JsonProperty("image")
	@Property("image")
	private byte[] image;
	@JsonProperty("specifications")
	@Embedded("specifications")
	private Specifications specifications;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("items_in_stock")
	@Property("items_in_stock")
	private Integer itemsInStock;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("seller")
	@Embedded("seller")
	private Seller seller;
	
	@JsonProperty("cities_for_delivery")
	@Property("cities_for_delivery")
	private List<String> citiesForDelivery = new ArrayList<String>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Product() {
	}

	/**
	 * 
	 * @param Name
	 * @param Pricing
	 * @param Category
	 * @param Image
	 * @param SubCategory
	 * @param ID
	 * @param citiesForDelivery
	 * @param Seller
	 * @param Specifications
	 * @param itemsInStock
	 * @param Features
	 */
	public Product(String id, String name, String category, String subCategory,
			Pricing pricing, List<String> features, byte[] image,
			Specifications specifications, Integer itemsInStock, Seller seller,
			List<String> citiesForDelivery) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.pricing = pricing;
		this.features = features;
		this.image = image;
		this.specifications = specifications;
		this.itemsInStock = itemsInStock;
		this.seller = seller;
		this.citiesForDelivery = citiesForDelivery;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The ID
	 */
	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param ID
	 *            The ID
	 */
	@JsonProperty("_id")
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The Name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param Name
	 *            The Name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The Category
	 */
	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param Category
	 *            The Category
	 */
	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 
	 * @return The SubCategory
	 */
	@JsonProperty("sub_category")
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * 
	 * @param SubCategory
	 *            The Sub-category
	 */
	@JsonProperty("sub_category")
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The Pricing
	 */
	@JsonProperty("pricing")
	public Pricing getPricing() {
		return pricing;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param Pricing
	 *            The Pricing
	 */
	@JsonProperty("pricing")
	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	/**
	 * 
	 * @return The Features
	 */
	@JsonProperty("features")
	public List<String> getFeatures() {
		return features;
	}

	/**
	 * 
	 * @param Features
	 *            The Features
	 */
	@JsonProperty("features")
	public void setFeatures(List<String> features) {
		this.features = features;
	}

	/**
	 * 
	 * @return The Image
	 */
	@JsonProperty("image")
	public byte[] getImage() {
		return image;
	}

	/**
	 * 
	 * @param Image
	 *            The Image
	 */
	@JsonProperty("image")
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * 
	 * @return The Specifications
	 */
	@JsonProperty("specifications")
	public Specifications getSpecifications() {
		return specifications;
	}

	/**
	 * 
	 * @param Specifications
	 *            The Specifications
	 */
	@JsonProperty("Specifications")
	public void setSpecifications(Specifications specifications) {
		this.specifications = specifications;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The itemsInStock
	 */
	@JsonProperty("items_in_stock")
	public Integer getItemsInStock() {
		return itemsInStock;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param itemsInStock
	 *            The items_in_stock
	 */
	@JsonProperty("items_in_stock")
	public void setItemsInStock(Integer itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The Seller
	 */
	@JsonProperty("seller")
	public Seller getSeller() {
		return seller;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param Seller
	 *            The Seller
	 */
	@JsonProperty("seller")
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	/**
	 * 
	 * @return The citiesForDelivery
	 */
	@JsonProperty("cities_for_delivery")
	public List<String> getCitiesForDelivery() {
		return citiesForDelivery;
	}

	/**
	 * 
	 * @param citiesForDelivery
	 *            The cities_for_delivery
	 */
	@JsonProperty("cities_for_delivery")
	public void setCitiesForDelivery(List<String> citiesForDelivery) {
		this.citiesForDelivery = citiesForDelivery;
	}

}