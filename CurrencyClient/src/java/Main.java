
import currencyrate.Currencyrate;
import currencyrate.CurrencyrateService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import javax.xml.ws.WebServiceRef;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruwini
 */
public class Main
{

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/currencyserver/CurrencyrateService.wsdl")
    private CurrencyrateService service;



    public static void main(String[] args )
    {

        CurrencyrateService CurrencyrateService = new CurrencyrateService();
        Currencyrate CurrencyratePort = CurrencyrateService.getCurrencyratePort();

        String sourceCurrency = readInputText();
        String targetCurrency = readInputText();
        double amountInSourceCurrency = readInputDouble();

        double result = CurrencyratePort.conveter(amountInSourceCurrency,sourceCurrency,targetCurrency);
        System.out.println( "The amount is " +result+targetCurrency + " from " + amountInSourceCurrency+sourceCurrency);
    }

    private static String readInputText(){
        String currency = null;
        boolean textFound = false;
        Scanner scan = new Scanner( System.in );
        do{
            System.out.println( "Please input an Currency" );
            String getCurrency = scan.next();

            if (CountryCodeChecker(getCurrency.toUpperCase()) && !getCurrency.equals("")) {
                currency = getCurrency.toUpperCase();
                textFound = true;
            } else{
                System.out.println( "Invalid input " + getCurrency + ". Please input a valid currency." );
            }

        } while( !textFound );
        return currency;
    }

    private static double readInputDouble()
    {
        double inputDouble = 0;
        boolean numberFound = false;
        Scanner scan = new Scanner( System.in );
        do
        {
            System.out.println( "Please input the amount of SourceCurrency" );
            String inputStr = scan.next();
            try
            {
                inputDouble = Double.parseDouble( inputStr );
                numberFound = true;
            }
            catch( Exception e )
            {
                System.out.println( "Invalid input " + inputStr + ". Please input a number." );
            }

        } while( !numberFound );
        return inputDouble;
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

    public static JSONObject JsonParser(){
        JSONObject jsonObject = null;
        try{
            JSONParser parser = new JSONParser();

            Object object = parser.parse(getJSONFromFile("D:\\Education\\dev\\currencyserver\\db.json"));
            JSONObject mainJsonObject = (JSONObject) object;
            jsonObject = (JSONObject) mainJsonObject.get("rates");

        }catch(ParseException e) {
        }
        return jsonObject;
    }

    public static boolean CountryCodeChecker(String userCountryCode){
        JSONObject jsonObject = JsonParser();
        boolean isAvailable = false;

        Set<String> keys = jsonObject.keySet();

        if(keys.contains(userCountryCode)){
            isAvailable = true;
        }
        return isAvailable;
    }

    private Double conveter(double arg0, java.lang.String arg1, java.lang.String arg2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        currencyrate.Currencyrate port = service.getCurrencyratePort();
        return port.conveter(arg0, arg1, arg2);
    }

  





  
   
}

