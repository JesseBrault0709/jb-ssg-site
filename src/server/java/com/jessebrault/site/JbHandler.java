package com.jessebrault.site;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.regex.Pattern;

public final class JbHandler extends Handler.Abstract {

    private static final Pattern extensionPattern = Pattern.compile(".*\\..+$");

    private static boolean hasExtension(String path) {
        final var m = extensionPattern.matcher(path);
        return m.matches();
    }

    private final Set<Path> bases;

    public JbHandler(Set<Path> bases) {
        this.bases = bases;
    }

    @Override
    public boolean handle(Request request, Response response, Callback callback) throws Exception {
        final String path = request.getHttpURI().getDecodedPath();
        String relative;
        if (path.length() > 1) {
            final String withoutStartSlash = path.substring(1);
            if (withoutStartSlash.endsWith("/")) {
                relative = withoutStartSlash + "index.html";
            } else {
                relative = withoutStartSlash;
            }
        } else {
            relative = "index.html";
        }

        if (!hasExtension(relative)) {
            relative = relative + ".html";
        }

        for (final Path base : this.bases) {
            final Path resolved = base.resolve(relative);
            if (Files.exists(resolved)) {
                try (final var inputStream = Files.newInputStream(resolved)) {
                    final ByteBuffer byteBuffer = ByteBuffer.wrap(inputStream.readAllBytes());
                    response.write(true, byteBuffer, callback);
                }
                return true;
            }
        }
        return false;
    }

}
