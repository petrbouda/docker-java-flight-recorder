package pbouda.docker.jfr;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public final class Application {

    private static Routing createRouting() {
        return Routing.builder()
                .get("greet", (req, resp) -> resp.send("Greetings, Helidon!"))
                .build();
    }

    public static void main(final String[] args) {
        ServerConfiguration serverConfig =
                ServerConfiguration.builder()
                        .port(8080)
                        .build();

        WebServer webServer = WebServer.create(serverConfig, createRouting());

        webServer.start().thenAccept(server -> System.out.println("Started on port: " + server.port()));
    }
}
