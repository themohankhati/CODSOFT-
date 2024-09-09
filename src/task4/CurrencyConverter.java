package task4;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class CurrencyConverter {
    private static final String API_KEY = "08047230289a3e8ce5ef02ba";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String [] args)
    {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the base currency (i.e. USD)");
        String baseCurrency=scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency (i.e. EUR)");
        String targetCurrency=scanner.nextLine().toUpperCase();

        //user input
        System.out.println("Enter the amount to convert:");
        double amount=scanner.nextDouble();

        // fetch real time exchange rate and also convert currency
        try{
            double exchangeRate=getExchangeRate(baseCurrency, targetCurrency);
            if(exchangeRate!=-1)
            {
                double convertedAmount=convertCurrency(amount, exchangeRate);
                //display the result
                System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            }

            else {
                System.out.println("Error while fetching");

            }
        }
        catch (Exception e)
        {
            System.out.println("Error occurred");
        }
        scanner.close();
        }
        //fetching real-time exchange rate from the API
        private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception{
        String apiURL =API_URL+API_KEY+ "/latest/"+baseCurrency;

        URL url=new URL(apiURL);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //checking if connection is successful
            int responsecode=connection.getResponseCode();
            if(responsecode!=200)
            {
                System.out.println("Error"+ responsecode);
                return -1;

            }

            //JSON response
            Scanner scanner=new Scanner(url.openStream());
            StringBuilder response=new StringBuilder();
            while(scanner.hasNext()){
                response.append(scanner.nextLine());
            }
            scanner.close();

            //parse the json response
            JSONObject jsonObject=new JSONObject(response.toString());
            if(jsonObject.getString("result").equals("success")){
                return jsonObject.getJSONObject("conversion_rates").getDouble(targetCurrency);
            }
            else{
                System.out.println("Invalid response from the API");
                return -1;
            }

    }

    //method to convert amount using exchange rate
    private static double convertCurrency(double amount, double exchangeRate){
        return amount* exchangeRate;
    }
}
