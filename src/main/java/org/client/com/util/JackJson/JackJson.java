package org.client.com.util.JackJson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JackJson {
    /**
     * object 转 jackjson
     *
     * @param bean
     * @return
     */
    public static String beanToJson(Object bean) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Convert object to JSON string
            return mapper.writeValueAsString(bean);
        } catch (Exception e) {
            return null;
        }
    }
//        //map转JSON
//        Map<String , Object> map = new HashMap<String ,Object>();
//        map.put("one", new User("张", 12, "深圳"));
//        map.put("two", new User("李", 22, "武汉"));
//        map.put("three", new User("王", 32, "北京"));
//        System.out.println("ObjectMapper方式");
//        objectMapper.writeValue(System.out, map);
//        //JsonGenerator方式同上
//
//        //list转JSON
//        List<User> list = new ArrayList<User>();
//        list.add(new User("张", 12, "深圳"));
//        list.add(new User("李", 22, "武汉"));
//        list.add(new User("王", 32, "北京"));
//        System.out.println("ObjectMapper方式");
//        objectMapper.writeValue(System.out, list);
//        //JsonGenerator方式同上
//
//        //JSON转java对象：
//        String json = "{\"name\":\"张三\",\"age\":23,\"address\":\"深圳市\"}";
//        User zhang = objectMapper.readValue(json, User.class);
//        System.out.println(zhang.getName()+"\n"+zhang.getAge()+"\n"+zhang.getAddress());
//
//        //JSON转list
//        String listJson = "[{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
//                + "{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
//                + "{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}]";
//        JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
//        List<User> userList = (List<User>)objectMapper.readValue(listJson, javaType1);
//        for (User user1 : userList) {
//            System.out.println(user1.getName()+"\t"+user1.getAge()+"\t"+user1.getAddress());
//        }
//
//        //JSON转map
//        String mapJson = "{\"one\":{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
//                + "\"two\":{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
//                + "\"three\":{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}}";
//        JavaType javaType2 = objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class, User.class);
//        Map<String,User> userMap = (Map<String,User>)objectMapper.readValue(mapJson, javaType2);
//        User one = userMap.get("one");
//        User two = userMap.get("two");
//        User three = userMap.get("three");
//        System.out.println(one.getName()+"\t"+one.getAge()+"\t"+one.getAddress());
//        System.out.println(two.getName()+"\t"+two.getAge()+"\t"+two.getAddress());
//        System.out.println(three.getName()+"\t"+three.getAge()+"\t"+three.getAddress());
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
}
