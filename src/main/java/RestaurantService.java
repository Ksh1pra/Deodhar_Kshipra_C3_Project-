import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        RestaurantService restaurantService = new RestaurantService();
//        restaurantService.addRestaurant("Spice", "Thane", LocalTime.parse("09:32:22",
//                DateTimeFormatter.ISO_TIME), LocalTime.parse("22:30:00",
//                DateTimeFormatter.ISO_TIME));
//        restaurantService.addRestaurant("Salt&Pepper", "Bengaluru", LocalTime.parse("10:30:00", DateTimeFormatter.ISO_TIME),
//                LocalTime.parse("23:00:00", DateTimeFormatter.ISO_TIME));
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        boolean found = false;
        int rest = 0;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurantName.equals(restaurants.get(i).getName())) {
                found = true;
                rest = i;
            }

        }
        if (!found)
            throw new restaurantNotFoundException(restaurantName);
        else
            return restaurants.get(rest);
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}

