package org.example;

import java.util.List;

// מחלקה המייצגת את כל הגיקסון.
// אני הייתי רוצה שיהיה לי איזה משהו ישדע לקחת את כל המחרוזת הענקית (זאת שחוזרת לי) ומיד לשבץ אותה במחלקה שלי.
// יש ספריה שיודעת לעשות זאת בשורת קוד בלבד.
// jackson databind maven
// נוסיף אותה ל pom.xml
// בשביל שנוכל להבין מה השדות ומה המבנה של הגיסון יש אתר שנקרא:
// json formatter



public class Response {

    private int response_code;
    private List<Question> results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
