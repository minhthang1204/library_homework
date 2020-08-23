/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BookManagrement {

    ArrayList<Book> list = new ArrayList<>();
    ArrayList<Book> bookSortedByPrice = new ArrayList<>();
    ArrayList<String> bookSortedByType = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void showBook() {
        for (int i = 0; i < list.size(); i++) {
//          list.get(i).showInfo();
            System.out.println(list.get(i).toString());
            try {
                //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Library_Homework\\Book.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                //Bước 2: Đọc dữ liệu
                Book sArr[] = (Book[]) ois.readObject();
                for (Book b : sArr) {
                    System.out.println(b.toString());
                }
                //Bước 3: Đóng luồng
                fis.close();
                ois.close();
            } catch (Exception ex) {
                System.out.println("Loi doc file: " + ex);
            }
        }
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream("d:/mydata2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Bước 2: Đọc dữ liệu
            Book sArr[] = (Book[]) ois.readObject();
            for (Book b : sArr) {
                System.out.println(b.toString());
            }
            //Bước 3: Đóng luồng
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public void addBook() {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Nhập thông tin cho sách thứ:  " + i);
            System.out.println("Mã sách : ");
            String id = sc.next();
            System.out.print("Tên Sách : ");
            String name = sc.next();
            System.out.print("Số trang : ");
            int NumberOfPage = sc.nextInt();
            System.out.print("Giá : ");
            int price = sc.nextInt();
            System.out.print("Nhà Xuất Bản : ");
            String NXB = sc.next();
            System.out.print("Loại sách : ");
            String type = sc.next();
            System.out.println("");
            Book book = new Book(price, id, NumberOfPage, name, NXB, type);
            list.add(book);
            try {
                //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                File f = new File("d:/mydata3.txt");
                FileWriter fw = new FileWriter(f);
                //Bước 2: Ghi dữ liệu
                fw.write("Ghi dữ liệu bằng luồng character");
                //Bước 3: Đóng luồng
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
        }
    }

    public boolean update(String nameOldBook, Book newBook) {
        int indexOfBook = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(nameOldBook)) {
                indexOfBook = i;
            }
        }
        if (indexOfBook == -1) {
            return false;
        } else {
            list.set(indexOfBook, newBook);
            return true;
        }
    }

    public void delete(String Id) {
        Book book = null;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(Id)) {
                book = list.get(i);
                break;
            }
        }
        if (book != null) {

            list.remove(book);

        } else {
            System.out.printf("id = %d not existed.\n", Id);
        }
    }

    public boolean findName(String nameOfBook) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(nameOfBook)) {
                return true;
            }
        }
        return false;
    }

    public boolean findId(String Id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        bookSortedByPrice = (ArrayList<Book>) list.clone(); // Class =Object => (ArrayList<Student>) => ArrayList
        for (int i = 0; i < bookSortedByPrice.size() - 1; i++) {  //bubble sort
            for (int j = i + 1; j < bookSortedByPrice.size(); j++) {
                if (bookSortedByPrice.get(i).getPrice() < bookSortedByPrice.get(j).getPrice()) {
                    Book temp = bookSortedByPrice.get(i);
                    bookSortedByPrice.set(i, bookSortedByPrice.get(j));
                    bookSortedByPrice.set(j, temp);
                }
            }
            bookSortedByPrice.get(i).toString();
        }

    }

    public ArrayList<String> filterBook() {
        for (int i = 0; i < list.size(); i++) {
            String currentBookType = list.get(i).getType();
            boolean isNewType = true;
            for (int j = 0; j < bookSortedByType.size(); j++) {
                if (currentBookType.equals(bookSortedByType.get(j))) {
                    isNewType = false;
                }
            }
            if (isNewType) {
                bookSortedByType.add(currentBookType);
            }
        }
        return bookSortedByType;
    }

}
