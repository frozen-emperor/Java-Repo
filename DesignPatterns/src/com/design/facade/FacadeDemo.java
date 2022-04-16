package com.design.facade;

public class FacadeDemo {
//facade simplies client interaction with complicated systm of interfaces
	//adapter converts one interfaces to other's compatibility
	
	//avoid god object
	
	public static void main(String[] args) {
		// if I want to generate invoice with order of laptop
		// without facade
		OrderService orderService = new OrderService("laptop");
		InvoiceService invoice = new InvoiceService(345f);

		System.out.println(orderService.placeOrder());
		System.out.println(invoice.generateInvoice());

		// above stage is very complicated exposing all the details to the client
		// imagine what if 4 more services get added

		// with facade
		EcommerceFacade ecommerceFacade = new EcommerceFacade(invoice, orderService);
		System.out.println(ecommerceFacade.placeOrder("facade prdo", 45f));
		System.out.println(ecommerceFacade.cancelOrder());
	}

}

class EcommerceFacade {

	private InvoiceService invoiceService;
	private OrderService orderService;

	public EcommerceFacade(InvoiceService invoiceService, OrderService orderService) {
		super();
		this.invoiceService = invoiceService;
		this.orderService = orderService;
	}

	public String placeOrder(String productName, float price) {
		//facade simplifies iteraction with complicated set of subinterfaces
		this.invoiceService.setPrice(price);
		this.orderService.setProduct(productName);

		return this.orderService.placeOrder() + this.invoiceService.generateInvoice();
	}
	
	public String cancelOrder() {
		return this.orderService.cancelOrder();
	}
}

class InvoiceService {
	private float price;

	public InvoiceService(float price) {
		super();
		this.price = price;
	}

	public String generateInvoice() {
		return "Invoice" + price + " rs to be paid";
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

class OrderService {
	private String product;

	public OrderService(String product) {
		super();
		this.product = product;
	}

	public String placeOrder() {
		return "order of " + product + " placed";
	}

	public String cancelOrder() {
		return "order of " + product + " cancelled";
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
