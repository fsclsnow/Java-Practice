package HM8;

import java.io.*;
import java.util.*;

public class LinkedListRec<E> {
    private Node<E> head;

    private static class Node<E> {
        private E data;
        private Node<E> next;
        // Constructors
        /** Creates a new node with a null next field.
         @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        /** Creates a new node that references another node.
         @param dataItem The data stored
         @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    public LinkedListRec() {
        head = null;
    }

    private int size(Node<E> head) {
        if (head == null)
            return 0;
        else
            return 1 + size(head.next);
    }
    /** Wrapper method for finding the size of a list.
     @return The size of the list
     */
    public int size() {
        return size(head);
    }

    private String toString(Node<E> head) {
        if (head == null)
            return "";
        else
            return head.data.toString() + "\n" + toString(head.next);
    }
    /** Wrapper method for returning the string representation of a list.
     @return The string representation of the list
     */
    public String toString() {
        return toString(head);
    }

    private void replace(Node<E> head, E oldObj, E newObj) {
        if (head != null) {
            if (oldObj.equals(head.data))
                head.data = newObj;
            else
                replace(head.next, oldObj, newObj);
        }
    }
    /** Wrapper method for replacing oldObj with newObj.
     post: Each occurrence of oldObj has been replaced by newObj.
     @param oldObj The object being removed
     @param newObj The object being inserted
     */
    public void replace(E oldObj, E newObj) {
        replace(head, oldObj, newObj);
    }

    private void add(Node<E> head, E data) {
// If the list has just one element, add to it.
        if (head.next == null)
            head.next = new Node<E>(data);
        else
            add(head.next, data); // Add to rest of list.
    }
    /** Wrapper method for adding a new node to the end of a list.
     @param data The data for the new node
     */
    public void add(E data) {
        if (head == null)
            head = new Node(data); // List has 1 node.
        else
            add(head, data);
    }

    private boolean remove(Node<E> head, Node<E> pred, E outData) {
        if (head == null) // Base case – empty list.
            return false;
        else if (head.data.equals(outData)) { // 2nd base case.
            pred.next = head.next; // Remove head.
            return true;
        } else
            return remove(head.next, head, outData);
    }
    public boolean remove(E outData) {
        if (head == null)
            return false;
        else if (head.data.equals(outData)) {
            head = head.next;
            return true;
        }
        else
            return remove(head.next, head, outData);
    }

    /**
     * Wrapper method for comparing if the given LinkedList is equal to the list
     * @param //Object  ???
     * @return boolean
     */
    public boolean equals (Object other){
        if (other == null)return false;
        if (getClass()!=other.getClass()) return false;
        else {
            LinkedListRec l = (LinkedListRec) other;
            if (size() != l.size()) return false;
            else return equals(head,l.head);
        }
    }

    private boolean equals(Node<E> head,Node<E> otherHead){
        if (head==null&&otherHead==null){return true;}
        else if (head.data.equals(otherHead.data)) {
            return equals(head.next, otherHead.next);
        }
        else
            return false;
    }

    //Wapper method
    public boolean search (E data){
        return search(head, data);
    }

    private boolean search (Node<E> head, E data){
        if (head == null) {return false;}
        else if (head.data.equals(data)){return true;}
        else
            return search(head.next, data);
    }

    public void insertBefore(E target, E data){
        insertBefore(head, target, data);
    }

    private void insertBefore(Node<E> head, E target, E data){
        if (head == null){
            System.out.println("No element of target is found.");
        }
        else if (head.data.equals(target)){
            Node<E> temp = head;
            head = new Node<>(data);
            head.next = temp;
        }
        else if (head.next.data.equals(target)){
            Node<E> temp = head.next;
            head.next = new Node<>(data);
            head.next.next = temp;
        }
        else
            insertBefore(head.next, target, data);
    }

    //Wapper method
    public LinkedListRec reverse(){
        LinkedListRec revList = new LinkedListRec();
        return reverse(head,revList);
    }

    private LinkedListRec reverse(Node<E> firstNode,LinkedListRec revList){
        if (firstNode==null){
            return null;
        }
        else if (firstNode.next!=null) {
            revList.insert(firstNode.data,0);
            reverse(firstNode.next, revList);
        }
        else
            revList.insert(firstNode.data,0);
            return revList;
    }

    //Wapper Method
    public void insert(E object, int index){
        insert(head, object, index);
    }

    private void insert (Node<E> first, E object, int index){
        if (index == 0){
            if (head!=null) {
                Node<E> temp = head;
                head = new Node<>(object);
                head.next = temp;
            }
            else {
                add(object);
            }
        }
        else if (index - 1 == 0){
            Node<E> newNode = new Node<>(object);
            newNode.next = first.next;
            first.next = newNode;
        }
        else {
            insert(first.next, object, index-1);
        }
    }

    //Wapper Method
    public void remove (int index){
        remove(head,index);
    }

    private void remove (Node<E> head, int index){
        if (index==0) {
            head = head.next;
        }
        else if (index-1==0){
            head.next = head.next.next;
        }
        else {
            remove(head.next,index-1);
        }
    }

    public static void main(String[] arg){
        LinkedListRec<Integer> llr = new LinkedListRec<>();
        LinkedListRec<Integer> llr2 = new LinkedListRec<>();
        llr.add(15);
        llr.add(23);
        llr.add(7);
        llr2.add(15);
        llr2.add(16);
        llr2.add(7);
        llr2.replace(16,23);
        System.out.println("llr's size is: " + llr.size());
        System.out.println("llr2 is: \n"+ llr2.toString());
        System.out.println(llr.equals(llr2));
        llr.insert(22,1);
        System.out.println("llr is: \n"+ llr.toString());
        llr.remove(2);
        System.out.println("llr is: \n"+ llr.toString());
        System.out.println(llr.search(15));
        System.out.println(llr.search(18));
        llr.insert(12,0);
        System.out.println("llr is: \n"+ llr.toString());
        llr.insertBefore(22,30);
        llr.remove((Integer)12);
        System.out.println("llr is: \n"+ llr.toString());
        System.out.println("llr-reversed is: \n"+ llr.reverse().toString());
    }
}


