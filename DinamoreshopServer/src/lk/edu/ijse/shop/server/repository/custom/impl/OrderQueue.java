/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.server.repository.custom.impl;
import lk.edu.ijse.shop.server.entity.Orders;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Irusha Yujitha
 */
class OrdersQueue{
	private Node front;
	private Node rear;
	int count;	
	OrdersQueue(){}
	
	public void enQueue(Orders orders){
		Node node=new Node(orders);
			if(front==null){
				front=node;
				rear=node;
				count++;
			}else{
				rear.next=node;
				rear=node;
				count++;
			}
	}
	public String toString(){
		String x="";
		Node temp=front;
		while(temp!=null){
		x+=temp.orders.getOid()+"-"+temp.orders.getName();
		temp=temp.next;
	}
	return x;
}
	public int size(){
		  return count;
	}
	
	public Orders deQueue(){
            Orders s=null;
                        if(front!=null){
                            s=front.orders;
                              front=front.next;
                              count--;
                        }else{
                                System.out.println("queue is empty");
     }
                        return s;
}
	public void printQueue(){
		System.out.println(toString());	
	}
        
class Node{
	private Node next;
	private Orders orders;
	Node(Orders orders){
			this.orders=orders;
		}
	
	}
}

public class OrderQueue{
    
    public Orders getQ(List<Orders>list){
        OrdersQueue q1=new OrdersQueue();
                
            try {
               
                for (Orders orders : list) {
                    q1.enQueue(orders); 
                }
                
                l: for (int i = 0; i < list.size(); i++) {
                    Orders od= q1.deQueue();
                if (od.getType().equals("Preparing") || od.getType().equals("Deleverd")) {
                   // continue l; 
                    }else{
                    return od;
                     }
                }

                } catch (Exception ex) {
                Logger.getLogger(OrderQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
	return null;
    }
    
	public static void main(String args[]){
            
        }
		      
}

