package jwp.controller;

import jwp.constants.JspPath;
import jwp.constants.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    enum Type {
        REDIRECT, FORWARD;
    }

    class Request {
        private final Type type;
        private final URL url;
        private final JspPath path;

        public Request(Type type, URL url) {
            this.type = type;
            this.url = url;
            this.path = null;
        }

        public Request(Type type, JspPath path) {
            this.type = type;
            this.path = path;
            this.url = null;
        }

        public Type getType() {
            return type;
        }

        public String getURL() {
            if(url != null)
                return url.get();
            if(path != null)
                return path.get();
            return "";
        }
    }

    Request execute(HttpServletRequest req, HttpServletResponse resp);

}
