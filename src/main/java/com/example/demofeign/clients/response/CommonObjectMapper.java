package com.example.demofeign.clients.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CommonObjectMapper {
    public static CommonObject mappedBy(Object o) {
        if (!(o instanceof Map))
            throw new IllegalArgumentException();

        /*
        * Map 이 외의 클래스는 IllegalArgumentException을 던지고,
        * Jackson으로 변환된 객체를 매핑하기 때문에 올바른 형변환이다.
        */
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) o;

        if (!map.containsKey("type"))
            throw new IllegalArgumentException();

        CommonObject commonObject;

        switch ((String) map.get("type")) {
            case "JPG":
                commonObject = newJPGObject(map);
                break;
            case "GIF":
                commonObject = newGIFObject(map);
                break;
            case "PNG":
                commonObject = newPNGObject(map);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return commonObject;
    }

    private static JPGObject newJPGObject(Map<String, Object> map) {
        String type = (String) map.get("type");
        int number = (int) map.get("number");

        return new JPGObject(type, number);
    }

    private static GIFObject newGIFObject(Map<String, Object> map) {
        String type = (String) map.get("type");
        String string = (String) map.get("string");

        return new GIFObject(type, string);
    }

    private static PNGObject newPNGObject(Map<String, Object> map) {
        String type = (String) map.get("type");
        LocalDateTime createdAt = LocalDateTime.parse((String) map.get("createdAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        /*
         * array 필드는 항상 List<String>을 반환하므로 안전하다.
         */
        @SuppressWarnings("unchecked")
        List<String> array = (List<String>) map.get("array");

        return new PNGObject(type, createdAt, array);
    }
}
