package com.jessebrault.site;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class JbHandler extends Handler.Abstract {

    private static final Pattern extensionPattern = Pattern.compile("\\.(?<extension>.+)$");

    private static String getExtension(String path) {
        final var m = extensionPattern.matcher(path);
        if (m.matches()) {
            return m.group("extension");
        } else {
            return null;
        }
    }

    private final Path base;

    public JbHandler(Path base) {
        this.base = base;
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

        final String extension = getExtension(relative);
        if (extension == null) {
            relative = relative + ".html";
        }

        final Path resolved = base.resolve(relative);
        if (!Files.exists(resolved)) {
            return false;
        } else {
            try (final var inputStream = Files.newInputStream(resolved)) {
                final ByteBuffer byteBuffer = ByteBuffer.wrap(inputStream.readAllBytes());
                response.write(true, byteBuffer, callback);
            }
            return true;
        }
    }

}
