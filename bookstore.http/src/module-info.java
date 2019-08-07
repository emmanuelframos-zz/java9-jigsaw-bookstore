module bookstore.http {
    exports br.com.bookstore.http;
    requires bookstore.domain;
    requires jdk.incubator.httpclient;
}