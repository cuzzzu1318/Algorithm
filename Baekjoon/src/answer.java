//package project;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.type.TypeReference;
//import java.nio.file.Paths;
//import java.nio.file.Files;
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//@SpringBootApplication
//@RestController
//public class App {
//
//    private static final String DATA_FILE_PATH = "../data/input/orders.json";
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
//    }
//
//    @GetMapping("/manage-order")
//    public List<Map<String, Object>> manageOrder() throws IOException {
//        // 아래에 코드를 작성하세요.
//
//        // 커피 종류별 정의
//        Map<String, Map<String, Integer>> coffeeMap = new HashMap<>();
//        coffeeMap.put("Americano", new HashMap<>());
//        coffeeMap.get("Americano").put("cost", 3000);
//        coffeeMap.get("Americano").put("time", 3);
//        coffeeMap.put("Latte", new HashMap<>());
//        coffeeMap.get("Latte").put("cost", 4000);
//        coffeeMap.get("Latte").put("time", 5);
//        coffeeMap.put("Cappuccino", new HashMap<>());
//        coffeeMap.get("Cappuccino").put("cost", 4500);
//        coffeeMap.get("Cappuccino").put("time", 4);
//        coffeeMap.put("Espresso", new HashMap<>());
//        coffeeMap.get("Espresso").put("cost", 3500);
//        coffeeMap.get("Espresso").put("time", 2);
//
//        byte[] jsonData = Files.readAllBytes(Paths.get(DATA_FILE_PATH));
//        List<Map<String, Object>> orders = objectMapper.readValue(jsonData,
//                new TypeReference<List<Map<String, Object>>>() {
//                });
//        for(Map<String, Object> order: orders){
//            if(order.get("status").equals("in progress")){
//                ArrayList<LinkedHashMap<String, Object>> coffeeOrders = (ArrayList<LinkedHashMap<String, Object>>) order.get("coffeeOrders");
//
//                // 커피 타입별 주문을 카운트해서 계산
//                int cntAmericano = 0;
//                int cntLatte = 0;
//                int cntCappuccino = 0;
//                int cntEspresso = 0;
//
//                for(LinkedHashMap<String, Object> map : coffeeOrders){
//                    int quantity = (Integer)map.get("quantity");
//                    switch(map.get("type").toString()){
//                        case "Americano":
//                            cntAmericano+=quantity;
//                            break;
//                        case "Latte":
//                            cntLatte+=quantity;
//                            break;
//                        case "Cappuccino":
//                            cntCappuccino+=quantity;
//                            break;
//                        case "Espresso":
//                            cntEspresso+=quantity;
//                            break;
//                    }
//                }
//                coffeeOrders.clear();
//
//                int orderTotalPrice = 0;
//                int estimatedWaitTime = 0;
//
//                if(cntAmericano>0){
//                    int waitTime = cntAmericano*coffeeMap.get("Americano").get("time");
//                    if(cntAmericano>1){
//                        waitTime/=2;
//                    }
//                    orderTotalPrice+=cntAmericano*coffeeMap.get("Americano").get("cost");
//                    estimatedWaitTime+=waitTime;
//                    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//                    map.put("type", "Americano");
//                    map.put("quantity", cntAmericano);
//                    coffeeOrders.add(map);
//                }
//                if(cntCappuccino>0){
//                    int waitTime = cntCappuccino*coffeeMap.get("Cappuccino").get("time");
//                    if(cntCappuccino>1){
//                        waitTime/=2;
//                    }
//                    orderTotalPrice+=cntCappuccino*coffeeMap.get("Cappuccino").get("cost");
//                    estimatedWaitTime+=waitTime;
//
//                    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//                    map.put("type", "Cappuccino");
//                    map.put("quantity", cntCappuccino);
//                    coffeeOrders.add(map);
//                }
//                if(cntEspresso>0){
//                    int waitTime = cntEspresso*coffeeMap.get("Espresso").get("time");
//                    if(cntEspresso>1){
//                        waitTime/=2;
//                    }
//                    orderTotalPrice+=cntEspresso*coffeeMap.get("Espresso").get("cost");
//                    estimatedWaitTime+=waitTime;
//
//                    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//                    map.put("type", "Espresso");
//                    map.put("quantity", cntEspresso);
//                    coffeeOrders.add(map);
//                }
//                if(cntLatte>0){
//                    int waitTime = cntLatte*coffeeMap.get("Latte").get("time");
//                    if(cntLatte>1){
//                        waitTime/=2;
//                    }
//                    orderTotalPrice+=cntLatte*coffeeMap.get("Latte").get("cost");
//                    estimatedWaitTime+=waitTime;
//
//                    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//                    map.put("type", "Latte");
//                    map.put("quantity", cntLatte);
//                    coffeeOrders.add(map);
//                }
//                order.put("orderTotalPrice", orderTotalPrice);
//                order.put("estimatedWaitTime", estimatedWaitTime);
//                order.put("status", "processingCompleted");
//            }
//        }
//
//        return orders;
//    }
//}
