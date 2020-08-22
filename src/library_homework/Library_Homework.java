/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Library_Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManagrement BK = new BookManagrement();

        while (true) {
            System.out.println("CHUONG TRINH QUAN LY THU VIEN");
            System.out.println("1. Xem thông tin sách ");
            System.out.println("2. Thêm sách");
            System.out.println("3. Sửa thông tin sách ");
            System.out.println("4. Xóa sách ");
            System.out.println("5. Giá từ thấp đến cao ");
            System.out.println("6. Sắp xếp theo loại sách");
            System.out.println("7. Exit");
            System.out.println("------------------------------");
            System.out.print("NHẬP LỰA CHỌN CỦA BẠN: ");
            System.out.println("");
   
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    BK.showBook();
                    break;
                case 2:
                    BK.addBook();
                    break;
                case 3:
                    System.out.println("Nhập vào tên sách muốn sửa");
                    String nameUpdateBook = sc.nextLine();
                    if (BK.findName(nameUpdateBook)) {
                        System.out.println("ID: ");
                        String newId = sc.next();
                        System.out.println("Name: ");
                        String newName = sc.nextLine();
                        System.out.println("NXB: ");
                        String newNXB = sc.nextLine();
                        System.out.println("Type: ");
                        String newType = sc.nextLine();
                        System.out.println("Price: ");
                        int newPrice = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Number Of Page: ");
                        int newNumberOfPage = sc.nextInt();
                        sc.nextLine();
                        Book newBook = new Book(newPrice, newId, newNumberOfPage, newName, newNXB, newType);
                        BK.update(nameUpdateBook, newBook);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    System.out.println("Nhập Id muống xóa: ");
                    String Id = sc.nextLine();
                    if (BK.findId(Id)) {
                    BK.delete(Id);
                    }
                    break;
                case 5:
                    BK.sort();
                    break;
                case 6:
                    ArrayList<String> types = BK.filterBook();
                    for (int i = 0; i < types.size(); i++) {
                        System.out.println(types.get(i));
                    }
                    break;
                    
                case 7:
                    System.out.println("Thoát chương trình");
                    return;
            }
        }
    }

}
