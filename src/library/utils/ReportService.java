package library.utils;

import java.util.ArrayList;
import java.util.List;

import library.books.Book;
import library.users.User;

public class ReportService {
    private List<ReportEntry> logs = new ArrayList<>();
    private ReportBuilder rb = new ReportBuilder(); //initialize obj only to access Report Entry

    public void log(User u, Book b, int action) {
        logs.add(rb.reportLog(u, b, action));
    }

    public List<ReportEntry> getLogs() {
        return logs;
    }
}
