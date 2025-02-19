package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLContext;

import entities.enums.OrderStatus;

public class Order {
	
	private Integer id;
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {}

	public Order(Integer id, Date moment, OrderStatus status,Client client) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : orderItem) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

	public void addItem(OrderItem oItem) {
		orderItem.add(oItem);		
	}
	
	public void removeItem(OrderItem oItem) {
		orderItem.remove(oItem);		
	}
	
	public Double total() {		
		double totalOrder = 0;
		for(OrderItem order : orderItem) {
			double valueOrder = order.getPrice();			
			totalOrder += valueOrder;
		}
		return totalOrder;			
	}
	
}
