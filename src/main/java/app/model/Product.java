package app.model;

public class Product {
	private Long id;
	private String name;
	private int price;
	private int total;
	private String description;
	private String producer;

	public Product() {
	}

	public Product(String name, int price, int total, String description, String producer) {
		this.name = name;
		this.price = price;
		this.total = total;
		this.description = description;
		this.producer = producer;
	}

	public Product(Long id, String name, int price, int total, String description, String producer) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.total = total;
		this.description = description;
		this.producer = producer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
}
