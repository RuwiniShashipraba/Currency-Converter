/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyrate;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Ruwini
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class Currencyrate
{
    @WebMethod
    public Double conveter(double amountInSourceCurrency, String sourceCurrency, String targetCurrency){
        double amount = 0.0;
        double getSourceCurrency = JsonParser(sourceCurrency);
        double getTargetCurrency = JsonParser(targetCurrency);

        try{
            amount = ((amountInSourceCurrency / getSourceCurrency) * getTargetCurrency);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static String getJSONFromFile(String filename) {
        StringBuilder jsonText = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }

    public static double JsonParser(String countryCode){
        double countrySalary = 0.0;
        try{
            JSONParser parser = new JSONParser();
            Object object = parser.parse(getJSONFromFile("D:\\Education\\dev\\currencyserver\\db.json"));
            JSONObject mainJsonObject = (JSONObject) object;
            JSONObject jsonObject = (JSONObject) mainJsonObject.get("rates");

            try {
                countrySalary = Double.parseDouble(jsonObject.get(countryCode).toString());
            }catch(Exception e) {
                countrySalary = 0.0;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return countrySalary;
    }

    public static void main(String[] args){
        System.out.println("Server Started!");
        Endpoint.publish("http://localhost:8080/WebService", new Currencyrate());
    }
}

