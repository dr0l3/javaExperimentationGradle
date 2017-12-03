import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.client.WinHttpClients;

/**
 * Created by g50848 on 26/06/2017.
 */
public class ExampleRest {
    public static void main(String[] args) throws UnirestException, InterruptedException {
//        Unirest.setProxy(new HttpHost("vdcii03proxy.oneadr.net", 8080));

//        GetRequest get = Unirest.get("http://google.com");
//        System.out.println("Restponse : " +get.asString().getBody());
        CloseableHttpClient httpclients = WinHttpClients.createDefault();
        CredentialsProvider credsProvider = new SystemDefaultCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("vda1cs1527", 80),
                new UsernamePasswordCredentials("oneadr\\g50848", "mju76YHN"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        Unirest.setHttpClient(httpclients);

        GetRequest get2 = Unirest.get("http://vda1cs1527/v1/marketdata/keyfigures/bonds?isins=DK0002027622");
        System.out.println("Restponse : " +get2.asString().getBody());
        System.out.println();
    }
}
