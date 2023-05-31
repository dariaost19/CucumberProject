package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    //we will pass the body in multiple formats
    public static String createEmployeePayload() {

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"nelena\",\n" +
                "  \"emp_lastname\": \"faria\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2012-05-20\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "nelena");
        obj.put("emp_lastname", "faria");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2012-05-20");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Engineer");

        return obj.toString();
    }

    public static String createEmployeePayloadJsonDynamic(String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender, String emp_birthday, String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayLoadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57591A");
        obj.put("emp_firstname", "Daria");
        obj.put("emp_lastname", "Os");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1995-03-26");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "QA Lead");

        return obj.toString();

    }
}

