import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows, seatsPerRow;

        try {
            System.out.println("Enter the number of rows:");
            numberOfRows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            seatsPerRow = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Number of rows and number of seats can be only numbers between 2 and 9");
            return;
        }

        if(numberOfRows > 9 || numberOfRows < 2 || seatsPerRow > 9 || numberOfRows < 2) {
            System.out.println("Number of rows and number of seats can be only numbers between 2 and 9");
            return;
        }

        int totalSeatsNumber = numberOfRows * seatsPerRow;

        char[][] screenRoom = new char[numberOfRows][seatsPerRow];

        for(int i = 0; i < screenRoom.length; i++) {
            for(int j = 0; j < screenRoom[0].length; j++) {
                screenRoom[i][j] = 'S';
            }
        }

        showSeats(screenRoom);

        int rowNumber, seatNumber;

        try {
            System.out.println("\nEnter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("\nEnter a seat number in that row:");
            seatNumber = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Row number and seat number can be only numbers between 2 and 9");
            return;
        }

        try {
            screenRoom[rowNumber - 1][seatNumber - 1] = 'B';
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The seat with row number " + rowNumber + " and seat number " + seatNumber + " does not exist in this room.");
            return;
        }

        int ticketPrice;

        if(totalSeatsNumber <= 60) {
            ticketPrice = 10;
        } else if (rowNumber <= numberOfRows/2){
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }

        System.out.println("\nTicket price: " + ticketPrice + "$\n");

        showSeats(screenRoom);

    }

    public static void showSeats(char[][] screenRoom){
        StringBuilder str = new StringBuilder();

        str.append("Cinema:\n  ");

        for(int j = 0; j < screenRoom[0].length; j++) {
            str.append(j+1).append(' ');
        }

        str.append('\n');

        for(int i = 0; i < screenRoom.length; i++) {
            str.append(i+1).append(' ');
            for(int j = 0; j < screenRoom[0].length; j++) {
                str.append(screenRoom[i][j]).append(' ');
            }
            str.append('\n');
        }

        System.out.println(str);
    }
}
