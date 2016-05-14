import com.bertramlabs.plugins.gstomp.Message
import com.bertramlabs.plugins.gstomp.StompClient
import com.google.gson.Gson

class test {
    static private Gson gson = new Gson();

    public static void main(String[] args) {
        String key = "94cc9199-7e04-4225-b226-3053bcf0aca0";

        StompClient stompClient = StompClient.overSockJs(new URL("https://shared.mybluemix.net/hello/"), null, ['X-API-KEY': '1234567', "Authorization": "bearer " + key])
        stompClient.setAutoReconnect(true)
        stompClient.connect()

        stompClient.isConnected()

        stompClient.subscribe("/user/topic/greetings") { stompFrame ->
            println "received StompFrame ${stompFrame.body}"
        }

        stompClient.send("/app/hello", ["content-type":"application/json"], gson.toJson(new Message(" welcome")))
        Thread.sleep(8000)
    }
}
