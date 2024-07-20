package org.example;


// ארכיטקטורה שרת לקוח- היכולות של שני מחשבים שונים לדבר אחד עם השני.
// אנו מתקשרים בעזרת האינטרנט. ללא האינטרנט אין את היכולת לשני מחשבים שונים לדבר.
// כל המחשבים האינדיבידואלים "מדוויחים" ונותנים מידע למחשב אחד ספציפי (שרת).
// שכל התפקיד שלו זה לשמור את המידע ולענות על שאלות ( על המידע).
// שרת צריך להיות מחובר לאינטרנט כל הזמן בשביל שיוכל לתקשר עם העולם החיצוני.
// תפקיד השרת זה לשרת (כמו שמו). כל מה שאומרים לו הוא עושה, לקוח מבקש לשמור מידע הוא שומר, לקוח שואל שאלה על המידע הוא עונה.
// יש המון לקוחות וכל הלקוחות פונים לשרת אחד.
// לסיכום ארכיטקטורה שרת לקוח היא הדרך הסטנדרטית לתקשר בין מחשבים.
// התקשורת תמיד עובדת כך שהלקוח פונה לשרת עם איזשהי בקשה.
// הבקשה בדרך כלל היא אחת מ2 סוגים: 1. תביא לי משהו  2. תשמור לי משהו.
// אז מה זה API?
// API זאת הדרך שבה הלקוח יכול לדבר עם השרת
// API זה איזשהי פונקציה שבעזרתה הלקוח  מדבר עם השרת
// בקשת API זאת בקשה שיוצאת מהלקוח לשרת.
// לכל שרת API יש דקומוטציה. (הסבר מפורט על איך להשתמש בשרת)
// בשביל לשלוח בקשות API אנחנו נצתרך איזשהי ספרייה. (ניתן גם ללא ספרייה אבל זה יותר עבודה)
// בשביל להוסיף ספרייה נשתמש בפרויקט Maven.
// אנחנו נשתמש בספריה שמאד פשוט איתה להוסיף API והיא נקראת apache httpcomponents
// בגוגל נכתוב: apache httpcomponents maven
// נכנס לאופציה הראשונה ונלחץ על הגרסה האחרונה ביותר.
// כעת נרצה להוסיף את הספריה ל intelliJ, נוסיף בpop.xml:
// <dependencies> (נכתוב את הספריה שהעתקנו מהגוגל) </dependencies>


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            CloseableHttpClient client = HttpClients.createDefault(); // יוצרים אוביקט של לקוח (בשביל לשלוח בקשה לשרת צריך לקוח)
            // אמרנו שיש 2 סוגי בקשות תביא לי תשמור לי.
            // אם אני רוצה שהוא ישמור לי על משהו אני אשתמש בבקשה שנקראת post
            // אם אני רוצה שהוא יביא לי משהו אני אשתמש בבקשה שנקראת get
            HttpGet request = new HttpGet("https://opentdb.com/api.php?amount=2&category=14&difficulty=medium&type=multiple"); // יצירת בקשה מסוג get
            CloseableHttpResponse response = client.execute(request); // אני משתמש ב client ושולח לו את הבקשה.
            String output = EntityUtils.toString(response.getEntity()); //התגובה שקיבלתי כמחרוזת
            Response response1 = new ObjectMapper().readValue(output, Response.class); // אנחנו בעצם מכיניסים מחרוזת שאותה אנו רוצים להכניס למחלקה שהכנסו
            System.out.println(response1.getResults().get(0).getQuestion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        // אנו רואים בהדפסה שאנו מקבלים מחרוזת מאד מבולגנת. אנחנו רוצים להציג למשתמש רק את השאלה בסופו של דבר ולא את כל שאר המלל.
        // מה שקיבלנו נקרא ג'יסון.
        // גיסון זה מבנה קבוע שמשמש לתקשורת בין מחשבים.
        // המבנה הזה הוא בעצם מבנה של מחלקה. (יש שדות וכו).
        // לכן נפתח מחלקה שתייצג את כל המלל הרב וכך יהיה יותר קל לעבוד.

}