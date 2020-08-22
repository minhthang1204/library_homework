/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_homework;

/**
 *
 * @author Admin
 */
public class Book {

    public int price, NumberOfPage;
    public String id, name, NXB, Type;

    public Book() {
    }

    public Book(int price, String id, int NumberOfPage, String name, String NXB, String Type) {
        this.price = price;
        this.id = id;
        this.NumberOfPage = NumberOfPage;
        this.name = name;
        this.NXB = NXB;
        this.Type = Type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfPage() {
        return NumberOfPage;
    }

    public void setNumberOfPage(int NumberOfPage) {
        this.NumberOfPage = NumberOfPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

//    public void showInfo() {
//        System.out.println("ID" + this.id + " name: " + this.name + "NumberOfPage" + this.NumberOfPage
//                + " price: " + this.price + "NXB: " + this.NXB + " Type: " + this.Type);
//    }

    
    @Override
    public String toString() {
        return "Book{"
                + "ID=' " + id
                + "name='" + name + '\''
                + ", origin='" + NXB + '\''
                + ", type='" + Type + '\''
                + ", price=" + price
                + ", numberOfPage=" + NumberOfPage
                + '}';
    }
}
