import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Note");
            System.out.println("2. Show Notes for Day");
            System.out.println("3. Show Notes for Week");
            System.out.println("4. Save Notes");
            System.out.println("5. Load Notes");
            System.out.println("6. Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice");
            } else {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            presenter.addNote();
                        } catch (Exception e) {
                            System.out.println("Something went wrong. Try Again");
                        }
                        break;
                    case 2:
                        presenter.showNotesForDay();
                        break;
                    case 3:
                        presenter.showNotesForWeek();
                        break;
                    case 4:
                        presenter.saveNotes();
                        break;
                    case 5:
                        presenter.loadNotes();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }

            scanner.nextLine();
        }
    }
}