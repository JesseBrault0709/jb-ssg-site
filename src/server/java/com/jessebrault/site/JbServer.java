package com.jessebrault.site;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

@CommandLine.Command(
        name = "jbServer",
        description = "The main server for jessebrault.com.",
        mixinStandardHelpOptions = true
)
public class JbServer implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new JbServer()).execute(args);
    }

    private static final Logger logger = LoggerFactory.getLogger(JbServer.class);

    @CommandLine.Option(names = "--watch")
    private boolean watch;

    @CommandLine.Option(names = { "-p", "--port" }, defaultValue = "8080")
    private int port;

    @CommandLine.Option(names = { "-d", "--dist" }, defaultValue = "default")
    private String dist;

    @CommandLine.Option(names = { "-s", "--static", "--static-dir" }, arity = "0..*", defaultValue = "static")
    private Set<Path> staticDirs;

    @Override
    public void run() {
        final var queuedThreadPool = new QueuedThreadPool();
        queuedThreadPool.setName("jbServer");

        final var server = new Server(queuedThreadPool);

        final var connector = new ServerConnector(server);
        connector.setPort(this.port);
        server.addConnector(connector);

        final Handler.Sequence sequence = new Handler.Sequence();

        final Set<Path> bases = new HashSet<>();
        bases.add(Path.of("dist", this.dist));
        bases.addAll(this.staticDirs);

        sequence.addHandler(new JbHandler(bases));
        sequence.addHandler(new DefaultHandler());
        server.setHandler(sequence);

        try {
            server.start();
            logger.info("Server started on port {}.", this.port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
