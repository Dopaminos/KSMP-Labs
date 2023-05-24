import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Connection connect;

    public Menu(Connection connect) {
        this.connect = connect;
    }

    public void inputMenuCommand() {
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.MAX_VALUE;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
        }

        CommandsSQL sqlCommands = new CommandsSQL(connect);

        switch (choice) {
            case 1 -> {
                System.out.println("All tables:");
                sqlCommands.outputAllTablesNames();
            }
            case 2 -> {
                System.out.println("Enter the name of the table you want to view: ");
                scanner.skip("((?<!\\R)\\s)*");
                String tableName = scanner.nextLine();
                sqlCommands.outputAllData(tableName);
            }
            case 3 -> {
                System.out.println("Enter the name of the table you want to sort: ");
                scanner.skip("((?<!\\R)\\s)*");
                String tableName = scanner.nextLine();
                System.out.println("Enter the name of the column to sort by: ");
                scanner.skip("((?<!\\R)\\s)*");
                String columnName = scanner.nextLine();
                sqlCommands.outputOrderBy(tableName, columnName);
            }
            case 4 -> {
                System.out.println("Enter the name of the table you want to group by: ");
                scanner.skip("((?<!\\R)\\s)*");
                String tableName = scanner.nextLine();
                System.out.println("Enter the name of the column to group by: ");
                scanner.skip("((?<!\\R)\\s)*");
                String groupingColumnName = scanner.nextLine();
                System.out.println("Enter the name of the associated column(s) for comparison (comma-separated if more than one): ");
                scanner.skip("((?<!\\R)\\s)*");
                String associatedColumnsName = scanner.nextLine();
                sqlCommands.outputGroupBy(tableName, groupingColumnName, associatedColumnsName);
            }
            case 5 -> {
                System.out.println("Enter the name of the table you want to filter: ");
                scanner.skip("((?<!\\R)\\s)*");
                String tableName = scanner.nextLine();
                System.out.println("Enter the filter condition (using AND/OR if more than one): ");
                scanner.skip("((?<!\\R)\\s)*");
                String conditions = scanner.nextLine();
                sqlCommands.outputWhere(tableName, conditions);
            }
            case 0 -> System.exit(0);
            default -> {
                System.err.println("Error: Invalid command");
                System.err.flush();
            }
        }
    }

    public void displayMenuCommands() {
        System.out.println("""
                Menu commands:
                1. Display all tables in the database
                2. Display all data from a specific table
                3. Display sorted data from a specific table
                4. Display grouped data from a table
                5. Display filtered data from a table
                0. Exit""");
        inputMenuCommand();
    }

    public static void main(String[] args) {
        // Assuming you have established a database connection and assigned it to 'connection' variable
        Connection connection = null;  // Replace with your actual connection object
        Menu menu = new Menu(connection);
        menu.displayMenuCommands();
    }
}
