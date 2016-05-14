import com.bertramlabs.plugins.gstomp.Message
import com.bertramlabs.plugins.gstomp.StompClient
import com.google.gson.Gson

class test {
    static private Gson gson = new Gson();

    public static void main(String[] args) {
        String key = "fc7578b2-6318-4cdb-9137-cde68359d0b6";

        StompClient stompClient = StompClient.overSockJs(new URL("http://localhost:8080/hello/"), null, ['X-API-KEY': '1234567', "Authorization": "bearer " + key])
        stompClient.setAutoReconnect(true)
        stompClient.connect()

        stompClient.isConnected()

        stompClient.subscribe("/user/topic/greetings") { stompFrame ->
            println "received StompFrame ${stompFrame.body}"
        }

        stompClient.send("/app/hello", ["content-type":"application/json"], gson.toJson(new Message(" welcome")))
        Thread.sleep(1000)
    }
}
